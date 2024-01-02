package mohsen.morma.digikala.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mohsen.morma.digikala.ui.screen.home.HomeScreen
import mohsen.morma.digikala.ui.screen.splash.SplashScreen

@Composable
fun NavSetup(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.Splash.route){

        composable(Screen.Splash.route){ SplashScreen()}
        composable(Screen.Home.route){ HomeScreen()}
        composable(Screen.Category.route){}
        composable(Screen.Basket.route){}
        composable(Screen.Profile.route){}

    }

}