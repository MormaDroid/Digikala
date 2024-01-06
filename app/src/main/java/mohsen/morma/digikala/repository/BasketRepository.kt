package mohsen.morma.digikala.repository

import mohsen.morma.digikala.data.remote.BaseApiResponse
import mohsen.morma.digikala.data.remote.IBasket
import javax.inject.Inject

class BasketRepository @Inject constructor(private val api : IBasket) : BaseApiResponse() {

    suspend fun getAllProducts() = safeApiCall { api.getAllProducts() }

}