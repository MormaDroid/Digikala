package mohsen.morma.digikala.ui.screen.checkout

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import mohsen.morma.digikala.R
import mohsen.morma.digikala.data.remote.NetworkResult
import mohsen.morma.digikala.ui.theme.DigikalaBlue
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.Constants.TAG
import mohsen.morma.digikala.viewmodel.AddressVM

@Composable
fun CartAddressSection(addressVM: AddressVM = hiltViewModel()) {

    val context = LocalContext.current

    var address by remember {
        mutableStateOf("")
    }
    var addressName by remember {
        mutableStateOf("")
    }

    var isLoading by remember {
        mutableStateOf(true)
    }

    val addressResult by addressVM.addressList.collectAsState()

    when (addressResult) {
        is NetworkResult.Success -> {

            Log.e(TAG, "success")

            addressResult.data?.let {
                Log.e(TAG, "CartAddressSection:${it[0].address}")
                if (it.isEmpty()) {
                    address = context.getText(R.string.no_address).toString()
                    addressName = ""
                } else {
                    address = it[0].address
                    addressName = it[0].name
                }

            }
            isLoading = false
        }

        is NetworkResult.Error -> {
            Log.e(TAG, "ERR")
            isLoading = true
            Log.e(TAG, "CenterBanners: ${addressResult.message}")
        }

        is NetworkResult.Loading -> {
            isLoading = true
        }
    }


    Column {
        Row(Modifier.fillMaxWidth()) {

            Image(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                Modifier
                    .size(36.dp)
                    .weight(0.15f)
                    .align(Alignment.CenterVertically),
            )

            Spacer(modifier = Modifier.size(8.dp))

            Column(Modifier.weight(0.85f), Arrangement.Center, Alignment.Start) {

                Text(
                    text = stringResource(id = R.string.send_to),
                    style = Typography.h6,
                    color = DigikalaBlue
                )



                Text(
                    text = address,
                    style = Typography.h4,
                    fontWeight = FontWeight.Bold,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = addressName,
                    style = Typography.h5,
                    fontWeight = FontWeight.Bold
                )

            }

        }

        Spacer(modifier = Modifier.size(16.dp))

        Row(Modifier.fillMaxWidth(), Arrangement.End, Alignment.CenterVertically) {

            Text(
                text = stringResource(id = R.string.change_or_edit_address),
                style = Typography.h6,
                color = DigikalaBlue
            )

            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = DigikalaBlue
            )

        }

        CheckoutDivider(36.dp)

    }
}
