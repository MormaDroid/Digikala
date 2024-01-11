package mohsen.morma.digikala.ui.screen.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import mohsen.morma.digikala.R
import mohsen.morma.digikala.data.remote.model.home.AmazingProductModel
import mohsen.morma.digikala.ui.theme.DigikalaDarkRed
import mohsen.morma.digikala.ui.theme.DigikalaRed
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.Constants
import mohsen.morma.digikala.util.DigitHelper

@Composable
fun SimilarProductsSection(
    navController: NavHostController,
    similarProductList : List<AmazingProductModel>
) {


    Text(
        text = stringResource(id = R.string.similar_products),
        style = Typography.h3,
        modifier = Modifier.padding(start = 16.dp)
    )

    Spacer(modifier = Modifier.size(8.dp))

    LazyRow {

        items(similarProductList) { product ->

            Row (verticalAlignment = Alignment.CenterVertically){
                Column(
                    Modifier
                        .fillMaxHeight(0.92f)
                        .width(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White)
                        .padding(horizontal = 12.dp, vertical = 16.dp)
                        .clickable { },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.size(8.dp))

                    Image(
                        painter = rememberAsyncImagePainter(model = product.image),
                        contentDescription = null,
                        modifier = Modifier.size(116.dp),
                        contentScale = ContentScale.FillBounds
                    )

                    Spacer(modifier = Modifier.size(16.dp))

                    Text(
                        text = product.name,
                        style = Typography.h5,
                        modifier = Modifier.height(28.dp),
                        textAlign = TextAlign.Start,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.size(12.dp))

                    Row(
                        Modifier.fillMaxWidth(),
                        Arrangement.SpaceBetween,
                        Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(28.dp)
                                .background(
                                    if (isSystemInDarkTheme()) DigikalaDarkRed else DigikalaRed,
                                    CircleShape
                                )
                                .clip(CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "${DigitHelper.digitByLocate(product.discountPercent.toString())}%",
                                style = Typography.h6,
                                color = Color.White
                            )
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {

                            Text(
                                text = DigitHelper.digitBySeparatorAndLocate(
                                    DigitHelper.applyDiscount(
                                        product.price,
                                        product.discountPercent
                                    )
                                ),
                                style = Typography.h3
                            )

                            Spacer(modifier = Modifier.size(0.dp))

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


                    Spacer(
                        modifier = Modifier
                            .height(200.dp)
                            .width(1.dp)
                            .background(Color.DarkGray.copy(0.2f))
                    )

            }


        }

    }


}