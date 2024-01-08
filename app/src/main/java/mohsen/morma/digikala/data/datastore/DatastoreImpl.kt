package mohsen.morma.digikala.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import mohsen.morma.digikala.util.AES
import mohsen.morma.digikala.util.Constants.DATASTORE_NAME
import mohsen.morma.digikala.util.Constants.IV
import mohsen.morma.digikala.util.Constants.KEY
import javax.inject.Inject

private val Context.datastore: DataStore<Preferences> by preferencesDataStore(DATASTORE_NAME)

class DatastoreImpl @Inject constructor(private val context: Context) : IDatastore {
    override suspend fun putString(key: String, value: String) {

        val preferencesKey = stringPreferencesKey(key)
        context.datastore.edit {
            it[preferencesKey] = AES.encryptAES(value, KEY, IV)
        }
    }

    override suspend fun restoreString(key: String): String? =
        try {
            val preferencesKey = stringPreferencesKey(key)
            val preferences = context.datastore.data.first()
            preferences[preferencesKey]?.let { AES.decryptAES(it, KEY, IV) }

        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
}