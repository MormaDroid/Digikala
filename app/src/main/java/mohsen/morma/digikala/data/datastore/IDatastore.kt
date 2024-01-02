package mohsen.morma.digikala.data.datastore

interface IDatastore {

    suspend fun putString(value: String, key: String)

    suspend fun restoreString(key: String): String?

}