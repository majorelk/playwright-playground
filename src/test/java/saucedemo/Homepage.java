package saucedemo;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import saucedemo.pages.LoginPage; // import page object

import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Homepage {
  // Shared between all tests in this class.
  static Playwright playwright;
  static Browser browser;
  static String userOne = "standard_user";
  static String userTwo = "locked_out_user";
  static String userThree = "problem_user";
  static String userFour = "performance_glitch_user";
  static String userPass = "secret_sauce";
  static String testSite = "https://saucedemo.com";
  LoginPage loginPage;
  // New instance for each test method.
  BrowserContext context;
  Page page;

  @BeforeAll
  static void launchBrowser() {
    playwright = Playwright.create();
    browser = playwright.chromium().launch();
  }

  @AfterAll
  static void closeBrowser() {
    playwright.close();
  }

  @BeforeEach
  void createContextAndPage() {
    context = browser.newContext();
    page = context.newPage();
  }

  @AfterEach
  void closeContext() {
    context.close();
  }

  @Test
  void shouldLoginWithValidDetails() {
    // navigate to page
    page.navigate(testSite);

    // complete login flow
    loginPage.completeLoginFlow(userOne, userPass);

    // assert state of application
    assertTrue(page.locator("#shopping_cart_container").isVisible());
  }

  @Test
  void shouldReportLockedOut() {
    // navigate to page
    page.navigate(testSite);

    // complete login flow
    loginPage.completeLoginFlow(userOne, userPass);
    
    assertThat(page.locator("#error-message-container error")).containsText("locked out");
  }
}
