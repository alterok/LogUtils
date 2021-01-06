package com.alterok.logutils

import android.util.Log

object LogUtils {
    private const val TAG_VERBOSE = "LogUtils[VERBOSE]"
    private const val TAG_DEBUG = "LogUtils[DEBUG]"
    private const val TAG_INFO = "LogUtils[INFO]"
    private const val TAG_WARNING = "LogUtils[WARNING]"
    private const val TAG_ERROR = "LogUtils[ERROR]"

    var isLogging: Boolean = true
        private set

    var verbose: Boolean = true
        private set
    var debug: Boolean = true
        private set
    var info: Boolean = true
        private set
    var warning: Boolean = true
        private set
    var error: Boolean = true
        private set

    /**
     * Enable or disable the entire LogUtils logging functionality.
     * It is recommended to pass your project's BuildConfig.DEBUG flag as an argument to prevent logging in release builds.
     * @param enable When set to false, this prevents all types(Log.v/d/i/w/e) of logging.
     */
    fun setLogging(enable: Boolean): LogUtils {
        this.isLogging = enable
        return this
    }

    /**
     * Enable or disable the verbose logging. Enabled by default.
     */
    fun allowVerbose(allow: Boolean): LogUtils {
        this.verbose = allow
        return this
    }

    /**
     * Enable or disable the debug logging. Enabled by default.
     */
    fun allowDebug(allow: Boolean): LogUtils {
        this.debug = allow
        return this
    }

    /**
     * Enable or disable the info logging. Enabled by default.
     */
    fun allowInfo(allow: Boolean): LogUtils {
        this.info = allow
        return this
    }

    /**
     * Enable or disable the warning logging. Enabled by default.
     */
    fun allowWarning(allow: Boolean): LogUtils {
        this.warning = allow
        return this
    }

    /**
     * Enable or disable the error logging. Enabled by default.
     */
    fun allowError(allow: Boolean): LogUtils {
        this.error = allow
        return this
    }


    /**
     * Prints all the logging states to the logcat.
     */
    fun toLogcat() {
        v(toString())
    }

    override fun toString(): String {
        return "LogUtils(isLogging=$isLogging, verbose=$verbose, debug=$debug, info=$info, warning=$warning, error=$error)"
    }


    /**
     * Sends a VERBOSE log message with default TAG= LogUtils&#91;VERBOSE&#93;
     * @param msg Info message
     */
    fun v(msg: String) {
        v(TAG_VERBOSE, msg)
    }

    /**
     * Sends a VERBOSE log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg Info message
     */
    fun v(tag: String, msg: String) {
        if (isLogging && verbose)
            Log.v(tag, msg)
    }

    /**
     * Sends a DEBUG log message with default TAG= LogUtils&#91;DEBUG&#93;
     * @param msg Info message
     */
    fun d(msg: String) {
        d(TAG_DEBUG, msg)
    }

    /**
     * Sends a DEBUG log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg Info message
     */
    fun d(tag: String, msg: String) {
        if (isLogging && debug)
            Log.d(tag, msg)
    }


    /**
     * Sends a INFO log message with default TAG= LogUtils&#91;INFO&#93;
     * @param msg Info message
     */
    fun i(msg: String) {
        i(TAG_INFO, msg)
    }

    /**
     * Sends a INFO log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg Info message
     */
    fun i(tag: String, msg: String) {
        if (isLogging && info)
            Log.i(tag, msg)
    }


    /**
     * Sends a WARNING log message with default TAG= LogUtils&#91;WARNING&#93;
     * @param msg Warning message
     */
    fun w(msg: String) {
        w(TAG_WARNING, msg)
    }

    /**
     * Sends a WARNING log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg Warning message
     */
    fun w(tag: String, msg: String) {
        if (isLogging && warning)
            Log.w(tag, msg)
    }


    /**
     * Sends a ERROR log message with default TAG= LogUtils&#91;ERROR&#93;
     * @param msg Error message
     * @param exception An exception to log(optional)
     */
    fun e(msg: String, exception: Throwable? = null) {
        e(TAG_ERROR, msg, exception)
    }

    /**
     * Sends a ERROR log message with default TAG= LogUtils&#91;ERROR&#93;
     * @param exception An exception to log
     */
    fun e(exception: Throwable) {
        e(TAG_ERROR, "", exception)
    }

    /**
     * Sends a ERROR log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg Error message
     * @param exception An exception to log(optional)
     */
    fun e(tag: String, msg: String, exception: Throwable? = null) {
        if (isLogging && error)
            Log.e(tag, msg, exception)
    }
}