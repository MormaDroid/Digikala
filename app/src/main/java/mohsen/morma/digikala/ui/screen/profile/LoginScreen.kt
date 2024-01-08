package mohsen.morma.digikala.ui.screen.profile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import mohsen.morma.digikala.R
import mohsen.morma.digikala.data.remote.model.profile.ProfileScreenState
import mohsen.morma.digikala.ui.theme.DigikalaBlue
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.InputValidation
import mohsen.morma.digikala.viewmodel.ProfileVM

@Composable
fun LoginScreen(profileVM: ProfileVM = hiltViewModel()) {

    val context  = LocalContext.current

    LazyColumn(
        Modifier
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

        item { Spacer(modifier = Modifier.size(128.dp)) }

        item {
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                Arrangement.Center,
                Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.digi_smile),
                    contentDescription = null,
                    Modifier.size(200.dp)
                )
            }
        }

        item { Spacer(modifier = Modifier.size(48.dp)) }

        item {
            Column(Modifier.fillMaxWidth(), Arrangement.Center, Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.loginTxt),
                    style = Typography.h5,
                    color = Color.Gray.copy(0.7f),
                    textAlign = TextAlign.Start
                )
            }
        }

        item { Spacer(modifier = Modifier.size(20.dp)) }

        item {
            ProfileEditText(
                profileVM.inputPhoneState,
                stringResource(id = R.string.phone_and_email),
            ) {
                profileVM.inputPhoneState = it
            }
        }

        item { Spacer(modifier = Modifier.size(20.dp)) }

        item {
            ProfileButton(stringResource(id = R.string.digikala_entry)) {
                if (InputValidation.isValidEmail(profileVM.inputPhoneState) || InputValidation.isValidPhone(profileVM.inputPhoneState)){
                    profileVM.screenState = ProfileScreenState.REGISTRY_STATE
                }else{
                    Toast.makeText(
                        context,
                        context.getText(R.string.login_error),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        item { Spacer(modifier = Modifier.size(36.dp)) }

        item { Divider(color = Color.Gray.copy(0.1f)) }

        item { Spacer(modifier = Modifier.size(36.dp)) }

        item {
            TermsAndRulesText(
                fullText = stringResource(id = R.string.terms_and_rules_full),
                DigikalaBlue,
                underlineText = listOf(
                    stringResource(id = R.string.terms_and_rules),
                    stringResource(id = R.string.privacy_and_rules)
                ),
                FontWeight.Bold,
                TextDecoration.Underline
            )
        }


    }

}