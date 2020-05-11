package com.sysco.web_ui_automation.pages;

import com.sysco.web_ui_automation.Types.PaymentMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class CheckoutPage extends PageBase {

    private By txtFirstName = By.xpath("//div[@id='shipping-new-address-form']/div/label/span[text()='First Name']/../following-sibling::div/input");
    private By txtLastName = By.xpath("//div[@id='shipping-new-address-form']/div/label/span[text()='Last Name']/../following-sibling::div/input");
    private By btnContinue = By.xpath("//button[@title='Continue']");
    private By btnContinueToPayment = By.id("shipping-method-button");
    private By btnPostCodeRemove = By.id("billing:postcodesuburbremove");
    private By divPostCodeAutoComplete =  By.xpath("//*[@class='input-text ui-autocomplete-input']");
    private By txtPostCode = By.xpath("//div[@id='shipping-new-address-form']/div/label/span[text()='Post Code']/../following-sibling::div/input");
    private By txtAddress1 = By.xpath("//div[@id='shipping-new-address-form']/fieldset//span[text()='Street Address Line 1']/../following-sibling::div/input");
    private By txtSuburb =By.xpath("//div[@id='shipping-new-address-form']/div/label/span[text()='Suburb']/../following-sibling::div/input");
    private By txtState = By.xpath("//div[@id='shipping-new-address-form']/div/label/span[text()='State/Province']/../following-sibling::div/input");
    private By txtContact = By.xpath("//div[@id='shipping-new-address-form']/div//label/span[text()='Phone Number']/../following-sibling::div/input");
    private By checkAuthorize = By.id("ns-checkout-shipping-authorize_mm");
    private By rbCreditCard = By.xpath("//strong[@class='card-title']");
    private By rbPaypal = By.xpath("//span[@class='paypal-text']");
    private By txtCreditCardNo = By.xpath("//*[@id='credit-card-number']");
    private By txtCVV = By.xpath("//*[@id=\"braintree_cc_type_cvv_div\"]/label/span/span");
    private By btnPurchase = By.xpath("//div[@class='opc-submit-step']");
    private By divCreditCardNoError = By.xpath("//*[@id=\"payment_form_braintree\"]/div[2]/div/div[2]/span");
    private By divCVVError = By.xpath("//*[@id='braintree_cc_cid']/following-sibling::div[@class='validation-advice']");

    public String getFirstNameTxtValue(){
        return syscoLabUI.getValue(txtFirstName);
    }

    public String getLastNameTxtValue(){
        return syscoLabUI.getValue(txtLastName);
    }

    public void waitUntillPageLoaded(){
        syscoLabUI.waitTillElementLoaded(txtFirstName);
    }

    public void clearFirstName(){
        syscoLabUI.clear(txtFirstName);
    }

    public void clearLastName(){
        syscoLabUI.clear(txtLastName);
    }

    public void fillFirstName(String firstName){
        syscoLabUI.sendKeys(txtFirstName,firstName);
    }

    public void fillLastName(String lastName){
        syscoLabUI.sendKeys(txtLastName, lastName);
    }

    public void clickContinueButton(){
        syscoLabUI.click(btnContinue);
    }
    public void clickContinueToPaymentButton(){
        syscoLabUI.click(btnContinueToPayment);
    }

    public boolean isFirstNameTxtDisplayed(){
        return isDisplayed(txtFirstName,10L);
    }

    public void clickPostCodeRemoveButton(){
        syscoLabUI.click(btnPostCodeRemove);
    }

    public void selectPostCodeAutoCompleteSuggestion(int index){

        syscoLabUI.waitTillElementLoaded(divPostCodeAutoComplete);
        syscoLabUI.click(webDriver.findElement(divPostCodeAutoComplete).findElement(By.xpath("//a[text()=' BARANGAROO New South Wales']")));
        sleep(3);
    }

    public void typeInPostCodeTxt(String postCode){
        syscoLabUI.sendKeys(txtPostCode,postCode);
    }

    public void typeInAddress1(String address){
        syscoLabUI.sendKeys(txtAddress1,address);
    }
    public void typeInSuburb(String suburb){
        syscoLabUI.sendKeys(txtSuburb,suburb);
    }
    public void typeInState(String state){
        syscoLabUI.sendKeys(txtState,state);
    }

    public void typeInContactNumber(String contactNo){
        syscoLabUI.sendKeys(txtContact,contactNo);
    }

    public void selectAuthorizeCheckBox(boolean checkStatus){

        syscoLabUI.waitTillElementLoaded(btnContinueToPayment);
        boolean currentStatus=false;
        if(syscoLabUI.getValue(checkAuthorize).equals("1"))
            currentStatus = true;
        else
            checkStatus = false;

        if(currentStatus != checkStatus)
            syscoLabUI.click(checkAuthorize);
    }

    public void selectPaymentMethod(PaymentMethods paymentMethods){

        sleep(3);
        syscoLabUI.waitTillElementLoaded(rbCreditCard);
        if (paymentMethods.equals(PaymentMethods.CREDIT_CARD)){
            syscoLabUI.click(rbCreditCard);
        } else {
            syscoLabUI.click(rbPaypal);
        }
    }

    public void fillCreditCardNumber(String cardNo){
        syscoLabUI.sendKeys(txtCreditCardNo,cardNo);
    }

    public void fillCreditCardCVV(String cvv){
        syscoLabUI.sendKeys(txtCVV,cvv);
    }

    public String getCreditCardNumberError(){
        return syscoLabUI.getText(divCreditCardNoError);
    }

    public String getCreditCardCVVError(){
        return syscoLabUI.getText(divCVVError);
    }

    public void clickPurchaseOrderButton(){
        syscoLabUI.click(btnPurchase);
        sleep(3);
    }
}
