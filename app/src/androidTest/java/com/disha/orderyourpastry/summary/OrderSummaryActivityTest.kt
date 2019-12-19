package com.disha.orderyourpastry.summary

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.disha.orderyourpastry.R
import org.hamcrest.core.AllOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OrderSummaryActivityTest {

    @get:Rule
    val intentsTestRule: IntentsTestRule<OrderSummaryActivity> =
        IntentsTestRule(OrderSummaryActivity::class.java)

    @Test
    fun clickSendEmailButton_SendsEmail() {
        Espresso.onView(ViewMatchers.withId(R.id.btn_send_mail)).perform(ViewActions.click())
        Intents.intended(
            AllOf.allOf(
                IntentMatchers.hasAction(Intent.ACTION_SENDTO),
                IntentMatchers.hasExtra(
                    Intent.EXTRA_TEXT,
                    "I have ordered yummy pastries. Check out now!"
                )
            )
        )
    }

}