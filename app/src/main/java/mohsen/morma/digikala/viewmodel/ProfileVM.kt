package mohsen.morma.digikala.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import mohsen.morma.digikala.data.remote.NetworkResult
import mohsen.morma.digikala.data.remote.model.profile.LoginRequestModel
import mohsen.morma.digikala.data.remote.model.profile.LoginResponseModel
import mohsen.morma.digikala.data.remote.model.profile.ProfileScreenState
import mohsen.morma.digikala.repository.ProfileRepository
import javax.inject.Inject

@HiltViewModel
class ProfileVM @Inject constructor(private val repository: ProfileRepository) : ViewModel() {

    //shared View model
    var  screenState by mutableStateOf(ProfileScreenState.LOGIN_STATE)

    var inputPhoneState by mutableStateOf("")
    var inputPasswordState by mutableStateOf("")

    var isLoading by mutableStateOf(false)

    var loginResult = MutableStateFlow<NetworkResult<LoginResponseModel>>(NetworkResult.Loading())

    fun login(){
        isLoading = true
        viewModelScope.launch (Dispatchers.IO) {
            loginResult.emit(repository.login(LoginRequestModel(inputPasswordState,inputPhoneState)))
        }
    }

    fun refreshToken(password : String,phone:String){
        viewModelScope.launch (Dispatchers.IO) {
            loginResult.emit(repository.login(LoginRequestModel(password = password,phone = phone)))
        }
    }

}