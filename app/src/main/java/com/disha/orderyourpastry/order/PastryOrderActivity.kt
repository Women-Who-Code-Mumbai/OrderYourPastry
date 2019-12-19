package com.disha.orderyourpastry.order

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.disha.orderpastry.utils.Constants.EXTRA_PASTRY_NAME
import com.disha.orderpastry.utils.Constants.EXTRA_PASTRY_PRICE
import com.disha.orderpastry.utils.Constants.EXTRA_PASTRY_QUANTITY
import com.disha.orderpastry.utils.Constants.EXTRA_PASTRY_SIZE
import com.disha.orderpastry.utils.Constants.EXTRA_PASTRY_SUGAR
import com.disha.orderyourpastry.R
import com.disha.orderyourpastry.databinding.ActivityPastryOrderBinding
import com.disha.orderyourpastry.summary.OrderSummaryActivity

class PastryOrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPastryOrderBinding
    private var price: Float = 0F
    private var pastryName: String? = null
    private lateinit var pastrySizeList: List<String>
    private lateinit var sugarArray: List<String>
    private lateinit var selectedPastrySize: String
    private lateinit var selectedSugar: String

    private var quantity: Int = 0
    private var totalPrice: Float = 0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pastry_order)

        setIntentData()
        setupSizeSpinner()
        setupSugarSpinner()
        binding.btnBite.setOnClickListener {
            if (quantity > 0)
                showSummary()
            else Toast.makeText(
                this,
                "Minimum 1 order is allowed",
                Toast.LENGTH_LONG
            ).show()
        }
        binding.btnRemove.setOnClickListener {
            if (quantity > 0) {
                binding.tvTotalQuantity.text = (--quantity).toString()
                totalPrice = price * quantity
                binding.tvTotalAmount.text = totalPrice.toString()
            }
        }
        binding.btnAdd.setOnClickListener {
            binding.tvTotalQuantity.text = (++quantity).toString()
            totalPrice = price * quantity
            binding.tvTotalAmount.text = totalPrice.toString()
        }
    }

    private fun setIntentData() {
        intent.run {
            pastryName = getStringExtra(EXTRA_PASTRY_NAME)
            binding.tvPastryName.text = pastryName
            price = getFloatExtra(EXTRA_PASTRY_PRICE, 0F)
            binding.tvTotalAmount.text = totalPrice.toString()
        }
    }

    private fun showSummary() {
        startActivity(Intent(this, OrderSummaryActivity::class.java).apply {
            putExtra(EXTRA_PASTRY_NAME, pastryName)
            putExtra(EXTRA_PASTRY_PRICE, totalPrice)
            putExtra(EXTRA_PASTRY_QUANTITY, quantity)
            putExtra(EXTRA_PASTRY_SIZE, selectedPastrySize)
            putExtra(EXTRA_PASTRY_SUGAR, selectedSugar)
        })
    }

    private fun setupSizeSpinner() {
        pastrySizeList = resources.getStringArray(R.array.pastry_size_array).toList()

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.pastry_size_array, android.R.layout.simple_spinner_item
        ).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        binding.spnSize.adapter = adapter
        binding.spnSize.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                selectedPastrySize = pastrySizeList[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedPastrySize = pastrySizeList[0]
            }
        }
    }

    private fun setupSugarSpinner() {
        sugarArray = resources.getStringArray(R.array.sugar_array).toList()

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.sugar_array, android.R.layout.simple_spinner_item
        ).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        binding.spnSugar.adapter = adapter
        binding.spnSugar.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                selectedSugar = sugarArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedSugar = sugarArray[0]
            }
        }
    }
}
