package com.disha.orderyourpastry.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.disha.orderpastry.utils.Constants.EXTRA_PASTRY_NAME
import com.disha.orderpastry.utils.Constants.EXTRA_PASTRY_PRICE
import com.disha.orderpastry.utils.toggleVisibility
import com.disha.orderyourpastry.R
import com.disha.orderyourpastry.databinding.ActivityPastryMenuBinding
import com.disha.orderyourpastry.order.PastryOrderActivity

class PastryMenuActivity : AppCompatActivity(), MenuContract.View {

    private lateinit var binding: ActivityPastryMenuBinding
    private lateinit var presenter: PastryMenuPresenter
    private lateinit var pastryMenuAdapter: PastryMenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_pastry_menu)
        presenter = PastryMenuPresenter(this)
        pastryMenuAdapter = PastryMenuAdapter(this, presenter)

        binding.rvPastries.apply {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = pastryMenuAdapter
        }
    }

    override fun showPastryList(show: Boolean) {
        binding.rvPastries.toggleVisibility(show)
    }

    override fun showPastryOrderScreen(pastryDataModel: PastryDataModel) {
        startActivity(Intent(this, PastryOrderActivity::class.java).apply {
            putExtra(EXTRA_PASTRY_NAME, pastryDataModel.pastryName)
            putExtra(EXTRA_PASTRY_PRICE, pastryDataModel.price)
        })
    }

}
