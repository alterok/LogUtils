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
 * Sends a VERBOSE log message with default TAG= LogUtils&#91;VERBOSE&#93;
 */
inline fun logV(tag: String = LogUtils.TAG_VERBOSE, messageBlock: () -> String?) {
    if (LogUtils.isVerboseAllowed()) {
        LogUtils.v(tag, messageBlock().toString())
    }
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

inline fun logD(tag: String = LogUtils.TAG_DEBUG, messageBlock: () -> String?) {
    if (LogUtils.isDebugAllowed()) {
        LogUtils.d(tag, messageBlock().toString())
    }
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

inline fun logI(tag: String = LogUtils.TAG_INFO, messageBlock: () -> String?) {
    if (LogUtils.isInfoAllowed()) {
        LogUtils.i(tag, messageBlock().toString())
    }
}

/**
 * Sends a WARNING log message with default TAG= LogUtils&#91;WARNING&#93;
 */
fun Any?.toWarningLog() {
    LogUtils.w(this?.toString() ?: NULL)
}

fun Any?.toWarningLog(tag: String) {
    LogUtils.w(tag, this?.toString() ?: NULL)
}

inline fun logW(tag: String = LogUtils.TAG_WARNING, messageBlock: () -> String?) {
    if (LogUtils.isWarningAllowed()) {
        LogUtils.w(tag, messageBlock().toString())
    }
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

inline fun logE(
    tag: String = LogUtils.TAG_ERROR,
    throwable: Throwable? = null,
    messageBlock: () -> String?
) {
    if (LogUtils.isErrorAllowed()) {
        LogUtils.e(tag, messageBlock().toString(), throwable)
    }
}