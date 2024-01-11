package mohsen.morma.digikala.data.remote

import mohsen.morma.digikala.data.remote.model.NetworkModel
import mohsen.morma.digikala.data.remote.model.home.AmazingProductModel
import mohsen.morma.digikala.data.remote.model.product.ProductResponse
import mohsen.morma.digikala.data.remote.model.product.SetNewCommentModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
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

    @POST("api/v1/setNewComment")
    suspend fun setNewComment(
        @Body comment : SetNewCommentModel
    ) : Response<NetworkModel<String>>



}