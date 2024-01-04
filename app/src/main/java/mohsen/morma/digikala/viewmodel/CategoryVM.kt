package mohsen.morma.digikala.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import mohsen.morma.digikala.data.remote.NetworkResult
import mohsen.morma.digikala.data.remote.model.category.CategoryModel
import mohsen.morma.digikala.repository.CategoryRepository
import javax.inject.Inject

@HiltViewModel
class CategoryVM @Inject constructor(private val repository: CategoryRepository) : ViewModel() {

    val categoryList = MutableStateFlow<NetworkResult<CategoryModel>>(NetworkResult.Loading())

    fun categoryApiRequest(){
        viewModelScope.launch(Dispatchers.IO){

            launch { repository.getTool().let { categoryList.emit(it) } }

        }
    }

}