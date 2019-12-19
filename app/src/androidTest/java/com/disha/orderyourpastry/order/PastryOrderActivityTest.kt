package com.disha.orderyourpastry.order

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.disha.orderyourpastry.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PastryOrderActivityTest {

    @get:Rule
    var mActivityTestRule: ActivityTestRule<PastryOrderActivity?>? =
        ActivityTestRule(PastryOrderActivity::class.java)

    @Test
    fun clickDecrementButton_ChangesQuantityAndCost() {

        val totalPrice = 0F

        Espresso.onView(ViewMatchers.withId(R.id.tv_total_quantity))
            .check(ViewAssertions.matches(ViewMatchers.withText("0")))

        Espresso.onView(ViewMatchers.withId(R.id.btn_remove)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.tv_total_quantity))
            .check(ViewAssertions.matches(ViewMatchers.withText("0")))

        Espresso.onView(ViewMatchers.withId(R.id.tv_total_amount))
            .check(ViewAssertions.matches(ViewMatchers.withText(totalPrice.toString())))
    }
}