package com.sysco.web_ui_automation.data;

import com.sysco.web_ui_automation.Types.UserTypes;

public class UserData {

    private String country;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    public String address1;
    public String suburb;
    public String state;
    public String contactNo;
    public String postCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String postCode) {
        this.suburb = suburb;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserData(UserTypes userType){

        switch (userType){
            case EMPTY_EMAIL:
                email = "";
                password = "abc123$$";
                break;
            case EMPTY_PASSWORD:
                email = "williamjacob802@gmail.com";
                password = "";
                break;
            case INVALID_EMAIL:
                email = "williamjacob802";
                password = "abc123$$";
                break;
            case INVALID_PASSWORD:
                email = "williamjacob802@gmail.com";
                password = "12345";
                break;
            case REGISTERED_USER:
                email = "williamjacob802@gmail.com";
                password = "abc123$$";
                firstName = "William";
                lastName = "Jacob";
                country = "Australia";
                contactNo = "0555555555";
                address1 = "ABC";
                suburb = "123";
                state = "Victoria";
                postCode = "2000";
                break;
            case EMPTY_ADDRESS:
                address1 = "";
                break;
            case EMPTY_SUBURB:
                suburb = "";
                break;
            case EMPTY_STATE:
                state = "";
                break;
            case EMPTY_POSTCODE:
                postCode = "";
            case EMPTY_PHONE_NO:
                contactNo = "";
                break;

        }
    }
}
