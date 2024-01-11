package mohsen.morma.digikala.ui.screen.product

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.R
import mohsen.morma.digikala.ui.theme.Purple40
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.DigitHelper

@Composable
fun ProductAddCommentSection(onClick: () -> Unit) {

    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable(
                onClick = { onClick() },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
    ) {

        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically) {

            Row(verticalAlignment = Alignment.CenterVertically) {

                Icon(
                    painter = painterResource(id = R.drawable.digi_comments_icon),
                    contentDescription = null,
                    Modifier.size(16.dp)
                )

                Spacer(modifier = Modifier.size(12.dp))

                Text(
                    text = stringResource(id = R.string.write_opinion),
                    style = Typography.h5,
                    fontWeight = FontWeight.Bold
                )

            }

            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                Modifier.size(24.dp)
            )

        }

        Spacer(modifier = Modifier.size(8.dp))

        Text(
            text = "${DigitHelper.digitByLocate("5")} ${stringResource(id = R.string.write_opinion_score)}",
            style = Typography.h6,
            color = Purple40
        )

        Spacer(modifier = Modifier.size(8.dp))

        Text(
            text = stringResource(id = R.string.digiclub_confirm),
            style = Typography.h5,
            color = Color.DarkGray.copy(0.7f)
        )

    }

}