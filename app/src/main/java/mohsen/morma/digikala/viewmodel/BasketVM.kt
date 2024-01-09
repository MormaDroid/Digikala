package mohsen.morma.digikala.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import mohsen.morma.digikala.data.remote.NetworkResult
import mohsen.morma.digikala.data.remote.model.home.AmazingProductModel
import mohsen.morma.digikala.data.room.CartDetailModel
import mohsen.morma.digikala.data.room.CartEntity
import mohsen.morma.digikala.data.room.CartStatus
import mohsen.morma.digikala.repository.BasketRepository
import mohsen.morma.digikala.ui.screen.basket.BasketScreenState
import mohsen.morma.digikala.util.DigitHelper
import javax.inject.Inject

@HiltViewModel
class BasketVM @Inject constructor(private val repository: BasketRepository) : ViewModel() {

    var productList =
        MutableStateFlow<NetworkResult<List<AmazingProductModel>>>(NetworkResult.Loading())

    var cartList = MutableStateFlow<BasketScreenState<List<CartEntity>>>(BasketScreenState.Loading)

    var ourCartList : MutableStateFlow<List<CartEntity>> = MutableStateFlow(emptyList())

    var nextCartList =
        MutableStateFlow<BasketScreenState<List<CartEntity>>>(BasketScreenState.Loading)

    var totalCurrentCartCount = repository.getTotalCurrentCartCount()
    var totalNextCartCount = repository.getTotalNextCartCount()

    var cartDetail = MutableStateFlow(CartDetailModel(0, 0, 0, 0))

    init {
        viewModelScope.launch(Dispatchers.IO) {

            launch {
                repository.getCurrentCart().collectLatest {
                    cartList.emit(BasketScreenState.Success(it))
                    ourCartList.emit(it)
                }
            }

            launch {
                repository.getNextCart().collectLatest {
                    nextCartList.emit(BasketScreenState.Success(it))
                }
            }

            launch {
                repository.getCurrentCart().collectLatest {
                    calculateCartDetail(it)
                }
            }

        }
    }

    fun apiRequest() {
        viewModelScope.launch(Dispatchers.IO) {
            launch { repository.getAllProducts().let { productList.emit(it) } }
        }
    }

    private fun calculateCartDetail(items: List<CartEntity>) {

        var totalCount = 0
        var totalPrice = 0
        var totalDiscount = 0

        items.forEach { item ->

            totalCount += item.count
            totalPrice += (item.price * item.count)
            totalDiscount += (DigitHelper.calculateDiscount(
                item.price,
                item.discountPercent * item.count
            ))

        }

        val payablePrice = (totalPrice - totalDiscount)

        cartDetail.value = CartDetailModel(totalCount, totalPrice, totalDiscount, payablePrice)

    }


    fun insertCartItem(cartEntity: CartEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            launch { repository.insertCartItem(cartEntity) }
        }
    }

    fun deleteCart(cartEntity: CartEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCart(cartEntity)
        }
    }

    fun changeCountCartItem(id: String, newCount: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.changeCountCartItem(id, newCount)
        }
    }

    fun changeCartStatus(id: String, newCartStatus: CartStatus) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.changeCartStatus(id, newCartStatus)
        }
    }


}