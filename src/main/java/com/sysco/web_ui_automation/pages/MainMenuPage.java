package com.sysco.web_ui_automation.pages;

import com.sysco.web_ui_automation.Types.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class MainMenuPage extends PageBase {

    private By lnkMyAccount = By.xpath("//*[contains(@class,'link') and text() = 'My account']");
    private By divSubMenu = By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div/a[1]/span");
    private By lnkShoppingCart = By.xpath("//span[@class='showcart-trigger header-sidebar-link -cart']");
    private By btnCheckout = By.xpath("//button[@title='Proceed To Checkout']");
    private By divCartEmpty = By.className("cart-empty");
    private By btnRemove = By.xpath("//a[@class='action delete']");
    private By confirmDeleteMessage = By.xpath("//div[text()='Are you sure you would like to remove this item from the shopping cart?']");
    private By btnOKinConfirmItemDeleteMessage = By.xpath("//span[text()='OK']");


    public void navigateTo(Pages page){

        switch (page){

            case HOME:
                break;

            case MY_ACCOUNT:
                sleep(3000);
                syscoLabUI.click(lnkMyAccount);
                break;
            case SHOPPING_CART:
                syscoLabUI.click(lnkShoppingCart);
                syscoLabUI.waitTillElementLoaded(btnCheckout);
                syscoLabUI.click(btnCheckout);
                break;
            case SHOPPING_MINI_CART:
                syscoLabUI.click(lnkShoppingCart);
                syscoLabUI.waitTillElementLoaded(btnCheckout);
                break;

        }
    }

    public void moveToMenuItem(Pages page){
        switch (page){
            case PRODUCTS:
                JavascriptExecutor executor = (JavascriptExecutor)syscoLabUI.driver;
                executor.executeScript("arguments[0].click();", syscoLabUI.driver.findElement(By.xpath("//*[@id='mi-1-4']")));
                syscoLabUI.waitTillElementLoaded(divSubMenu);
                break;
        }

    }

    public void selectLinkInSubMenu(Pages page){

        switch (page){

            case ADIDAS:
                JavascriptExecutor executor = (JavascriptExecutor)syscoLabUI.driver;
                executor.executeScript("arguments[0].click();", syscoLabUI.driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div/a[1]/span")));
        }
    }

    public boolean getCartIsEmpty(){
        return !findElements(divCartEmpty,5L).isEmpty();
    }

    public void removeAllItemsFromCart(){

        if(!getCartIsEmpty()){
//            syscoLabUI.click(btnCheckout);
//            ShoppingCart.verifyShoppingCartLoaded();
            syscoLabUI.click(btnRemove);
            syscoLabUI.waitTillElementLoaded(confirmDeleteMessage);

            JavascriptExecutor executor = (JavascriptExecutor)syscoLabUI.driver;
            executor.executeScript("arguments[0].click();", syscoLabUI.driver.findElement(By.xpath("//span[text()='OK']")));
            sleep(2);
        }
    }
}
