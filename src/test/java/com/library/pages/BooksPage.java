package com.library.pages;

import com.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BooksPage {
    public BooksPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input")
    public WebElement searchBox;

    @FindBy(xpath = "//tr/td[.='387448631259']/following-sibling::td")
    public List< WebElement> book;

    @FindBy (id = "book_categories")
    public WebElement all_books;

    @FindBy(xpath = "//option[.='ALL']/following-sibling::option")
    public List<WebElement> list;
}
