package mohsen.morma.digikala.ui.screen.profile.profile_ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.ui.theme.Typography

@Composable
fun MenuRowItem(
    icon: @Composable () -> Unit,
    text: String,
    isHaveDivider: Boolean
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 16.dp)


    ) {

        Column(
            Modifier
                .fillMaxHeight()
                .weight(0.1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            icon()
        }

        Column(
            Modifier
                .fillMaxHeight()
                .weight(0.9f)
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.Center,
        ) {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    style = Typography.h5,
                    fontWeight = FontWeight.Bold,
                    text = text
                )


                Icon(
                    Icons.Outlined.KeyboardArrowLeft,
                    contentDescription = "",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Gray.copy(0.7f)
                )


            }

            if (isHaveDivider) {
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .alpha(0.4f),
                    color = Color.LightGray,
                )
            }

        }


    }

}
