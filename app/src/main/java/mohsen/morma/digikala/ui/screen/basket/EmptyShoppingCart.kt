package mohsen.morma.digikala.ui.screen.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.R
import mohsen.morma.digikala.ui.theme.Typography

@Composable
fun EmptyShoppingCart() {

    Column(
        Modifier
            .fillMaxWidth()
            .height(296.dp)
            .padding(horizontal = 8.dp, vertical = 16.dp), Arrangement.Center, Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.empty_basket),
            contentDescription = null,
            modifier = Modifier
                .width(200.dp)
                .height(164.dp),
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.size(16.dp))

        Text(text = stringResource(id = R.string.empty_basket), style = Typography.h3)

    }

}