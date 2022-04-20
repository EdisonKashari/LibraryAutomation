package com.library.step_definitions;

import com.library.pages.BasePage;
import com.library.pages.BooksPage;
import com.library.pages.DashboardPage;
import com.library.utilities.BrowserUtils;
import com.library.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class US_5 {
    BasePage basePage = new BasePage();
    DashboardPage dashboardPage = new DashboardPage();
    BooksPage booksPage = new BooksPage();

    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
        basePage.login();

    }

    @Given("I navigate to {string} page")
    public void i_navigate_to_page(String books) {
        BrowserUtils.waitForVisibility(dashboardPage.books, 5);
        BrowserUtils.highlight(dashboardPage.books);
        dashboardPage.navigateToModules(books);


    }

    @When("I open book {string}")
    public void i_open_book(String string) {
        booksPage.searchBox.sendKeys(string);

        DB_Util.runQuery("select name, author,year from books where name='Chordeiles minor'");


    }

    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {


        List<String> actualResult = DB_Util.getRowDataAsList(1);

        System.out.println("actualResult = " + actualResult);


        ArrayList<String> expectedResult = new ArrayList<>();

        for (WebElement element : booksPage.book) {
            BrowserUtils.highlight(element);

         if (element.getText().isEmpty() || element.getText().equals("Classic")) {
            continue;

            }
            expectedResult.add(element.getText());


        }
        System.out.println("expectedResult = " + expectedResult);
        BrowserUtils.sleep(3);
        Assert.assertEquals(expectedResult, actualResult);

    }
}
