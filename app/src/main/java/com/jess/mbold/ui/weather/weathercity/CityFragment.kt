package com.jess.mbold.ui.weather.weathercity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.jess.mbold.R
import com.jess.mbold.databinding.FragmentCityBinding
import com.jess.mbold.ui.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CityFragment : Fragment() {
    private var _binding: FragmentCityBinding? = null
    private val binding get() = _binding!!
    private val viewmodel: WeatherViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCityBinding.inflate(layoutInflater, container, false)
        var cities = resources.getStringArray(R.array.citie)
     var citiess = emptyArray<String>()
       viewmodel.cities.observe(viewLifecycleOwner){
         citiess = it.toTypedArray()
cities = citiess
           it.forEach {
               println("ene jh $it")
           }
       }

        cities.forEach {
            println("ene $it")
        }
        val arrayAdapter =
            ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, cities)
        binding.etCity.setAdapter(arrayAdapter)

        binding.etCity.doOnTextChanged { text, start, before, count ->
            viewmodel.getCities(text.toString())
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}