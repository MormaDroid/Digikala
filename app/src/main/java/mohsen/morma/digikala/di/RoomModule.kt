package mohsen.morma.digikala.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import mohsen.morma.digikala.data.room.CartDao
import mohsen.morma.digikala.data.room.DigikalaDatabase
import mohsen.morma.digikala.util.Constants

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    fun provideRoom(@ApplicationContext context: Context): DigikalaDatabase =
        Room.databaseBuilder(context, DigikalaDatabase::class.java, Constants.DATABASE_NAME)
            .allowMainThreadQueries().build()

    @Provides
    fun provideCartDao(database: DigikalaDatabase): CartDao = database.cartDao()

}