package mohsen.morma.digikala.repository

import mohsen.morma.digikala.data.remote.BaseApiResponse
import mohsen.morma.digikala.data.remote.IProduct
import mohsen.morma.digikala.data.remote.model.product.SetNewCommentModel
import javax.inject.Inject

class ProductRepository @Inject constructor(private val api: IProduct) : BaseApiResponse() {

    suspend fun getProduct(id: String) = safeApiCall { api.getProductById(id) }

    suspend fun getSimilarProducts(categoryId: String) =
        safeApiCall { api.getSimilarProducts(categoryId) }

    suspend fun setNewComment(comment: SetNewCommentModel) =
        safeApiCall { api.setNewComment(comment) }

}