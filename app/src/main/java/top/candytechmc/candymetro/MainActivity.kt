package top.candytechmc.candymetro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import top.candytechmc.candymetro.nav.RootNav
import top.candytechmc.candymetro.ui.theme.CandyMetroTheme

/**
 * Main Activity
 * This app only have one activity for Compose container.
 * @author Sokeriaaa
 * @date 2023/1/17
 */
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CandyMetroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RootNav(
                        rootNavHostController = rememberAnimatedNavController()
                    )
                }
            }
        }
    }
}