package test.java.tests;

import org.testng.annotations.Test;

public class UIChangeLangTests extends TestBase{
    @Test
    public void testGetPageOnEn(){
        app.sessionUI().ChangeLang("English");
        String screenshot = app.sessionUI().takeScreenshot();
        System.out.println("The path to screenshot is: " + screenshot);
        logger.info(screenshot);

    }

}
