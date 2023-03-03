package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.ActivityAction
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class AnotherActivityTest {
    @Test
    fun tryingIntend() {
        Intents.init()
        val intent = Intent(
            ApplicationProvider.getApplicationContext<Context>(),
            AnotherActivity::class.java
        )
        val hello = "helloWorld"
        intent.putExtra("message_key",hello)
        try {
        var aS = ActivityScenario.launch<AnotherActivity>(intent)
            onView(withId(R.id.received_value_id)).check(matches(withText("Greeting "+hello)))
        } finally{
        }
        Intents.release()

    }
}