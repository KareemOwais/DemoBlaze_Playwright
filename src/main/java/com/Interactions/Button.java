package com.Interactions;


public class Button extends Label {
    // Constructor

    public Button(String Locator , String Description) {
        super(Locator);
        this.Description=Description;
    }
    public Button(String Locator ) {
        super(Locator);
    }

    public void click() {
        page.locator(Locator).click();
        logger.info("Clicked on button: {}", Description);
    }



}