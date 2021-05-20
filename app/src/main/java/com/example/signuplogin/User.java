package com.example.signuplogin;

public class User {
    private String userName;
    private String UserEmail;
    private String userPassword;
    private String isSignin;

    public User(){}

    public User(String userName, String userEmail, String userPassword, String isSignin) {
        this.userName = userName;
        UserEmail = userEmail;
        this.userPassword = userPassword;
        this.isSignin = isSignin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getIsSignin() {
        return isSignin;
    }

    public void setIsSignin(String isSignin) {
        this.isSignin = isSignin;
    }
}
