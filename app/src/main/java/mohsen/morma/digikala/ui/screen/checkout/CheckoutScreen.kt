package mohsen.morma.digikala.ui.screen.checkout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CheckoutScreen(navController: NavHostController) {




    Box(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {

        LazyColumn {

            item { CheckoutTopBarSection(navController) }

            item { CheckoutDivider() }

            item { Spacer(modifier = Modifier.size(12.dp)) }

            item { CartAddressSection() }

        }

    }

}


