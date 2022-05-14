package authorization;

import com.microsoft.playwright.*;

// import pages.LoginPage;

public class whenAuthorizingForAccess {
  private static final String USER_NAME = null;
  private static final String PASS_WORD = null;
  public static final String USERNAME_FIELD = "input[name='email']";
  public static final String PASSWORD_FIELD = "input[name='password']";
  
  // static LoginPage login;
  
  static Playwright playwright = Playwright.create();
  static Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
      .setHeadless(false));
  static BrowserContext context = browser.newContext();
  static Page page = context.newPage();

  public static void loginToApplicationWith() {
    page.navigate("https://www.amazon.com/");
    // login.withUi(USER_NAME, PASS_WORD);
    page.fill(USERNAME_FIELD, USER_NAME);
    page.fill(PASSWORD_FIELD, PASS_WORD);
    page.waitForNavigation(() -> {
      page.click("input[type='submit']");
    });
    assert page.url().equals("https://www.amazon.com/ref=ap_frn_logo");
  }
}
