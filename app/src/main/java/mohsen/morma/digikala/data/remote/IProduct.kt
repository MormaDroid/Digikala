package mohsen.morma.digikala.data.remote

import mohsen.morma.digikala.data.remote.model.NetworkModel
import mohsen.morma.digikala.data.remote.model.home.AmazingProductModel
import mohsen.morma.digikala.data.remote.model.product.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IProduct {

    @GET("api/v1/getProductById")
    suspend fun getProductById(
        @Query("id") id : String
    ) : Response<NetworkModel<ProductResponse>>

    @GET("api/v1/getSimilarProducts")
    suspend fun getSimilarProducts(
        @Query("categoryId") categoryId : String
    ) : Response<NetworkModel<List<AmazingProductModel>>>

}