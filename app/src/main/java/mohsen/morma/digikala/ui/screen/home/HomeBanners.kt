package mohsen.morma.digikala.ui.screen.home

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import mohsen.morma.digikala.data.remote.NetworkResult
import mohsen.morma.digikala.data.remote.model.HomeBannerModel
import mohsen.morma.digikala.util.Constants
import mohsen.morma.digikala.viewmodel.HomeVM

@Composable
fun HomeBanners( item: Int, homeVM: HomeVM = hiltViewModel()) {

    var isLoading by remember {
        mutableStateOf(true)
    }

    var homeBannerList by remember {
        mutableStateOf<List<HomeBannerModel>>(emptyList())
    }

    val result by homeVM.homeBannerList.collectAsState()

    when (result) {
        is NetworkResult.Success -> {
            result.data?.let { homeBannerList = it }
            isLoading = false
        }

        is NetworkResult.Error -> {
            isLoading = true
            Log.e(Constants.TAG, "CenterBanners: ${result.message}")
        }

        is NetworkResult.Loading -> {
            isLoading = true
        }
    }

    AnimatedVisibility(visible = !isLoading, enter = fadeIn(tween(2000))) {

        Image(
            painter = rememberAsyncImagePainter(model = homeBannerList[item].image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(horizontal = 12.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.FillBounds
        )

    }

}