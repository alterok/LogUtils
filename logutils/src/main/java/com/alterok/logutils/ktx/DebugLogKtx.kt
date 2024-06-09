package com.alterok.logutils.ktx

import android.util.Log
import com.alterok.logutils.LogUtils

/**
 * Sends a DEBUG log message with default TAG= [LogUtils.TAG_DEBUG];
 */
fun Any?.toLogD() {
    LogUtils.d(this.toString())
}

/**
 * Sends a [Log.d] log message with TAG returned by the [tagBlock].
 */
fun Any?.toLogD(tagBlock : () -> String) {
    LogUtils.d(tagBlock(), this.toString())
}

/**
 * Sends a [Log.d] log message with [Pair] of Strings, first is msg, second is tag.
 *
 * eg: logD { "msg" to "tag" }
 */
inline fun logD(msgWithTag: () -> Pair<String, String>) {
    val msgWithTagPair = msgWithTag()
    LogUtils.d(msgWithTagPair.second, msgWithTagPair.first)
}