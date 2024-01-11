package mohsen.morma.digikala.ui.screen.product

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import mohsen.morma.digikala.R
import mohsen.morma.digikala.data.remote.model.product.ProductResponse
import mohsen.morma.digikala.navigation.Screen
import mohsen.morma.digikala.ui.screen.checkout.CheckoutDivider
import mohsen.morma.digikala.ui.theme.Typography



@Composable
fun ProductDescriptionSection(navController: NavHostController,product: ProductResponse) {

    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {

        Text(
            text = stringResource(id = R.string.product_attribute),
            style = Typography.h4,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.size(16.dp))

        CheckoutDivider(spacerSize = 0.dp)

        Spacer(modifier = Modifier.size(16.dp))

        DescriptionItem(stringResource(id = R.string.product_introduction)){
            product.description?.let {
                navController.navigate(Screen.Description.withArgs(it))
            }
        }

        Spacer(modifier = Modifier.size(16.dp))

        CheckoutDivider(spacerSize = 0.dp)

        Spacer(modifier = Modifier.size(16.dp))

        DescriptionItem(stringResource(id = R.string.technical_specifications)){
            product.technicalFeatures?.let {
                navController.navigate(Screen.Technical.withArgs(it))
            }
        }

        Spacer(modifier = Modifier.size(16.dp))

    }

}

@Composable
fun DescriptionItem(string: String, onClick: () -> Unit) {
    Row(Modifier
        .fillMaxWidth()
        .clickable(
            onClick = { onClick() },
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        ), Arrangement.SpaceBetween, Alignment.CenterVertically) {

        Text(
            text = string,
            style = Typography.h4,
            fontWeight = FontWeight.Bold
        )

        Icon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = null,
            Modifier.size(24.dp)
        )
    }
}
