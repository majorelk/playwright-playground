package models;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
  private final Page page;
  private final Locator usernameField;
  private final Locator passwordField;
  private final Locator loginButton;
  private final Locator continueButton;

  public LoginPage(Page page) {
    this.page = page;
    this.loginButton = page.locator("#signInSubmit");
    this.continueButton = page.locator("input[id='continue']");
    this.passwordField = page.locator("input[name='email']");
    this.usernameField = page.locator("input[name='password']");
  }

  public void loginToAppWith(String username, String password) {
    page.waitForNavigation(() -> {
      usernameField.fill(username);
      continueButton.click();
      passwordField.waitFor();
      passwordField.fill(password);
      loginButton.click();
    });
  }
}
