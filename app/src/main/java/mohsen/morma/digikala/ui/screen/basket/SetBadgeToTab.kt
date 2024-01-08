package mohsen.morma.digikala.ui.screen.basket

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.ui.theme.DigikalaDarkRed
import mohsen.morma.digikala.ui.theme.DigikalaRed
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.DigitHelper

@Composable
fun SetBadgeToTab(selectedTabIndex: Int, index: Int, cartCounter: Int) {

    Card(modifier = Modifier.background(Color.Transparent)) {

        var color = Color.Gray
        if (selectedTabIndex == index) {
            color =  if (isSystemInDarkTheme()) DigikalaDarkRed else DigikalaRed
        }

        Text(
            text = DigitHelper.digitByLocate(cartCounter.toString()),
            style = Typography.h6,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier.background(color = color).padding(horizontal = 8.dp)
        )

    }


}