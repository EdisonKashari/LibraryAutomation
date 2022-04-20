package com.library.step_definitions;

import com.library.utilities.DB_Util;
import com.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class US_1 {

    @Given("Establish the database connection")
    public void establish_the_database_connection() {

        String url = "jdbc:mysql://34.230.35.214:3306/library2";
        String username = "library2_client";
        String password = "6s2LQQTjBcGFfDhY";

        DB_Util.createConnection(url, username, password);


    }

    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {

        DB_Util.runQuery("SELECT distinct count(ID) FROM users");

    }

    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {

        int actualResult = Integer.parseInt(DB_Util.getFirstRowFirstColumn());

        int expectedResult = 142;

        Assert.assertEquals(expectedResult, actualResult);

    }


    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
        // DB_Util.runQuery("select Column_Name from information_schema.COLUMNS where  TABLE_NAME='users'");
        DB_Util.runQuery("select * from users");

    }

    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> expectedColumns) {
        List<String> actualColumns = DB_Util.getAllColumnNamesAsList();

        System.out.println("actualColumns = " + actualColumns);

        Assert.assertEquals(expectedColumns, actualColumns);
    }

}
