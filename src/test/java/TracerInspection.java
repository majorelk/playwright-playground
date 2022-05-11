import com.microsoft.playwright.*;
import java.nio.file.Paths;


    public class TracerInspection {
        public static void main(String[] args) {
            try (Playwright playwright = Playwright.create()) {
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                        .setHeadless(false));
                BrowserContext context = browser.newContext();

                // Start tracing before creating / navigating a page.
                context.tracing().start(new Tracing.StartOptions()
                        .setScreenshots(true)
                        .setSnapshots(true));

                // Open new page
                Page page = context.newPage();

                // Go to https://www.amazon.com/
                page.navigate("https://www.amazon.com/");
                // Click #nav-signin-tooltip >> text=Sign in
                page.click("#nav-signin-tooltip >> text=Sign in");
                // assert page.url().equals("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
                // Click input[name="email"]
                page.click("input[name=\"email\"]");
                // Fill input[name="email"]
                page.fill("input[name=\"email\"]", "naveen@gmail.com");
                // Click input[type="submit"]
                page.click("input[type=\"submit\"]");
                // assert page.url().equals("https://www.amazon.com/ap/signin");
                // Click input[name="password"]
                page.click("input[name=\"password\"]");
                // Fill input[name="password"]
                page.fill("input[name=\"password\"]", "123456");
                // Click input[type="submit"]
                // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://www.amazon.com/ap/signin"), () ->
                page.waitForNavigation(() -> {
                    page.click("input[type=\"submit\"]");
                });
                // Click [aria-label="Amazon"]
                page.click("[aria-label=\"Amazon\"]");
                // assert page.url().equals("https://www.amazon.com/ref=ap_frn_logo");

                // Stop tracing and export it into a zip archive.
                context.tracing().stop(new Tracing.StopOptions()
                        .setPath(Paths.get("trace.zip")));
            }
        }
    }

