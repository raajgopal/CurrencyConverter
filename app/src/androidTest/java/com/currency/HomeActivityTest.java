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
import static android.support.test.espresso.matcher.ViewMatchers.*;

public class HomeActivityTest {
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
    public void testHomeActivityViews() {
        onView(withId(R.id.headerTitle)).perform(setViewVisibitity(true));
        onView(withId(R.id.headerTitle)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.tabularLayout)).perform(setViewVisibitity(true));
        onView(withId(R.id.viewPager)).perform(setViewVisibitity(true));
    }
}
