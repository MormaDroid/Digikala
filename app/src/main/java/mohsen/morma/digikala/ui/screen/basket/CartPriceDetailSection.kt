package mohsen.morma.digikala.ui.screen.basket

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.R
import mohsen.morma.digikala.data.room.CartDetailModel
import mohsen.morma.digikala.ui.theme.DigikalaDarkRed
import mohsen.morma.digikala.ui.theme.DigikalaRed
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.Constants
import mohsen.morma.digikala.util.DigitHelper

@Composable
fun CartPriceDetailSection(
    cartDetail: CartDetailModel,
    isCheckout: Boolean,
    shippingCost: Int = 0
) {

    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {

        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically) {

            Text(
                text = if (isCheckout)
                    stringResource(id = R.string.price_detail)
                else
                    stringResource(id = R.string.basket_summary),
                style = Typography.h3,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = DigitHelper.digitByLocate(cartDetail.totalCount.toString()) + " " + stringResource(
                    id = R.string.commodity
                ),
                style = Typography.h5,
                color = Color.Gray
            )

        }

        Spacer(modifier = Modifier.size(36.dp))

        PriceDetailText(
            stringResource(id = R.string.commodities_price),
            cartDetail.totalPrice.toString()
        )

        Spacer(modifier = Modifier.size(16.dp))

        PriceDetailText(
            stringResource(id = R.string.commodities_discount),
            cartDetail.totalDiscount.toString(),
            if (isSystemInDarkTheme()) DigikalaDarkRed else DigikalaRed
        )

        Spacer(modifier = Modifier.size(16.dp))

        PriceDetailText(
            stringResource(id = R.string.total_basket),
            cartDetail.totalPayable.toString()
        )

        if (!isCheckout) {
            Spacer(modifier = Modifier.size(36.dp))

            Text(
                text = stringResource(id = R.string.post_info),
                style = Typography.h6,
                color = Color.Gray.copy(0.7f),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        if (isCheckout) {
            Divider(Modifier.fillMaxWidth(), Color.Gray.copy(0.2f))

            Spacer(modifier = Modifier.size(36.dp))

            PostSection(shippingCost)

            Spacer(modifier = Modifier.size(16.dp))
        }

        Divider(Modifier.fillMaxWidth(), Color.Gray.copy(0.2f))

        Spacer(modifier = Modifier.size(36.dp))

        DigiClubScoreSection(cartDetail.totalCount)

        Spacer(modifier = Modifier.height(96.dp))


    }

}

@Composable
fun PostSection(shippingCost: Int) {

    Column(Modifier.fillMaxWidth()) {

        PriceDetailText(
            stringResource(id = R.string.shipment_cost),
            shippingCost.toString()
        )

        Spacer(modifier = Modifier.size(16.dp))

        Row(Modifier.fillMaxWidth(), Arrangement.Start, Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.dot),
                contentDescription = null,
                Modifier.size(6.dp),
                tint = Color.Gray.copy(0.7f)
            )

            Spacer(modifier = Modifier.size(4.dp))

            Text(
                text = stringResource(id = R.string.post_detail),
                style = Typography.h6,
                color = Color.Gray.copy(0.7f)
            )

        }

        Spacer(modifier = Modifier.size(8.dp))

    }

}


@Composable
private fun PriceDetailText(title: String, price: String, color: Color = Color.Black) {

    Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically) {

        Text(
            text = title,
            style = Typography.h5,
            fontWeight = FontWeight.SemiBold,
            color = Color.DarkGray
        )

        Row {

            Text(
                text = DigitHelper.digitBySeparatorAndLocate(price),
                style = Typography.h5,
                color = color,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.size(4.dp))

            Icon(
                painter = painterResource(
                    id = if (Constants.USER_LANG == Constants.PERSIAN_LANG)
                        R.drawable.toman
                    else
                        R.drawable.dollar
                ),
                contentDescription = null,
                Modifier.size(20.dp),
                tint = color
            )
        }


    }

}