package web_ui_automation.tests;

import com.sysco.web_ui_automation.Types.CreditCardTypes;
import com.sysco.web_ui_automation.Types.Pages;
import com.sysco.web_ui_automation.Types.PaymentMethods;
import com.sysco.web_ui_automation.Types.UserTypes;
import com.sysco.web_ui_automation.data.*;
import com.sysco.web_ui_automation.functions.*;
import web_ui_automation.utils.TestBase;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static com.sysco.web_ui_automation.data.VerficationMessages.MANDATORY_FIELD_MESSAGE;

@Listeners(SyscoLabListener.class)
public class ProductCartVerificationTest extends TestBase {

    static CheckOutData checkOutData = new CheckOutData();
    private SoftAssert softAssert;
    UserData registeredUser;
    @BeforeClass
    public void initClass(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Account Verification - Account Verification");

        registeredUser = new UserData(UserTypes.REGISTERED_USER);
        MyAccount.Login(registeredUser);
        AccountManagement.verifyPageLoaded();
        MainMenu.navigateTo(Pages.SHOPPING_MINI_CART);
        MainMenu.removeAllItemsFromCart();

    }

    @Test(description = "Verify cart displays added items correctly")
    public void testProductsInCart(){

        softAssert = new SoftAssert();
        MainMenu.expandMenuItem(Pages.PRODUCTS);
        MainMenu.selectSubMenu(Pages.ADIDAS);
        Products.verifyProductPageLoaded();
        Products.addExclusiveProductByProductName(ProductData.PRODUCT_XPATH_NAME);
        Products.addItemToCart();

        MainMenu.navigateTo(Pages.SHOPPING_CART);
        ShoppingCart.verifyShoppingCartLoaded();
        softAssert.assertEquals(ShoppingCart.getShoppingCartItemName(1).toUpperCase(),(ProductData.PRODUCT_NAME));
        softAssert.assertEquals(ShoppingCart.getShoppingCartItemPrice(1).toUpperCase(),ProductData.PRICE);
        softAssert.assertAll();

    }

    @Test(description = "Verify checkout page details", dependsOnMethods = "testProductsInCart",alwaysRun = true)
    public void testCheckoutPageData(){

        softAssert = new SoftAssert();
        softAssert.assertEquals(Checkout.getFirstName().toLowerCase(), registeredUser.getFirstName().toLowerCase(), "Verify First Name" );
        softAssert.assertEquals(Checkout.getLastName().toLowerCase(), registeredUser.getLastName().toLowerCase(), "Verify Last Name" );
        softAssert.assertAll();
    }

    @Test(description = "Verify continue button behaviour without mandatory data", dependsOnMethods = "testCheckoutPageData",alwaysRun = true)
    public void testContinueWithoutMandatoryInfo(){

        softAssert = new SoftAssert();
        softAssert.assertTrue(Checkout.isStillInCheckoutPage(), "Verify checkout not continued");

        UserData emptyCheckoutAddress = new UserData(UserTypes.EMPTY_ADDRESS);
        String errorMessage = MyAccount.continueWithEmptyAddress(emptyCheckoutAddress);
        softAssert.assertEquals(errorMessage,MANDATORY_FIELD_MESSAGE, "Verify Address Line 1 is Mandatory");

        UserData emptyCheckoutSuburb = new UserData(UserTypes.EMPTY_SUBURB);
        String errorMessageSuburb = MyAccount.continueWithEmptySuburb(emptyCheckoutSuburb);
        softAssert.assertEquals(errorMessageSuburb,MANDATORY_FIELD_MESSAGE, "Verify Suburb is Mandatory");

        UserData emptyCheckoutPostCode = new UserData(UserTypes.EMPTY_POSTCODE);
        String errorMessagePostCode = MyAccount.continueWithEmptyPostCode(emptyCheckoutPostCode);
        softAssert.assertEquals(errorMessagePostCode,MANDATORY_FIELD_MESSAGE, "Verify PostCode is Mandatory");

        UserData emptyCheckoutPhoneNo = new UserData(UserTypes.EMPTY_PHONE_NO);
        String errorMessagePhoneNo = MyAccount.continueWithEmptyPhoneNo(emptyCheckoutPhoneNo);
        softAssert.assertEquals(errorMessagePhoneNo,MANDATORY_FIELD_MESSAGE, "Verify PhoneNo is Mandatory");

        Checkout.fillAddress(checkOutData);

//        Checkout.fillAddress(registeredUser.getAddress1());
//        Checkout.fillSuburb(registeredUser.getSuburb());
//        Checkout.searchPostCode(registeredUser.getPostCode());
//        Checkout.selectPostCodeFromSuggestions(0);
//        Checkout.fillContactNo(registeredUser.getContactNo());
//        Checkout.selectAuthorizeCheckBox(true);

        Checkout.continueCheckout();

        softAssert.assertAll();
    }

    @Test(description = "Verify Credit Card Validation", dependsOnMethods = "testContinueWithoutMandatoryInfo")
    public void testCreditCardValidation(){

        softAssert = new SoftAssert();
        Checkout.selectPaymentMethod(PaymentMethods.CREDIT_CARD);
        String messageCCNO1 = Checkout.fillCreditCardNoWithInvalidData(new CreditCardData(CreditCardTypes.EMPTY_CC_NO));
        softAssert.assertEquals(messageCCNO1, VerficationMessages.MANDATORY_CC_FIELD_MESSAGE, "Credit card no mandatory" );

        softAssert.assertAll();

    }
}
