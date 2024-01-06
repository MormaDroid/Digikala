package mohsen.morma.digikala.ui.screen.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import mohsen.morma.digikala.R
import mohsen.morma.digikala.data.remote.model.home.AmazingProductModel
import mohsen.morma.digikala.ui.theme.DigikalaDarkRed
import mohsen.morma.digikala.ui.theme.DigikalaRed
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.Constants
import mohsen.morma.digikala.util.DigitHelper

@Composable
fun SuggestionItemSection(suggestionModel: AmazingProductModel) {

    Column(
        Modifier
            .fillMaxHeight(0.93f)
            .width(200.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.size(8.dp))

        Box(modifier = Modifier.size(116.dp), contentAlignment = Alignment.BottomStart) {
            Image(
                painter = rememberAsyncImagePainter(model = suggestionModel.image),
                contentDescription = null,
                modifier = Modifier.size(116.dp),
                contentScale = ContentScale.FillBounds
            )

            FloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(24.dp),
                backgroundColor = Color.White
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = if (isSystemInDarkTheme()) DigikalaDarkRed else DigikalaRed
                )
            }

        }


        Spacer(modifier = Modifier.size(16.dp))

        Text(
            text = suggestionModel.name,
            style = Typography.h5,
            modifier = Modifier.height(28.dp),
            textAlign = TextAlign.Start,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.size(12.dp))

        Row(Modifier.fillMaxWidth(), Arrangement.Start, Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.in_stock),
                contentDescription = null,
                modifier = Modifier.size(18.dp),
                contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = suggestionModel.seller,
                style = Typography.h6
            )
        }

        Spacer(modifier = Modifier.size(20.dp))

        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically) {

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
                    text = "${DigitHelper.digitByLocate(suggestionModel.discountPercent.toString())}%",
                    style = Typography.h6,
                    color = Color.White
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {

                Text(
                    text = DigitHelper.digitBySeparatorAndLocate(
                        DigitHelper.applyDiscount(
                            suggestionModel.price,
                            suggestionModel.discountPercent
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

        Row(Modifier.fillMaxWidth(), Arrangement.End, Alignment.CenterVertically) {

            Text(
                text = DigitHelper.digitBySeparatorAndLocate(suggestionModel.price.toString()),
                style = Typography.h5,
                color = Color.LightGray,
                textDecoration = TextDecoration.LineThrough
            )

            Spacer(modifier = Modifier.width(if (Constants.USER_LANG == Constants.PERSIAN_LANG) 24.dp else 20.dp))
        }
    }

}