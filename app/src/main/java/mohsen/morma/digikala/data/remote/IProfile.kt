package mohsen.morma.digikala.data.remote

import mohsen.morma.digikala.data.remote.model.NetworkModel
import mohsen.morma.digikala.data.remote.model.profile.LoginRequestModel
import mohsen.morma.digikala.data.remote.model.profile.LoginResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface IProfile {

    @POST("api/v1/login")
    suspend fun login(@Body login: LoginRequestModel) : Response<NetworkModel<LoginResponseModel>>

}