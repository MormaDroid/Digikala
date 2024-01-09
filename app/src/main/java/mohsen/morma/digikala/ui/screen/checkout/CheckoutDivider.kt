package mohsen.morma.digikala.ui.screen.checkout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CheckoutDivider(spacerSize : Dp = 8.dp,thickness : Dp = 1.dp) {
    Column {
        Spacer(modifier = Modifier.size(spacerSize))
        Divider(color = Color.LightGray.copy(0.5f), thickness = thickness)
    }
}