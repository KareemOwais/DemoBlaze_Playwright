package com.DemoBlaze.pages;

import com.Interactions.Button;
import com.Interactions.Label;
import com.Interactions.Textbox;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;


public class HomePage {
    //Locators
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    private final Button LogoutButton = new Button("#logout2", "Logout Button");
    private Button SignUpBUtton = new Button("#signin2","SignUp Button");
    private Button LoginButton= new Button("#login2","Login Button");
    private Button HomeButton= new Button("xpath=//a[text()='Home ']","Home Button");
    private Button CartButton= new Button("#cartur","Cart Button");
    //private Label CheckLabel = new Label("xpath=(//img[@class='card-img-top img-fluid'])[1]");
    private Label WelcomeText = new Label("#nameofuser");
    private Textbox usernameTextbox = new Textbox("#loginusername","Username Textbox");
    private Textbox passwordTextbox = new Textbox("#loginpassword","Password Textbox");
    private Button loginButtonForm = new Button("xpath=//button[text()='Log in']","Login Button Form");
    private Button PhonesCategory = new Button("xpath=//a[text()='Phones']","Phones Category");
    private Button LaptopsCategory = new Button("xpath=//a[text()='Laptops']","Laptops Category");
    private Button MonitorsCategory = new Button("xpath=//a[text()='Monitors']","Monitors Category");
    private Button CategoryButton = new Button("xpath=//a[text()='CATEGORIES']","All Categories Buttons");

    @Step("Navigate to: {button}")
    public void NavigateTO(String button){
        switch (button.toLowerCase()) {
            case "signup":
                SignUpBUtton.click();
                break;
            case "login":
                LoginButton.click();
                break;
            case "cart":
                CartButton.click();
                break;
            case "home":
                HomeButton.click();
                break;
            case "logout":
                LogoutButton.click();
                break;
            default:
                logger.error("Invalid button clicked");
        }
    }
    @Step("Login with username: {username} and password: {password}")
    public void Login(String username, String password) {
        LoginButton.click();
        usernameTextbox.setText(username);
        passwordTextbox.setText(password);
        loginButtonForm.click();
        //Assert.assertEquals("Welcome " + username, WelcomeText.getText());
        logger.info("User logged in successfully");
    }
    @Step("Choose category: {category}")
    public HomePage ChooseCategory(String category) {
        CategoryButton.click();
        switch (category.toLowerCase()) {
            case "phones":
                PhonesCategory.click();
                break;
            case "laptops":
                LaptopsCategory.click();
                break;
            case "monitors":
                MonitorsCategory.click();
                break;
            default:
                logger.error("Invalid category clicked");
        }
        return this;
    }
    @Step("Choose product: {product}")
    public void ChooseProduct(String product) {
            String xpath = "xpath=//a[text()='" + product + "']";
            Button productButton = new Button(xpath,"Product Button");
            productButton.click();

    }
    

}
