package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage{

    @FindBy(xpath = "//input[@name ='username']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@name ='password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//button[text() = 'Log in']")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginButton);
    }

    public void login(String email, String password){
        pause(3);
        emailField.type(email);
        passwordField.type(password);
        loginButton.click();
    }



}
