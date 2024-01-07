package mohsen.morma.digikala.ui.screen.basket

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import mohsen.morma.digikala.data.room.CartEntity
import mohsen.morma.digikala.ui.theme.Typography

@Composable
fun CartItemCard(cartEntity: CartEntity) {

    Column(Modifier.fillMaxSize()) {

        Text(text = "name: ${cartEntity.name} count: ${cartEntity.count}", style = Typography.h4)

    }

}