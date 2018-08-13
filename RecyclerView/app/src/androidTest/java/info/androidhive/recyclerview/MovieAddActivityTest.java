package info.androidhive.recyclerview;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import org.hamcrest.Matchers;
import org.hamcrest.core.AllOf;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by kenyo on 07/08/18.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovieAddActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<MainActivity>(MainActivity.class);


    @Before
    public void seteup(){
        Espresso.onView(ViewMatchers.withId(R.id.imageButton)).perform(ViewActions.click());
    }

    @Test
    public void A_movieAddActivityReady(){
        Espresso.onView(
                ViewMatchers.withText("New Movie")
        ).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void B_buttonAddIsEnabled(){
        Espresso.onView(
                ViewMatchers.withId(R.id.btnAdd)
        ).check(ViewAssertions.matches(Matchers.not(ViewMatchers.isEnabled())));
    }

    @Test
    public void C_buttonAddEnabledTrue(){
        Espresso.onView(
                ViewMatchers.withId(R.id.txtTitle)
        ).perform(ViewActions.typeText("Indiana Jones"));
        Espresso.onView(
                ViewMatchers.withId(R.id.txtYear)
        ).perform(ViewActions.typeText("1990"));
        Espresso.onView(
                ViewMatchers.withId(R.id.cmbGender)
        ).perform(ViewActions.click());
        Espresso.onData(
                            AllOf.allOf(
                                            Matchers.is(Matchers.instanceOf(String.class)),
                                            Matchers.is("Action")
                            )
        ).perform(ViewActions.click());
        Espresso.onView(
                ViewMatchers.withText("Add")
        ).check(ViewAssertions.matches(ViewMatchers.isEnabled()));
    }

    @Test
    public void D_buttonAddEnabledFalse(){
        Espresso.onView(
                ViewMatchers.withId(R.id.txtTitle)
        ).perform(ViewActions.typeText("Indiana Jones"));
        Espresso.onView(
                ViewMatchers.withId(R.id.txtYear)
        ).perform(ViewActions.typeText("1990"));
        Espresso.onView(
                ViewMatchers.withId(R.id.cmbGender)
        ).perform(ViewActions.click());
        Espresso.onData(
                AllOf.allOf(
                        Matchers.is(Matchers.instanceOf(String.class)),
                        Matchers.is("Action")
                )
        ).perform(ViewActions.click());
        Espresso.onView(
                ViewMatchers.withId(R.id.txtTitle)
        ).perform(ViewActions.clearText());
        Espresso.onView(
                ViewMatchers.withId(R.id.btnAdd)
        ).check(ViewAssertions.matches(Matchers.not(ViewMatchers.isEnabled())));
    }

    @Test
    public void E_saveMovie(){
        String movieToSave = "Indiana Jones";
        String movieYear = "1990";
        String movieGenre = "SYFY";
        Espresso.onView(
                ViewMatchers.withId(R.id.txtTitle)
        ).perform(ViewActions.typeText(movieToSave));

        Espresso.onView(
                ViewMatchers.withId(R.id.txtYear)
        ).perform(ViewActions.typeText(movieYear));

        Espresso.onView(
                ViewMatchers.withId(R.id.cmbGender)
        ).perform(ViewActions.click());

        Espresso.onData(
                AllOf.allOf(
                        Matchers.is(Matchers.instanceOf(String.class)),
                        Matchers.is(movieGenre)
                )
        ).perform(ViewActions.click());

        Espresso.onView(
                ViewMatchers.withId(R.id.btnAdd)
        ).perform(ViewActions.click());

        Espresso.onView(
                AllOf.allOf(
                        ViewMatchers.withId(R.id.title),
                        ViewMatchers.withText(movieToSave)
                )
        ).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        Espresso.onView(
                AllOf.allOf(
                        ViewMatchers.withId(R.id.genre),
                        ViewMatchers.withText(movieGenre)
                )
        ).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        Espresso.onView(
                AllOf.allOf(
                        ViewMatchers.withId(R.id.year),
                        ViewMatchers.withText(movieYear)
                )
        ).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

}
