package mohsen.morma.digikala.repository

import mohsen.morma.digikala.data.remote.BaseApiResponse
import mohsen.morma.digikala.data.remote.IHome
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api : IHome) :BaseApiResponse() {


    suspend fun getSlider()  = safeApiCall { api.getSlider() }

    suspend fun getAmazingProduct() = safeApiCall { api.getAmazingProduct() }

    suspend fun getSuperMarketAmazingProducts() = safeApiCall { api.getSuperMarketAmazingProducts() }

    suspend fun get4Banners() = safeApiCall { api.get4Banners() }

    suspend fun getCategories() = safeApiCall { api.getCategories() }

    suspend fun getCenterBanners() = safeApiCall { api.getCenterBanners() }

    suspend fun getBestSeller()  = safeApiCall { api.getBestSeller() }

    suspend fun getMostFavorite()  = safeApiCall { api.getMostFavorite() }

}