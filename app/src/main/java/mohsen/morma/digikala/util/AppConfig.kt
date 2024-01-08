package mohsen.morma.digikala.util

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import mohsen.morma.digikala.data.datastore.DatastoreVM

@Composable
fun AppConfig(datastoreVM: DatastoreVM = hiltViewModel()) {
    getDataStoreVariables(datastoreVM)
}

private fun getDataStoreVariables(datastoreVM: DatastoreVM){
    Constants.USER_LANG =  Constants.PERSIAN_LANG
    datastoreVM.saveUserLanguage(Constants.USER_LANG)
}