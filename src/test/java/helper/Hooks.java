package helper;

import io.cucumber.java.*;

import static helper.Utility.quitDriver;
import static helper.Utility.startDriver;

public class Hooks {

    @BeforeAll
    public static void setUp(){
    }

    @AfterAll
    public static void tearDown(){
    }

    @Before
    public void beforeTest(){
        //pangil driver celenium
        startDriver();
    }

    @After
    public void afterTest(){
    //kill celenium
        quitDriver();
    }
}
