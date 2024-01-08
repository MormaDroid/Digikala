package mohsen.morma.digikala.repository

import mohsen.morma.digikala.data.remote.BaseApiResponse
import mohsen.morma.digikala.data.remote.IBasket
import mohsen.morma.digikala.data.room.CartDao
import mohsen.morma.digikala.data.room.CartEntity
import mohsen.morma.digikala.data.room.CartStatus
import javax.inject.Inject

class BasketRepository @Inject constructor(
    private val api: IBasket,
    private val dao: CartDao
) : BaseApiResponse() {

    suspend fun getAllProducts() = safeApiCall { api.getAllProducts() }

    suspend fun insertCartItem(cartEntity: CartEntity) { dao.addCartItem(cartEntity) }


    fun getCurrentCart() = dao.getAllCart(CartStatus.CURRENT_CARD)

    fun getNextCart() = dao.getAllCart(CartStatus.NEXT_CARD)

    suspend fun deleteCart(cartEntity: CartEntity) = dao.deleteCart(cartEntity)

    suspend fun changeCountCartItem(id: String, newCount: Int) {
        dao.changeCountCartItem(id, newCount)
    }

    suspend fun changeCartStatus(id: String, newCartStatus: CartStatus) {
        dao.changeCartStatus(id, newCartStatus)
    }

    fun getTotalCurrentCartCount() = dao.getTotalCartCount(CartStatus.CURRENT_CARD)
    fun getTotalNextCartCount() = dao.getTotalCartCount(CartStatus.NEXT_CARD)
}