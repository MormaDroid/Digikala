package mohsen.morma.digikala.ui.screen.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import mohsen.morma.digikala.R
import mohsen.morma.digikala.ui.screen.home.amazing.AmazingProductSection
import mohsen.morma.digikala.ui.theme.DigikalaDarkGreen
import mohsen.morma.digikala.ui.theme.DigikalaDarkRed
import mohsen.morma.digikala.ui.theme.DigikalaGreen
import mohsen.morma.digikala.ui.theme.DigikalaRed
import mohsen.morma.digikala.util.Constants
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

    LaunchedEffect(isRefresh) {
        if (isRefresh) {
            apiRequest(homeVM)
            delay(3000)
            isRefresh = false
        }

    }

    val refresh = rememberSwipeRefreshState(isRefreshing = isRefresh)

    SwipeRefresh(state = refresh, onRefresh = { isRefresh = true }) {
        LazyColumn(Modifier.fillMaxSize()) {

            item { SearchBarSection() }

            item { Spacer(modifier = Modifier.size(20.dp)) }

            item { TopSliderSection() }

            item { Spacer(modifier = Modifier.size(36.dp)) }

            item { ShowCaseSection() }

            item { Spacer(modifier = Modifier.size(20.dp)) }

            item {
                AmazingProductSection(
                    homeVM.amazingList.collectAsState().value,
                    if (isSystemInDarkTheme()) DigikalaDarkRed else DigikalaRed,
                    R.drawable.box,
                    if (Constants.USER_LANG == Constants.PERSIAN_LANG) R.drawable.amazings else R.drawable.amazing_en
                )
            }

            item { Spacer(modifier = Modifier.size(12.dp)) }

            item { CenterBanners() }

            item { Spacer(modifier = Modifier.size(12.dp)) }

            item {
                AmazingProductSection(
                    homeVM.superMarketAmazingList.collectAsState().value,
                    if (isSystemInDarkTheme()) DigikalaDarkGreen else DigikalaGreen,
                    R.drawable.market_box,
                    if (Constants.USER_LANG == Constants.PERSIAN_LANG) R.drawable.supermarketamazings else R.drawable.amazing_en
                )
            }

            item { Spacer(modifier = Modifier.size(20.dp)) }

            item { HomeCategorySection() }

            item { Spacer(modifier = Modifier.size(20.dp)) }

            item { HomeBanners(0) }

            item { Spacer(modifier = Modifier.size(20.dp)) }

            item { HomeBanners(3) }

            item { Spacer(modifier = Modifier.size(20.dp)) }

            item { BestSellerAndFavoriteSection(homeVM.bestSellerList.collectAsState().value,R.string.best_seller)}

            item { Spacer(modifier = Modifier.size(20.dp)) }

            item { HomeBanners(1) }

            item { Spacer(modifier = Modifier.size(20.dp)) }

            item { BestSellerAndFavoriteSection(homeVM.mostFavoriteList.collectAsState().value,R.string.most_favorite) }

            item { Spacer(modifier = Modifier.size(20.dp)) }

            item { HomeBanners(2) }

            item { Spacer(modifier = Modifier.size(20.dp)) }

            item { HomeBanners(4) }

            item { Spacer(modifier = Modifier.size(64.dp)) }
        }
    }
}

private fun apiRequest(homeVM: HomeVM) {
    homeVM.homeApiRequest()
}
