package com.sysco.web_ui_automation.pages;

import org.openqa.selenium.By;

public class ProductsPage extends PageBase {

    String productXpath =  "//*[@id=\"ewave-layerednavigation-product-list\"]/div[2]/ul/li[1]/div/div[3]/strong/a";
    By lbtItemCount = By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span");


    public void selectProductByName(String name){
        productXpath = productXpath.replaceAll("product_name", name);
        syscoLabUI.isDisplayed(By.xpath(productXpath));
        syscoLabUI.click(By.xpath(productXpath));
    }

    public boolean isItemsPerPageDisplayed(){
        return syscoLabUI.isDisplayed(lbtItemCount);
    }
}
