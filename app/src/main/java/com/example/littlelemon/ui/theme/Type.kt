package com.example.littlelemon.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R

// Set of Material typography styles to start with
val markaziTextFamily = FontFamily(
    Font(R.font.markazi_text_normal, FontWeight.Normal),
    Font(R.font.markazi_text_medium, FontWeight.Medium),
    Font(R.font.markazi_text_semibold, FontWeight.SemiBold),
    Font(R.font.markazi_text_bold, FontWeight.Bold)
)

val karlaFamily = FontFamily(
    Font(R.font.karla_regular, FontWeight.Normal),
    Font(R.font.karla_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.karla_bold, FontWeight.Bold),
    Font(R.font.karla_bold_italic, FontWeight.Bold, FontStyle.Italic)
)

val markaziTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = markaziTextFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 64.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = markaziTextFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 40.sp
    ),
)

val karlaTypography = Typography(
    titleMedium = TextStyle(
        fontFamily = karlaFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    ),
)

object MarkaziTypography {
    val displayLarge = TextStyle(
        fontFamily = markaziTextFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 64.sp,
        lineHeightStyle = LineHeightStyle(LineHeightStyle.Alignment.Center, LineHeightStyle.Trim.Both)
    )
    val displayMedium = TextStyle(
        fontFamily = markaziTextFamily,
        fontWeight = FontWeight.Light,
        fontSize = 44.sp
    )
}

object KarlaTypography {
    val displayMedium = TextStyle(
        fontFamily = karlaFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    )

    val sectionTitle = TextStyle(
        fontFamily = karlaFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp
    )

    val title = TextStyle(
        fontFamily = karlaFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp
    )

    val formButton = TextStyle(
        fontFamily = karlaFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp
    )

    val formField = TextStyle(
        fontFamily = karlaFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    )

    val leadText = TextStyle(
        fontFamily = karlaFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    )

    val leadTextBold = TextStyle(
        fontFamily = karlaFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )

    val categoryButton = TextStyle(
        fontFamily = karlaFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )

}

