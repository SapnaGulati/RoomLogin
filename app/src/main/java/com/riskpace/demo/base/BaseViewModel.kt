package com.riskpace.demo.base

import androidx.lifecycle.ViewModel
import com.riskpace.demo.data.datamanager.DataManager
import com.riskpace.demo.data.preferences.IPreference
import com.riskpace.demo.data.remote.ApiService
import com.riskpace.demo.data.roomdatabase.AppDatabase

open class BaseViewModel : ViewModel() {

    fun getPreference(): IPreference {
        return DataManager.getInstance().getPreference()
    }

    fun getDatabase(): AppDatabase {
        return DataManager.getInstance().getDatabase()
    }

    fun getRemote(): ApiService {
        return DataManager.getInstance().getRemote()
    }
}