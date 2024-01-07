package mohsen.morma.digikala.repository

import mohsen.morma.digikala.data.remote.BaseApiResponse
import mohsen.morma.digikala.data.remote.IBasket
import mohsen.morma.digikala.data.room.CartDao
import mohsen.morma.digikala.data.room.CartEntity
import mohsen.morma.digikala.data.room.CartStatus
import javax.inject.Inject

class BasketRepository @Inject constructor(
    private val api : IBasket,
    private val dao : CartDao
) : BaseApiResponse() {

    suspend fun getAllProducts() = safeApiCall { api.getAllProducts() }

    suspend fun insertCartItem(cartEntity: CartEntity) { dao.addCartItem(cartEntity)}

    fun getCurrentCart() = dao.getAllCart(CartStatus.CURRENT_CARD)

}