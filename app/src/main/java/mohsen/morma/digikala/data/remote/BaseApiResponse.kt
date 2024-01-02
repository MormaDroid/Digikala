package mohsen.morma.digikala.data.remote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mohsen.morma.digikala.data.remote.model.NetworkModel
import retrofit2.Response

abstract class BaseApiResponse {

    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<NetworkModel<T>>): NetworkResult<T> =
        withContext(Dispatchers.IO){

            try {
                val response = apiCall()
                if (response.isSuccessful){
                    val body = response.body()
                    body?.data?.let {
                        return@withContext NetworkResult.Success(body.message,it)
                    }
                }

                return@withContext NetworkResult.Error(response.message())

            }catch (e:Exception){
                return@withContext errorHandler<T>(e.message.toString())
            }

        }


    private fun <T> errorHandler(errorMessage : String) : NetworkResult<T> =
        NetworkResult.Error(errorMessage)
}