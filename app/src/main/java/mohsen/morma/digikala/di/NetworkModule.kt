package mohsen.morma.digikala.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mohsen.morma.digikala.data.remote.IBasket
import mohsen.morma.digikala.data.remote.ICategory
import mohsen.morma.digikala.data.remote.ICheckout
import mohsen.morma.digikala.data.remote.IHome
import mohsen.morma.digikala.data.remote.IProduct
import mohsen.morma.digikala.data.remote.IProfile
import mohsen.morma.digikala.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    internal fun interceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideClient(interceptor: HttpLoggingInterceptor): OkHttpClient = OkHttpClient.Builder()
        .readTimeout(Constants.TIMEOUT_TIME, TimeUnit.SECONDS)
        .writeTimeout(Constants.TIMEOUT_TIME, TimeUnit.SECONDS)
        .connectTimeout(Constants.TIMEOUT_TIME, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("x-api-key", Constants.X_API_KEY)
                .addHeader("lang", Constants.USER_LANG)
            chain.proceed(request.build())
        }
        .build()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    fun provideHomeInterface(retrofit: Retrofit): IHome = retrofit.create(IHome::class.java)

    @Provides
    fun provideCategoryInterface(retrofit: Retrofit): ICategory =
        retrofit.create(ICategory::class.java)

    @Provides
    fun provideBasketInterface(retrofit: Retrofit): IBasket = retrofit.create(IBasket::class.java)

    @Provides
    fun provideProfileInterface(retrofit: Retrofit): IProfile =
        retrofit.create(IProfile::class.java)

    @Provides
    fun provideCheckoutInterface(retrofit: Retrofit): ICheckout =
        retrofit.create(ICheckout::class.java)

    @Provides
    fun provideProductInterface(retrofit: Retrofit): IProduct =
        retrofit.create(IProduct::class.java)

}