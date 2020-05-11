package com.sysco.web_ui_automation.pages;

import org.openqa.selenium.By;

public class ProductDetailsPage extends PageBase {

    private By btnAddToCart = By.xpath("//*[@id=\"product-addtocart-button\"]");
    private By btnAddSize = By.xpath("//*[@id=\"swatch-row-228\"]/div[11]");


    public void waitUntillPageLoaded(){
        syscoLabUI.waitTillElementLoaded(btnAddToCart);
    }

    public void addItemToCart(){
        syscoLabUI.click(btnAddSize);
        syscoLabUI.click(btnAddToCart);
    }
}
