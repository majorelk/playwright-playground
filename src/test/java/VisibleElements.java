import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class VisibleElements {
    public static void main(String[] args) {

//       2 ways for creating visibility filter:
//        tag:visible
//        tag >> visible=true

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://www.amazon.co.uk/");
        List <String> allLinks = page.locator("a:visible").allInnerTexts();
        for(String w: allLinks){
            System.out.println(w);
        }

        int imgCount = page.locator("xpath=//img>>visible=true").count();
        System.out.println(imgCount);
    }


}
