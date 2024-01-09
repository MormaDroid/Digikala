package mohsen.morma.digikala.ui.screen.checkout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import mohsen.morma.digikala.R
import mohsen.morma.digikala.navigation.Screen
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.Constants

@Composable
fun CheckoutTopBarSection(navController: NavHostController) {

    Row(Modifier.fillMaxWidth(), Arrangement.Start, Alignment.CenterVertically) {

        IconButton(onClick = { navController.navigate(Screen.Basket.route) { popUpTo(0) } }) {
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                Modifier
                    .size(24.dp)
                    .rotate(if (Constants.USER_LANG == Constants.PERSIAN_LANG) 0f else 180f)
            )
        }

        Text(
            text = stringResource(id = R.string.address_and_time),
            style = Typography.h3,
            fontWeight = FontWeight.Bold
        )

    }

}