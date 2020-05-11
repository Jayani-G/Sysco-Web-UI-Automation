package com.sysco.web_ui_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


public class ShoppingCartPage extends PageBase {

    private By btnCheckout = By.xpath("//button[@title='Proceed To Checkout']");
    String productNameXpath = "//*[@id=\"checkout\"]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/strong";
    String productPriceXpath = "//*[@id=\"checkout\"]/div[2]/div[1]/div[2]/table/tbody/tr[1]/td/span";

    public String getItemName(int itemIndex) {

        productNameXpath = productNameXpath.replace("ITEM_INDEX", String.valueOf(itemIndex));
        JavascriptExecutor executor = (JavascriptExecutor) syscoLabUI.driver;
        executor.executeScript("arguments[0].click();", syscoLabUI.driver.findElement(By.xpath("//*[@id=\"checkout\"]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/strong")));
        return syscoLabUI.getText(By.xpath("//*[@id=\"checkout\"]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/strong"));
    }



    public String getItemPrice(int itemIndex){
        productPriceXpath = productPriceXpath.replace("ITEM_INDEX", String.valueOf(itemIndex));
        return syscoLabUI.getText(By.xpath(productPriceXpath));
    }

    public boolean isCheckoutButtonDisplayed(){
        return isDisplayed(btnCheckout,10L);
    }

    public void clickProceedToCheckoutBtn(){
        syscoLabUI.click(btnCheckout);
    }

}
