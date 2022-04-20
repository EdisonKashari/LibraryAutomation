package com.library.step_definitions;

import com.library.utilities.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US_4 {
    @When("I execute a query to find the most popular user")
    public void i_execute_a_query_to_find_the_most_popular_user() {
        DB_Util.runQuery("select full_name,count(*) from users u inner join book_borrow bb on u.id = bb.user_id group by full_name order by 2 desc");

    }


    @Then("verify {string} is the user who reads the most")
    public void verifyIsTheUserWhoReadsTheMost(String expectedReader) {

        String actualReader = DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(expectedReader,actualReader);


    }
}
