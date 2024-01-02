package mohsen.morma.digikala.navigation

sealed class Screen (val route : String){

    data object Home : Screen("Home")
    data object Category : Screen("Category")
    data object Basket : Screen("Basket")
    data object Profile : Screen("Profile")
    data object Splash : Screen("Splash")

}