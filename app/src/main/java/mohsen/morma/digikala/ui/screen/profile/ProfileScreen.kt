package mohsen.morma.digikala.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import mohsen.morma.digikala.R
import mohsen.morma.digikala.data.datastore.DatastoreVM
import mohsen.morma.digikala.data.remote.model.profile.ProfileScreenState
import mohsen.morma.digikala.ui.screen.profile.profile_ui.MyOrdersSection
import mohsen.morma.digikala.ui.screen.profile.profile_ui.ProfileHeader
import mohsen.morma.digikala.ui.screen.profile.profile_ui.ProfileMenuSection
import mohsen.morma.digikala.ui.screen.profile.profile_ui.ProfileMiddleSection
import mohsen.morma.digikala.viewmodel.ProfileVM

@Composable
fun ProfileScreen(
    profileVM: ProfileVM = hiltViewModel(),
    datastoreVM: DatastoreVM = hiltViewModel()
) {

    val userToken = datastoreVM.restoreUserToken()

    if (!userToken.isNullOrBlank() && userToken != "null") {
        ProfileUI()
    } else {
        when (profileVM.screenState) {
            ProfileScreenState.LOGIN_STATE -> LoginScreen()
            ProfileScreenState.PROFILE_STATE -> ProfileUI()
            ProfileScreenState.REGISTRY_STATE -> RegistryScreen()
        }
    }


}

@Composable
fun ProfileUI() {

//    AppConfig()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 16.dp)
    ) {

        item {
            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically) {

                IconButton(onClick = { /*TODO*/ }) {

                    Icon(
                        painter = painterResource(id = R.drawable.digi_settings),
                        contentDescription = null,
                        Modifier.size(28.dp)
                    )

                }

                IconButton(onClick = { /*TODO*/ }) {

                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        Modifier.size(28.dp)
                    )

                }

            }
        }
        item { ProfileHeader() }
        item { ProfileMiddleSection() }
        item { MyOrdersSection() }
        item { CenterBannerItem(painter = painterResource(id = R.drawable.digiclub1)) }
        item { ProfileMenuSection() }
        item { CenterBannerItem(painter = painterResource(id = R.drawable.digiclub2)) }
        item { Spacer(modifier = Modifier.size(65.dp))}


    }

}

@Composable
fun CenterBannerItem(painter: Painter) {
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 12.dp)
            .clip(RoundedCornerShape(8.dp)),
        contentScale = ContentScale.FillBounds
    )
}






