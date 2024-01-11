package mohsen.morma.digikala.ui.screen.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import mohsen.morma.digikala.data.remote.model.product.ProductResponse

@Composable
fun TopSliderProduct(product: ProductResponse) {

    val state = rememberPagerState(initialPage = 0)

    product.imageSlider?.let { imageList ->

        HorizontalPager(
            state = state,
            count = imageList.size,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            itemSpacing = 16.dp,
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {

            Image(
                painter = rememberAsyncImagePainter(model = imageList[it].image),
                contentDescription = null,
                modifier = Modifier
                    .size(256.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.FillBounds
            )

        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(24.dp), Alignment.BottomCenter) {
            HorizontalPagerIndicator(
                pagerState = state,
                pageCount = imageList.size,
                activeColor = Color.Black,
                inactiveColor = Color.Gray.copy(0.8f)
            )
        }


    }

}