package com.ismailmesutmujde.kotlinspinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinspinner.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var bindingMain : ActivityMainBinding
    private lateinit var dataAdapter : ArrayAdapter<String>
    private val countries = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        val view = bindingMain.root
        setContentView(view)

        countries.add("Türkiye")
        countries.add("Italy")
        countries.add("Germany")
        countries.add("Japan")
        countries.add("China")
        countries.add("Portugal")
        countries.add("Spain")

        dataAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, countries)
        bindingMain.spinner.adapter = dataAdapter

        bindingMain.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(applicationContext,"Selected Country : ${countries[position]}", Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        bindingMain.buttonShow.setOnClickListener {
            Toast.makeText(applicationContext,"Country : ${countries[bindingMain.spinner.selectedItemPosition]}", Toast.LENGTH_LONG).show()
        }
    }
}