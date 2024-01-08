package mohsen.morma.digikala.data.remote.model.profile

data class LoginResponseModel(
    val id: String,
    val phone: String,
    val role: String,
    val token: String
)