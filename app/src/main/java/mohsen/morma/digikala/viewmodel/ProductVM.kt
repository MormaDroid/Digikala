package mohsen.morma.digikala.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import mohsen.morma.digikala.data.remote.NetworkResult
import mohsen.morma.digikala.data.remote.model.home.AmazingProductModel
import mohsen.morma.digikala.data.remote.model.product.ProductResponse
import mohsen.morma.digikala.repository.ProductRepository
import javax.inject.Inject

@HiltViewModel
class ProductVM @Inject constructor(private val repository: ProductRepository) : ViewModel() {

    var productDetail = MutableStateFlow<NetworkResult<ProductResponse>>(NetworkResult.Loading())
    var similarProducts = MutableStateFlow<NetworkResult<List<AmazingProductModel>>>(NetworkResult.Loading())

    fun getProduct(id: String) {

        viewModelScope.launch(Dispatchers.IO) {
            repository.getProduct(id).let { productDetail.emit(it) }
        }

    }

    fun getSimilarProducts(categoryId : String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getSimilarProducts(categoryId).let { similarProducts.emit(it) }
        }
    }

}