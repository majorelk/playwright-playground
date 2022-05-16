import com.microsoft.playwright.*;

public class ShadowDomElement {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://books-pwakit.appspot.com/");
        page.locator("//book-app[@apptitle='BOOKS']").locator("id=input").fill("testing books");

//         The purpose here is to select an element inside Shadow DOM, but the following works as well (at least for this website).

         //page.locator("id=input").fill("testing books");
         page.keyboard().press("Enter");

    }
}
