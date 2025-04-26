package com.Interactions;

public class Label extends  Element{

    public Label(String Locator) {
        super(Locator);
    }

    public String getText() {
        return page.locator(Locator).textContent();
    }
}
