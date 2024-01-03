package mohsen.morma.digikala.ui.screen.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay
import mohsen.morma.digikala.viewmodel.HomeVM

@Composable
fun HomeScreen(homeVM: HomeVM = hiltViewModel()) {

    apiRequest(homeVM)
    HomeUI(homeVM)

}

@Composable
fun HomeUI(homeVM: HomeVM) {

    var isRefresh by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(isRefresh){
        if (isRefresh){
            apiRequest(homeVM)
            delay(3000)
            isRefresh = false
        }

    }

    val refresh = rememberSwipeRefreshState(isRefreshing =isRefresh )

    SwipeRefresh(state = refresh , onRefresh = { isRefresh = true }) {
        LazyColumn {

            item { SearchBarSection() }

            item { Spacer(modifier = Modifier.size(20.dp)) }

            item { TopSliderSection() }
        }
    }




}

private fun apiRequest(homeVM : HomeVM){
    homeVM.apiRequest()
}
