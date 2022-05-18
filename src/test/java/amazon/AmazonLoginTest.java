package amazon;
import com.microsoft.playwright.*;

import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import models.LoginPage;

public class AmazonLoginTest {
  private static final String USER_NAME = null;
  private static final String USER_PASS = null;
  static final String LOGGED_IN_NAV_TEXT = "Account & Lists";
  static final String webPage = "https://amazon.co.uk";

  Playwright playwright = Playwright.create();
  Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
  Page page = browser.newPage();
  LoginPage loginPage = new LoginPage(page);


  @Test
  void shouldLoginToApplication() {
    page.navigate(webPage);
    page.click("#sp-cc-accept");
    page.click("#nav-link-accountList");

    // standard lines
    page.fill("input[name='email']", USER_NAME);
    page.click("input[id='continue']");
    page.fill("input[name='password']", USER_PASS);
    page.click("#signInSubmit");

    // POM method does not work here flow is different.
    // loginPage.loginToAppWith(USER_NAME, USER_PASS);
    //loginPage.loginToAppWith(USER_NAME, USER_PASS);
    assertThat(page.locator("#nav-link-accountList")).containsText(LOGGED_IN_NAV_TEXT);
  }

  @Test
  void shouldNotContinueWithWrongEmail() {
    page.navigate(webPage);
    page.click("#sp-cc-accept");
    page.click("#nav-link-accountList");

    // standard lines
    page.fill("input[name='email']", "fakeEmai@fakemail.com");
    page.click("input[id='continue']");

    // POM method does not work here flow is different.
    // loginPage.loginToAppWith(USER_NAME, USER_PASS);
    //loginPage.loginToAppWith(USER_NAME, USER_PASS);
    assertThat(page.locator("#auth-error-message-box")).containsText("There was a problem");
    assertThat(page.locator("#auth-error-message-box")).containsText("We cannot find an account with that e-mail address");
  }

  @Test
  void shouldNotContinueWithWrongPassword() {
    page.navigate(webPage);
    page.click("#sp-cc-accept");
    page.click("#nav-link-accountList");

    page.fill("input[name='email']", USER_NAME);
    page.click("input[id='continue']");

    page.fill("input[name='password']", "wrongPassword!23");
    page.click("#signInSubmit");

    assertThat(page.locator("#auth-error-message-box")).containsText("There was a problem");
    assertThat(page.locator("#auth-error-message-box")).containsText("Your password is incorrect");
  }
}
