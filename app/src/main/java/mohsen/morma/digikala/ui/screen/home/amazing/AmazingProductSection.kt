package mohsen.morma.digikala.ui.screen.home.amazing

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import mohsen.morma.digikala.data.remote.NetworkResult
import mohsen.morma.digikala.data.remote.model.home.AmazingProductModel
import mohsen.morma.digikala.util.Constants.TAG

@Composable
fun AmazingProductSection(
    result: NetworkResult<List<AmazingProductModel>>,
    backgroundColor: Color,
    amazingIcon: Int,
    amazingText: Int,
    navController: NavHostController
) {

    var amazingList by remember {
        mutableStateOf<List<AmazingProductModel>>(emptyList())
    }

    var isLoading by remember {
        mutableStateOf(true)
    }

    when (result) {

        is NetworkResult.Success -> {
            result.data?.let { amazingList = it }
            isLoading = false
        }

        is NetworkResult.Error -> {
            isLoading = true
            Log.e(TAG, "AmazingProductSection: ${result.message}")
        }

        is NetworkResult.Loading -> {
            isLoading = true
        }

    }

    AmazingLazyRowSection(isLoading, amazingList, navController, amazingIcon, amazingText,backgroundColor)

}






