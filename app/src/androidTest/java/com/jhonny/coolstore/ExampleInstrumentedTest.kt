package com.jhonny.coolstore

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import androidx.navigation.compose.rememberNavController
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.jhonny.coolstore.presenter.MainActivity
import com.jhonny.coolstore.presenter.composables.CounterButton
import com.jhonny.coolstore.presenter.main.MainScreen
import com.jhonny.coolstore.presenter.navigation.AppNavigation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import okhttp3.Dispatcher
import okhttp3.internal.wait
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.jhonny.coolstore", appContext.packageName)
    }

    @get:Rule
    val composeTestRule = createComposeRule()
   /* @get:Rule
    val composeTestRuleActivity = createAndroidComposeRule<MainActivity>()*/


    @Test
    fun navigateToResumeScreenWithActivity() {
                composeTestRule.onNode(
                    hasContentDescription("Increase count")
                ).performClick()

                composeTestRule.waitForIdle()
        //composeTestRule.onNodeWithText("Comprar").performClick()
       // composeTestRule.onNodeWithText("Pagar").assertIsDisplayed()

    }


    @Test
    fun navigateCounterButton() {
        composeTestRule.setContent {
            var valueCounter by remember {
                mutableStateOf(0)
            }
            CounterButton(
                value = valueCounter.toString(),
                onValueIncreaseClick = {
                    valueCounter += 1
                },
                onValueDecreaseClick = {
                    valueCounter = maxOf(valueCounter - 1, 0)
                },
                onValueClearClick = {
                    valueCounter = 0
                }
            )
        }

        composeTestRule.onNode(
            hasContentDescription("Increase count")
        ).performClick()
        composeTestRule.onNode(
            hasText("1")
        ).assertIsDisplayed()

        composeTestRule.onNode(
            hasContentDescription("Decrease count")
        ).performClick()
        composeTestRule.onNode(
            hasText("0")
        ).assertIsDisplayed()

        //composeTestRule.onNodeWithText("Comprar").performClick()
        // composeTestRule.onNodeWithText("Pagar").assertIsDisplayed()

    }
    /*
    @Test
    fun navigateToResumeScreen() {
        composeTestRule1.setContent {
            AppNavigation()
        }
/*
        composeTestRule1.onNode(
            hasContentDescription("Increase count")
        ).performClick()

        composeTestRule1.waitForIdle()*/
        //composeTestRule.onNodeWithText("Comprar").performClick()
        // composeTestRule.onNodeWithText("Pagar").assertIsDisplayed()

    }*/
}
