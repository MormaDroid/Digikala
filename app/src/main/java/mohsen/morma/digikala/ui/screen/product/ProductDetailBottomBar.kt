package mohsen.morma.digikala.ui.screen.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import mohsen.morma.digikala.R
import mohsen.morma.digikala.data.remote.model.product.ProductResponse
import mohsen.morma.digikala.data.room.CartEntity
import mohsen.morma.digikala.data.room.CartStatus
import mohsen.morma.digikala.ui.theme.DigikalaDarkRed
import mohsen.morma.digikala.ui.theme.DigikalaRed
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.Constants
import mohsen.morma.digikala.util.DigitHelper
import mohsen.morma.digikala.viewmodel.BasketVM

@Composable
fun ProductDetailBottomBar(
    productItem: ProductResponse,
    basketVM: BasketVM = hiltViewModel(),
    id: String
) {

    BottomNavigation(
        modifier = Modifier
            .fillMaxWidth()
            .height(76.dp),
        backgroundColor = Color.White
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            Arrangement.SpaceBetween,
            Alignment.CenterVertically
        ) {

            Button(
                onClick = {


                    if (productItem.imageSlider != null)
                        basketVM.insertCartItem(
                            CartEntity(
                                id = id,
                                discountPercent = productItem.discountPercent!!,
                                image = productItem.imageSlider[productItem.imageSlider.lastIndex].image,
                                name = productItem.name!!,
                                price = productItem.price!!,
                                seller = productItem.seller!!,
                                count = 1,
                                cartStatus = CartStatus.CURRENT_CARD
                            )
                        )


                },
                modifier = Modifier
                    .width(158.dp)
                    .height(70.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = if (isSystemInDarkTheme()) DigikalaDarkRed else DigikalaRed)
            ) {

                Text(
                    text = stringResource(id = R.string.add_to_cart),
                    style = Typography.h5,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

            }


            Column(

                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {


                Row(Modifier.fillMaxWidth(), Arrangement.End, Alignment.CenterVertically) {

                    Box(
                        modifier = Modifier
                            .width(36.dp)
                            .height(26.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                if (isSystemInDarkTheme()) DigikalaDarkRed else DigikalaRed,
                                CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = DigitHelper.digitByLocate(productItem.discountPercent.toString()) + "%",
                            style = Typography.h6,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.size(8.dp))

                    Text(
                        text = DigitHelper.digitBySeparatorAndLocate(productItem.price.toString()),
                        style = Typography.h5,
                        color = Color.Gray.copy(0.7f)
                    )

                }

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Text(
                        text = DigitHelper.digitBySeparatorAndLocate(
                            DigitHelper.applyDiscount(
                                productItem.price!!,
                                productItem.discountPercent!!
                            )
                        ),
                        style = Typography.h3
                    )

                    Image(
                        painter = painterResource(
                            id = if (Constants.USER_LANG == Constants.PERSIAN_LANG) R.drawable.toman else R.drawable.dollar
                        ),
                        contentDescription = null,
                        Modifier.size(if (Constants.USER_LANG == Constants.PERSIAN_LANG) 24.dp else 20.dp)
                    )

                }

            }

        }

    }

}