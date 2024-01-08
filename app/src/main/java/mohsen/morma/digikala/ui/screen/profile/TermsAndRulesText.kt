package mohsen.morma.digikala.ui.screen.profile


import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import mohsen.morma.digikala.ui.theme.Typography

@Composable
fun TermsAndRulesText(
    fullText: String,
    textColor: Color,
    underlineText: List<String>,
    underlineTextFontWeight: FontWeight = FontWeight.Normal,
    underlineTextDecoration: TextDecoration = TextDecoration.None,
    textAlign: TextAlign = TextAlign.Center,
) {

    Text(
        text = buildAnnotatedString {
            append(fullText)
            underlineText.forEach { text ->
                val startIndex = fullText.indexOf(text)
                val endIndex = startIndex + text.length
                addStyle(
                    style = SpanStyle(
                        color = textColor,
                        fontSize = 12.sp,
                        fontWeight = underlineTextFontWeight,
                        textDecoration = underlineTextDecoration,
                    ),
                    start = startIndex,
                    end = endIndex
                )

            }
        },
        style = Typography.h5,
        textAlign = textAlign,
        color = Color.DarkGray.copy(0.5f),
        fontSize = 10.sp
    )

}