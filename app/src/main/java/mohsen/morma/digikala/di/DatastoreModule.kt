package mohsen.morma.digikala.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import mohsen.morma.digikala.data.datastore.DatastoreImpl
import mohsen.morma.digikala.data.datastore.IDatastore

@Module
@InstallIn(SingletonComponent::class)
object DatastoreModule {

    @Provides
    fun provideDatastore(@ApplicationContext context: Context): IDatastore = DatastoreImpl(context)

}