package com.currency;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import com.currency.views.ui.activities.HomeActivity;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class CurrencyInfoFragmentTest {
    @Rule
    public ActivityTestRule<HomeActivity> mActivityRule =
            new ActivityTestRule<>(HomeActivity.class);

    private static ViewAction setViewVisibitity(final boolean value) {
        return new ViewAction() {

            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(View.class);
            }

            @Override
            public void perform(UiController uiController, View view) {
                view.setVisibility(value ? View.VISIBLE : View.GONE);
            }

            @Override
            public String getDescription() {
                return "Show / Hide View";
            }
        };
    }


    @Test
    public void testCurrencyFragmentView() {
        onView(withId(R.id.progressView)).perform(setViewVisibitity(true));
        onView(withId(R.id.progressView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.currencyRecyclerView)).perform(setViewVisibitity(true));
        onView(withId(R.id.currencyRecyclerView)).check(matches(isCompletelyDisplayed()));
    }
}
