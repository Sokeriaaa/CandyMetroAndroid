package io.candytechmc.candymetro.nav

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import io.candytechmc.candymetro.ui.RootScene
import io.candytechmc.candymetro.ui.lines.LinesScene

/**
 * App root navigation
 * @author Sokeriaaa
 * @date 2023/1/17
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RootNav(
    rootNavHostController: NavHostController
) {
    AnimatedNavHost(
        navController = rootNavHostController,
        // TODO Revert default scene to root
        startDestination = Scene.LineList.route,
        route = "cm_nav_root"
    ) {
        composable(
            route = Scene.Root.route,
            enterTransition = {
                slideInHorizontally(animationSpec = tween(400)) + fadeIn()
            },
            exitTransition = {
                slideOutHorizontally(animationSpec = tween(400)) + fadeOut()
            }
        ) {
            RootScene(
                rootNavHostController = rootNavHostController
            )
        }
        composable(
            route = Scene.LineList.route,
            enterTransition = {
                slideInHorizontally() + fadeIn()
            },
            exitTransition = {
                slideOutHorizontally() + fadeOut()
            }
        ) {
            LinesScene(
                rootNavHostController = rootNavHostController
            )
        }
    }
}