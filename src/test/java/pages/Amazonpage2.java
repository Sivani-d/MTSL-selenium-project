package pages;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Amazonpage2 {
	WebDriver driver;
	public Amazonpage2 (WebDriver driver) {
		this.driver=driver;
		
	}
	
	By cartButton = By.xpath("(//*[@value='Add to Cart'])[2]");
	By popUp = By.xpath("//a[@aria-label='Exit this panel and return to the product page. ']");
	By itemsinCart= By.id("nav-cart-count-container");
	By productName=By.xpath("//span[@class='a-truncate-cut']");
	By productPrice=By.cssSelector(".sc-product-price");
	
	public static double finalPrice;
	
  
  public void Cart() throws InterruptedException {
	 
	  String mainWindowHandle = driver.getWindowHandle();
	 
	  
	  for (String handle : driver.getWindowHandles()) {
          if (!handle.equals(mainWindowHandle)) {
              driver.switchTo().window(handle); 
              break;
          }
      }
	  System.out.println(driver.getCurrentUrl());
	  Thread.sleep(5000);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(cartButton));
     
	  driver.findElement(cartButton).click();
	  Thread.sleep(5000);
	  driver.findElement(popUp).click();
	  Thread.sleep(3000);
     
	  driver.findElement(itemsinCart).click();
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9000));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
	  
	  String AmazonProductName= driver.findElement(productName).getText();
	  String AmazonProductPrice= driver.findElement(productPrice).getText().replaceAll("[^\\d.]", "");
	  finalPrice = Double.parseDouble(AmazonProductPrice);
	  System.out.println("Amazon product name is:"+ AmazonProductName);
	  System.out.println("Amazon product price is:"+ AmazonProductPrice);
	  Thread.sleep(5000);
	  driver.close();
	  Thread.sleep(2000);
	  driver.switchTo().window(mainWindowHandle);
	
	  
  }

  

}

//this.page1=page1;
//this.cartButton = page1.getByRole('button', { name: 'Add to Cart' });
//this.exitPanelButton = page1.getByLabel('Exit this panel and return to');
//this.itemsInCartButton = page1.getByLabel('items in cart');
//this.productName = page1.locator('(//span[@class="a-truncate-full a-offscreen"])[1]');
//this.priceElement = page1.locator('//span[@class="a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold"]');
//
//}
//
//async addToCart() {
//await this.cartButton.click();
//}
//
//async exitPanel() {
//await this.exitPanelButton.click();
//}
//
//async viewCart() {
//await this.itemsInCartButton.click();
//}
//
//async getProductName() {
//return await this.productName.textContent();
//}
//
//async getProductPriceA() {
//const priceText = await this.priceElement.textContent();
//return parseFloat(priceText.replace(/[^0-9.-]+/g, ""));
//}
