package com.Interactions;
import com.Factory.PageFactory;
import com.microsoft.playwright.Page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class Element {
    protected String Locator ;
    protected static final Logger logger = LoggerFactory.getLogger(Element.class);
    String Description ;
    protected Page page;
    // Constructor
    protected Element(String Locator) {
        this.Locator = Locator;
        this.page = PageFactory.getPage();
    }

}