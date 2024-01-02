package mohsen.morma.digikala

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import mohsen.morma.digikala.navigation.BottomNav
import mohsen.morma.digikala.navigation.NavSetup
import mohsen.morma.digikala.ui.theme.DigikalaTheme
import mohsen.morma.digikala.utils.SystemUI

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            SystemUI(navController)

            DigikalaTheme {

                Scaffold(bottomBar = { BottomNav(navController = navController)}) {
                    NavSetup(navController = navController)
                }

            }
        }
    }
}