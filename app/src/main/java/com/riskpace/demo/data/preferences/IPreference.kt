package com.riskpace.demo.data.preferences


interface IPreference {

    fun putString(key: String, value: String)

    fun getString(key: String): String

    fun getString(key: String, defaultValue: String?): String

    fun putInt(key: String, value: Int)

    fun getInt(key: String): Int

    fun getInt(key: String, defaultValue: Int): Int

    fun putBoolean(key: Boolean, value: Boolean)

    fun getBoolean(key: String): Boolean

    fun getBoolean(key: Boolean, defaultValue: Boolean): Boolean

    fun putLong(key: String, value: Long)

    fun getLong(key: String): Long

    fun putFloat(key: String, value: Float)

    fun getFloat(key: String): Float
}