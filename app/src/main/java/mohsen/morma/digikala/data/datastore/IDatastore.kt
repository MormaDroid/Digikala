package mohsen.morma.digikala.data.datastore

interface IDatastore {

    suspend fun putString(key : String , value : String)

    suspend fun restoreString(key: String): String?

}