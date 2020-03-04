package com.antonioleiva.mymovies

import android.app.Application
import android.content.Intent
import android.os.SystemClock
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import com.antonioleiva.mymovies.ui.main.MainActivity
import com.jakewharton.espresso.OkHttp3IdlingResource
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.time.ExperimentalTime

class UiTest {

    @ExperimentalTime
    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, false, false)

    @get:Rule
    val grantPermissionRule: GrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_COARSE_LOCATION"
            )

    private lateinit var mockWebServer: MockWebServer

    @ExperimentalTime
    @Before
    fun setUp(){
        val instrumentation= InstrumentationRegistry.getInstrumentation()
        val app = instrumentation.targetContext.applicationContext as Application
        val component = DaggerUiTestComponent.factory().create(app)

        mockWebServer = component.mockWebServer

        val resource = OkHttp3IdlingResource.create("OkHttp", component.movieDB.okHttpClient)
        IdlingRegistry.getInstance().register(resource)

        val intent = Intent(instrumentation.targetContext, MainActivity::class.java)

        activityTestRule.launchActivity(intent)
    }

    @Test
    fun clickAMovieNavigatesToDetail() {

        mockWebServer.enqueue(
                MockResponse()
                        .setResponseCode(200)
                        .setBody(popularMovies)
        )

        SystemClock.sleep(1000)

        onView(withId(R.id.recycler)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        4,
                        click()
                )
        )

        onView(withId(R.id.movieDetailToolbar))
                .check(matches(hasDescendant(withText("Spider-Man: Far from Home"))))

    }

    @After
    fun tearDown(){
       mockWebServer.close()
    }
}