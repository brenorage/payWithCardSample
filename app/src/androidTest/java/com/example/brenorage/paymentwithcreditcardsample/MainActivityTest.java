package com.example.brenorage.paymentwithcreditcardsample;

import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.brenorage.paymentwithcreditcardsample.view.HistoryActivity;
import com.example.brenorage.paymentwithcreditcardsample.view.MainActivity;
import com.example.brenorage.paymentwithcreditcardsample.view.PaymentActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.getIdlingResources;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setupMainActivityTest() {
        rule.launchActivity(new Intent(rule.getActivity(), MainActivity.class));
        Intents.init();
    }

    @After
    public void afterTest() {
        Intents.release();
    }

    @Test
    public void openPaymentActivity() {
        onView(withId(R.id.mainPayButton)).perform(click());
        intended(allOf(
                hasComponent(hasClassName(PaymentActivity.class.getName())),
                toPackage(rule.getActivity().getPackageName())));
    }

    @Test
    public void openHistoryActivity() {
        onView(withId(R.id.historyButton)).perform(click());
        intended(allOf(
                hasComponent(hasClassName(HistoryActivity.class.getName())),
                toPackage(rule.getActivity().getPackageName())));
    }

}
