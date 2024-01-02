package mohsen.morma.digikala.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.R
import mohsen.morma.digikala.ui.theme.Typography3
import mohsen.morma.digikala.util.Constants.PERSIAN_LANG
import mohsen.morma.digikala.util.Constants.USER_LANG

@Composable
fun SearchBarSection() {

    TopAppBar(
        elevation = 8.dp,
        backgroundColor = Color.White
    ) {
        Box(modifier = Modifier.fillMaxSize(), Alignment.Center){
            Row(
                Modifier
                    .fillMaxWidth(0.95f)
                    .fillMaxHeight(0.8f)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray.copy(0.35f)),
                Arrangement.Start,
                Alignment.CenterVertically
            ) {

                Spacer(modifier = Modifier.size(8.dp))

                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier
                        .size(28.dp)
                        .rotate(if (USER_LANG == PERSIAN_LANG) 360f else 0f),
                    tint = Color.Black
                )

                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = stringResource(id = R.string.search_bar),
                    style = Typography3.bodyMedium,
                    color = Color.Gray
                )

                Image(
                    painter = painterResource(
                        id = if (USER_LANG == PERSIAN_LANG) R.drawable.digi_red_persian
                        else R.drawable.digi_red_english
                    ),
                    contentDescription = null,
                    modifier = Modifier.width(96.dp),
                    contentScale = ContentScale.FillBounds
                )

            }
        }

    }

}