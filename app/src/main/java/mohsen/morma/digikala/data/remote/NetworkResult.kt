package mohsen.morma.digikala.data.remote

sealed class NetworkResult<T>(val message : String? = null , val data : T? = null) {

    class Success<T>(message: String , data: T) : NetworkResult<T>(message, data)
    class Error<T>(message: String) : NetworkResult<T>(message)
    class Loading<T>() : NetworkResult<T>()

}