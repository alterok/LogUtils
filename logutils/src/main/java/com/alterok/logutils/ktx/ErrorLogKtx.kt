package com.alterok.logutils.ktx

import android.util.Log
import com.alterok.logutils.LogUtils

/**
 * Sends a [Log.e] log message with default TAG= [LogUtils.TAG_ERROR].
 */
fun Any?.toLogE() {
    LogUtils.e(this.toString())
}

/**
 * Sends a [Log.e] log message with TAG returned by the [tagBlock].
 */
fun Any?.toLogE(tagBlock : () -> String) {
    LogUtils.e(tagBlock(), this.toString())
}


/**
 * Sends a [Log.e] log message of this [Throwable] with default TAG= [LogUtils.TAG_ERROR].
 */
fun Throwable.toLogE() {
    LogUtils.e(this)
}

/**
 * Sends a [Log.e] log message with [Pair] of Strings, first is msg, second is tag.
 *
 * eg: logE { "msg" to "tag" }
 */
inline fun logE(msgWithTag: () -> Pair<String, String>) {
    val msgWithTagPair = msgWithTag()
    LogUtils.e(msgWithTagPair.second, msgWithTagPair.first)
}