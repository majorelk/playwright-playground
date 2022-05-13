import java.lang.reflect.Method;

public class authorization {

  public void loginToApplication(String username, String password) {
    page.fill("input[name='email']", username);
    page.fill("input[name='email']", password);
    page.click("input[type='submit']");
  }

  public void getAndSetLoginAuth(String username, String password) {
    // TODO - Add api call, get details, set window cookies/ storage //
  }
}
