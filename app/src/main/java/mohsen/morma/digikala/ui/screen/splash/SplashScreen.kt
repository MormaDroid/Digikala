package mohsen.morma.digikala.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import mohsen.morma.digikala.R
import mohsen.morma.digikala.navigation.Screen
import mohsen.morma.digikala.ui.component.Lottie3dots
import mohsen.morma.digikala.ui.theme.DigikalaColor

@Composable
fun SplashScreen(navController: NavHostController) {
    Splash()

    LaunchedEffect(true){
        delay(3000)
        navController.navigate(Screen.Home.route){popUpTo(0)}
    }

}

@Composable
fun Splash() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DigikalaColor)
    ) {

        Box(modifier = Modifier.fillMaxSize(), Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.digi_logo),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(0.6f)
            )
        }

        Box(modifier = Modifier.fillMaxSize(), Alignment.BottomCenter) {
            Column (Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){

                Image(
                    painter = painterResource(id = R.drawable.digi_txt_white),
                    contentDescription = null,
                    modifier = Modifier.height(36.dp)
                )

                Lottie3dots(size = 48.dp)

            }
        }

    }
}
