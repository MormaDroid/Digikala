package mohsen.morma.digikala.data.remote

import mohsen.morma.digikala.data.remote.model.NetworkModel
import mohsen.morma.digikala.data.remote.model.home.SliderModel
import retrofit2.Response
import retrofit2.http.GET

interface IHome {

    @GET("api/v1/getSlider")
    suspend fun getSlider() : Response<NetworkModel<List<SliderModel>>>

}