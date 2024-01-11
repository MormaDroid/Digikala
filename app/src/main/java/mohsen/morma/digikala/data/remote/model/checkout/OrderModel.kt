package mohsen.morma.digikala.data.remote.model.checkout

import mohsen.morma.digikala.data.room.CartEntity

data class OrderModel(
    val orderAddress: String,
    val orderDate: String,
    val orderTotalDiscount: Int,
    val orderTotalPrice: Int,
    val orderUserName: String,
    val orderUserPhone: String,
    val token: String,
    val orderProducts: List<CartEntity>
)