package com.DemoBlaze.pages;
import com.Factory.PageFactory;
import com.Interactions.Button;
import com.Interactions.Label;
import com.Interactions.Textbox;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import io.qameta.allure.Step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


public class CartPage {
    //Locators
    private static final Logger logger = LoggerFactory.getLogger(CartPage.class);


    Label PlaceOrderLabel = new Label( "#orderModalLabel");
        Button ConfirmationButton = new Button( "xpath=//button[text()='OK']","Confirmation Button");
        private Button PlaceOrderButton = new Button( "xpath=//button[@class='btn btn-success']","Place Order Button");
        private Textbox NameTextbox = new Textbox( "#name","Name TextBox in Payment");
        private Textbox CountryTextbox = new Textbox( "#country","Country TextBox in Payment");
        private Textbox CityTextbox = new Textbox( "#city","City Textbox in Payment");
        private Textbox CreditCardTextbox = new Textbox( "#card","Card number TextBox");
        private Textbox MonthTextbox = new Textbox( "#month" ,"Month Textbox");
        private Textbox YearTextbox = new Textbox( "#year" , "Year TextBox");
        private Button PurchaseButton = new Button( "xpath=//button[text()='Purchase']","Purchase Button");
        private Button CloseButton = new Button( "xpath=//*[@id='orderModal']/div/div/div[3]/button[1]","Close Payment from Button");
        private Locator TotalPrice_Locator = PageFactory.getPage().locator("#totalp");
        private Button TotalPrice = new Button( "#totalp","Total Price");
        private ArrayList <Integer> cartItems = new ArrayList<>();

        public int expectedPrice(){
            getCartItems();
            int sum = 0;
            for (Integer item : cartItems) {
                sum += item;
            }
            logger.info("Expected price Calculated : " + sum);
            return sum;
        }
        public int ActualPrice(){
            PlaywrightAssertions.assertThat(TotalPrice_Locator).isVisible();
            String totalString = TotalPrice.getText();
            logger.info("Actual price Calculated : " + totalString);
            return Integer.parseInt(totalString);
        }
        public int getProductCount() {
            return cartItems.size();
        }

        public void getCartItems() {
            cartItems.clear(); // clear previous content

            Locator rows = PageFactory.getPage().locator("//tr[@class='success']");

            int rowCount = rows.count();
            for (int i = 0; i < rowCount; i++) {
                String priceText = rows.nth(i).locator("xpath=./td[3]").textContent().trim();
                int price = Integer.parseInt(priceText);
                cartItems.add(price);
            }
    }
    @Step("Delete product from cart: {productName}")
    public void deleteProductFromCart(String productName) {
    //wait for the total price to be visible
    PageFactory.getPage().waitForSelector("#totalp");
    Locator rows = PageFactory.getPage().locator("xpath=//tr[@class='success']");
    int rowCount = rows.count();

    for (int i = 0; i < rowCount; i++) {
        Locator row = rows.nth(i);
        String name = row.locator("xpath=./td[2]").textContent().trim();
        if (name.equalsIgnoreCase(productName)) {
            row.locator("xpath=./td[4]/a").click();
            PlaywrightAssertions.assertThat(row).isHidden();
            logger.info("Product deleted from cart successfully");
            break;
        }
    }
    getCartItems();
    }
 
    @Step("Fill order details: {name}, {country}, {city}, {creditCard}, {month}, {year}")
    public void fillOrderDetails(String name, String country, String city, String creditCard, String month, String year) {
        NameTextbox.setText(name);
        CountryTextbox.setText(country);
        CityTextbox.setText(city);
        CreditCardTextbox.setText(creditCard);
        MonthTextbox.setText(month);
        YearTextbox.setText(year);
        logger.info("Order details filled successfully");
    }
    @Step("Click Purchase button")
    public void clickPurchaseButton() {
        PurchaseButton.click();
        logger.info("Purchase button clicked successfully");
    }
    @Step("Click Close button")
    public void clickCloseButton() {
        CloseButton.click();
    }
    @Step("Click Confirmation button")
    public void clickConfirmationButton() {
        ConfirmationButton.click();
    }
    public void ClickPlaceOrderButton() {
        PlaceOrderButton.click();
}
    public void completePurchase(String name, String country, String city, String card, String month, String year) {
        ClickPlaceOrderButton();
        fillOrderDetails(name, country, city, card, month, year);
        clickPurchaseButton();
        clickConfirmationButton();
    }
}
