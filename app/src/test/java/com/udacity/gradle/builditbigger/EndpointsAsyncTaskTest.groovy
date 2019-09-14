package com.udacity.gradle.builditbigger


import org.junit.Test

class EndpointsAsyncTaskTest {

    @Test
    void testPostExecuteData() {
        String test=new EndpointsAsyncTask().execute().testPostExecuteData();
        assert (test !=null && test.isEmpty());
    }


}
