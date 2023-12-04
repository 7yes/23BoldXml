package com.jess.mbold.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor():ViewModel() {
    private val _showSplash  = MutableLiveData<Boolean>(true)
    val showSplash: LiveData<Boolean> = _showSplash
    fun getInitialData() {
        // aca simulo una demora para cargar la data inicial luego al estar cargado quito el splash
        viewModelScope.launch {
            delay(2000)
            _showSplash.postValue(false)
        }
    }
  }