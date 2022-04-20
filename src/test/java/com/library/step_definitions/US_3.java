package com.library.step_definitions;

import com.library.utilities.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US_3 {

    @When("I execute a query to find the most popular book genre")
    public void i_execute_a_query_to_find_the_most_popular_book_genre() {
        DB_Util.runQuery("select bc.name,count(*) from book_borrow bb inner join books b on bb.book_id = b.id inner join book_categories bc on b.book_category_id=bc.id group by name order by 2 desc ");


    }


    @Then("verify that {string} is the most popular book genre.")
    public void verifyThatIsTheMostPopularBookGenre(String classicGenre) {

//int actualResult = Integer.parseInt(DB_Util.getFirstRowFirstColumn());
        //  System.out.println("actualResult = " + actualResult);
        System.out.println("DB_Util.getFirstRowFirstColumn() = " + DB_Util.getFirstRowFirstColumn());

        String actualResult1 = DB_Util.getFirstRowFirstColumn();
        Assert.assertEquals(classicGenre, actualResult1);


    }
}
