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
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class US_6 {

    BasePage basePage = new BasePage();
    DashboardPage dashboardPage = new DashboardPage();
    BooksPage booksPage = new BooksPage();


    @Given("I log in as a librarian")
    public void i_log_in_as_a_librarian() {
        basePage.login();

    }

    @When("I navigate to the {string} page")
    public void i_navigate_to_the_page(String string) {
        dashboardPage.navigateToModules(string);
    }

    @When("I take all book categories in UI")
    public void i_take_all_book_categories_in_ui() {
        BrowserUtils.hover(booksPage.all_books);

        booksPage.all_books.click();

    }

    @When("I execute a query to get book categories")
    public void i_execute_a_query_to_get_book_categories() {
        DB_Util.runQuery("select name from book_categories");

    }

    @Then("verify book categories must match the book_categories table from DB.")
    public void verify_book_categories_must_match_the_book_categories_table_from_db() {
        ArrayList<String> expectedResult = new ArrayList<>();
        for (WebElement element : booksPage.list) {
            BrowserUtils.highlight(element);
            expectedResult.add(element.getText());
        }


        List<String> actualResult = DB_Util.getColumnDataAsList(1);

       /* Select select = new Select(booksPage.all_books);
        select.selectByVisibleText(electronics);

        ArrayList<String> expectedCategories = new ArrayList<>();

        List<WebElement> allCategories = select.getOptions();
        for (WebElement allCategory : allCategories) {
            BrowserUtils.highlight(allCategory);
            expectedCategories.add(allCategory.getText());

        }
        BrowserUtils.sleep(6);

        Assert.assertEquals(all, DB_Util.displayAllData());

*/


        Assert.assertEquals(expectedResult, actualResult);


    }

}
