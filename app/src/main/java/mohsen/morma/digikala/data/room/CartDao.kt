package mohsen.morma.digikala.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCartItem(cartEntity: CartEntity)

    @Query("SELECT * From CartEntity where cartStatus =:cartStatus")
    fun getAllCart(cartStatus: CartStatus): Flow<List<CartEntity>>

    @Delete
    suspend fun deleteCart(cartEntity: CartEntity)

    @Query("Update CartEntity Set count =:newCount where id =:id ")
    suspend fun changeCountCartItem(id:String,newCount:Int)

    @Query("update CartEntity set cartStatus =:newCartStatus where id=:id")
    suspend fun changeCartStatus(id: String,newCartStatus: CartStatus)

    @Query("select total(count) as count from CartEntity where cartStatus =:status")
    fun getTotalCartCount(status: CartStatus) : Flow<Int>

}