package mohsen.morma.digikala.data.remote.model

data class BestSellerAndFavoriteModel(
    val _id: String,
    val discountPercent: Int,
    val image: String,
    val name: String,
    val price: Int,
    val seller: String
)