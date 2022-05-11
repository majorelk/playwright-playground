import com.microsoft.playwright.*;
import org.junit.Assert;

public class BrowserContextConcept {

    public static void main(String[] args) {


        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context1 = browser.newContext();
        Page p1 = context1.newPage();
        p1.navigate("http://www.google.com");
        p1.click("(//*[.='I agree'])[1]");
        p1.fill("//input[@name='q']","playwright automation");
        System.out.println(p1.title());


        BrowserContext context2 = browser.newContext();
        Page p2 = context2.newPage();
        p2.navigate("http://automationpractice.com/index.php");
        p2.fill("#search_query_top","Dress");
        System.out.println(p2.title());

        p1.close();
        context1.close();

        p2.close();
        context2.close();



    }
}
