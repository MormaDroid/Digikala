package mohsen.morma.digikala.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CartEntities(
    @ColumnInfo
    @PrimaryKey
    val id: String,
    @ColumnInfo
    val discountPercent: Int,
    @ColumnInfo
    val image: String,
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val price: Int,
    @ColumnInfo
    val seller: String
)

