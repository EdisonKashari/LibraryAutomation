package com.library.step_definitions;

import com.library.pages.BasePage;
import com.library.pages.DashboardPage;
import com.library.utilities.BrowserUtils;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.DB_Util;
import com.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US_2 {
    BasePage basePage = new BasePage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("I am in the homepage of the library app")
    public void i_am_in_the_homepage_of_the_library_app() {


        basePage.login();
        BrowserUtils.waitForVisibility(dashboardPage.dashboard, 5);


    }

    @When("I take borrowed books number")
    public void i_take_borrowed_books_number() {
       BrowserUtils.highlight(dashboardPage.borrowed_books);

        DB_Util.runQuery("select count(*) from book_borrow where is_returned=0");

    }

    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        String actualResult = dashboardPage.borrowed_books.getText();


        String expectedResult = DB_Util.getFirstRowFirstColumn();


        BrowserUtils.sleep(3);

        Assert.assertEquals(expectedResult, actualResult);


    }
}
