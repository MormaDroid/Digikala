package mohsen.morma.digikala.ui.screen.basket

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import mohsen.morma.digikala.data.room.CartEntity
import mohsen.morma.digikala.util.Constants.TAG
import mohsen.morma.digikala.viewmodel.BasketVM

@Composable
fun NextShoppingCart(basketVM: BasketVM = hiltViewModel()) {

    var isLoading by remember {
        mutableStateOf(false)
    }

    var nextCartList by remember {
        mutableStateOf<List<CartEntity>>(emptyList())
    }

    val result by basketVM.nextCartList.collectAsState()

    when(result){
        is BasketScreenState.Success ->{
            nextCartList = (result as BasketScreenState.Success<List<CartEntity>>).data
            isLoading = false
        }

        is BasketScreenState.Error ->{

            isLoading = true
            Log.e(TAG, "NextShoppingCart: ${(result as BasketScreenState.Error).message}")

        }

        is BasketScreenState.Loading ->{
            isLoading = true
        }
    }

    val height = LocalConfiguration.current.screenHeightDp

    AnimatedVisibility(visible = !isLoading, enter = fadeIn(tween(2000))) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 65.dp)
        ) {

            item {
                AnimatedVisibility(
                    visible = nextCartList.isEmpty(),
                    enter = fadeIn(tween(500)),
                    exit = fadeOut(tween(500))
                ) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .height(height.dp)) {
                        EmptyNextCart()
                    }

                }
            }

            items(nextCartList) {


                Spacer(modifier = Modifier.size(20.dp))

                NextCartItemCard(it)


            }

        }

    }


}




