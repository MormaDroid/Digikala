package mohsen.morma.digikala.ui.screen.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import mohsen.morma.digikala.R
import mohsen.morma.digikala.data.room.CartDetailModel
import mohsen.morma.digikala.data.room.CartEntity
import mohsen.morma.digikala.ui.theme.DigikalaBlue
import mohsen.morma.digikala.ui.theme.DigikalaDarkRed
import mohsen.morma.digikala.ui.theme.DigikalaRed
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.DigitHelper

@Composable
fun CartItemReviewSection(
    cartList: List<CartEntity>,
    cartDetail: CartDetailModel,
    onClick : () -> Unit
) {


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {

            Text(
                text = stringResource(R.string.Shipment),
                style = Typography.h3,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.size(8.dp))

            Row(Modifier.fillMaxWidth(), Arrangement.Start, Alignment.CenterVertically) {

                Image(
                    painter = painterResource(id = R.drawable.k1),
                    contentDescription = null,
                    Modifier.size(16.dp)
                )

                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = stringResource(R.string.fast_delivery),
                    style = Typography.h6,
                    fontWeight = FontWeight.Bold,
                    color = if (isSystemInDarkTheme()) DigikalaDarkRed else DigikalaRed
                )

                Spacer(modifier = Modifier.width(24.dp))

                Text(
                    text = DigitHelper.digitByLocate(cartDetail.totalCount.toString()) + " " + stringResource(
                        R.string.commodity
                    ),
                    style = Typography.h6,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray.copy(0.7f)
                )

            }

            Spacer(modifier = Modifier.size(16.dp))

            LazyRow(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                items(cartList) { cart ->

                    Box(
                        modifier = Modifier
                            .size(128.dp)
                            .padding(8.dp), contentAlignment = Alignment.BottomEnd
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = cart.image),
                            contentDescription = null,
                            Modifier.size(128.dp),
                            contentScale = ContentScale.FillBounds
                        )

                        Text(
                            text = DigitHelper.digitByLocate(cart.count.toString()),
                            style = Typography.h5,
                            color = if (isSystemInDarkTheme()) DigikalaDarkRed else DigikalaRed,
                        )
                    }

                    Divider(
                        Modifier
                            .height(100.dp)
                            .width(1.dp), color = Color.LightGray.copy(0.5f)
                    )

                }
            }

            Spacer(modifier = Modifier.size(32.dp))

            Row(Modifier.fillMaxWidth(), Arrangement.Start, Alignment.CenterVertically) {

                Text(
                    text = stringResource(R.string.ready_to_send),
                    style = Typography.h5,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray.copy(0.7f)
                )

                Spacer(modifier = Modifier.size(16.dp))

                Text(
                    text = "${stringResource(id = R.string.pishtaz_post)} : (${stringResource(id = R.string.delivery_delay)})",
                    style = Typography.h6,
                    fontWeight = FontWeight.Bold
                )

            }

            Spacer(modifier = Modifier.size(24.dp))

            Row(Modifier
                .fillMaxWidth()
                .clickable(
                    onClick = { onClick() },
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ), Arrangement.Start, Alignment.CenterVertically
            ) {

                Text(
                    text = stringResource(id = R.string.choose_a_time_to_send),
                    style = Typography.h4,
                    fontWeight = FontWeight.Bold,
                    color = DigikalaBlue
                )

                Spacer(modifier = Modifier.size(4.dp))

                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    Modifier.size(16.dp),
                    tint = DigikalaBlue
                )

            }


        }

    }


}