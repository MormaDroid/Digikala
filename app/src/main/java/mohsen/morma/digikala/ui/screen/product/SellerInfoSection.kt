package mohsen.morma.digikala.ui.screen.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.R
import mohsen.morma.digikala.ui.component.CartItemTextWithIcon
import mohsen.morma.digikala.ui.theme.DigikalaBlue
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.DigitHelper

@Composable
fun SellerInfoSection(productPrice: Long) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                vertical = 8.dp,
                horizontal = 16.dp,
            )

    ) {


        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = stringResource(id = R.string.seller),
            style = Typography.h4,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 8.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Row(
            modifier = Modifier.padding(
                top = 8.dp,
                start = 8.dp,
                end = 8.dp
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.digi_logo),
                modifier = Modifier
                    .size(25.dp)
                    .clip(CircleShape),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = Typography.h5
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "${DigitHelper.digitByLocate("99")}%" + stringResource(id = R.string.satisfaction),
                        style = Typography.h6,
                        color = Color.DarkGray.copy(0.8f)
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.LightGray.copy(0.4f))
                )
            }

        }


        Row(
            modifier = Modifier.padding(
                bottom = 12.dp,
                start = 8.dp,
                end = 8.dp
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.warranty),
                modifier = Modifier.size(24.dp),
                contentDescription = ""
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                    text = stringResource(id = R.string.commodity_warranty),
                    style = Typography.h5,

                    )
                Spacer(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.LightGray.copy(0.4f))
                )
            }

        }



        Row(
            modifier = Modifier
                .padding(horizontal = 6.dp)
        )
        {
            Column(
                modifier = Modifier
                    .width(16.dp)
                    .fillMaxHeight()
                    .padding(
                        vertical = 8.dp,
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.in_stock),
                    contentDescription = "",
                    modifier = Modifier
                        .size(16.dp),
                    tint = DigikalaBlue
                )

                Divider(
                    Modifier
                        .width(2.dp)
                        .height(16.dp)
                        .alpha(0.6f),
                    color = Color.LightGray
                )

                Icon(
                    painter = painterResource(id = R.drawable.dot),
                    contentDescription = "",
                    modifier = Modifier
                        .size(10.dp)
                        .padding(1.dp),
                    tint = DigikalaBlue,
                )

                Divider(
                    Modifier
                        .width(2.dp)
                        .height(16.dp)
                        .alpha(0.6f),
                    color = Color.LightGray
                )

                Icon(
                    painter = painterResource(id = R.drawable.dot),
                    contentDescription = "",
                    modifier = Modifier
                        .size(10.dp)
                        .padding(1.dp),
                    tint = DigikalaBlue,
                )


            }

            Column(Modifier.padding(horizontal = 6.dp)) {

                Text(
                    text = stringResource(id = R.string.seller),
                    style = Typography.h6,
                    color = Color.DarkGray.copy(0.8f),
                    modifier = Modifier
                        .padding(vertical = 4.dp),
                )

                CartItemTextWithIcon(
                    stringResource(id = R.string.posted_by_digiKala),
                    R.drawable.k1,
                    false
                )

                CartItemTextWithIcon(
                    stringResource(id = R.string.fast_delivery),
                    R.drawable.k2,
                    false
                )

            }
        }


        Spacer(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray.copy(0.4f))
        )




        Row(
            modifier = Modifier.padding(
                horizontal = 8.dp
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.digi_score),
                modifier = Modifier
                    .size(20.dp)
                    .clip(RoundedCornerShape(8.dp)), contentDescription = ""
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                    text = stringResource(id = R.string.digiclub_score),
                    style = Typography.h5,
                )

            }

        }


        Spacer(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray.copy(0.4f))
        )



        Row(
            modifier = Modifier.padding(
                bottom = 8.dp,
                start = 8.dp,
                end = 8.dp
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = Icons.Outlined.Info,
                modifier = Modifier
                    .size(20.dp)
                    .clip(RoundedCornerShape(8.dp)), contentDescription = ""
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                    text = "${stringResource(id = R.string.manufacturer_price)} ${
                        DigitHelper.digitBySeparatorAndLocate(
                            productPrice.toString()
                        )
                    } ${
                        stringResource(
                            id = R.string.toman
                        )
                    }",
                    style = Typography.h5,
                    color = Color.DarkGray.copy(0.8f),
                )
            }

        }


        Spacer(modifier = Modifier.height(4.dp))


        Row(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    end = 8.dp
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = stringResource(id = R.string.better_price_suggestion),
                style = Typography.h6,
                color = DigikalaBlue,
            )

            Image(
                painter = painterResource(id = R.drawable.mark),
                modifier = Modifier
                    .size(25.dp), contentDescription = ""
            )
        }

    }


}

