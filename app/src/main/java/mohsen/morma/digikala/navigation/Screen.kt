package mohsen.morma.digikala.navigation

sealed class Screen (val route : String){

    data object Home : Screen("Home")

    data object Category : Screen("Category")

    data object Basket : Screen("Basket")

    data object Profile : Screen("Profile")

    data object Splash : Screen("Splash")

    data object Checkout : Screen("Checkout")

    data object ProductDetail : Screen("ProductDetail")
    data object Description : Screen("Description")
    data object Technical : Screen("Technical")

    fun withArgs(vararg args : Any):String = buildString {
        append(route)
        args.forEach {
            append("/$it")
        }
    }

}