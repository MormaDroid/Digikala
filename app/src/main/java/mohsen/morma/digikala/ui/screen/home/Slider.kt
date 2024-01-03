@file:Suppress("DEPRECATION")

package mohsen.morma.digikala.ui.screen.home

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mohsen.morma.digikala.data.remote.NetworkResult
import mohsen.morma.digikala.data.remote.model.home.SliderModel
import mohsen.morma.digikala.util.Constants.TAG
import mohsen.morma.digikala.viewmodel.HomeVM


@Composable
fun TopSliderSection(homeVM: HomeVM = hiltViewModel()) {

    var sliderList by remember {
        mutableStateOf<List<SliderModel>>(emptyList())
    }

    var isLoading by remember {
        mutableStateOf(true)
    }

    val result by homeVM.sliderList.collectAsState()

    when (result) {
        is NetworkResult.Success -> {
            result.data?.let { sliderList = it }
            isLoading = false
        }

        is NetworkResult.Error -> {
            isLoading = true
            Log.e(TAG, "Slider: ${result.message}")
        }

        is NetworkResult.Loading -> {
            isLoading = true
        }

    }

    AnimatedVisibility(visible = !isLoading, enter = fadeIn(tween(2000))) {
        val pagerState = rememberPagerState()

        HorizontalPager(
            count = sliderList.size,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            state = pagerState,
            itemSpacing = 16.dp,
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {


            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomStart
            ) {

                Image(
                    painter = rememberAsyncImagePainter(model = sliderList[it].image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.FillBounds
                )

                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    pageCount = sliderList.size,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                )
            }
        }

        var key by remember { mutableStateOf(false) }

        LaunchedEffect(key1 = key) {
            launch {
                delay(6000)
                with(pagerState) {
                    val target = if (currentPage < pageCount - 1) currentPage + 1 else 0
                    animateScrollToPage(page = target) //Broken
                    key = !key
                }
            }
        }
    }

}