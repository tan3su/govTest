package test.java.tests;

import org.testng.annotations.Test;
import test.java.framework.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class APIChangeLangTests extends TestBase{
    @Test
    public void testGetPageOnEn() throws IOException {
        HttpSession session = app.newSession();
        String title = "gov.il - The new website for services and government information";
        assertTrue(session.isLanguageSelected("en", title));
    }
}
