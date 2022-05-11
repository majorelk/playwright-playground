package playwrightsessions;

import java.nio.file.Paths;

import com.microsoft.playwright.*;

public class Demo {

  public static void main(String[] args) {
   try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless());
      Page page = browser.newPage();
      page.navigate("http://google.com");
      System.out.println(page.title());
      page.type("input[name='q']", "Cucumber");
      page.click("//input[@name='btnK']");
      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("examples.png")));
      browser.close();
      playwright.close();
   }
  }
} 
