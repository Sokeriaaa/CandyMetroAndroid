package io.candytechmc.candymetro.nav

sealed class Scene(val route: String) {

    object Root : Scene("cm_root")

}