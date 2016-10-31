package com.example.brenorage.paymentwithcreditcardsample;

import android.content.Intent;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.brenorage.paymentwithcreditcardsample.view.PaymentActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class PaymentActivityTest {

    private String name = "breno rage";
    private String creditCard = "4242424242424242";
    private String cvv = "111";
    private String month = "11";
    private String year = "2018";
    private String amount = "10000";
    private String brandCard = "visa";
    private String wrongMonth = "13";
    private String wrongYear = "2015";
    private String emptyField = "Esse campo deve ser preenchido corretamente";

    @Rule
    public ActivityTestRule<PaymentActivity> rule = new ActivityTestRule<>(PaymentActivity.class);

    @Before
    public void setupMainActivityTest() {
        rule.launchActivity(new Intent(rule.getActivity(), PaymentActivity.class));
        Intents.init();
    }

    @After
    public void afterTest() {
        Intents.release();
    }

    @Test
    public void testDoTransaction() {
        fillTransactionFields();
        payClick();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(rule.getActivity().getString(R.string.success_payment), true);
    }

    private void payClick() {
        onView(withId(R.id.paymentButton)).perform(closeSoftKeyboard()).perform(click());
    }


    @Test
    public void getErrorInAmountField() {
        payClick();
        onView(withId(R.id.amountEditText)).check(matches(hasErrorText(emptyField)));
        onView(withId(R.id.amountEditText)).perform(typeText(amount));
        payClick();
        onView(withId(R.id.nameEditText)).check(matches(hasErrorText(emptyField)));
        onView(withId(R.id.nameEditText)).perform(typeText(name));
        payClick();
        onView(withId(R.id.cardNumberEditText)).check(matches(hasErrorText(emptyField)));
        onView(withId(R.id.cardNumberEditText)).perform(typeText(creditCard));
        payClick();
        onView(withId(R.id.brandCardEditText)).check(matches(hasErrorText(emptyField)));
        onView(withId(R.id.brandCardEditText)).perform(typeText(brandCard));
        payClick();
        onView(withId(R.id.cvvEditText)).check(matches(hasErrorText(emptyField)));
        onView(withId(R.id.cvvEditText)).perform(closeSoftKeyboard()).perform(typeText(cvv));
        onView(withId(R.id.monthEditText)).perform(closeSoftKeyboard()).perform(typeText(wrongMonth));
        payClick();
        onView(withId(R.id.monthEditText)).check(matches(hasErrorText(emptyField)));
        onView(withId(R.id.monthEditText)).perform(closeSoftKeyboard()).perform(clearText()).perform(typeText(month));
        onView(withId(R.id.yearEditText)).perform(closeSoftKeyboard()).perform(typeText(wrongYear));
        payClick();
        onView(withId(R.id.yearEditText)).check(matches(hasErrorText(emptyField)));
    }

    private void fillTransactionFields() {
        onView(withId(R.id.amountEditText)).perform(typeText(amount));
        onView(withId(R.id.nameEditText)).perform(typeText(name));
        onView(withId(R.id.cardNumberEditText)).perform(typeText(creditCard));
        onView(withId(R.id.brandCardEditText)).perform(typeText(brandCard));
        onView(withId(R.id.cvvEditText)).perform(closeSoftKeyboard()).perform(typeText(cvv));
        onView(withId(R.id.monthEditText)).perform(closeSoftKeyboard()).perform(typeText(month));
        onView(withId(R.id.yearEditText)).perform(closeSoftKeyboard()).perform(typeText(year));
    }
}
