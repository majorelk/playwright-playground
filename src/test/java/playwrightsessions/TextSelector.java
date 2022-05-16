package playwrightsessions;

import com.microsoft.playwright.*;

public class TextSelector {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

//        text locators

        Page page=browser.newPage();
        page.navigate("https://www.amazon.co.uk/");
//        Locator primeText = page.locator("text=Prime");// page.locator() can be used to find specific element or num of elements

//        for (int i=0; i<primeText.count(); i++){
//            String text = primeText.nth(i).textContent();
//            if(text.equals("Seller Fulfilled Prime")){
//                primeText.nth(i).click();
//                page.locator("text=Accept all cookies").click();
//                page.locator("text=Sell").first().hover();
//                page.locator("text=Selling overview").click();
//                break;
//
//            }

//        second way using "''" => this is same as "text=Hello"
//        String helloText = page.locator("'Hello'").first().textContent();
//        System.out.println(helloText);
//        page.locator("'Hello'").click();


//        button
        page.locator("'Hello, Sign in'").hover();
        page.locator("(//span[@class='nav-action-inner'])[1]").click();













        }

    }

