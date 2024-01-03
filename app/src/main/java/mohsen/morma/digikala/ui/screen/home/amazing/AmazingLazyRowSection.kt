package mohsen.morma.digikala.ui.screen.home.amazing

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.R
import mohsen.morma.digikala.data.remote.model.home.AmazingProductModel
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.Constants

@Composable
fun AmazingLazyRowSection(isLoading: Boolean, amazingList: List<AmazingProductModel>) {

    AnimatedVisibility(visible = !isLoading, enter = fadeIn(tween(2000))) {
        LazyRow {

            items(amazingList) {amazingModel->

                AmazingItemSection(amazingModel = amazingModel)

                Spacer(modifier = Modifier.size(12.dp))

            }

            item { ShowMore() }

            item { Spacer(modifier = Modifier.size(12.dp)) }
        }
    }
}

@Composable
private fun ShowMore() {
    Column(
        Modifier
            .fillMaxHeight(0.93f)
            .width(200.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.show_more),
            contentDescription = null,
            modifier = Modifier
                .size(46.dp)
                .rotate(if (Constants.USER_LANG == Constants.ENGLISH_LANG) 180f else 0f)
        )

        Spacer(modifier = Modifier.size(16.dp))

        Text(text = stringResource(id = R.string.see_all), style = Typography.h3 )
    }
}
