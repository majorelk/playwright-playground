package amazon;
import com.microsoft.playwright.*;

import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import models.LoginPage;

public class AmazonLoginTest {
  static final String USER_NAME = "naveen@gmail.com";
  static final String USER_PASS = "123456";
  static final String LOGGED_IN_NAV_TEXT = "Account & Lists";

  Playwright playwright = Playwright.create();
  Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
  Page page = browser.newPage();
  LoginPage loginPage = new LoginPage(page);


  @Test
  void shouldLoginToApplication() {
    page.navigate("https://amazon.co.uk");
    page.click("#sp-cc-accept");
    page.click("#nav-link-accountList");
    page.fill("input[name='email']", USER_NAME);
    page.click("input[id='continue']");
    page.fill("input[name='password']", USER_PASS);
    page.click("#signInSubmit");

    //loginPage.loginToAppWith(USER_NAME, USER_PASS);
    assertThat(page.locator(".nav-line-2")).hasText(LOGGED_IN_NAV_TEXT);
  }

}
