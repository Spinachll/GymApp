package com.sporttest.gymapp.data.datastore

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

// Try to make this class singleton
class AppValuesStore(private val context: Context) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("appDefaults")
        val CATEGORY_PREPOPULATED_KEY = stringPreferencesKey("category_prep")
        val USER_TOKEN_KEY = stringPreferencesKey("user_token")
    }

    //User Token
    val getUserToken: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_TOKEN_KEY].toString()
        }

    suspend fun saveUserToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_TOKEN_KEY] = token
        }
    }

    fun clearUserToken() {
        coroutineScope.launch {
            context.dataStore.edit { preferences ->
                preferences[USER_TOKEN_KEY] = ""
            }
        }
    }

    //region Category Prepopulate
    val getCategoryPrepopulated: Flow<Boolean?> = context.dataStore.data
        .map { preferences ->
            preferences[CATEGORY_PREPOPULATED_KEY].toBoolean()
        }

    fun getPrepopulateCategory(): Boolean {
        var returnValue = false
        context.dataStore.data.map { preferences ->
            Log.d(
                "MyTag",
                "getPrepopulateCategory ${preferences[CATEGORY_PREPOPULATED_KEY].toBoolean()}"
            )
            returnValue = preferences[CATEGORY_PREPOPULATED_KEY].toBoolean()
        }
        context.dataStore.data
        return returnValue
    }

    suspend fun saveCategoryPrepopulate(name: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[CATEGORY_PREPOPULATED_KEY] = name.toString()
        }
    }
    //endregion Category Prepopulate

}
