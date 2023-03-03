package com.example.myapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import junit.framework.TestCase.assertEquals
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    var testRule = ActivityScenarioRule(
        MainActivity::class.java
    )


    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.myapplication", appContext.packageName)
    }

    @Test
    fun tryingHello() {
        // Context of the app under test.
     onView(withId( R.id.send_text_id)).perform(typeText("Hello"))
    }

    @Test
    fun tryingHello2() {
        // Context of the app under test.
       onView(withId( R.id.send_text_id)).perform(typeText("Hello")).check(matches(
            withText("Hello")
        ))
       onView(withId(R.id.btnStartAnotherActivity)).perform(click())
    }

    @Test
    fun tryingIntend() {
        Intents.init()
        onView(withId( R.id.send_text_id)).perform(typeText("Hello"))
        onView(withId(R.id.btnStartAnotherActivity)).perform(click())   // Build the result to return when the activity is launched.
        intended(allOf(
            hasExtra("message_key","Hello")
        ))
        Intents.release()

    }


}