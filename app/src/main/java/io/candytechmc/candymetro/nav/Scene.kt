package io.candytechmc.candymetro.nav

/**
 * App scene list
 * @author Sokeriaaa
 * @date 2023/1/17
 */
sealed class Scene(val route: String) {

    object Root : Scene("cm_root")

    object LineList : Scene("cm_line_list")

}