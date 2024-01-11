package mohsen.morma.digikala.repository

import mohsen.morma.digikala.data.remote.BaseApiResponse
import mohsen.morma.digikala.data.remote.ICheckout
import mohsen.morma.digikala.data.remote.model.checkout.OrderModel
import javax.inject.Inject

class CheckoutRepository @Inject constructor(private val api: ICheckout) : BaseApiResponse() {

    suspend fun getUserAddress(token : String) = safeApiCall { api.getUserAddress(token) }

    suspend fun getShippingCost(address : String) = safeApiCall { api.getShippingCost(address) }

    suspend fun setNewOrder(orderModel: OrderModel) = safeApiCall { api.setNewOrder(orderModel) }


}