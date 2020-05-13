package com.alterok.logutils

import android.util.Log

object LogUtils {
    private const val TAG = "LogUtils"

    @JvmStatic
    var isInDebuggingMode: Boolean = BuildConfig.DEBUG

    @JvmStatic
    var show_d: Boolean = true

    @JvmStatic
    var show_i: Boolean = true

    @JvmStatic
    var show_w: Boolean = true

    @JvmStatic
    var show_e: Boolean = true

    @JvmStatic
    fun d(msg: String) {
        if (isInDebuggingMode && show_d)
            Log.d(TAG, msg)
    }

    @JvmStatic
    fun d(tag: String, msg: String) {
        if (isInDebuggingMode && show_d)
            Log.d(tag, msg)
    }

    @JvmStatic
    fun i(msg: String) {
        if (isInDebuggingMode && show_i)
            Log.i(TAG, msg)
    }

    @JvmStatic
    fun i(tag: String, msg: String) {
        if (isInDebuggingMode && show_i)
            Log.i(tag, msg)
    }

    @JvmStatic
    fun w(msg: String) {
        if (isInDebuggingMode && show_w)
            Log.w(TAG, msg)
    }

    @JvmStatic
    fun w(tag: String, msg: String) {
        if (isInDebuggingMode && show_w)
            Log.w(tag, msg)
    }

    @JvmStatic
    fun e(msg: String) {
        if (isInDebuggingMode && show_e)
            Log.e(TAG, msg)
    }

    @JvmStatic
    fun e(tag: String, msg: String) {
        if (isInDebuggingMode && show_e)
            Log.e(tag, msg)
    }
}