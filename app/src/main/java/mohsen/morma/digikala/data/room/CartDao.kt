package mohsen.morma.digikala.data.room

import androidx.room.Dao
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

}