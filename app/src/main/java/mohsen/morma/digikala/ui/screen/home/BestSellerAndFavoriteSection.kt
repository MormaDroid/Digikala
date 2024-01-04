package mohsen.morma.digikala.ui.screen.home

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import mohsen.morma.digikala.data.remote.NetworkResult
import mohsen.morma.digikala.data.remote.model.home.BestSellerAndFavoriteModel
import mohsen.morma.digikala.ui.theme.DigikalaBlue
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.Constants
import mohsen.morma.digikala.util.DigitHelper

@Composable
fun BestSellerAndFavoriteSection(result : NetworkResult<List<BestSellerAndFavoriteModel>>, title : Int) {

    var isLoading by remember {
        mutableStateOf(true)
    }

    var bestSellerList by remember {
        mutableStateOf<List<BestSellerAndFavoriteModel>>(emptyList())
    }

    when (result) {
        is NetworkResult.Success -> {
            result.data?.let { bestSellerList = it }
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

        Column(Modifier.fillMaxSize().padding(horizontal = 16.dp), horizontalAlignment = Alignment.Start) {

            Text(text = stringResource(title), style = Typography.h2)


            LazyHorizontalGrid(
                rows = GridCells.Fixed(3),
                modifier = Modifier.height(256.dp).padding(top = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                itemsIndexed(bestSellerList) { index, item ->

                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Image(
                            painter = rememberAsyncImagePainter(model = item.image),
                            contentDescription = null,
                            modifier = Modifier.size(64.dp),
                            contentScale = ContentScale.FillBounds
                        )

                        Spacer(modifier = Modifier.size(8.dp))

                        Text(
                            text = DigitHelper.digitByLocate((index+1).toString()),
                            style = Typography.h1,
                            color = DigikalaBlue
                        )

                        Spacer(modifier = Modifier.size(8.dp))


                        Text(
                            text = item.name ,
                            style = Typography.h3,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )


                    }

                }

            }

        }

    }


}