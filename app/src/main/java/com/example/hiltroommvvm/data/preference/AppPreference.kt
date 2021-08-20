package com.example.hiltroommvvm.data.preference

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

object AppPreference {

    private lateinit var mSharedPref: SharedPreferences
    private lateinit var prefsEditor: SharedPreferences.Editor

    fun initAppPreference(context: Context) {
        mSharedPref =
            context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)
    }

    fun read(key: String, defValue: String): String {
        return mSharedPref.getString(key, defValue).toString()
    }

    fun write(key: String, value: String) {
        prefsEditor = mSharedPref.edit()
        prefsEditor.putString(key, value)
        prefsEditor.apply()
    }

    fun write(key: String?, value: Int) {
        prefsEditor = mSharedPref.edit()
        prefsEditor.putInt(key, value)
        prefsEditor.apply()
    }

    fun write(key: String?, value: Long) {
        prefsEditor = mSharedPref.edit()
        prefsEditor.putLong(key, value)
        prefsEditor.apply()
    }

    fun read(key: String?, defValue: Long): Long {
        return mSharedPref.getLong(key, defValue)
    }

    fun read(key: String?, defValue: Int): Int {
        return mSharedPref.getInt(key, defValue)
    }

    fun read(key: String?, defValue: Boolean): Boolean {
        return mSharedPref.getBoolean(key, defValue)
    }

    fun write(key: String?, value: Boolean) {
        prefsEditor = mSharedPref.edit()
        prefsEditor.putBoolean(key, value)
        prefsEditor.apply()
    }

    fun remove(key: String) {
        prefsEditor = mSharedPref.edit()
        prefsEditor.remove(key)
        prefsEditor.apply()
    }

    fun clear() {
        prefsEditor = mSharedPref.edit()
        prefsEditor.clear()
        prefsEditor.apply()
    }

}