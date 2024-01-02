package mohsen.morma.digikala.ui.screen.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import mohsen.morma.digikala.viewmodel.HomeVM

@Composable
fun HomeScreen(homeVM: HomeVM = hiltViewModel()) {

    homeVM.apiRequest()

    HomeUI()

}

@Composable
fun HomeUI() {

    LazyColumn {

        item { SearchBarSection() }

        item { Spacer(modifier = Modifier.size(20.dp)) }

        item { TopSliderSection() }
    }


}
