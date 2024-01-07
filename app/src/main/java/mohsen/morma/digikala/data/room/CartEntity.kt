package mohsen.morma.digikala.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CartEntity(

    @PrimaryKey
    val id: String,
    val discountPercent: Int,
    val image: String,
    val name: String,
    val price: Int,
    val seller: String,
    val count : Int,
    val cartStatus : CartStatus
)

