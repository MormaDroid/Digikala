package mohsen.morma.digikala.data.remote.model.product

import com.google.gson.JsonObject


data class ProductResponse(
    val id: String? = null,
    val agreeCount: Int? = null,
    val agreePercent: Int? = null,
    val colors: List<Color>? = null,
    val commentCount: Int? = null,
    val comments: List<Comment>? = null,
    val discountPercent: Int? = null,
    val imageSlider: List<ImageSlider>? = null,
    val name: String? = null,
    val price: Int? = null,
    val questionCount: Int? = null,
    val seller: String? = null,
    val star: Double? = null,
    val starCount: Int? = null,
    val viewCount: Int? = null,
    val category: String? = null,
    val categoryId: String? = null,
    val description: String? = null,
    val technicalFeatures: JsonObject? = null
)