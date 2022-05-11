import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import java.util.*;

public class Example {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();

            // Open new page
            Page page = context.newPage();

            // Go to https://www.google.co.uk/
            page.navigate("https://www.google.co.uk/");

            // Click button:has-text("I agree")
            // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://www.google.co.uk/"), () ->
            page.waitForNavigation(() -> {
                page.click("button:has-text(\"I agree\")");
            });


            // Click [aria-label="Search"]
            page.click("[aria-label=\"Search\"]");

            // Fill [aria-label="Search"]
            page.fill("[aria-label=\"Search\"]", "apple watch");

            // Press ArrowDown
            page.press("[aria-label=\"Search\"]", "ArrowDown");

            // Press ArrowDown
            page.press("[aria-label=\"Search\"]", "ArrowDown");

            // Press Enter
            // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://www.google.co.uk/search?q=apple+watch+series+7&source=hp&ei=hZxyYu_5No69gQaPgquYBg&iflsig=AJiK0e8AAAAAYnKqlc29s90hBEnTIaiQwv0Vm1T18We6&oq=apple+watch&gs_lcp=Cgdnd3Mtd2l6EAMYATIICAAQgAQQsQMyCAgAEIAEELEDMggIABCABBCxAzIICAAQgAQQsQMyBQgAEIAEMggIABCABBCxAzIFCAAQgAQyCAgAEIAEELEDMggIABCABBCxAzILCAAQgAQQsQMQgwE6DgguEI8BEOoCEIwDEOUCOg4IABCPARDqAhCMAxDlAjoOCC4QgAQQsQMQxwEQowI6CwguEIAEELEDEIMBOhEILhCABBCxAxDHARDRAxDUAjoRCC4QgAQQsQMQgwEQxwEQ0QM6CAguELEDEIMBOggILhCABBDUAjoOCC4QgAQQsQMQxwEQ0QM6CwguEIAEEMcBEK8BUJofWL97YJePAWgKcAB4AIABWIgB4gmSAQIyMJgBAKABAbABCrgBAw&sclient=gws-wiz"), () ->
            page.waitForNavigation(() -> {
                page.press("[aria-label=\"Search\"]", "Enter");
            });
            // assert page.url().equals("https://www.google.co.uk/search?q=apple+watch+series+7&source=hp&ei=hZxyYu_5No69gQaPgquYBg&iflsig=AJiK0e8AAAAAYnKqlc29s90hBEnTIaiQwv0Vm1T18We6&oq=apple+watch&gs_lcp=Cgdnd3Mtd2l6EAMYATIICAAQgAQQsQMyCAgAEIAEELEDMggIABCABBCxAzIICAAQgAQQsQMyBQgAEIAEMggIABCABBCxAzIFCAAQgAQyCAgAEIAEELEDMggIABCABBCxAzILCAAQgAQQsQMQgwE6DgguEI8BEOoCEIwDEOUCOg4IABCPARDqAhCMAxDlAjoOCC4QgAQQsQMQxwEQowI6CwguEIAEELEDEIMBOhEILhCABBCxAxDHARDRAxDUAjoRCC4QgAQQsQMQgwEQxwEQ0QM6CAguELEDEIMBOggILhCABBDUAjoOCC4QgAQQsQMQxwEQ0QM6CwguEIAEEMcBEK8BUJofWL97YJePAWgKcAB4AIABWIgB4gmSAQIyMJgBAKABAbABCrgBAw&sclient=gws-wiz");

            // Click text=Buy Apple Watch Series 7
            page.click("text=Buy Apple Watch Series 7");
            // assert page.url().equals("https://www.apple.com/uk/shop/buy-watch/apple-watch");

            // Click button:has-text("Case Finish")
            page.click("button:has-text(\"Case Finish\")");

            // Click img[alt="Front view Starlight Aluminium Case with Sport Loop"]
            page.click("img[alt=\"Front view Starlight Aluminium Case with Sport Loop\"]");
            // assert page.url().equals("https://www.apple.com/uk/shop/buy-watch/apple-watch?option.watch_cases=MKNP3B/A&option.watch_bands=MN5V3ZM/A&preSelect=false&product=Z0YQ&step=detail#");

            // Click #ac-gn-firstfocus
            page.click("#ac-gn-firstfocus");
            // assert page.url().equals("https://www.apple.com/uk/");
        }
    }
}