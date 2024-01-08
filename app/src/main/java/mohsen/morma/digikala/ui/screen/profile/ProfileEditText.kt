package mohsen.morma.digikala.ui.screen.profile

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.ui.theme.DigikalaBlue
import mohsen.morma.digikala.ui.theme.Typography

@Composable
fun ProfileEditText(
    value: String,
    placeHolderText : String,
    onValueChange : (String) -> Unit
) {

    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        placeholder = {
            Text(text = placeHolderText, style = Typography.h5)
        },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            backgroundColor = Color.LightGray.copy(0.5f),
            cursorColor = DigikalaBlue,
            unfocusedLabelColor = Color.LightGray.copy(0.5f),
            focusedLabelColor = Color.LightGray.copy(0.5f),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(8.dp)
    )

}