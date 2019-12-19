package com.disha.orderyourpastry.menu

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.disha.orderyourpastry.R
import org.hamcrest.CoreMatchers
import org.hamcrest.Matchers
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PastryMenuActivityTest2 {

    @get:Rule
    var mActivityTestRule: ActivityTestRule<PastryMenuActivity?> =
        ActivityTestRule(PastryMenuActivity::class.java)

    @Test
    fun checkRecyclerItemsCount() {
        val recyclerView =
            mActivityTestRule.activity!!.findViewById(R.id.rv_pastries) as? RecyclerView
        recyclerView?.adapter?.let {
            assert(it.itemCount > 0)
        }
    }

    @Test
    fun checkRecyclerViewItems_atParticularPosition() {
        val position = 10
        Espresso.onView(ViewMatchers.withId(R.id.rv_pastries))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    position,
                    ViewActions.click()
                )
            )

        Espresso.onView(
            CoreMatchers.allOf(
                ViewMatchers.withId(R.id.tv_pastry_name),
                Matchers.not(ViewMatchers.withText(DummyData.getPastryList()[position].pastryName))
            )
        )

    }

}