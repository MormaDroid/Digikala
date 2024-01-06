package mohsen.morma.digikala.data.remote

import mohsen.morma.digikala.data.remote.model.NetworkModel
import mohsen.morma.digikala.data.remote.model.home.AmazingProductModel
import retrofit2.Response
import retrofit2.http.GET

interface IBasket {

    @GET("api/v1/getAllProducts")
    suspend fun getAllProducts() : Response<NetworkModel<List<AmazingProductModel>>>

}