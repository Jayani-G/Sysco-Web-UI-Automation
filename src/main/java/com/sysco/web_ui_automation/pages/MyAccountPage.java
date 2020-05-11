package com.sysco.web_ui_automation.pages;

import org.openqa.selenium.By;

public class MyAccountPage extends PageBase {

    private By btnLogin = By.xpath("//*[contains(@class,'link') and text() = 'Login']");
    private By txtEmail = By.id("email");
    private By txtPassword = By.id("pass");
    private By divEmailError = By.xpath("//*[@id='email']/following-sibling::div[@class='mage-error']");
    private By divPasswordError = By.xpath("//*[@id='pass']/following-sibling::div[@class='mage-error']");
    private By btnLogin2 = By.id("send2");
    private By divPasswordErrorInBanner = By.xpath ("//*[@id=\"maincontent\"]/div[2]/div[2]/div[1]/div");
    private By txtAddress = By.xpath("//div[@id='shipping-new-address-form']/fieldset//span[text()='Street Address Line 1']/../following-sibling::div/input");
    private By btnContinue = By.xpath("//button[@title='Continue']");
    private By divAddressError =By.xpath("//div[@id='shipping-new-address-form']/fieldset//span[text()='Street Address Line 1']/../following-sibling::div/div/span");
    private By txtSuburb =By.xpath("//div[@id='shipping-new-address-form']/div/label/span[text()='Suburb']/../following-sibling::div/input");
    private By divSuburbError =By.xpath("//div[@id='shipping-new-address-form']/div/label/span[text()='Suburb']/../following-sibling::div/div/span");
    private By txtState = By.xpath("//div[@id='shipping-new-address-form']/div/label/span[text()='State/Province']/../following-sibling::div/input");
    private By divStateError =By.xpath("//div[@id='shipping-new-address-form']/div/label/span[text()='State/Province']/../following-sibling::div/div/span");
    private By txtPostCode = By.xpath("//div[@id='shipping-new-address-form']/div/label/span[text()='Post Code']/../following-sibling::div/input");
    private By divPostCodeError =By.xpath("//div[@id='shipping-new-address-form']/div/label/span[text()='Post Code']/../following-sibling::div/div/span");
    private By txtPhoneNo = By.xpath("//div[@id='shipping-new-address-form']/div//label/span[text()='Phone Number']/../following-sibling::div/input");
    private By divPhoneNoError =By.xpath("//div[@id='shipping-new-address-form']/div//label/span[text()='Phone Number']/../following-sibling::div/div[@class='field-error mage-error']/span");

    public boolean isLoginButtonVisible(){
        return isDisplayed(btnLogin,10L);
    }

    public void enterEmailAddress(String emailAddress){
        syscoLabUI.sendKeys(txtEmail,emailAddress);
    }
    public void enterAddress(String address1){
        syscoLabUI.sendKeys(txtAddress,address1);
    }
    public void enterSuburb(String suburb){
        syscoLabUI.sendKeys(txtSuburb,suburb);
    }
    public void enterState(String state){
        syscoLabUI.sendKeys(txtState,state);
    }
    public void enterPostCode(String postCode){
        syscoLabUI.sendKeys(txtPostCode,postCode);
    }
    public void enterPhoneNo(String phoneNo){
        syscoLabUI.sendKeys(txtPhoneNo,phoneNo);
    }
    public void enterPassword(String password){
        syscoLabUI.sendKeys(txtPassword,password);
    }
    public void clickLoginButton(){
        syscoLabUI.click(btnLogin);
    }

    public void clickLoginButton2(){
        syscoLabUI.click(btnLogin2);
    }
    public String getEmailErrorMessage(){
        return syscoLabUI.getText(divEmailError);
    }
    public void clickContinueButton(){
        syscoLabUI.click(btnContinue);
    }
    public String getAddressErrorMessage(){
        return syscoLabUI.getText(divAddressError);
    }
    public String getSuburbErrorMessage(){
        return syscoLabUI.getText(divSuburbError);
    }
    public String getPostCodeErrorMessage(){
        return syscoLabUI.getText(divPostCodeError);
    }
    public String getPhoneNoErrorMessage(){
        return syscoLabUI.getText(divPhoneNoError);
    }
    public String getStateErrorMessage(){
        return syscoLabUI.getText(divStateError);
    }
    public String getEmailErrorMessage2(){
        return syscoLabUI.getText(divEmailError);
    }
    public String getPaswordErrorMessage(){
        return syscoLabUI.getText(divPasswordError);
    }

    public String getPaswordErrorMessageInBanner(){
        return syscoLabUI.getText(divPasswordErrorInBanner);
    }

    public String getPaswordErrorMessageInBanner2(){
        return syscoLabUI.getText(divPasswordErrorInBanner);
    }
}
