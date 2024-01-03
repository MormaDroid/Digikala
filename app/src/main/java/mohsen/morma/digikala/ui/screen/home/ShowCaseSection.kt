package mohsen.morma.digikala.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.R
import mohsen.morma.digikala.ui.theme.Typography3

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ShowCaseSection() {

    val showCaseList = listOf(
        ShowCaseModel(R.string.digi_jet, R.drawable.digijet),
        ShowCaseModel(R.string.auction, R.drawable.auction),
        ShowCaseModel(R.string.digipay, R.drawable.digipay),
        ShowCaseModel(R.string.pindo, R.drawable.pindo),
        ShowCaseModel(R.string.digi_plus, R.drawable.digiplus),
        ShowCaseModel(R.string.gift_card, R.drawable.giftcard),
        ShowCaseModel(R.string.shopping, R.drawable.shopping),
        ShowCaseModel(R.string.more, R.drawable.more),
    )


    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        maxItemsInEachRow = 4,
        horizontalArrangement = Arrangement.SpaceEvenly,

        ) {

        showCaseList.forEach {item->

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = item.icon),
                    contentDescription = null,
                    modifier = Modifier.size(48.dp),
                    contentScale = ContentScale.FillBounds
                )

                Text(text = stringResource(id = item.name), style = Typography3.bodySmall)

                Spacer(modifier = Modifier.size(20.dp))

            }


        }

    }

}

data class ShowCaseModel(
    val name: Int,
    val icon: Int
)