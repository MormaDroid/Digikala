package mohsen.morma.digikala.ui.screen.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
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
import mohsen.morma.digikala.data.remote.model.home.CenterBannerModel
import mohsen.morma.digikala.util.Constants.TAG
import mohsen.morma.digikala.viewmodel.HomeVM

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CenterBanners(homeVM: HomeVM = hiltViewModel()) {


    var isLoading by remember {
        mutableStateOf(true)
    }

    var centerBannerList by remember {
        mutableStateOf<List<CenterBannerModel>>(emptyList())
    }

    val result by homeVM.centerBannerList.collectAsState()

    when (result) {
        is NetworkResult.Success -> {
            result.data?.let { centerBannerList = it }
            isLoading = false
        }

        is NetworkResult.Error -> {
            isLoading = true
            Log.e(TAG, "CenterBanners: ${result.message}")
        }

        is NetworkResult.Loading -> {
            isLoading = true
        }
    }


    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(256.dp)
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalArrangement = Arrangement.SpaceEvenly,
        maxItemsInEachRow = 2
    ) {

        centerBannerList.forEach { bannerModel ->
            Image(
                painter = rememberAsyncImagePainter(model = bannerModel.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(0.5f)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .weight(0.5f),
                contentScale = ContentScale.FillBounds
            )
        }
    }

}