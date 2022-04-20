package com.library.pages;

import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement inputEmail;


    @FindBy(id = "inputPassword")
    public WebElement password;


    @FindBy(xpath = "//button")
    public WebElement signInButton;

    public void login() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        inputEmail.sendKeys(ConfigurationReader.getProperty("librarian_email"));
        password.sendKeys(ConfigurationReader.getProperty("l_password"));
        signInButton.click();
    }

}
