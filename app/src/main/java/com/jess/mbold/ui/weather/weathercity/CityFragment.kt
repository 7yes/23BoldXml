package com.jess.mbold.ui.weather.weathercity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
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

        viewmodel.cities.observe(viewLifecycleOwner) {
            binding.temp.text=it.toString()
        }

        binding.etCity.doOnTextChanged { text, start, before, count ->
            viewmodel.getCities(text.toString())
        }

        binding.btnCity.setOnClickListener {
            viewmodel.getForecast(binding.etCity.toString())
            Toast.makeText(requireActivity(),"aca paso a la siguiente pantalla el valor escogido, No alcance, por favor vean el link que esta en el readme",Toast.LENGTH_LONG).show()
         }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}