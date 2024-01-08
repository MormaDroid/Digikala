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
    isEnable : Boolean = true,
    onValueChange : (String) -> Unit
) {

    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        enabled = isEnable,
        placeholder = {
            Text(text = placeHolderText, style = Typography.h5)
        },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            backgroundColor = Color.LightGray.copy(0.2f),
            cursorColor = DigikalaBlue,
            unfocusedLabelColor = Color.LightGray.copy(0.2f),
            focusedLabelColor = Color.LightGray.copy(0.2f),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            disabledLabelColor = Color.Transparent,
            disabledTextColor = Color.Black
        ),
        shape = RoundedCornerShape(8.dp)
    )

}