package com.sysco.web_ui_automation.pages;

import org.openqa.selenium.By;

public class AccountManagementPage extends PageBase{

    private By txtWelcomeMessage = By.xpath("//*[contains(@class ,'name') ]//span[1]");

    public String getLoggedInUserName(){

        return webDriver.findElement(txtWelcomeMessage).getText();
    }


    public boolean isUserWelcomeMsgDisplayed(){
        return isDisplayed(txtWelcomeMessage,10L);
    }

}