package com.library.pages;

import com.library.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a/span[.='Dashboard']")
    public WebElement dashboard;


    @FindBy(id = "borrowed_books")
    public WebElement borrowed_books;

    @FindBy(xpath = "//a/span[.='Books']")
    public WebElement books;

    public void navigateToModules(String module){
        String locator = "//a/span[.='"+module+"']";

        WebElement allModules = Driver.getDriver().findElement(By.xpath(locator));

        allModules.click();
    }
}
