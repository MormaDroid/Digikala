package mohsen.morma.digikala.util

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.Dispatchers
import mohsen.morma.digikala.data.datastore.DatastoreVM
import mohsen.morma.digikala.data.remote.NetworkResult
import mohsen.morma.digikala.util.Constants.PERSIAN_LANG
import mohsen.morma.digikala.viewmodel.ProfileVM

@Composable
fun AppConfig(
    datastoreVM: DatastoreVM = hiltViewModel(),
    profileVM: ProfileVM = hiltViewModel()
) {
    getDataStoreVariables(datastoreVM)

    profileVM.refreshToken(Constants.USER_PASSWORD, Constants.USER_PHONE)

    val result by profileVM.loginResult.collectAsState()

    LaunchedEffect(Dispatchers.Main){
        when (result) {
            is NetworkResult.Success -> {
                result.data?.let { user ->

                    if (user.token.isNotEmpty()){
                        datastoreVM.saveUserToken(user.token)
                        datastoreVM.saveUserId(user.id)
                        datastoreVM.saveUserPhoneNumber(user.phone)
                        datastoreVM.saveUserPassword(profileVM.inputPasswordState)

                        getDataStoreVariables(datastoreVM)

                    }
                }
            }
            else -> {Log.e(Constants.TAG, result.message.toString())}
        }
    }


}

private fun getDataStoreVariables(datastoreVM: DatastoreVM) {
    Constants.USER_LANG = datastoreVM.restoreLanguage() ?: PERSIAN_LANG
    datastoreVM.saveUserLanguage(Constants.USER_LANG)

    Constants.USER_TOKEN = datastoreVM.restoreUserToken().toString()
    Constants.USER_ID = datastoreVM.restoreUserId().toString()
    Constants.USER_PHONE = datastoreVM.restoreUserPhoneNumber().toString()
    Constants.USER_PASSWORD = datastoreVM.restoreUserPassword().toString()

}