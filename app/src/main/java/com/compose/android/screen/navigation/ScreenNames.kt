package com.compose.android.screen.navigation

sealed class ScreenNames(val route: String) {
    data object HomeActivity : ScreenNames(route = "home_activity")
    data object DetailActivity : ScreenNames(route = "detail_activity")

    fun withArgs(vararg arguments: String): String {
        return buildString {
            /**
             * If we not append route then you will see below exception. Need to understand why
             *                                                                                                     java.lang.IllegalArgumentException: Navigation destination that matches route /rwerwerwerwer cannot be found in the navigation graph ComposeNavGraph(0x0) startDestination={Destination(0x9c0ac802) route=home_activity}
             * java.lang.IllegalArgumentException: Navigation destination that matches route /rwerwerwerwer cannot be found in the navigation graph ComposeNavGraph(0x0) startDestination={Destination(0x9c0ac802) route=home_activity}                                                                                                         java.lang.IllegalArgumentException: Navigation destination that matches route /rwerwerwerwer cannot be found in the navigation graph ComposeNavGraph(0x0) startDestination={Destination(0x9c0ac802) route=home_activity}
             *                                                                                          java.lang.IllegalArgumentException: Navigation destination that matches route /rwerwerwerwer cannot be found in the navigation graph ComposeNavGraph(0x0) startDestination={Destination(0x9c0ac802) route=home_activity
             */
            append(route)
            arguments.forEach { argument ->
                append("/$argument")
            }
        }
    }
}