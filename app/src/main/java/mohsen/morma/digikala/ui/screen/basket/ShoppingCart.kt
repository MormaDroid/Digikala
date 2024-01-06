package mohsen.morma.digikala.ui.screen.basket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingCart() {

    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(bottom = 65.dp)){

        item { EmptyShoppingCart() }

        item { Spacer(modifier = Modifier.fillMaxWidth().height(2.dp).background(Color.LightGray)) }

        item { SuggestionListSection() }

    }

}