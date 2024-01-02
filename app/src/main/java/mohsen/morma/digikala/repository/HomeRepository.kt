package mohsen.morma.digikala.repository

import mohsen.morma.digikala.data.remote.BaseApiResponse
import mohsen.morma.digikala.data.remote.IHome
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api : IHome) :BaseApiResponse() {


    suspend fun getSlider()  = safeApiCall { api.getSlider() }

}