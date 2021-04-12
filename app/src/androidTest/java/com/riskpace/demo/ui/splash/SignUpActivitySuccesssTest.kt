package com.riskpace.demo.ui.splash


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.riskpace.demo.R
import com.riskpace.demo.ui.authentication.SignUpActivity
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class SignUpActivitySuccesssTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(SignUpActivity::class.java)

    @Test
    fun signUpActivitySuccesssTest() {
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
        textInputEditText.perform(replaceText("chintan123"), closeSoftKeyboard())

        val textInputEditText2 = onView(
            allOf(
                withId(R.id.edtFirstName),
                isDisplayed()
            )
        )
        textInputEditText2.perform(replaceText("chintan"), closeSoftKeyboard())

        val textInputEditText3 = onView(
            allOf(
                withId(R.id.edtLastName),
                isDisplayed()
            )
        )
        textInputEditText3.perform(replaceText("prajapati"), closeSoftKeyboard())

        val textInputEditText4 = onView(
            allOf(
                withId(R.id.edtLastName), withText("prajapati"),
                isDisplayed()
            )
        )
        textInputEditText4.perform(pressImeActionButton())

        val textInputEditText5 = onView(
            allOf(
                withId(R.id.edtPassword),
                isDisplayed()
            )
        )
        textInputEditText5.perform(replaceText("111"), closeSoftKeyboard())


        val appCompatButton = onView(
            allOf(
                withId(R.id.btnSignUp), withText("Sign Up"),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())

        val textView = onView(
            allOf(
                withId(R.id.tvSignUpLabel), withText("Sign Up"),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Sign Up")))
    }

}
