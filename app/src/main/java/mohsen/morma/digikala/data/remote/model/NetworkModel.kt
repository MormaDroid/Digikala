package mohsen.morma.digikala.data.remote.model

data class NetworkModel<T>(
    val message : String,
    val data : T,
    val success : Boolean
)
