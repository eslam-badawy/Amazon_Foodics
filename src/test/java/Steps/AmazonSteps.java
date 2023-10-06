package Steps;

import java.io.IOException;
import com.amazon.pages.AmazonPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class AmazonSteps  {
    public AmazonSteps() throws IOException {
    }


@Given("I am on the amazon website and I open “All” menu from the left side")
    public void openAllMenu() throws InterruptedException {
       AmazonPage.clickOnAllMenu();
    }

@And("I click on “video games” then choose “all video games”")
    public void clickVideoGamesAndChooseAllVideoGames() throws InterruptedException {
       AmazonPage.clickOnSeeAll();  
       AmazonPage.clickOnVideoGames();
       AmazonPage.clickOnAllVideoGames();
    }

 @And("I add filter “free shipping” & add the filter of condition “new”")
    public void addFilters() {
        AmazonPage.clickOnFreeShippingFilter();
        AmazonPage.clickOnNewConditionFilter();
    }

@And("I sort by price: high to low")
    public void sortByPriceHighToLow() throws InterruptedException {
        AmazonPage.clickOnSortByPriceHighToLow();
    }

@When("I complete an order with all products that its cost below 15k EGP")
public void addProductsBelow15kEGP() throws InterruptedException {
    AmazonPage.addProductsBelowSpecificAmount(15000); // You can adjust the amount as needed
    AmazonPage.clickOnCartContainer();
}

}
