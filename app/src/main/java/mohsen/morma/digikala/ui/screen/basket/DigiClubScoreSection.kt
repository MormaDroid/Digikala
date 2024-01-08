package mohsen.morma.digikala.ui.screen.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.R
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.DigitHelper

@Composable
fun DigiClubScoreSection(totalCont : Int) {
    Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically) {

        Row {
            Image(
                painter = painterResource(id = R.drawable.digi_score),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = stringResource(id = R.string.digiclub_score),
                style = Typography.h5,
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray.copy(0.9f)
            )
        }

        Text(
            text = DigitHelper.digitBySeparatorAndLocate((totalCont * 7).toString())+ " " + stringResource(id = R.string.score),
            style = Typography.h5,
            fontWeight = FontWeight.Bold,
        )

    }

    Spacer(modifier = Modifier.size(36.dp))

    Text(
        text = stringResource(id = R.string.digiclub_info),
        style = Typography.h6,
        color = Color.Gray.copy(0.7f),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Start
    )

}