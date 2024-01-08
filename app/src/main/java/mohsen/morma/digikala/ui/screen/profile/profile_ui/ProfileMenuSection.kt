package mohsen.morma.digikala.ui.screen.profile.profile_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.R

@Composable
fun ProfileMenuSection() {

    MenuRowItem(
        icon = {
            Image(
                painter = painterResource(id = R.drawable.digi_plus_icon),
                contentDescription = "",
                modifier = Modifier
                    .size(36.dp)
                    .padding(8.dp)
            )
        },
        text = stringResource(id = R.string.digi_plus),
        isHaveDivider = true
    )
    MenuRowItem(
        icon = {
            Image(
                painter = painterResource(id = R.drawable.digi_fav_icon),
                contentDescription = "",
                modifier = Modifier
                    .size(36.dp)
                    .padding(8.dp)
            )
        },
        text = stringResource(id = R.string.fav_list),
        isHaveDivider = true
    )

    MenuRowItem(
        icon = {
            Image(
                painter = painterResource(id = R.drawable.digi_comments_icon),
                contentDescription = "",
                modifier = Modifier
                    .size(36.dp)
                    .padding(8.dp)
            )
        },
        text = stringResource(id = R.string.my_comments),
        isHaveDivider = true
    )
    MenuRowItem(
        icon = {
            Image(
                painter = painterResource(id = R.drawable.digi_adresses_icon),
                contentDescription = "",
                modifier = Modifier
                    .size(36.dp)
                    .padding(8.dp)
            )
        },
        text = stringResource(id = R.string.addresses),
        isHaveDivider = true
    )

    MenuRowItem(
        icon = {
            Image(
                painter = painterResource(id = R.drawable.digi_profile_icon),
                contentDescription = "",
                modifier = Modifier
                    .size(36.dp)
                    .padding(8.dp)
            )
        },
        text = stringResource(id = R.string.profile_data),
        isHaveDivider = false
    )


}
