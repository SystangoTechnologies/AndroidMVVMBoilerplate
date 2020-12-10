package com.systango.mvvm.utils

import android.util.Log

import java.util.HashSet


/**
 * Wraps [Log] to make disabling logging easily configurable.
 *
 *
 */
object Logger {

    /**
     * The Constant TAG.
     */
    val TAG = Log::class.java.getSimpleName()

    /**
     * The disabled logs.
     */
    private val disabledLogs = HashSet<String>()

    /**
     * The disable all.
     */
    private var disableAll = false // disable all Logs. (true to disable all logs in release version, false otherwise)

    /**
     * Disables all logging from the indicated tag.
     *
     * @param tag the tag to disable logging for
     */
    fun disableLogging(tag: String) {
        disabledLogs.add(tag)
    }

    /**
     * Disables logging for all tags.
     */
    fun disableAllLogging() {
        disableAll = true
    }

    /**
     * Returns true if the tag is not disabled.
     *
     * @param tag the tag to check if disabled
     * @return true, if is logging enabled
     */
    fun isLoggingEnabled(tag: String?): Boolean {
        return !(disableAll || disabledLogs.contains(tag))
    }

    /**
     * D.
     *
     * @param tag the tag
     * @param msg the msg
     * @see Log.d
     */
    @JvmStatic
    fun d(tag: String, msg: String) {
        try {
            if (isLoggingEnabled(tag)) {
                Log.d(tag, msg)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * D.
     *
     * @param tag the tag
     * @param msg the msg
     * @param tr  the tr
     * @see Log.d
     */
    fun d(tag: String, msg: String, tr: Throwable) {
        try {
            if (isLoggingEnabled(tag)) {
                Log.d(tag, msg, tr)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * E.
     *
     * @param tag the tag
     * @param msg the msg
     * @see Log.e
     */
    fun e(tag: String?, msg: String?) {
        try {


            if (isLoggingEnabled(tag)) {
                if (null != tag && null != msg)
                    Log.e(tag, msg)

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * E.
     *
     * @param tag the tag
     * @param msg the msg
     * @param tr  the tr
     * @see Log.e
     */

    fun e(tag: String, msg: String, tr: Throwable) {
        try {
            if (isLoggingEnabled(tag)) {
                Log.e(tag, msg, tr)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * I.
     *
     * @param tag the tag
     * @param msg the msg
     * @see Log.i
     */
    fun i(tag: String, msg: String) {
        try {
            if (isLoggingEnabled(tag)) {
                Log.i(tag, msg)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * I.
     *
     * @param tag the tag
     * @param msg the msg
     * @param tr  the tr
     * @see Log.i
     */
    fun i(tag: String, msg: String, tr: Throwable) {
        try {
            if (isLoggingEnabled(tag)) {
                Log.i(tag, msg, tr)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * V.
     *
     * @param tag the tag
     * @param msg the msg
     * @see Log.v
     */
    fun v(tag: String, msg: String) {
        try {
            if (isLoggingEnabled(tag)) {
                Log.v(tag, msg)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * V.
     *
     * @param tag the tag
     * @param msg the msg
     * @param tr  the tr
     * @see Log.v
     */
    fun v(tag: String, msg: String, tr: Throwable) {
        try {
            if (isLoggingEnabled(tag)) {
                Log.v(tag, msg, tr)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * W.
     *
     * @param tag the tag
     * @param msg the msg
     * @see Log.w
     */
    fun w(tag: String, msg: String) {
        try {
            if (isLoggingEnabled(tag)) {
                Log.w(tag, msg)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * W.
     *
     * @param tag the tag
     * @param msg the msg
     * @param tr  the tr
     * @see Log.w
     */
    fun w(tag: String, msg: String, tr: Throwable) {

        try {
            if (isLoggingEnabled(tag)) {
                Log.w(tag, msg, tr)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * Wtf.
     *
     * @param tag the tag
     * @param msg the msg
     * @see Log.wtf
     */
    fun wtf(tag: String, msg: String) {
        try {
            if (isLoggingEnabled(tag)) {
                Log.wtf(tag, msg)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * Wtf.
     *
     * @param tag the tag
     * @param msg the msg
     * @param tr  the tr
     * @see Log.wtf
     */
    fun wtf(tag: String, msg: String, tr: Throwable) {
        try {
            if (isLoggingEnabled(tag)) {
                Log.wtf(tag, msg, tr)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


}
