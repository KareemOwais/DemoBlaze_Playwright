package com.Factory;

import com.microsoft.playwright.Browser;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PageFactory {
    
    private static Page page = null;
    public static Page getPage() {
        if (page == null) {
            Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            page = browser.newPage();
        }
        return page;
    }

    //public static void closeDriver() {
      //  if (driver != null) {
            //driver.quit();
        //    driver = null;
        //}
    //}
}
