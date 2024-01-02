package mohsen.morma.digikala.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.sp
import mohsen.morma.digikala.R

val font_bold = Font(R.font.iranyekanbold).toFontFamily()
val font_medium = Font(R.font.iranyekanmedium).toFontFamily()
val font_standard = Font(R.font.iranyekan).toFontFamily()

// Set of Material typography styles to start with
val Typography3 = Typography(
    bodyLarge = TextStyle(
        fontFamily = font_bold ,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = font_medium ,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontFamily = font_standard ,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )


)

val Typography = androidx.compose.material.Typography(
    body1 = TextStyle(
        fontFamily = font_medium,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 25.sp
    ),
    body2 = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        lineHeight = 25.sp
    ),

    h1 = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 25.sp
    ),
    h2 = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 25.sp
    ),
    h3 = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 25.sp
    ),
    h4 = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = 25.sp
    ),
    h5 = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 25.sp
    ),
    h6 = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 25.sp
    )

)