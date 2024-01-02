package mohsen.morma.digikala.ui.screen.profile

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import mohsen.morma.digikala.MainActivity
import mohsen.morma.digikala.data.datastore.DatastoreVM
import mohsen.morma.digikala.util.Constants

@Composable
fun ProfileScreen(datastoreVM: DatastoreVM = hiltViewModel()) {

    val context = LocalContext.current as Activity

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Button(onClick = {

            datastoreVM.saveUserLanguage(Constants.PERSIAN_LANG)

            context.apply {
                finish()
                startActivity(Intent(context, MainActivity::class.java))
            }


        }) {
            Text(text = "Persian")
        }

        Button(onClick = {

            datastoreVM.saveUserLanguage(Constants.ENGLISH_LANG)

            context.apply {
                context.finish()
                context.startActivity(Intent(context, MainActivity::class.java))
            }
        }) {
            Text(text = "English")
        }

    }

}