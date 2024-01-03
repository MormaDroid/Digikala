package mohsen.morma.digikala.ui.screen.home.amazing

import android.util.Log
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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mohsen.morma.digikala.R
import mohsen.morma.digikala.data.remote.model.home.AmazingProductModel
import mohsen.morma.digikala.ui.theme.DigikalaDarkGreen
import mohsen.morma.digikala.ui.theme.DigikalaDarkRed
import mohsen.morma.digikala.ui.theme.DigikalaRed
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.Constants.PERSIAN_LANG
import mohsen.morma.digikala.util.Constants.TAG
import mohsen.morma.digikala.util.Constants.USER_LANG
import mohsen.morma.digikala.util.DigitHelper

@Composable
fun AmazingItemSection(amazingModel: AmazingProductModel) {

    val time = (((1..12).random()) * 3600)
    Log.e(TAG, "time : $time")


    var amazingTimer by remember {
        mutableIntStateOf(time)
    }

    LaunchedEffect(amazingTimer) {
        launch(Dispatchers.Default) {
            delay(1000)
            amazingTimer -= 1
        }
    }

    Column(
        Modifier
            .fillMaxHeight(0.93f)
            .width(200.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = R.string.amazing_app),
            style = Typography.h6,
            modifier = Modifier.fillMaxWidth(),
            color = if (isSystemInDarkTheme()) DigikalaDarkGreen else DigikalaRed,
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.size(8.dp))

        Image(
            painter = rememberAsyncImagePainter(model = amazingModel.image),
            contentDescription = null,
            modifier = Modifier.size(116.dp),
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.size(16.dp))

        Text(
            text = amazingModel.name,
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
                text = amazingModel.seller,
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
                    text = "${DigitHelper.digitByLocate(amazingModel.discountPercent.toString())}%",
                    style = Typography.h6,
                    color = Color.White
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {

                Text(
                    text = DigitHelper.digitBySeparatorAndLocate(
                        DigitHelper.applyDiscount(
                            amazingModel.price,
                            amazingModel.discountPercent
                        )
                    ),
                    style = Typography.h3
                )

                Spacer(modifier = Modifier.size(0.dp))

                Image(
                    painter = painterResource(
                        id = if (USER_LANG == PERSIAN_LANG) R.drawable.toman else R.drawable.dollar
                    ),
                    contentDescription = null,
                    Modifier.size(if (USER_LANG == PERSIAN_LANG) 24.dp else 20.dp)
                )

            }

        }

        Row(Modifier.fillMaxWidth(), Arrangement.End, Alignment.CenterVertically) {

            Text(
                text = DigitHelper.digitBySeparatorAndLocate(amazingModel.price.toString()),
                style = Typography.h5,
                color = Color.LightGray,
                textDecoration = TextDecoration.LineThrough
            )

            Spacer(modifier = Modifier.width(if (USER_LANG == PERSIAN_LANG) 24.dp else 20.dp))
        }

        Spacer(modifier = Modifier.size(12.dp))

        Text(
            text = DigitHelper.digitByLocate(DigitHelper.digitByClockSeparator(amazingTimer)),
            style = Typography.h4,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End,
            color = Color.LightGray
        )
    }
}
