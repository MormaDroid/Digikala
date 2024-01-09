package mohsen.morma.digikala.ui.screen.checkout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.R
import mohsen.morma.digikala.ui.theme.Typography

@Composable
fun InvoiceSection() {

    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.LightGray.copy(0.2f))
            .padding(vertical = 16.dp, horizontal = 16.dp), Arrangement.Center, Alignment.CenterVertically
    ) {

        Icon(
            imageVector = Icons.Outlined.Info,
            contentDescription = null,
            Modifier.size(24.dp),
            tint = Color.DarkGray.copy(0.7f)
        )

        Spacer(modifier = Modifier.size(8.dp))

        Text(
            text = stringResource(id = R.string.invoice_info),
            style = Typography.h5,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray.copy(0.8f)
        )

    }

}