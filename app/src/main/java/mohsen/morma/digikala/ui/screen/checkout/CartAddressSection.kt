package mohsen.morma.digikala.ui.screen.checkout

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.R
import mohsen.morma.digikala.ui.theme.DigikalaBlue
import mohsen.morma.digikala.ui.theme.Typography

@Composable
fun CartAddressSection(
    address: String,
    addressName: String
) {


    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)) {

            Image(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                Modifier
                    .size(36.dp)
                    .weight(0.15f)
                    .align(Alignment.CenterVertically),
            )

            Spacer(modifier = Modifier.size(8.dp))

            Column(Modifier.weight(0.85f), Arrangement.Center, Alignment.Start) {

                Text(
                    text = stringResource(id = R.string.send_to),
                    style = Typography.h6,
                    color = DigikalaBlue
                )



                Text(
                    text = address,
                    style = Typography.h4,
                    fontWeight = FontWeight.Bold,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = addressName,
                    style = Typography.h5,
                    fontWeight = FontWeight.Bold
                )

            }

        }

        Spacer(modifier = Modifier.size(16.dp))

        Row(Modifier.fillMaxWidth(), Arrangement.End, Alignment.CenterVertically) {

            Text(
                text = stringResource(id = R.string.change_or_edit_address),
                style = Typography.h6,
                color = DigikalaBlue
            )

            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = DigikalaBlue
            )

        }

        CheckoutDivider(36.dp, 6.dp)

    }
}
