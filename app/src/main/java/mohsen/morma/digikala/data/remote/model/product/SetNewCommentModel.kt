package mohsen.morma.digikala.data.remote.model.product

data class SetNewCommentModel(
    val token  :String,
    val productId : String,
    val star : Int,
    val title : String,
    val description : String,
    val userName : String
)
