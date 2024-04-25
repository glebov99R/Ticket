package com.example.ticket.viewmodel

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ThemeViewModel(
    private val dataStore: DataStore<Preferences>
) : ViewModel() {


    /**
     * Ключ для чтения, удаления,добавления в MutablePreferences значений
     * по парам-ключа - значения
     */
    private val forceDarkModeKey = booleanPreferencesKey("themes")

    /**
     * Использульется для получения состояния выбранного режима использования темы
     */
    val stateSelectedThemeCurrent = MutableLiveData<Boolean?>(null)

    /**
     * Функция вызывается для проверки состояния true or false
     */
    fun request() {
        viewModelScope.launch {
            /** collectLatest - Оператор терминального потока,
             *  который собирает данный поток с заданным действием.
             *  *Принципиальное отличие от collect заключается в том,
             *  что когда исходный поток выдает новое значение,
             *  блок действий для предыдущего значения отменяется.
             */
            dataStore.data.collectLatest {
                stateSelectedThemeCurrent.value = it[forceDarkModeKey]
            }
        }
    }

    /**
     * Удалите настройки из этого MutablePreferences.
     * И обновляет значение isSystemSettings
     * Используется при переключение на системную тему
     */
    fun switchToUseSystemSettings(isSystemSettings: Boolean) {
        viewModelScope.launch {
            if (isSystemSettings) {
                dataStore.edit {
                    it.remove(forceDarkModeKey)
                }
            }
        }
    }

    /**
     * Редактирует  настройки в этом MutablePreferences.
     * И обновляет значение isDarkTheme
     * Используется при переключение на тёмную тему
     */
    fun switchToUseDarkMode(isDarkTheme: Boolean) {
        viewModelScope.launch {
            dataStore.edit {
                it[forceDarkModeKey] = isDarkTheme
            }
        }
    }
}