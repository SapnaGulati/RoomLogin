package com.riskpace.demo.ui.splash


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.riskpace.demo.R
import com.riskpace.demo.ui.authentication.SignInActivity
import com.riskpace.demo.ui.authentication.SignUpActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class SignUpActivityFailTest {

//    @Rule
//    @JvmField
//    var mActivityTestRule = ActivityTestRule(SignInActivity::class.java)

    @Rule
    @JvmField
    var mActivityTestRule1 = ActivityTestRule(SignUpActivity::class.java)

    @Test
    fun signUpActivityTest() {
        val appCompatTextView = onView(
            allOf(
                withId(R.id.tvSignUpLabel), withText("Sign Up"),
                isDisplayed()
            )
        )
        appCompatTextView.perform(click())

        val textInputEditText = onView(
            allOf(
                withId(R.id.edtUserName),
                isDisplayed()
            )
        )
        textInputEditText.perform(replaceText("chin n"), closeSoftKeyboard())

        val textInputEditText2 = onView(
            allOf(
                withId(R.id.edtUserName), withText("chin n"),
                isDisplayed()
            )
        )
        textInputEditText2.perform(pressImeActionButton())

        val textInputEditText3 = onView(
            allOf(
                withId(R.id.edtUserName), withText("chin n"),
                isDisplayed()
            )
        )
        textInputEditText3.perform(replaceText("chin nc"))

        val textInputEditText4 = onView(
            allOf(
                withId(R.id.edtUserName), withText("chin nc"),
                isDisplayed()
            )
        )
        textInputEditText4.perform(closeSoftKeyboard())

        val textInputEditText5 = onView(
            allOf(
                withId(R.id.edtFirstName),
                isDisplayed()
            )
        )
        textInputEditText5.perform(replaceText("chintan"), closeSoftKeyboard())

        val textInputEditText6 = onView(
            allOf(
                withId(R.id.edtFirstName), withText("chintan"),
                isDisplayed()
            )
        )
        textInputEditText6.perform(pressImeActionButton())

        val textInputEditText7 = onView(
            allOf(
                withId(R.id.edtFirstName), withText("chintan"),
                isDisplayed()
            )
        )
        textInputEditText7.perform(replaceText("chintanprajap"))

        val textInputEditText8 = onView(
            allOf(
                withId(R.id.edtFirstName), withText("chintanprajap"),
                isDisplayed()
            )
        )
        textInputEditText8.perform(closeSoftKeyboard())

        val textInputEditText9 = onView(
            allOf(
                withId(R.id.edtLastName),
                isDisplayed()
            )
        )
        textInputEditText9.perform(replaceText("praj"), closeSoftKeyboard())

        val textInputEditText10 = onView(
            allOf(
                withId(R.id.edtLastName), withText("praj"),
                isDisplayed()
            )
        )
        textInputEditText10.perform(pressImeActionButton())

        val textInputEditText11 = onView(
            allOf(
                withId(R.id.edtPassword),
                isDisplayed()
            )
        )
        textInputEditText11.perform(replaceText("111"), closeSoftKeyboard())


        val appCompatButton = onView(
            allOf(
                withId(R.id.btnSignUp), withText("Sign Up"),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())

        val button = onView(
            allOf(
                withId(R.id.btnSignUp),
                isDisplayed()
            )
        )
        button.check(matches(isDisplayed()))
    }

}
