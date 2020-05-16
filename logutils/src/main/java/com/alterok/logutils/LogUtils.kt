package com.alterok.logutils

import android.util.Log

class LogUtils private constructor() {
    private var isLogging: Boolean = true

    private var verbose: Boolean = true
    private var debug: Boolean = true
    private var info: Boolean = true
    private var warning: Boolean = true
    private var error: Boolean = true

    /**
     * Enable/Disable the entire LogUtils logging functionality.
     * It is recommended to pass your project's BuildConfig.DEBUG flag as an argument to prevent logging in release builds.
     * @param isLogging When set to false, this prevents all types(Log.v/d/i/w/e) of logging.
     */
    fun setLogging(isLogging: Boolean): LogUtils {
        this.isLogging = isLogging
        return this
    }

    fun allowVerbose(allow: Boolean): LogUtils {
        this.verbose = allow
        return this
    }

    fun allowDebug(allow: Boolean): LogUtils {
        this.debug = allow
        return this
    }

    fun allowInfo(allow: Boolean): LogUtils {
        this.info = allow
        return this
    }

    fun allowWarning(allow: Boolean): LogUtils {
        this.warning = allow
        return this
    }

    fun allowError(allow: Boolean): LogUtils {
        this.error = allow
        return this
    }

    /**
     * prints all the logging states to the logcat.
     */
    fun out() {
        v(toString())
    }

    override fun toString(): String {
        return "LogUtils(isLogging=$isLogging, verbose=$verbose, debug=$debug, info=$info, warning=$warning, error=$error)"
    }

    companion object {
        private const val TAG = "LogUtils"

        private const val TAG_VERBOSE = "LogUtils[VERBOSE]"
        private const val TAG_DEBUG = "LogUtils[DEBUG]"
        private const val TAG_INFO = "LogUtils[INFO]"
        private const val TAG_WARNING = "LogUtils[WARNING]"
        private const val TAG_ERROR = "LogUtils[ERROR]"

        private var sInstance: LogUtils? = null
        private lateinit var instance: LogUtils

        fun getInstance(): LogUtils {
            if (sInstance == null)
                sInstance = createInstance()

            return sInstance!!
        }

        @Synchronized
        private fun createInstance(): LogUtils {
            if (sInstance == null)
                sInstance = LogUtils()

            instance = sInstance!!

            return sInstance!!
        }

        fun v(msg: String) {
            v(TAG_VERBOSE, msg)
        }

        fun v(tag: String, msg: String) {
            if (instance.isLogging && instance.verbose)
                Log.v(tag, msg)
        }

        fun d(msg: String) {
            d(TAG_DEBUG, msg)
        }

        fun d(tag: String, msg: String) {
            if (instance.isLogging && instance.debug)
                Log.d(tag, msg)
        }

        fun i(msg: String) {
            i(TAG_INFO, msg)
        }

        fun i(tag: String, msg: String) {
            if (instance.isLogging && instance.info)
                Log.i(tag, msg)
        }

        fun w(msg: String) {
            w(TAG_WARNING, msg)
        }

        fun w(tag: String, msg: String) {
            if (instance.isLogging && instance.warning)
                Log.w(tag, msg)
        }

        fun e(msg: String) {
            e(TAG_ERROR, msg)
        }

        fun e(tag: String, msg: String) {
            if (instance.isLogging && instance.error)
                Log.e(tag, msg)
        }
    }
}