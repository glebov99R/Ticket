package com.example.ticket.util

import android.content.Context

class SharedPreferencesManager(private val context: Context) {

    private val sharedPreferences = context.getSharedPreferences("my_preferences",
        Context.MODE_PRIVATE
    )

    fun saveData(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getData(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

}

// val sharedPreferenceManager = remember { SharedPreferencesManager(viewModel.context) }
// sharedPreferenceManager.saveData("select_printer_key", printerName)
// val IdVp = sharedPreferenceManager.getData("ID_VP1",savedValue.toString())