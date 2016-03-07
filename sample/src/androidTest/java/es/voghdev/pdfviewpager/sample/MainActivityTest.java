/*
 * Copyright (C) 2016 Olmo Gallegos Hernández.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.voghdev.pdfviewpager.sample;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.voghdev.pdfviewpager.MainActivity;
import es.voghdev.pdfviewpager.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.PositionAssertions.isBelow;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class) @LargeTest public class MainActivityTest  {
    @Rule public IntentsTestRule<MainActivity> activityRule =
            new IntentsTestRule<>(MainActivity.class, true, false);

    @Test public void showsSamplesTitle() {
        startActivity();

        onView(withText(R.string.txt1)).check(matches(isDisplayed()));
    }

    @Test public void showsSamplesButton2() {
        startActivity();

        onView(withId(R.id.btnSample2)).check(matches(isDisplayed()));
    }

    @Test public void showsSamplesButton3() {
        startActivity();

        onView(withText(R.string.sample3_txt)).check(isBelow(withId(R.id.btnSample2)));
    }

    @Test public void showsSamplesButton6() {
        startActivity();

        onView(withText(R.string.sample6_txt)).check(isBelow(withId(R.id.btnSample5)));
    }

    @Test public void showsSamplesButton7() {
        startActivity();

        onView(withText(R.string.sample7_txt)).check(isBelow(withId(R.id.btnSample6)));
    }

    @Test public void showsSamplesButton8() {
        startActivity();

        onView(withText(R.string.sample8_txt)).check(isBelow(withId(R.id.btnSample7)));
    }


    @Test public void samplesButton3IsCorrectlyPositioned() {
        startActivity();

        onView(withText(R.string.sample3_txt)).check(isBelow(withId(R.id.btnSample2)));
    }

    @Test public void showsInitialPdfViewer() {
        startActivity();

        onView(withId(R.id.pdfViewPager)).check(matches(isDisplayed()));
    }

    private MainActivity startActivity() {
        return activityRule.launchActivity(null);
    }
}