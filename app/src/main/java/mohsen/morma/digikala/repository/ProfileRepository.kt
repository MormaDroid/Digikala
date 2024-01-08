package mohsen.morma.digikala.repository

import mohsen.morma.digikala.data.remote.BaseApiResponse
import mohsen.morma.digikala.data.remote.IProfile
import mohsen.morma.digikala.data.remote.model.profile.LoginRequestModel
import javax.inject.Inject

class ProfileRepository @Inject constructor(private  val api : IProfile) : BaseApiResponse() {


    suspend fun login(login : LoginRequestModel) = safeApiCall { api.login(login) }

}