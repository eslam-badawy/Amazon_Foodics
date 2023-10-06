package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.io.IOException;
import com.amazon.base.Base;
import com.amazon.pages.AmazonPage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.CartPage;


public class Hooks extends Base {
    public Hooks() throws IOException {
    }
    AmazonPage amazonPage = new AmazonPage();
    LoginPage loginPage = new LoginPage();
    CartPage cartPage = new CartPage();


    @Before
    public void runsBeforeAnyScenario(){
       initializeBrowser();
       loginPage.login();
       cartPage.deleteAllProductsInCart();     
    }

    @After
    public void tearDown() {
       driver.quit(); 
    }
}
