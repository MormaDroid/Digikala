package mohsen.morma.digikala.data.remote

import mohsen.morma.digikala.data.remote.model.NetworkModel
import mohsen.morma.digikala.data.remote.model.checkout.OrderModel
import mohsen.morma.digikala.data.remote.model.checkout.ResponseAddressModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ICheckout {

    @GET("api/v1/getUserAddress")
    suspend fun getUserAddress(
        @Query("token")
        token : String
    ) : Response<NetworkModel<List<ResponseAddressModel>>>

    @GET("api/v1/getShippingCost")
    suspend fun getShippingCost(
        @Query("address") address : String
    ) : Response<NetworkModel<Int>>

    @POST("api/v1/setNewOrder")
    suspend fun setNewOrder(
        @Body orderModel : OrderModel
    ) : Response<NetworkModel<String>>

}