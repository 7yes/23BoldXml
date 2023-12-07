package com.jess.mbold.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jess.mbold.domain.GetCitiesUseCase
import com.jess.mbold.domain.GetForcaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getCitiesUseCase: GetCitiesUseCase,
    private val getForcaseUseCase: GetForcaseUseCase
) :
    ViewModel() {
    private val _showSplash = MutableLiveData<Boolean>(true)
    val showSplash: LiveData<Boolean> = _showSplash

    private val _cities = MutableLiveData<List<String>>()
    val cities: LiveData<List<String>> = _cities
    fun getInitialData() {
        // aca simulo una demora para cargar la data inicial luego al estar cargado quito el splash
        viewModelScope.launch {
            delay(200)
            _showSplash.postValue(false)
        }
    }

    fun getCities(city: String) {
        viewModelScope.launch {
            var s = emptyArray<String>()
            val response = getCitiesUseCase.getCities(city)
            response?.forEach {
                s += "${it.name} en ${it.country}"

            }
            if (s.isNotEmpty()) {
                _cities.postValue(s.toList())
            }
        }
    }

    fun getForecast(city: String) {
        viewModelScope.launch {
            val response = getForcaseUseCase.getForecast(city)
            response?.let {
                println("ene ddd ${it.current}")
                println("ene ddd ${it.forecast}")
                println("ene ddd ${it.location}")
            }
        }
    }
}