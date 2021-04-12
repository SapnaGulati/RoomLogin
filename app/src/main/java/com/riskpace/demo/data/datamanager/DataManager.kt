package com.riskpace.demo.data.datamanager

import com.riskpace.demo.data.preferences.PreferenceManager
import com.riskpace.demo.data.remote.ApiClient
import com.riskpace.demo.data.remote.ApiService
import com.riskpace.demo.data.roomdatabase.AppDatabase

class DataManager : IDataManager {

    companion object {

        private var SINGLETON_INSTANCE: IDataManager? = null

        fun getInstance(): IDataManager {
            if (SINGLETON_INSTANCE == null) {
                SINGLETON_INSTANCE = DataManager()
            }
            return SINGLETON_INSTANCE!!
        }
    }

    override fun getPreference() = PreferenceManager.getInstance()

    override fun getDatabase(): AppDatabase {
        return AppDatabase.getDatabase()
    }

    override fun getRemote(): ApiService {
        return ApiClient.getInstance("https://api.jsonbin.io/").create(ApiService::class.java)
    }
}