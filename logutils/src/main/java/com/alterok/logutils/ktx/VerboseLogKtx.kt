package com.alterok.logutils.ktx

import com.alterok.logutils.LogUtils

private const val NULL = "NULL"

/**
 * Sends a VERBOSE log message with default TAG= LogUtils&#91;ERROR&#93;
 */
fun Any?.logV() {
    LogUtils.v(this.toString())
}

fun Any?.logV(tag: String) {
    LogUtils.v(tag, this.toString())
}

inline fun logV(msgWithTag: () -> Pair<String, String>) {
    val msgWithTagPair = msgWithTag()
    LogUtils.v(msgWithTagPair.second, msgWithTagPair.first)
}