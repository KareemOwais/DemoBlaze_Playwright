package com.Interactions;



public class Textbox extends Element {
    // Constructor
    public Textbox(String Locator , String Description) {
        super(Locator);
        this.Description = Description;
    }
    public Textbox(String Locator) {
        super(Locator);
    }

    public void setText(String text) {
        try {
            
            page.locator(Locator).fill(text);
            logger.info("Set text {} {} {}" , text , "' in element: " , Description);
        } catch (Exception e) {
            logger.error("Unexpected error while setting text in textbox: {}" ,Description, e);
        }
    }

}