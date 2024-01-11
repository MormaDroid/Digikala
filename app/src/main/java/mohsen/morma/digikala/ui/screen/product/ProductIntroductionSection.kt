package mohsen.morma.digikala.ui.screen.product

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.R
import mohsen.morma.digikala.ui.theme.Typography

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductIntroductionSection(description: String) {

    Scaffold(topBar = { IntroductionTopBar() }) {

        LazyColumn{
            item {
                Column(Modifier
                    .fillMaxWidth()
                    .padding(top = 92.dp, start = 16.dp, end = 16.dp)) {

                    Text(
                        text = stringResource(id = R.string.product_introduction),
                        style = Typography.h4,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.size(16.dp))

                    Text(
                        text = description,
                        style = Typography.h5,
                        textAlign = TextAlign.Start
                    )

                }
            }
        }
    }
}

@Composable
fun IntroductionTopBar() {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(68.dp)
            ,
        backgroundColor = Color.White,
        elevation = 4.dp
    ) {


        Text(
            text = stringResource(id = R.string.product_interview),
            style = Typography.h3,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )


    }
}
