package Steps;

import java.io.IOException;
import org.junit.Assert;
import com.amazon.pages.CartPage;
import io.cucumber.java.en.Then;

public class CartSteps {
    public CartSteps() throws IOException {
    }

    @Then("I see the total amount of all items is correct")
    public void iSeeTotalAmountIsCorrect() {
        double actualResult = CartPage.getSubTotalPrice();
        CartPage.clickOnProceedToBuyButton();
        double expectedResult = CartPage.getFinalPrice();
        Assert.assertEquals("Wrong price", actualResult, expectedResult);
    }
    
}
