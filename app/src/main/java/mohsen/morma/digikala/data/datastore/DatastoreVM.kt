package mohsen.morma.digikala.data.datastore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class DatastoreVM @Inject constructor(private val repository: IDatastore) : ViewModel() {

    companion object {
        const val LANGUAGE_KEY = "LANGUAGE_KEY"
        const val USER_TOKEN_KEY = "USER_TOKEN_KEY"
        const val USER_ID_KEY = "USER_ID_KEY"
        const val USER_PHONE_KEY = "USER_PHONE_KEY"
        const val USER_PASSWORD_KEY = "USER_PASSWORD_KEY"
    }

    fun saveUserLanguage(value: String) {
        viewModelScope.launch(Dispatchers.IO) { repository.putString(LANGUAGE_KEY, value) }
    }

    fun restoreLanguage() = runBlocking { repository.restoreString(LANGUAGE_KEY) }

    fun saveUserToken(value: String) {
        viewModelScope.launch { repository.putString(USER_TOKEN_KEY, value) }
    }

    fun restoreUserToken() = runBlocking { repository.restoreString(USER_TOKEN_KEY) }

    fun saveUserId(value: String) {
        viewModelScope.launch { repository.putString(USER_ID_KEY, value) }
    }

    fun restoreUserId() = runBlocking { repository.restoreString(USER_ID_KEY) }

    fun saveUserPhoneNumber(value: String) {
        viewModelScope.launch { repository.putString(USER_PHONE_KEY, value) }
    }

    fun restoreUserPhoneNumber() = runBlocking { repository.restoreString(USER_PHONE_KEY) }


    fun saveUserPassword(value: String) {
        viewModelScope.launch { repository.putString(USER_PASSWORD_KEY, value) }
    }

    fun restoreUserPassword() = runBlocking { repository.restoreString(USER_PASSWORD_KEY) }


}