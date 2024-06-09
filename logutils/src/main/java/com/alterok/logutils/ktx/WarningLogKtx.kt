package com.alterok.logutils.ktx

import android.util.Log
import com.alterok.logutils.LogUtils


/**
 * Sends a [Log.w] log message with default TAG= [LogUtils.TAG_WARNING].
 */
fun Any?.toLogW() {
    LogUtils.w(this.toString())
}

/**
 * Sends a [Log.w] log message with TAG returned by the [tagBlock].
 */
fun Any?.toLogW(tagBlock : () -> String) {
    LogUtils.w(tagBlock(), this.toString())
}

fun Throwable.toLogW() {
    LogUtils.w(this)
}
/**
 * Sends a [Log.w] log message with [Pair] of Strings, first is msg, second is tag.
 *
 * eg: logW { "msg" to "tag" }
 */
inline fun logW(msgWithTag: () -> Pair<String, String>) {
    val msgWithTagPair = msgWithTag()
    LogUtils.w(msgWithTagPair.second, msgWithTagPair.first)
}