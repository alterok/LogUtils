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
     * Enable or disable the entire LogUtils logging functionality.
     * It is recommended to pass your project's BuildConfig.DEBUG flag as an argument to prevent logging in release builds.
     * @param isLogging When set to false, this prevents all types(Log.v/d/i/w/e) of logging.
     */
    fun setLogging(isLogging: Boolean): LogUtils {
        this.isLogging = isLogging
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

    companion object {
        private const val TAG = "LogUtils"

        private const val TAG_VERBOSE = "LogUtils[VERBOSE]"
        private const val TAG_DEBUG = "LogUtils[DEBUG]"
        private const val TAG_INFO = "LogUtils[INFO]"
        private const val TAG_WARNING = "LogUtils[WARNING]"
        private const val TAG_ERROR = "LogUtils[ERROR]"

        private var sInstance: LogUtils? = null
        private lateinit var instance: LogUtils


        /**
         * Returns an Instance of the LogUtils. Use it to enable or disable the various log priorities.
         */
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


        /**
         * Sends a VERBOSE log message with default TAG = LogUtils&#91;VERBOSE&#93;
         * @param msg The message you would like logged.
         */
        fun v(msg: String) {
            v(TAG_VERBOSE, msg)
        }

        /**
         * Sends a VERBOSE log message.
         * @param tag Used to identify the source of a log message.  It usually identifies
         *        the class or activity where the log call occurs.
         * @param msg The message you would like logged.
         */
        fun v(tag: String, msg: String) {
            if (instance.isLogging && instance.verbose)
                Log.v(tag, msg)
        }

        /**
         * Sends a DEBUG log message with default TAG = LogUtils&#91;DEBUG&#93;
         * @param msg The message you would like logged.
         */
        fun d(msg: String) {
            d(TAG_DEBUG, msg)
        }

        /**
         * Sends a DEBUG log message.
         * @param tag Used to identify the source of a log message.  It usually identifies
         *        the class or activity where the log call occurs.
         * @param msg The message you would like logged.
         */
        fun d(tag: String, msg: String) {
            if (instance.isLogging && instance.debug)
                Log.d(tag, msg)
        }


        /**
         * Sends a INFO log message with default TAG = LogUtils&#91;INFO&#93;
         * @param msg The message you would like logged.
         */
        fun i(msg: String) {
            i(TAG_INFO, msg)
        }

        /**
         * Sends a INFO log message.
         * @param tag Used to identify the source of a log message.  It usually identifies
         *        the class or activity where the log call occurs.
         * @param msg The message you would like logged.
         */
        fun i(tag: String, msg: String) {
            if (instance.isLogging && instance.info)
                Log.i(tag, msg)
        }


        /**
         * Sends a WARNING log message with default TAG = LogUtils&#91;WARNING&#93;
         * @param msg The message you would like logged.
         */
        fun w(msg: String) {
            w(TAG_WARNING, msg)
        }

        /**
         * Sends a WARNING log message.
         * @param tag Used to identify the source of a log message.  It usually identifies
         *        the class or activity where the log call occurs.
         * @param msg The message you would like logged.
         */
        fun w(tag: String, msg: String) {
            if (instance.isLogging && instance.warning)
                Log.w(tag, msg)
        }


        /**
         * Sends a ERROR log message with default TAG = LogUtils&#91;ERROR&#93;
         * @param msg The message you would like logged.
         */
        fun e(msg: String) {
            e(TAG_ERROR, msg)
        }

        /**
         * Sends a ERROR log message.
         * @param tag Used to identify the source of a log message.  It usually identifies
         *        the class or activity where the log call occurs.
         * @param msg The message you would like logged.
         */
        fun e(tag: String, msg: String) {
            if (instance.isLogging && instance.error)
                Log.e(tag, msg)
        }
    }
}