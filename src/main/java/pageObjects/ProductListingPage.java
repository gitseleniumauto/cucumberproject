package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import selenium.Wait;

public class ProductListingPage {

    WebDriver driver;

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

   // @FindBy(how = How.CSS, using = "button.single_add_to_cart_button")
    @FindBy(how = How.XPATH, using = "//button[@class='single_add_to_cart_button button alt']")
    private WebElement btn_AddToCart;

    @FindAll(@FindBy(how = How.XPATH, using = "//div[contains(@class,'noo-product')]"))
    private List<WebElement> prd_List;

    public void clickOn_AddToCart() {
        btn_AddToCart.click();
        Wait.untilJqueryIsDone(driver);
    }

    public void select_Product(int productNumber) {
		 prd_List.get(productNumber).findElement(By.xpath("//h3")).click();
	
    }

    public void select_Color(int color) {
    	 Select select = new Select(driver.findElement(By.id("pa_color")));
    	 select.selectByIndex(color);
	
   }
   
    public void select_Size(int size) {
   	 Select select = new Select(driver.findElement(By.id("pa_size")));
   	 select.selectByIndex(size);
	
  }
    
    public String getProductName(int productNumber){
        return prd_List.get(productNumber).findElement(By.xpath("//h3")).getText();
    }

}