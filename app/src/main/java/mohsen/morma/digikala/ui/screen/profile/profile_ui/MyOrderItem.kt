package mohsen.morma.digikala.ui.screen.profile.profile_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.ui.theme.Typography

@Composable
fun MyOrdersItem(
    text: String,
    painter: Painter
) {
    Row(
        modifier = Modifier.padding(vertical = 20.dp)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painter,
                contentDescription = "",
                modifier = Modifier
                    .size(72.dp)
                    .padding(bottom = 8.dp)
            )
            Text(
                style = Typography.h6,
                color = Color.Gray.copy(0.7f),
                text = text
            )
        }
        Divider(
            modifier = Modifier
                .width(1.dp)
                .height(90.dp)
                .alpha(0.4f),
            color = Color.LightGray,
        )
    }
}
