package com.example.watchlist

import java.util.regex.Matcher
import java.util.regex.Pattern

fun verifyUsername(username: String): Boolean {
    return username.length >= 5
}


//check if password matches criteria
fun verifyPassword(password: String): Boolean {
    val pattern: Pattern
    val matcher: Matcher
    val PASSWORD_PATTERN =
        "^(?=.*[0-9])(?=.*[a-z]).{6,}$"
    pattern = Pattern.compile(PASSWORD_PATTERN)
    matcher = pattern.matcher(password)

    return matcher.matches()
}
