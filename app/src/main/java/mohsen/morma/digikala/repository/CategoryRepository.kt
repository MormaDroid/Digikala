package mohsen.morma.digikala.repository

import mohsen.morma.digikala.data.remote.BaseApiResponse
import mohsen.morma.digikala.data.remote.ICategory
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val api : ICategory) : BaseApiResponse() {

    suspend fun getTool() = safeApiCall { api.getCategories() }

}