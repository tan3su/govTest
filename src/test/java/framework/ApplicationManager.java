package test.java.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private Properties properties;
  protected WebDriver wd;
  protected WebDriverWait wait;

//protected SessionHelper session;
private SessionHelperUI sessionHelper ;
private String browser;



  public ApplicationManager(String browser)  {
    this.browser = browser;
    properties = new Properties();

  }


  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));


//    session.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));

  }


  public void stop() {
   if(wd != null) {
     wd.quit();
   }
  }



//  public SessionHelper getSession() {
//    return session;
//  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }

public HttpSession newSession(){
    return  new HttpSession(this);
}

//  public String getProperty(String key) {
//    return properties.getProperty(key);
//  }



  public WebDriver getDriver() {
    if (wd == null){
      if (browser.equals(BrowserType.FIREFOX)) {
        wd = new FirefoxDriver();
      } else if (browser.equals(BrowserType.CHROME)) {
        wd = new ChromeDriver();
      } else if (browser.equals(BrowserType.IE)) {
        wd = new InternetExplorerDriver();
      }
      wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
      wait = new WebDriverWait(wd, 25);
      wd.get(properties.getProperty("web.baseUrl","http://localhost/mantisbt-1.2.19/"));
    }
    return  wd;
  }


  public SessionHelperUI sessionUI(){
    if(sessionHelper == null){
      sessionHelper = new SessionHelperUI(this);
    }
    return  sessionHelper;

  }


}
