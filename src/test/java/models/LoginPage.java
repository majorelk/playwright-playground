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
    this.loginButton = page.locator("input[type='email']");
    this.continueButton = page.locator("input[id='continue']");
    this.passwordField = page.locator("input[type='email']");
    this.usernameField = page.locator("input[type='password']");
  }

  public void loginToAppWith(String username, String password) {
    usernameField.fill(username);
    continueButton.click();
    passwordField.fill(password);
    loginButton.click();
  }
}
