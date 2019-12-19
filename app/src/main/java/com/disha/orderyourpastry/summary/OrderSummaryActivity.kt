package com.disha.orderyourpastry.summary

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.disha.orderpastry.utils.Constants.EXTRA_PASTRY_PRICE
import com.disha.orderpastry.utils.Constants.EXTRA_PASTRY_QUANTITY
import com.disha.orderpastry.utils.Constants.EXTRA_PASTRY_SIZE
import com.disha.orderpastry.utils.Constants.EXTRA_PASTRY_SUGAR
import com.disha.orderyourpastry.R
import com.disha.orderyourpastry.databinding.ActivityOrderSummaryBinding

class OrderSummaryActivity : AppCompatActivity() {

    lateinit var binding: ActivityOrderSummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order_summary)

        setIntentData()
        binding.btnSendMail.setOnClickListener {
            sendEmail()
        }
    }

    private fun sendEmail() {
        Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_summary_email_subject))
            putExtra(Intent.EXTRA_TEXT, getString(R.string.email_message))
        }.run {
            if (resolveActivity(packageManager) != null) {
                startActivity(this)
            }
        }
    }

    private fun setIntentData() {
        with(intent) {
            with(binding) {
                tvQuantity.text = getIntExtra(EXTRA_PASTRY_QUANTITY, 0).toString()
                tvSize.text = getStringExtra(EXTRA_PASTRY_SIZE)
                tvSugar.text = getStringExtra(EXTRA_PASTRY_SUGAR)
                tvTotal.text = getFloatExtra(EXTRA_PASTRY_PRICE, 0F).toString()
            }
        }
    }
}
