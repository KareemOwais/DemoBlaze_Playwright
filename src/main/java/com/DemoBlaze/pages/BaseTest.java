package com.DemoBlaze.pages;

import com.Factory.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected HomePage homePage;
    protected ProductPage productPage;
    protected CartPage cartPage;
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    @BeforeMethod
    public void setUp() {
        PageFactory.getPage().navigate("https://demoblaze.com/");
        PageFactory.getPage().setViewportSize(1920, 1080); // Set the viewport size to 1920x1080
        homePage = new HomePage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        logger.info("-----------------  Test STARTED ------------");
    }

    @AfterMethod
    public void tearDown() {
        logger.info("-----------------  Test ENDED ------------");
        PageFactory.closeDriver();
    }

}
