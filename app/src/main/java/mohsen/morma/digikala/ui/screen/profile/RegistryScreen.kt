package mohsen.morma.digikala.ui.screen.profile

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import mohsen.morma.digikala.R
import mohsen.morma.digikala.data.datastore.DatastoreVM
import mohsen.morma.digikala.data.remote.NetworkResult
import mohsen.morma.digikala.data.remote.model.profile.ProfileScreenState
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.Constants
import mohsen.morma.digikala.util.InputValidation.isValidPassword
import mohsen.morma.digikala.viewmodel.ProfileVM

@Composable
fun RegistryScreen(
    profileVM: ProfileVM = hiltViewModel(),
    datastoreVM: DatastoreVM = hiltViewModel()
) {

    val context = LocalContext.current

    LaunchedEffect(Dispatchers.Main) {
        profileVM.loginResult.collectLatest { result ->
            when (result) {
                is NetworkResult.Success -> {
                    result.data?.let { user ->
                        if (user.token.isNotEmpty()) {

                            Log.e(Constants.TAG, "RegistryScreen: ${user.token} ")

                            datastoreVM.saveUserToken(user.token)
                            datastoreVM.saveUserId(user.id)
                            datastoreVM.saveUserPhoneNumber(user.phone)
                            Constants.USER_PHONE = user.phone
                            Constants.USER_TOKEN = user.token

                            datastoreVM.saveUserPassword(profileVM.inputPasswordState)

                            profileVM.screenState = ProfileScreenState.PROFILE_STATE
                        }
                    }

                    profileVM.isLoading = false

                }

                is NetworkResult.Error -> {

                    profileVM.isLoading = false

                    Toast.makeText(
                        context,
                        context.getText(R.string.password_error),
                        Toast.LENGTH_LONG
                    ).show()
                }

                is NetworkResult.Loading -> {}
            }
        }
    }
    Column(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 16.dp)
    ) {

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


        Spacer(modifier = Modifier.size(48.dp))


        Column(Modifier.fillMaxWidth(), Arrangement.Center, Alignment.CenterHorizontally) {
            Text(
                text = stringResource(id = R.string.set_password_text),
                style = Typography.h5,
                color = Color.Gray.copy(0.7f),
                textAlign = TextAlign.Start
            )
        }


        Spacer(modifier = Modifier.size(20.dp))


        ProfileEditText(
            profileVM.inputPhoneState,
            stringResource(id = R.string.phone_and_email),
            isEnable = false
        ) {}


        Spacer(modifier = Modifier.size(36.dp))


        ProfileEditText(
            profileVM.inputPasswordState,
            stringResource(id = R.string.set_password),
        ) {
            profileVM.inputPasswordState = it
        }


        Spacer(modifier = Modifier.size(36.dp))


        if (profileVM.isLoading) ProfileLoadingButton()
        else
            ProfileButton(stringResource(id = R.string.digikala_login)) {
                if (isValidPassword(profileVM.inputPasswordState)) {
                    profileVM.login()
                } else {
                    Toast.makeText(
                        context,
                        context.getText(R.string.password_format_error),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }


}