package com.DemoBlaze.pages;

import com.Interactions.Button;
import com.Interactions.Label;
import io.qameta.allure.Step;
import org.testng.Assert;



public class ProductPage {

    private Button AddToCartButton = new Button("xpath=//a[text()='Add to cart']","Add to cart button");
    private Label Description = new Label("xpath=//strong");
    private Label image = new Label("xpath=//*[@id=\"imgp\"]/div/img");
    @Step("Click on Add to cart button")
    public void clickAddToCart() {
        Assert.assertEquals(Description.getText(),"Product description");
        AddToCartButton.click();
    }

}

