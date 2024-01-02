package mohsen.morma.digikala.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import mohsen.morma.digikala.navigation.Screen
import mohsen.morma.digikala.ui.theme.DigikalaColor

@Composable
fun SystemUI(navController: NavHostController) {
    val systemUi = rememberSystemUiController()

    systemUi.apply {

        when (navController.currentBackStackEntryAsState().value?.destination?.route) {
            Screen.Splash.route -> {
                setStatusBarColor(DigikalaColor)
                setNavigationBarColor(DigikalaColor)
            }

            else -> {
                setStatusBarColor(Color.White)
                setNavigationBarColor(Color.White)
            }
        }

    }

}