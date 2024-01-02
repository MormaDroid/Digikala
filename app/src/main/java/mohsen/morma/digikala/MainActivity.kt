package mohsen.morma.digikala

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import mohsen.morma.digikala.navigation.BottomNav
import mohsen.morma.digikala.navigation.NavSetup
import mohsen.morma.digikala.ui.theme.DigikalaTheme
import mohsen.morma.digikala.util.AppConfig
import mohsen.morma.digikala.util.Constants.PERSIAN_LANG
import mohsen.morma.digikala.util.Constants.USER_LANG
import mohsen.morma.digikala.util.LocaleUtils
import mohsen.morma.digikala.util.SystemUI

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            AppConfig()

            LocaleUtils().setLocale(this, USER_LANG)

            val navController = rememberNavController()
            SystemUI(navController)

            DigikalaTheme {

                CompositionLocalProvider(
                    LocalLayoutDirection provides if (USER_LANG == PERSIAN_LANG) LayoutDirection.Rtl else LayoutDirection.Ltr
                ) {
                    Scaffold(bottomBar = { BottomNav(navController = navController) }) {
                        NavSetup(navController = navController)
                    }
                }


            }
        }
    }
}