package mohsen.morma.digikala.ui.screen.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import mohsen.morma.digikala.R
import mohsen.morma.digikala.data.room.CartEntity
import mohsen.morma.digikala.data.room.CartStatus
import mohsen.morma.digikala.ui.component.CartItemTextWithIcon
import mohsen.morma.digikala.ui.theme.DigikalaBlue
import mohsen.morma.digikala.ui.theme.DigikalaDarkRed
import mohsen.morma.digikala.ui.theme.DigikalaRed
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.Constants
import mohsen.morma.digikala.util.Constants.PERSIAN_LANG
import mohsen.morma.digikala.util.Constants.USER_LANG
import mohsen.morma.digikala.util.DigitHelper
import mohsen.morma.digikala.viewmodel.BasketVM


@Composable
fun CurrentCartItemCard(cartEntity: CartEntity, basketVM: BasketVM = hiltViewModel()) {

    var cartCount by remember {
        mutableIntStateOf(cartEntity.count)
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {

        Spacer(modifier = Modifier.size(16.dp))

        Row(
            Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically
        ) {

            Column {

                Text(
                    text = stringResource(id = R.string.your_shopping_list),
                    style = Typography.h4,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = DigitHelper.digitByLocate(cartCount.toString()) + " " + stringResource(id = R.string.commodity),
                    style = Typography.h6,
                    color = Color.Gray
                )

            }

            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null,
                Modifier.size(28.dp)
            )

        }

        Spacer(modifier = Modifier.size(20.dp))

        Row(
            Modifier.fillMaxWidth()
        ) {

            Image(
                painter = rememberAsyncImagePainter(model = cartEntity.image),
                contentDescription = null,
                modifier = Modifier.size(112.dp),
                contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = Modifier.size(16.dp))

            Column {

                Text(
                    text = cartEntity.name,
                    style = Typography.h5,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                CartItemTextWithIcon(
                    stringResource(id = R.string.commodity_warranty), R.drawable.warranty,
                    false
                )

                CartItemTextWithIcon(
                    stringResource(id = R.string.app_name),
                    R.drawable.store,
                    false
                )

                CartItemTextWithIcon(
                    if (USER_LANG == PERSIAN_LANG) cartEntity.seller else stringResource(id = R.string.seller) ,
                    R.drawable.in_stock,
                    false
                )

                CartItemTextWithIcon(
                    stringResource(id = R.string.posted_by_digiKala),
                    R.drawable.k1,
                    true
                )

                CartItemTextWithIcon(
                    stringResource(id = R.string.digikala_supermarket_fast_delivery),
                    R.drawable.k2,
                    true
                )

            }

        }

        Spacer(modifier = Modifier.size(36.dp))

        Row(
            Modifier.fillMaxWidth(),
            Arrangement.Start,
            Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .width(112.dp)
                    .height(44.dp)
                    .border(
                        1.dp,
                        if (isSystemInDarkTheme()) DigikalaDarkRed else DigikalaRed,
                        RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Row(Modifier.fillMaxSize(), Arrangement.SpaceBetween, Alignment.CenterVertically) {

                    IconButton(onClick = {
                        cartCount++
                        basketVM.changeCountCartItem(cartEntity.id, cartCount)
                    }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = if (isSystemInDarkTheme()) DigikalaDarkRed else DigikalaRed
                        )
                    }

                    Text(
                        text = DigitHelper.digitBySeparatorAndLocate(cartCount.toString()),
                        style = Typography.h5
                    )

                    IconButton(onClick = {
                        if (cartCount > 1) {
                            cartCount--
                            basketVM.changeCountCartItem(cartEntity.id, cartCount)
                        } else {
                            basketVM.deleteCart(cartEntity)
                        }
                    }) {
                        Icon(
                            painter = painterResource(if (cartCount == 1) R.drawable.digi_trash else R.drawable.minus),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = if (isSystemInDarkTheme()) DigikalaDarkRed else DigikalaRed
                        )
                    }

                }

            }


            Spacer(modifier = Modifier.size(16.dp))

            Column {
                Text(
                    text = DigitHelper.digitBySeparatorAndLocate(
                        DigitHelper.calculateDiscount(
                            cartEntity.price * cartCount,
                            cartEntity.discountPercent
                        ).toString()
                    ) + " " + stringResource(id = R.string.price_off),
                    style = Typography.h6,
                    color = if (isSystemInDarkTheme()) DigikalaDarkRed else DigikalaRed
                )
                Row {
                    Text(
                        text = DigitHelper.digitBySeparatorAndLocate(
                            DigitHelper.applyDiscount(
                                cartEntity.price * cartCount,
                                cartEntity.discountPercent
                            )
                        ),
                        style = Typography.h3
                    )

                    Spacer(modifier = Modifier.size(4.dp))

                    Image(
                        painter = painterResource(
                            id = if (USER_LANG == PERSIAN_LANG) R.drawable.toman else R.drawable.dollar
                        ),
                        contentDescription = null,
                        Modifier.size(if (USER_LANG == PERSIAN_LANG) 24.dp else 20.dp)
                    )
                }

            }

        }

        Spacer(modifier = Modifier.size(20.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .clickable(
                    onClick = { basketVM.changeCartStatus(cartEntity.id, CartStatus.NEXT_CARD) },
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = stringResource(id = R.string.save_in_next_cart),
                style = Typography.h5,
                color = DigikalaBlue
            )

            Spacer(modifier = Modifier.size(0.dp))

            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .rotate(if (USER_LANG == Constants.ENGLISH_LANG) 180f else 0f),
                tint = DigikalaBlue
            )

        }

        Spacer(modifier = Modifier.size(36.dp))

        Divider(color = Color.Gray.copy(0.2f))

    }

}