package mohsen.morma.digikala.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.R
import mohsen.morma.digikala.ui.theme.DigikalaBlue
import mohsen.morma.digikala.ui.theme.Typography

@Composable
fun CartItemTextWithIcon(
    text: String,
    icon: Int,
    isDeliver: Boolean
) {

    Row(Modifier.fillMaxWidth(), Arrangement.Start, Alignment.CenterVertically) {


        if (isDeliver) {
            Spacer(modifier = Modifier.size(3.dp))
            Icon(
                painter = painterResource(R.drawable.dot),
                contentDescription = null,
                Modifier.size(8.dp),
                tint = DigikalaBlue
            )
            Spacer(modifier = Modifier.size(8.dp))
        }

        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .width(14.dp)
                .height(16.dp)
        )

        Spacer(modifier = Modifier.size(8.dp))

        Text(
            text = text,
            style = Typography.h5
        )
    }

    Spacer(modifier = Modifier.size(4.dp))

}