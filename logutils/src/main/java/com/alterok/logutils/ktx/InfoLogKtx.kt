package com.alterok.logutils.ktx

import android.util.Log
import com.alterok.logutils.LogUtils

/**
 * Sends a [Log.i] log message with default TAG= [LogUtils.TAG_INFO].
 */
fun Any?.toLogI() {
    LogUtils.i(this.toString())
}

/**
 * Sends a [Log.i] log message with TAG returned by the [tagBlock].
 */
fun Any?.toLogI(tagBlock : () -> String) {
    LogUtils.i(tagBlock(), this.toString())
}

/**
 * Sends a [Log.i] log message with [Pair] of Strings, first is msg, second is tag.
 *
 * eg: logI { "msg" to "tag" }
 */
inline fun logI(msgWithTag: () -> Pair<String, String>) {
    val msgWithTagPair = msgWithTag()
    LogUtils.i(msgWithTagPair.second, msgWithTagPair.first)
}