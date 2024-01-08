package mohsen.morma.digikala.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mohsen.morma.digikala.ui.screen.basket.BasketScreen
import mohsen.morma.digikala.ui.screen.category.CategoryScreen
import mohsen.morma.digikala.ui.screen.home.HomeScreen
import mohsen.morma.digikala.ui.screen.profile.ProfileScreen
import mohsen.morma.digikala.ui.screen.splash.SplashScreen

@Composable
fun NavSetup(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.Splash.route){

        composable(Screen.Splash.route){ SplashScreen(navController)}
        composable(Screen.Home.route){ HomeScreen()}
        composable(Screen.Category.route){ CategoryScreen()}
        composable(Screen.Basket.route){ BasketScreen(navController)}
        composable(Screen.Profile.route){ ProfileScreen()}

    }

}