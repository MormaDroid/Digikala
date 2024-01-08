package mohsen.morma.digikala.ui.screen.basket

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import mohsen.morma.digikala.R
import mohsen.morma.digikala.data.remote.NetworkResult
import mohsen.morma.digikala.data.remote.model.home.AmazingProductModel
import mohsen.morma.digikala.data.room.CartEntity
import mohsen.morma.digikala.data.room.CartStatus
import mohsen.morma.digikala.ui.component.ScreenLoading
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.Constants.TAG
import mohsen.morma.digikala.viewmodel.BasketVM

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SuggestionListSection(basketVM: BasketVM = hiltViewModel()) {

    BasketApiRequest(basketVM)

    var isLoading by remember {
        mutableStateOf(true)
    }

    var suggestionList by remember {
        mutableStateOf<List<AmazingProductModel>>(emptyList())
    }

    val result by basketVM.productList.collectAsState()

    when (result) {
        is NetworkResult.Success -> {
            result.data?.let { suggestionList = it }
            isLoading = false
        }

        is NetworkResult.Error -> {
            isLoading = true
            Log.e(TAG, "SuggestionListSection: ${result.message}")
        }

        is NetworkResult.Loading -> {
            isLoading = true
        }
    }

    if (isLoading) {
        val height = LocalConfiguration.current.screenHeightDp / 2
        ScreenLoading(height = height)
    }

    AnimatedVisibility(visible = !isLoading, enter = fadeIn(tween(2000))) {

        Column {

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = stringResource(id = R.string.suggestion_for_you),
                style = Typography.h2,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.size(16.dp))

            FlowRow(
                modifier = Modifier.fillMaxWidth(), maxItemsInEachRow = 2,
                horizontalArrangement = Arrangement.Start,
                verticalArrangement = Arrangement.Top
            ) {

                suggestionList.forEach { amazingProductModel ->
                    SuggestionItemSection(suggestionModel = amazingProductModel) {
                        basketVM.insertCartItem(
                            CartEntity(
                                it._id,
                                it.discountPercent,
                                it.image,
                                it.name,
                                it.price,
                                it.seller,
                                1,
                                CartStatus.CURRENT_CARD
                            )
                        )
                    }
                }

            }
        }


    }
}

@Composable
private fun BasketApiRequest(basketVM: BasketVM) {
    LaunchedEffect(true){
        basketVM.apiRequest()
    }
}

