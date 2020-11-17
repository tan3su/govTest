package test.java.framework;

import org.openqa.selenium.By;

public class SessionHelperUI extends HelperBase {

  public SessionHelperUI(ApplicationManager app) {
    super(app);
  }

  public void ChangeLang(String language) {

    click(By.cssSelector("#lang-menu"));
    click(By.xpath("//ul[@id='select_lang-menu']//li[contains(., '"+ language+"')]"));

    String title = wd.findElement(By.cssSelector("title")).getText();

  }
}
