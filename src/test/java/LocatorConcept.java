import com.microsoft.playwright.*;

import java.util.List;

public class LocatorConcept {

    public static void main(String[] args) {


        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));


//        locators
//        We can perform click(), hover() etc. actions based on the exact text of the element which is present on the UI

        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://www.orangehrm.com/");
//        single element - when there is only one element on the web page, the click operation will be performed.
//        when there is more than one element with the same name there will be Playwright Exception.
        Locator contactSales = page.locator("text=CONTACT SALES");
        contactSales.hover();
        contactSales.click();


//        here we are specifying which element exactly we want to click.
//        We need to specify which element we want to click.. first(), last() etc..
//        there are 3 Login buttons on the webpage, and it is giving exception unless we specify
        Page page1 = browserContext.newPage();
        page1.navigate("https://academy.naveenautomationlabs.com/");
        Locator loginButton = page1.locator("text=Login");

//        getting the total number of the elements as an int
        int numOfLogins = loginButton.count();
        System.out.println("Total number of login text :"+numOfLogins);
//        clicking on the first one
        loginButton.first().click();


//        multiple elements:
        Page page3 = browserContext.newPage();
        page3.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/?");
        Locator countryOptions = page3.locator("select#Form_submitForm_Country option");
        System.out.println("Number of countries: "+countryOptions.count());

//        PRINT ALL THE COUNTRIES IN THE DROPDOWN

//        First way:
//        for (int i=0; i<=countryOptions.count(); i++){
//            String allCountries = countryOptions.nth(i).textContent();
//            System.out.println(allCountries);
//        }


//        Second way: using List<String> and for each loop
         List<String> textOfCountries = countryOptions.allTextContents();
//         for(String w:textOfCountries){
//             System.out.println(w);
//         }

//        Third way: using lambda
        textOfCountries.forEach(e -> System.out.println(e));


















    }

}