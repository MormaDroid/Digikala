package mohsen.morma.digikala.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import mohsen.morma.digikala.data.remote.NetworkResult
import mohsen.morma.digikala.data.remote.model.home.AmazingProductModel
import mohsen.morma.digikala.data.room.CartEntity
import mohsen.morma.digikala.repository.BasketRepository
import javax.inject.Inject

@HiltViewModel
class BasketVM @Inject constructor(private val repository: BasketRepository) : ViewModel(){

    var productList = MutableStateFlow<NetworkResult<List<AmazingProductModel>>>(NetworkResult.Loading())

    var cartList : Flow<List<CartEntity>> = repository.getCurrentCart()

    fun apiRequest(){
        viewModelScope.launch(Dispatchers.IO) {

            launch { repository.getAllProducts().let { productList.emit(it) } }

        }
    }


    fun insertCartItem(cartEntity: CartEntity){
        viewModelScope.launch(Dispatchers.IO) {
            launch { repository.insertCartItem(cartEntity) }
        }
    }



}