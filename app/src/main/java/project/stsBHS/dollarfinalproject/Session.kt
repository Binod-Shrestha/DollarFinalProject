package project.stsBHS.dollarfinalproject

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager


class Session(context: Context?) {
    private val prefs: SharedPreferences

    fun setSelectedId(id: String) {
        prefs.edit().putString("id", id).commit()
    }

    fun getSelectedId(): String? {
        return prefs.getString("id", "")
    }

    init {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(context)
    }
}