package dev.olaore.mamopay_exercise.mappers

import java.text.DecimalFormat

fun String.format(): String {

    var formatted = ""
    if (this == "") {
        formatted = "0.00"
    } else if (this.endsWith(".")) {
        formatted = "${ formatAsDecimal(this) }.00"
    } else {
        formatted = formatAsDecimal(this)
    }

    return checkForDecimal(formatted)

}

fun formatAsDecimal(text: String): String {
    val decimalFormat = DecimalFormat("###,###,###.##")
    var formattedValue = decimalFormat.format(text.toDouble())

    return formattedValue
}

fun checkForDecimal(text: String): String {
    if (!text.contains(".")) {
        return "$text.00"
    } else if (hasOneNumberAfterPoint(text)) {
        return text + "0"
    }

    return text
}


fun hasOneNumberAfterPoint(text: String): Boolean {
    if (text.length > 1 && text[text.lastIndex - 1].toString() == ".") {
        return true
    }

    return false
}