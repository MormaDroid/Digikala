package mohsen.morma.digikala.ui.screen.profile.profile_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.R
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.Constants
import mohsen.morma.digikala.util.DigitHelper.digitByLocate

@Composable
fun ProfileHeader() {

        Spacer(modifier = Modifier.height(24.dp))


            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "یوز نیم",
                textAlign = TextAlign.Center,
                style = Typography.h5
            )




        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = Typography.h6,
            color = Color.Gray.copy(0.7f),
            text = digitByLocate(Constants.USER_PHONE)
        )

        Spacer(modifier = Modifier.size(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Row(
                modifier = Modifier
                    .weight(0.49f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.digi_score),
                    contentDescription = "",
                    modifier = Modifier
                        .size(42.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            style = Typography.h5,
                            color = Color.Gray.copy(0.7f),
                            text = "${digitByLocate("975")} "
                        )
                        Text(
                            style = Typography.h6,
                            color = Color.Gray.copy(0.7f),
                            text = stringResource(R.string.score)
                        )
                    }

                    Text(
                        style = Typography.h6,
                        fontWeight = FontWeight.Bold,
                        text = stringResource(id = R.string.digiclub_score)
                    )
                }


            }

            Divider(
                modifier = Modifier
                    .width(2.dp)
                    .height(60.dp)
                    .alpha(0.3f),
                color = Color.Gray,
            )

            Column(
                modifier = Modifier.weight(0.49f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.digi_wallet),
                    contentDescription = "",
                    modifier = Modifier
                        .size(34.dp)
                )

                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    style = Typography.h6,
                    fontWeight = FontWeight.Bold,
                    text = stringResource(id = R.string.active_wallet)
                )

            }

        }

        Spacer(modifier = Modifier.height(24.dp))



}