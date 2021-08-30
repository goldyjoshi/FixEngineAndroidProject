package com.example.fixengine;

import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.widget.Button;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;


public class MainActivityPageTest {

    @Rule
    public ActivityTestRule<MainActivityPage> mActivityTestRule =
            new ActivityTestRule<MainActivityPage>(MainActivityPage.class);

    private MainActivityPage mainActivityPage = null;

    @Before
    public void setUp() {
        mainActivityPage = mActivityTestRule.getActivity();
    }


    @After
    public void cleanUp() {
        mainActivityPage = null;
    }
}
