package com.jhonny.coolstore.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

fun setStyleBold(boldText: String, normalText: String) =
buildAnnotatedString {
    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
        append(boldText)
    }
    append(normalText)
}

fun setStyleBoldRed(boldText: String, redText: String) =
    buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
            append(boldText)
        }
        withStyle(style = SpanStyle(fontWeight = FontWeight.Light, color = Color.Red)) {
            append(redText)
        }
    }
enum class SearchDisplay {
    InitialResults, Suggestions, Results, NoResults
}