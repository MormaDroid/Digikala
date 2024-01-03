package mohsen.morma.digikala.ui.screen.home

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import mohsen.morma.digikala.R
import mohsen.morma.digikala.data.remote.NetworkResult
import mohsen.morma.digikala.data.remote.model.home.HomeCategoryModel
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.Constants
import mohsen.morma.digikala.viewmodel.HomeVM

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CategorySection(homeVM: HomeVM = hiltViewModel()) {

    var isLoading by remember {
        mutableStateOf(true)
    }

    var categoryList by remember {
        mutableStateOf<List<HomeCategoryModel>>(emptyList())
    }

    val result by homeVM.categoryList.collectAsState()

    when (result) {
        is NetworkResult.Success -> {
            result.data?.let { categoryList = it }
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

    AnimatedVisibility(visible = !isLoading) {

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = stringResource(id = R.string.buy_by_categories), style = Typography.h1)

            Spacer(modifier = Modifier.size(16.dp))

            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.Center,
                maxItemsInEachRow = 3
            ) {

                categoryList.forEach { category ->

                    Column(
                        modifier = Modifier.size(128.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = category.image),
                            contentDescription = null,
                            modifier = Modifier
                                .size(96.dp)
                                .padding(8.dp),
                            contentScale = ContentScale.FillBounds
                        )

                        Text(text = category.name, style = Typography.h4)

                    }

                }

            }

        }

    }

}