package mohsen.morma.digikala.data.remote

import mohsen.morma.digikala.data.remote.model.NetworkModel
import mohsen.morma.digikala.data.remote.model.checkout.ResponseAddressModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ICheckout {

    @GET("api/v1/getUserAddress")
    suspend fun getUserAddress(
        @Query("token")
        token : String
    ) : Response<NetworkModel<List<ResponseAddressModel>>>

}