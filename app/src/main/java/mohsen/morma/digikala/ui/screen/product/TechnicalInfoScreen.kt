package mohsen.morma.digikala.ui.screen.product

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.R
import mohsen.morma.digikala.ui.screen.checkout.CheckoutDivider
import mohsen.morma.digikala.ui.theme.Typography
import org.json.JSONObject

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TechnicalInfoSection(jsonString: String) {

    val jsonObject = JSONObject(jsonString)
    val keys = jsonObject.keys()



    Scaffold(topBar = { TechnicalTopBar() }) {

        LazyColumn(Modifier.fillMaxSize().background(Color.White)) {
            item {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(top = 96.dp, start = 16.dp, end = 16.dp)
                ) {

                    Text(
                        text = stringResource(id = R.string.Specifications),
                        style = Typography.h4,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.size(16.dp))

                    while (keys.hasNext()){
                        val key = keys.next()
                        val value = jsonObject.get(key).toString()

                        TechnicalItem(key , value)

                    }

                }
            }
        }

    }

}

@Composable
fun TechnicalItem(key : String , value : String) {

    Row(Modifier.fillMaxWidth(),Arrangement.Start,Alignment.CenterVertically) {
        Text(
            text = key,
            style = Typography.h6,
            modifier = Modifier.width(96.dp),
            color = Color.DarkGray.copy(0.8f)
        )

        Spacer(modifier = Modifier.size(48.dp))

        Text(
            text = value,
            style = Typography.h5,
            fontWeight = FontWeight.Bold,
        )
    }

    CheckoutDivider(spacerSize = 16.dp)



}

@Composable
fun TechnicalTopBar() {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(68.dp),
        backgroundColor = Color.White,
        elevation = 4.dp
    ) {
        Text(
            text = stringResource(id = R.string.technical_specifications),
            style = Typography.h3,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}
