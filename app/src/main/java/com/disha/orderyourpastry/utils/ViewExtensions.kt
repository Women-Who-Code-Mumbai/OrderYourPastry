package com.disha.orderpastry.utils

import android.view.View

fun View.toggleVisibility(show: Boolean) {
    this.visibility = if (show) View.VISIBLE else View.GONE
}