package authorization;

import com.microsoft.playwright.*;

// import pages.LoginPage;

public class whenAuthorizingForAccess {
  private static final String USER_NAME = null;
  private static final String PASS_WORD = null;
  // static LoginPage login;
  static Playwright playwright = Playwright.create();
  static Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
      .setHeadless(false));
  static BrowserContext context = browser.newContext();
  static Page page = context.newPage();

  public static void loginToApplicationWith() {
    page.navigate("https://www.amazon.com/");
    // login.withUi(USER_NAME, PASS_WORD);
    page.fill("input[name='email']", USER_NAME);
    page.fill("input[name='password']", PASS_WORD);
    page.waitForNavigation(() -> {
      page.click("input[type='submit']");
    });
    assert page.url().equals("https://www.amazon.com/ref=ap_frn_logo");
  }
}
