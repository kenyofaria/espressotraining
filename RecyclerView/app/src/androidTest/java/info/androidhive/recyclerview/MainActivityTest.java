package info.androidhive.recyclerview;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;

/**
 * Created by kenyo on 07/08/18.
 */

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity>
            rule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void activityReady(){
        Espresso.onView(
                ViewMatchers.withText("Movie")
        ).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void floatButtonisEnabled(){
        Espresso.onView(
                ViewMatchers.withId(R.id.imageButton)
        ).check(ViewAssertions.matches(ViewMatchers.isEnabled()));
    }

    @Test
    public void recyclerViewIsEmpty(){
        RecyclerView viewById =
                (RecyclerView) rule.getActivity()
                        .findViewById(R.id.recycler_view);
        Assert.assertTrue(viewById.getAdapter().getItemCount() == 0);
    }
}
