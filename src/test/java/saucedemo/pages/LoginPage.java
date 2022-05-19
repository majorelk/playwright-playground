package saucedemo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
  private final Page page;
  private final Locator usernameField;
  private final Locator passwordField;
  private final Locator loginButton;

  public LoginPage(Page page) {
    this.page = page;
    this.loginButton = page.locator("#login-button");
    this.passwordField = page.locator("#user-name");
    this.usernameField = page.locator("#password");
  }

  public void completeLoginFlow(String userName, String userPassword) {
    usernameField.fill(userName);
      passwordField.waitFor();
      passwordField.fill(userPassword);
      loginButton.click();
  }
}
