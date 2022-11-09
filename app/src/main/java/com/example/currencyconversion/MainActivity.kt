package com.example.currencyconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userNumber = findViewById<EditText>(R.id.editTextNumber)
        val dollarKrona = findViewById<RadioButton>(R.id.idRadioDollarKr)
        val kronaDollar = findViewById<RadioButton>(R.id.idRadioKrDollar)
        var result = findViewById<TextView>(R.id.txtResult)
        val btnResult = findViewById<Button>(R.id.btnResult)

        btnResult.setOnClickListener {
            var conversionValue = userNumber.text.toString().toDouble()!!

            val decimalStyle = DecimalFormat("###,###.00")
            var convertedMoney: Double?
            if (dollarKrona.isChecked) {
                if (conversionValue <= 10000) {
                    convertedMoney = conversionValue * 145.37
                    result.text = decimalStyle.format(convertedMoney) + "kr"
                } else {
                    Toast.makeText(this@MainActivity, "ERROR less than 10,000", Toast.LENGTH_LONG)
                        .show()
                }
            }
            if (kronaDollar.isChecked) {
                if (conversionValue <= 10000) {
                    convertedMoney = conversionValue / 145.37
                    result.text = "$" + decimalStyle.format(convertedMoney)
                } else {
                    Toast.makeText(this@MainActivity, "ERROR less than 10,000", Toast.LENGTH_LONG)
                        .show()
                }

            }
        }
    }
}