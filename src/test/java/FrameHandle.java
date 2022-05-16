import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.Assert;

public class FrameHandle {
    public static void main(String[] args) {


        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
//        page.navigate("http://londonfreelance.org/courses/frames/index.html");
////        going into frame using frameLocator
//        String header = page.frameLocator("frame[name='main']").locator("h2").textContent();
//        System.out.println(header);
//
////        using frame name
//        String header2 = page.frame("main").locator("h2").textContent();
//        System.out.println(header2);


        page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");

//      In this case we need to click on the iframe first. It appears as an image when the page is loaded.
        page.locator("//img[@title='vehicle-registration-forms-and-templates']").click();

//      to perform an action in the iframe we need to go in it every time
        page.frameLocator("//iframe[contains(@id,'frame-one')]").locator("//input[@name='RESULT_TextField-2']").fill("2002");
        page.frameLocator("//iframe[contains(@id,'frame-one')]").locator("id=RESULT_TextField-3").fill("Mazda");
        page.frameLocator("//iframe[contains(@id,'frame-one')]").locator("//input[@id='RESULT_TextField-4']").fill("6");
        page.frameLocator("//iframe[contains(@id,'frame-one')]").locator("#FSsubmit").click();

    }

}
