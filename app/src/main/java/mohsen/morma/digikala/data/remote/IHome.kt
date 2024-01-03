package mohsen.morma.digikala.data.remote

import mohsen.morma.digikala.data.remote.model.NetworkModel
import mohsen.morma.digikala.data.remote.model.home.AmazingProductModel
import mohsen.morma.digikala.data.remote.model.home.CenterBannerModel
import mohsen.morma.digikala.data.remote.model.home.HomeCategoryModel
import mohsen.morma.digikala.data.remote.model.home.SliderModel
import retrofit2.Response
import retrofit2.http.GET

interface IHome {

    @GET("api/v1/getSlider")
    suspend fun getSlider() : Response<NetworkModel<List<SliderModel>>>

    @GET("api/v1/getAmazingProducts")
    suspend fun getAmazingProduct() : Response<NetworkModel<List<AmazingProductModel>>>

    @GET("api/v1/getSuperMarketAmazingProducts")
    suspend fun getSuperMarketAmazingProducts() : Response<NetworkModel<List<AmazingProductModel>>>

    @GET("api/v1/get4Banners")
    suspend fun get4Banners() : Response<NetworkModel<List<CenterBannerModel>>>

    @GET("api/v1/getCategories")
    suspend fun getCategories() : Response<NetworkModel<List<HomeCategoryModel>>>

}