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
    }

    fun saveUserLanguage(value: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.putString(value, LANGUAGE_KEY)
        }
    }

    fun restoreLanguage() = runBlocking { repository.restoreString(LANGUAGE_KEY) }

}