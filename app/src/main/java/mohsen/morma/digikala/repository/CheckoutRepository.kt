package mohsen.morma.digikala.repository

import mohsen.morma.digikala.data.remote.BaseApiResponse
import mohsen.morma.digikala.data.remote.ICheckout
import javax.inject.Inject

class CheckoutRepository @Inject constructor(private val api: ICheckout) : BaseApiResponse() {

    suspend fun getUserAddress(token : String) = safeApiCall { api.getUserAddress(token) }

}