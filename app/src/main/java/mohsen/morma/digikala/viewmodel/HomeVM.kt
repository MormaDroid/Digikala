package mohsen.morma.digikala.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import mohsen.morma.digikala.data.remote.NetworkResult
import mohsen.morma.digikala.data.remote.model.home.AmazingProductModel
import mohsen.morma.digikala.data.remote.model.home.SliderModel
import mohsen.morma.digikala.repository.HomeRepository
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    var sliderList = MutableStateFlow<NetworkResult<List<SliderModel>>>(NetworkResult.Loading())

    var amazingList = MutableStateFlow<NetworkResult<List<AmazingProductModel>>>(NetworkResult.Loading())
    var superMarketAmazingList = MutableStateFlow<NetworkResult<List<AmazingProductModel>>>(NetworkResult.Loading())

    fun apiRequest(){
        viewModelScope.launch(Dispatchers.IO) {

            launch { repository.getSlider().let { sliderList.emit(it) } }

            launch { repository.getAmazingProduct().let { amazingList.emit(it) } }

            launch { repository.getSuperMarketAmazingProducts().let { superMarketAmazingList.emit(it) } }

        }
    }

}