package mohsen.morma.digikala.ui.screen.home.amazing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.R
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.Constants

@Composable
fun AmazingUISection(
    amazingIcon: Int,
    amazingText: Int
) {

    Spacer(modifier = Modifier.size(16.dp))

    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.35f),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {

        AmazingImageBox(height = 150.dp, width = 150.dp, amazingText)

        Spacer(modifier = Modifier.size(8.dp))

        AmazingImageBox(height = 112.dp, width = 112.dp, amazingIcon)

        Spacer(modifier = Modifier.size(24.dp))

        SeeAll(R.string.see_all)

    }

    Spacer(modifier = Modifier.size(16.dp))

}


@Composable
private fun SeeAll(text: Int) {

    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(text = stringResource(id = text), style = Typography.h3, color = Color.White)

        Spacer(modifier = Modifier.size(0.dp))

        Icon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = null,
            modifier = Modifier
                .size(28.dp)
                .rotate(if (Constants.USER_LANG == Constants.ENGLISH_LANG) 180f else 0f),
            tint = Color.White
        )

    }

}

@Composable
private fun AmazingImageBox(height: Dp, width: Dp, image: Int) {

    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        modifier = Modifier.size(height = height, width = width),
        contentScale = ContentScale.FillBounds
    )

}