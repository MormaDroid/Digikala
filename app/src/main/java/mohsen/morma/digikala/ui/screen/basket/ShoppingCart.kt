package mohsen.morma.digikala.ui.screen.basket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.collectLatest
import mohsen.morma.digikala.data.room.CartEntity
import mohsen.morma.digikala.viewmodel.BasketVM

@Composable
fun ShoppingCart(
    basketVM: BasketVM = hiltViewModel()
) {

    var currentCartItem by remember {
        mutableStateOf<List<CartEntity>>(emptyList())
    }

    LaunchedEffect(true) {
        basketVM.cartList.collectLatest {
            currentCartItem = it
        }
    }


    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(bottom = 65.dp)){

        if (currentCartItem.isEmpty()){

            item { EmptyShoppingCart() }

            item { Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Color.LightGray)) }

            item { SuggestionListSection() }

        }else{
            items(currentCartItem){
                CartItemCard(it)
            }
        }


    }

}


