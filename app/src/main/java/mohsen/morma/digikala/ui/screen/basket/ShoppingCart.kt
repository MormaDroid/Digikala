package mohsen.morma.digikala.ui.screen.basket

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import mohsen.morma.digikala.data.room.CartEntity
import mohsen.morma.digikala.util.Constants
import mohsen.morma.digikala.viewmodel.BasketVM

@Composable
fun ShoppingCart(
    basketVM: BasketVM = hiltViewModel()
) {

    val cartDetail by basketVM.cartDetail.collectAsState()

    var isLoading by remember {
        mutableStateOf(false)
    }

    var currentCartList by remember {
        mutableStateOf<List<CartEntity>>(emptyList())
    }

    val result by basketVM.cartList.collectAsState()

    when (result) {
        is BasketScreenState.Success -> {
            currentCartList = (result as BasketScreenState.Success<List<CartEntity>>).data
            isLoading = false
        }

        is BasketScreenState.Error -> {

            isLoading = true
            Log.e(Constants.TAG, "NextShoppingCart: ${(result as BasketScreenState.Error).message}")

        }

        is BasketScreenState.Loading -> {
            isLoading = true
        }
    }


    AnimatedVisibility(visible = !isLoading, enter = fadeIn(tween(2000))) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(bottom = 65.dp)
            ) {

                item {
                    AnimatedVisibility(
                        visible = currentCartList.isEmpty(),
                        enter = fadeIn(tween(500)),
                        exit = fadeOut(tween(500))
                    ) {

                        Column {
                            EmptyCurrentCart()

                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(2.dp)
                                    .background(Color.LightGray)
                            )

                            SuggestionListSection()
                        }

                    }
                }

                items(currentCartList) {

                    AnimatedVisibility(
                        visible = currentCartList.isNotEmpty(),
                        enter = fadeIn(tween(500)),
                        exit = fadeOut(tween(500))
                    ) {
                        Spacer(modifier = Modifier.size(20.dp))

                        CurrentCartItemCard(it)

                        Spacer(modifier = Modifier.size(28.dp))
                    }
                }

                item {
                    AnimatedVisibility(
                        visible = currentCartList.isNotEmpty(),
                        enter = fadeIn(tween(500)),
                        exit = fadeOut(tween(500))
                    ) {
                        CartPriceDetailSection(cartDetail)
                    }
                }

            }


            if (cartDetail.totalCount>0)
                Row(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.17f)
                        .border(1.dp, color = Color.LightGray.copy(0.2f), RoundedCornerShape(8.dp))
                        .background(Color.White)
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 58.dp, start = 16.dp, end = 16.dp),
                    Arrangement.SpaceBetween,
                    Alignment.CenterVertically
                ) {

                    BuyProcessContinue(cartDetail.totalPayable)

                }

        }


    }
}





