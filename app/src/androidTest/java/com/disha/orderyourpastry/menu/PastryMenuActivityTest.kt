package com.disha.orderyourpastry.menu

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.disha.orderyourpastry.R
import com.disha.orderyourpastry.order.PastryOrderActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PastryMenuActivityTest {

    @get:Rule
    val intentTestRule: IntentsTestRule<PastryMenuActivity> =
        IntentsTestRule(PastryMenuActivity::class.java)

    @Test
    fun onClickOfPastry_OrderActivityOpens() {
        Espresso.onView(ViewMatchers.withId(R.id.rv_pastries))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    ViewActions.click()
                )
            )
        intended(hasComponent(PastryOrderActivity::class.java.name))
    }

}