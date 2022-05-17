import com.microsoft.playwright.*;

public class AmazonLoginTest {
  static final String USER_NAME = "naveen@gmail.com";
  static final String USER_PASS = "123456";
  static final String LOGGED_IN_NAV_TEXT = "Account & Lists";
  Page page = browser.newPage();
  LoginPage loginPage = new LoginPage(page);


  @Test
  void shouldLoginToApplication() {
    page.navigate("https://amazon.co.uk");
    page.click("div[class='nav-action-inner']");
    loginPage.loginToAppWith(USER_NAME, USER_PASS);
    assertThat(page.locator(".nav-line-2").hasText(LOGGED_IN_NAV_TEXT));
  }

}
