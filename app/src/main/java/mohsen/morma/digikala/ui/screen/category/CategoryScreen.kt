package mohsen.morma.digikala.ui.screen.category

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import mohsen.morma.digikala.ui.screen.home.SearchBarSection
import mohsen.morma.digikala.viewmodel.CategoryVM

@Composable
fun CategoryScreen(categoryVM: CategoryVM = hiltViewModel()) {

    categoryApiRequest(categoryVM)

    CategoryUI()

}

@Composable
fun CategoryUI(categoryVM: CategoryVM = hiltViewModel()) {
    var isRefresh by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(isRefresh) {
        if (isRefresh) {
            categoryApiRequest(categoryVM)
            delay(3000)
            isRefresh = false
        }

    }

    val refresh = rememberSwipeRefreshState(isRefreshing = isRefresh)

    SwipeRefresh(state = refresh, onRefresh = { isRefresh = true }) {

        LazyColumn(Modifier.fillMaxSize()) {

            item { SearchBarSection() }

            item { SubCategorySection() }

            item { Spacer(modifier = Modifier.size(65.dp)) }

        }

    }
}

private fun categoryApiRequest(categoryVM: CategoryVM) {
        categoryVM.categoryApiRequest()
    }