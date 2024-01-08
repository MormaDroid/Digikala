package mohsen.morma.digikala.ui.screen.profile.profile_ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.R
import mohsen.morma.digikala.ui.theme.Typography

@Composable
fun MyOrdersSection() {
    Text(
        modifier = Modifier.padding(16.dp),
        style = Typography.h3,
        fontWeight = FontWeight.Bold,
        text = stringResource(id = R.string.my_orders),
    )

    LazyRow {
        item {
            MyOrdersItem(
                text = stringResource(id = R.string.unpaid),
                painter = painterResource(id = R.drawable.digi_unpaid)
            )
        }
        item {
            MyOrdersItem(
                text = stringResource(id = R.string.processing),
                painter = painterResource(id = R.drawable.digi_processing)
            )
        }
        item {
            MyOrdersItem(
                text = stringResource(id = R.string.my_orders),
                painter = painterResource(id = R.drawable.digi_delivered)
            )
        }
        item {
            MyOrdersItem(
                text = stringResource(id = R.string.cancelled),
                painter = painterResource(id = R.drawable.digi_cancel)
            )
        }
        item {
            MyOrdersItem(
                text = stringResource(id = R.string.returned),
                painter = painterResource(id = R.drawable.digi_returned)
            )
        }
    }
}
