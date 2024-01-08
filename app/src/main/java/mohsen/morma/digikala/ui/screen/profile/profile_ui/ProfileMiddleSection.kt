package mohsen.morma.digikala.ui.screen.profile.profile_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.R
import mohsen.morma.digikala.ui.theme.Typography

@Composable
fun ProfileMiddleSection() {

    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(8.dp)
            .alpha(0.4f)
            .shadow(2.dp),
        color = Color.LightGray,
    )

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp)
    ) {
        MiddleItem(R.drawable.digi_user, R.string.auth)

        MiddleItem(R.drawable.digi_contact_us, R.string.contact_us)

        MiddleItem(R.drawable.digi_club, R.string.club)

    }


    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(8.dp)
            .alpha(0.4f)
            .shadow(2.dp),
        color = Color.LightGray,
    )


}

@Composable
private fun MiddleItem(icon: Int, title: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "",
            modifier = Modifier
                .size(60.dp)
                .padding(bottom = 8.dp)
        )
        Text(
            style = Typography.h6,
            color = Color.Gray,
            text = stringResource(title)
        )
    }
}
