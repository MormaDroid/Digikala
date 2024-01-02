package mohsen.morma.digikala

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.rememberNavController
import mohsen.morma.digikala.navigation.NavSetup
import mohsen.morma.digikala.ui.theme.DigikalaTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            DigikalaTheme {

                Scaffold {
                    NavSetup(navController = navController)
                }

            }
        }
    }
}