package mohsen.morma.digikala.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import mohsen.morma.digikala.util.Constants.DATASTORE_NAME
import javax.inject.Inject

private val Context.datastore : DataStore<Preferences> by preferencesDataStore(DATASTORE_NAME)
class DatastoreImpl @Inject constructor(private val context : Context) :IDatastore {
    override suspend fun putString(value: String, key: String) {
        val preferencesKey = stringPreferencesKey(key)
        context.datastore.edit {
            it[preferencesKey] = value
        }
    }

    override suspend fun restoreString(key: String): String? =
        try {
            val preferencesKey = stringPreferencesKey(key)
            val preferences = context.datastore.data.first()
            preferences[preferencesKey]
        }catch (e : Exception){
            e.printStackTrace()
            null
        }
}