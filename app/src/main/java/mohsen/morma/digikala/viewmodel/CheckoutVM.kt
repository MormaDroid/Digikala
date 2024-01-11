package mohsen.morma.digikala.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import mohsen.morma.digikala.data.remote.NetworkResult
import mohsen.morma.digikala.data.remote.model.checkout.OrderModel
import mohsen.morma.digikala.repository.CheckoutRepository
import javax.inject.Inject

@HiltViewModel
class CheckoutVM @Inject constructor(private val repository: CheckoutRepository) : ViewModel() {

    val shippingCost = MutableStateFlow<NetworkResult<Int>>(NetworkResult.Loading())
    val orderResponse = MutableStateFlow<NetworkResult<String>>(NetworkResult.Loading())

    fun getShippingCost(address: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getShippingCost(address).let { shippingCost.emit(it) }
        }
    }

    fun addNewOrder(orderModel: OrderModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.setNewOrder(orderModel).let { orderResponse.emit(it) }
        }
    }

}