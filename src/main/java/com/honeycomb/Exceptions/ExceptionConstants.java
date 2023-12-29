package com.honeycomb.Exceptions;

public class ExceptionConstants {

    public static final String USER_NOT_FOUND = "User not found with id : ";
    public static final String EMAIL_NOT_FOUND = "Email not found with id : ";
    public static final String INVALID_EMAIL_PASSWORD = "Invalid email or password";
    public static final String EMAIL_ALREADY_PRESENT = "Email already present. Please try different email";
    public static final String PRODUCT_NOT_FOUND = "Product not found with id : ";
    public static final String TOKEN_EXPIRED = "Token expired. Please initiate new password request";
    public static final String TOKEN_BEFORE_TIME = "Token already initiated. Please try after sometime.";
    public static final String PASSWORD_RESET_PROGRESS = "Password reset request initiated. Please reset the password first.";
    public static final String PASSWORD_WITHIN_DAY = "Password only changes one time in 24 hours. Password change initiated at : ";
}
