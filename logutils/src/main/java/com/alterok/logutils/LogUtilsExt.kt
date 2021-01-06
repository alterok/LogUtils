package com.alterok.logutils

private const val NULL = "NULL"

/**
 * Sends a VERBOSE log message with default TAG= LogUtils&#91;ERROR&#93;
 */
fun Any?.toLog() {
    LogUtils.v(this?.toString() ?: NULL)
}

fun Any?.toVerboseLog(tag: String) {
    LogUtils.v(tag, this?.toString() ?: NULL)
}

/**
 * Sends a DEBUG log message with default TAG= LogUtils&#91;DEBUG&#93;
 */
fun Any?.toDebugLog() {
    LogUtils.d(this?.toString() ?: NULL)
}

fun Any?.toDebugLog(tag: String) {
    LogUtils.d(tag, this?.toString() ?: NULL)
}

/**
 * Sends a INFO log message with default TAG= LogUtils&#91;INFO&#93;
 */
fun Any?.toInfoLog() {
    LogUtils.i(this?.toString() ?: NULL)
}

fun Any?.toInfoLog(tag: String) {
    LogUtils.i(tag, this?.toString() ?: NULL)
}
/**
 * Sends a WARNING log message with default TAG= LogUtils&#91;WARNING&#93;
 */
fun Any?.toWarningLog() {
    LogUtils.i(this?.toString() ?: NULL)
}

fun Any?.toWarningLog(tag: String) {
    LogUtils.i(tag, this?.toString() ?: NULL)
}

/**
 * Sends a ERROR log message with default TAG= LogUtils&#91;ERROR&#93;
 */
fun Any?.toErrorLog() {
    LogUtils.e(this?.toString() ?: NULL)
}

/**
 * Sends a ERROR log message with default TAG= LogUtils&#91;ERROR&#93;
 */
fun Throwable.toErrorLog() {
    LogUtils.e(this)
}

fun Any?.toErrorLog(tag: String) {
    LogUtils.e(tag, this?.toString() ?: NULL)
}