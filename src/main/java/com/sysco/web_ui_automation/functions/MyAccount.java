package com.sysco.web_ui_automation.functions;

import com.sysco.web_ui_automation.data.UserData;
import com.sysco.web_ui_automation.pages.MyAccountPage;

public class MyAccount {

    private static MyAccountPage myAccountPage = new MyAccountPage();

    public static boolean verifyPageLoaded(){
        return myAccountPage.isLoginButtonVisible();
    }

    public static String loginWithPasswordError(UserData userData){
        myAccountPage.enterEmailAddress(userData.getEmail());
        myAccountPage.enterPassword(userData.getPassword());
        myAccountPage.clickLoginButton2();
        return myAccountPage.getPaswordErrorMessage();
    }

    public static String loginWithPasswordErrorBanner(UserData userData){
        myAccountPage.enterEmailAddress(userData.getEmail());
        myAccountPage.enterPassword(userData.getPassword());
        myAccountPage.clickLoginButton2();
        return myAccountPage.getPaswordErrorMessageInBanner();
    }
    public static String loginWithPasswordErrorBanner2(UserData userData){
        myAccountPage.enterEmailAddress(userData.getEmail());
        myAccountPage.enterPassword(userData.getPassword());
        myAccountPage.clickLoginButton2();
        return myAccountPage.getPaswordErrorMessageInBanner2();
    }

    public static String loginWithEmailError(UserData userData){
        myAccountPage.clickLoginButton();
        myAccountPage.enterEmailAddress(userData.getEmail());
        myAccountPage.enterPassword(userData.getPassword());
        myAccountPage.clickLoginButton2();
        return myAccountPage.getEmailErrorMessage();
    }

    public static String continueWithEmptyAddress(UserData userData){
        myAccountPage.enterAddress(userData.getAddress1());
        Checkout.continueCheckout();
        return myAccountPage.getAddressErrorMessage();
    }
    public static String continueWithEmptySuburb(UserData userData){
        myAccountPage.enterSuburb(userData.getSuburb());
        Checkout.continueCheckout();
        return myAccountPage.getSuburbErrorMessage();
    }
    public static String continueWithEmptyPostCode(UserData userData){
        myAccountPage.enterPostCode(userData.getPostCode());
        Checkout.continueCheckout();
        return myAccountPage.getPostCodeErrorMessage();
    }
    public static String continueWithEmptyPhoneNo(UserData userData){
        myAccountPage.enterPhoneNo(userData.getContactNo());
        Checkout.continueCheckout();
        return myAccountPage.getPhoneNoErrorMessage();
    }
    public static String continueWithEmptyState(UserData userData){
        myAccountPage.enterState(userData.getState());
        Checkout.continueCheckout();
        return myAccountPage.getStateErrorMessage();
    }


    public static String loginWithEmailError2(UserData userData){
        myAccountPage.clickLoginButton();
        myAccountPage.enterEmailAddress(userData.getEmail());
        myAccountPage.enterPassword(userData.getPassword());
        myAccountPage.clickLoginButton2();
        return myAccountPage.getEmailErrorMessage2();
    }

    public static void Login(UserData userData){
        myAccountPage.clickLoginButton();
        myAccountPage.enterEmailAddress(userData.getEmail());
        myAccountPage.enterPassword(userData.getPassword());
        myAccountPage.clickLoginButton2();
    }
}
