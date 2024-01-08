package mohsen.morma.digikala.ui.screen.basket

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.R
import mohsen.morma.digikala.ui.theme.DigikalaDarkRed
import mohsen.morma.digikala.ui.theme.DigikalaRed
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.Constants.PERSIAN_LANG
import mohsen.morma.digikala.util.Constants.USER_LANG
import mohsen.morma.digikala.util.DigitHelper

@Composable
fun BuyProcessContinue(payablePrice: Int) {

    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .height(64.dp)
            .width(212.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSystemInDarkTheme()) DigikalaDarkRed else DigikalaRed
        )
    ) {
        Text(
            text = stringResource(id = R.string.continue_purchase),
            style = Typography.h3,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }


    Column {

        Text(
            text = stringResource(id = R.string.total_basket),
            style = Typography.h6,
            color = Color.Gray.copy(0.7f)
        )

        Row(verticalAlignment = Alignment.CenterVertically) {

            Text(
                text = DigitHelper.digitBySeparatorAndLocate(payablePrice.toString()),
                style = Typography.h4,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.size(4.dp))

            Icon(
                painter = painterResource(id = if (USER_LANG == PERSIAN_LANG) R.drawable.toman else R.drawable.dollar),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )

        }

    }

}