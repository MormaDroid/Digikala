package mohsen.morma.digikala.data.remote

import mohsen.morma.digikala.data.remote.model.NetworkModel
import mohsen.morma.digikala.data.remote.model.category.CategoryModel
import retrofit2.Response
import retrofit2.http.GET

interface ICategory {

    @GET("api/v1/getSubCategories")
    suspend fun getCategories(): Response<NetworkModel<CategoryModel>>

}