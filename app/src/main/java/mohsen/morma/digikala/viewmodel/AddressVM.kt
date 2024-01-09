package mohsen.morma.digikala.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import mohsen.morma.digikala.data.remote.NetworkResult
import mohsen.morma.digikala.data.remote.model.checkout.ResponseAddressModel
import mohsen.morma.digikala.repository.CheckoutRepository
import mohsen.morma.digikala.util.Constants
import javax.inject.Inject

@HiltViewModel
class AddressVM @Inject constructor(private val repository: CheckoutRepository) : ViewModel() {

    val addressList = MutableStateFlow<NetworkResult<List<ResponseAddressModel>>>(NetworkResult.Loading())

    init {
        getUserAddress()
    }

    private fun getUserAddress(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getUserAddress(Constants.USER_TOKEN).let { addressList.emit(it) }
        }
    }

}