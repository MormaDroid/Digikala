package mohsen.morma.digikala.ui.screen.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.R
import mohsen.morma.digikala.data.remote.model.product.ProductResponse
import mohsen.morma.digikala.ui.theme.DigikalaBlue
import mohsen.morma.digikala.ui.theme.GoldColor
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.DigitHelper

@Composable
fun ProductHeaderSection(product: ProductResponse) {

    product.name?.let {

        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {

            Text(
                text = product.category!!,
                style = Typography.h5,
                fontWeight = FontWeight.Bold,
                color = DigikalaBlue
            )

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = it,
                style = Typography.h3,
                modifier = Modifier.height(28.dp),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.size(16.dp))

            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

                Icon(
                    imageVector = Icons.Sharp.Star,
                    contentDescription = null,
                    Modifier.size(20.dp),
                    tint = GoldColor
                )

                Spacer(modifier = Modifier.size(2.dp))

                Text(
                    text = DigitHelper.digitByLocate(product.star.toString()),
                    style = Typography.h5,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.size(2.dp))

                Text(
                    text = "(${DigitHelper.digitByLocate(product.starCount.toString())})",
                    style = Typography.h6,
                    color = Color.DarkGray.copy(0.7f)
                )

                Spacer(modifier = Modifier.size(12.dp))

                Icon(
                    painter = painterResource(id = R.drawable.dot),
                    contentDescription = null,
                    modifier = Modifier.size(6.dp),
                    tint = DigikalaBlue.copy(0.8f)
                )

                Spacer(modifier = Modifier.size(12.dp))

                Text(
                    text = DigitHelper.digitByLocate(product.commentCount.toString()) + stringResource(
                        id = R.string.User_opinion
                    ),
                    style = Typography.h5,
                    color = DigikalaBlue.copy(0.7f)
                )

                Spacer(modifier = Modifier.size(12.dp))

                Icon(
                    painter = painterResource(id = R.drawable.dot),
                    contentDescription = null,
                    modifier = Modifier.size(6.dp),
                    tint = DigikalaBlue.copy(0.8f)
                )

                Spacer(modifier = Modifier.size(12.dp))

                Text(
                    text = DigitHelper.digitBySeparatorAndLocate(product.viewCount.toString()),
                    style = Typography.h5,
                    color = DigikalaBlue.copy(0.7f)
                )

            }

            Spacer(modifier = Modifier.size(16.dp))

            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

                Image(
                    painter = painterResource(id = R.drawable.like),
                    contentDescription = null,
                    Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = "${
                        DigitHelper.digitByLocate(product.agreePercent.toString())
                    }% (${DigitHelper.digitBySeparatorAndLocate(product.agreeCount.toString())} ${
                        stringResource(id = R.string.person)
                    }) ${
                        stringResource(id = R.string.agree_text)
                    }",
                    style = Typography.h6,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray.copy(0.9f)
                )

            }

            Spacer(modifier = Modifier.size(24.dp))

            Divider(color = Color.DarkGray.copy(0.2f))

            Spacer(modifier = Modifier.size(24.dp))

            product.colors?.let { colorList ->

                var selectedColor by remember {
                    mutableStateOf(colorList[0])
                }

                Text(
                    text = "${stringResource(id = R.string.color)} : ${selectedColor.color}",
                    style = Typography.h5,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.size(16.dp))

                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

                    colorList.forEach { color ->

                        Card(
                            modifier = Modifier
                                .wrapContentWidth()
                                .height(40.dp)
                                .clickable { selectedColor = color }
                                .border(
                                    width = 1.dp,
                                    color = if (selectedColor == color) Color.DarkGray.copy(0.8f) else Color.Transparent,
                                    RoundedCornerShape(16.dp)
                                ),
                            shape = RoundedCornerShape(16.dp),
                            elevation = 4.dp,
                            backgroundColor = Color.White
                        ) {

                            Row(
                                Modifier
                                    .fillMaxHeight()
                                    .wrapContentWidth()
                                    .padding(8.dp),
                                Arrangement.Center,
                                Alignment.CenterVertically
                            ) {

                                Box(
                                    modifier = Modifier
                                        .size(24.dp)
                                        .background(
                                            Color(
                                                ("ff" + color.code.removePrefix("#")).toLong(
                                                    16
                                                )
                                            ), shape = CircleShape
                                        )
                                        .border(
                                            1.dp,
                                            if (color.color == "سفید") Color.Black else Color.Transparent,
                                            CircleShape
                                        )
                                        .clip(CircleShape)
                                )

                                Spacer(modifier = Modifier.size(8.dp))

                                Text(
                                    text = color.color,
                                    style = Typography.h5,
                                    fontWeight = FontWeight.Bold,
                                )


                            }

                        }

                        Spacer(modifier = Modifier.size(8.dp))

                    }


                }
            }

        }


    }

}