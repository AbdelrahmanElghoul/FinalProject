package com.udacity.gradle.builditbigger;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.IdlingResource;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {

    private IdlingResource mIdlingResource;

    @Test
   public void testPostExecuteData() throws IOException {

        EndpointsAsyncTask test=new EndpointsAsyncTask();
        mIdlingResource=EndpointsAsyncTask.idlingResource;
        Espresso.registerIdlingResources(mIdlingResource);
        String jokeTest=test.ReadGCE();
        Espresso.unregisterIdlingResources(mIdlingResource);
        assert ( jokeTest !=null && jokeTest.isEmpty());
    }
}
