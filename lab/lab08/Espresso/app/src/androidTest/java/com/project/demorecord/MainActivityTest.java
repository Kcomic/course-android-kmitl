package com.project.demorecord;


import android.os.SystemClock;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.buttonAdded), withText("ADDED"), isDisplayed()));
        appCompatButton.perform(click());

        onView(allOf(withId(android.R.id.button1), withText("OK"))).perform(click());
        SystemClock.sleep(2000);

    }

    @Test
    public void mainActivityTest2() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editTextAge), isDisplayed()));
        appCompatEditText.perform(replaceText("20"), closeSoftKeyboard());


        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.buttonAdded), withText("ADDED"), isDisplayed()));
        appCompatButton.perform(click());

        onView(allOf(withId(android.R.id.button1), withText("OK"))).perform(click());
        SystemClock.sleep(1500);

    }

    @Test
    public void mainActivityTest3() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"), isDisplayed()));
        appCompatButton.perform(click());

        SystemClock.sleep(2000);

    }

    @Test
    public void mainActivityTest4() {

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editTExtName), isDisplayed()));
        appCompatEditText2.perform(replaceText("Ying"), closeSoftKeyboard());


        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.buttonAdded), withText("ADDED"), isDisplayed()));
        appCompatButton.perform(click());
        onView(allOf(withId(android.R.id.button1), withText("OK"))).perform(click());
        SystemClock.sleep(2000);


    }

    @Test
    public void mainActivityTest5() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editTExtName), isDisplayed()));
        appCompatEditText.perform(replaceText("Ying"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editTextAge), isDisplayed()));
        appCompatEditText2.perform(replaceText("20"), closeSoftKeyboard());


        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.buttonAdded), withText("ADDED"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"), isDisplayed()));
        appCompatButton2.perform(click());
        SystemClock.sleep(2000);

    }

    @Test
    public void mainActivityTest6() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editTExtName), isDisplayed()));
        appCompatEditText.perform(replaceText("Ladarat"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editTextAge), isDisplayed()));
        appCompatEditText2.perform(replaceText("20"), closeSoftKeyboard());


        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.buttonAdded), withText("ADDED"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"), isDisplayed()));
        appCompatButton2.perform(click());
        SystemClock.sleep(2000);

    }

    @Test
    public void mainActivityTest7() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editTExtName), isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editTExtName), isDisplayed()));
        appCompatEditText2.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.editTExtName), isDisplayed()));
        appCompatEditText3.perform(click());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.editTExtName), isDisplayed()));
        appCompatEditText4.perform(replaceText("Somkait"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.editTextAge), isDisplayed()));
        appCompatEditText5.perform(replaceText("80"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.buttonAdded), withText("ADDED"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"), isDisplayed()));
        appCompatButton2.perform(click());
        SystemClock.sleep(2000);

    }

    @Test
    public void mainActivityTest8() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editTExtName), isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editTExtName), isDisplayed()));
        appCompatEditText2.perform(replaceText("Prayoch"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.editTextAge), isDisplayed()));
        appCompatEditText3.perform(replaceText("60"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.buttonAdded), withText("ADDED"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"), isDisplayed()));
        appCompatButton2.perform(click());
        SystemClock.sleep(2000);
    }

    @Test
    public void mainActivityTest9() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editTExtName), isDisplayed()));
        appCompatEditText.perform(replaceText("Prayoch"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editTextAge), isDisplayed()));
        appCompatEditText2.perform(replaceText("50"), closeSoftKeyboard());


        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.buttonAdded), withText("ADDED"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"), isDisplayed()));
        appCompatButton2.perform(click());
        SystemClock.sleep(2000);

    }
}
