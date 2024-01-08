package mohsen.morma.digikala.ui.screen.profile

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.ui.component.Lottie3dots
import mohsen.morma.digikala.ui.theme.DigikalaDarkRed
import mohsen.morma.digikala.ui.theme.DigikalaRed

@Composable
fun ProfileLoadingButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isSystemInDarkTheme()) DigikalaDarkRed else DigikalaRed
        )
    ) {

        Lottie3dots(36.dp)

    }
}