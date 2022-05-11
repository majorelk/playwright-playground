package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.Test;

public class PlaywrightBasics {


    public static void main(String[] args) {
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.amazon.com");

        String title = page.title();
        System.out.println("page title is : "+ title);
        String url = page.url();
        System.out.println("url = " + url);


        page.click("(//*[.='Hello, Sign in'])[2]");
    }


}


