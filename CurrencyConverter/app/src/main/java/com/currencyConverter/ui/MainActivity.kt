package com.currencyConverter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import com.currencyConverter.R
import com.currencyConverter.ServiceLocator
import com.currencyConverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var currencyViewModel: CurrencyViewModel
    lateinit var viewModelFactory: ViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModelFactory= ViewModelFactory(ServiceLocator.provideRepository())
        currencyViewModel =
            ViewModelProvider(this, viewModelFactory).get(CurrencyViewModel::class.java)
        binding.currencyViewModel=currencyViewModel


        val adapter = ArrayAdapter(
            this,android.R.layout.simple_spinner_item, currencyViewModel.currencyList
        )

        binding.givenSpinner.adapter = adapter
        binding.givenSpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                currencyViewModel.givenCurrency = binding.givenSpinner.selectedItem.toString()

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
                Log.i("TAG", "onNothingSelected: ")
            }

        }

        val requiredAdapter = ArrayAdapter(
            this, R.layout.item_spinner,
            currencyViewModel.currencyList
        )




        binding.requiredSpinner.adapter=requiredAdapter
        binding.requiredSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                currencyViewModel.requiredCurrency = binding.requiredSpinner.selectedItem.toString()
            }

        }


    }
}