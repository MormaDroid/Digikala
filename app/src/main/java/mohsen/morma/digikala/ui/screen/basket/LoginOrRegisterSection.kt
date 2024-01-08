package mohsen.morma.digikala.ui.screen.basket

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import mohsen.morma.digikala.R
import mohsen.morma.digikala.navigation.Screen
import mohsen.morma.digikala.ui.theme.Amber
import mohsen.morma.digikala.ui.theme.Typography

@Composable
fun LoginOrRegisterSection(
    navController: NavController
){

    Card(
        modifier = Modifier
            .padding(16.dp)
            .clickable {navController.navigate(Screen.Profile.route) },
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp ,
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ){

            Icon(
                painter = painterResource(id = R.drawable.import_96_orenge),
                contentDescription = "",
                tint = Amber,
                modifier = Modifier
                    .size(30.dp)
                    .weight(0.1f)
                    .align(Alignment.Top)
            )

            Spacer(modifier = Modifier.weight(0.05f))

            Column(
                modifier = Modifier.weight(0.8f),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
            ){
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = stringResource(R.string.login_or_register),
                    textAlign = TextAlign.Start,
                    style = Typography.h5,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = stringResource(R.string.login_or_register_msg),
                    textAlign = TextAlign.Start,
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold,
                    style = Typography.h6,
                )
            }

            Spacer(modifier = Modifier.weight(0.05f))

            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "",
                tint = Color.Gray,
                modifier = Modifier
                    .size(28.dp)
                    .weight(0.1f)
                    .align(Alignment.Top)

            )

        }
    }

}
