package pages;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkartpage2 {
	WebDriver driver;
	public Flipkartpage2(WebDriver driver) {
		this.driver=driver;
	}
	
	By addToCartButton = By.xpath("//*[text()='Add to cart']");
	By addToCartIcon = By.xpath("//button[@class='QqFHMw vslbG+ In9uk2 JTo6b7']");
	By productName = By.xpath("//*[@class='T2CNXf QqLTQ-']");
	By productPrice = By.xpath("(//span[@class='LAlF6k re6bBo'])[1]");
	public static double finalPrice;
	
	
  
  public void Cart() throws InterruptedException {
	  String mainWindowHandle = driver.getWindowHandle();
	 
	  System.out.println(driver.getWindowHandle().length());
	  for (String handle : driver.getWindowHandles()) {
          if (!handle.equals(mainWindowHandle)) {
              driver.switchTo().window(handle); 
              break;
          }
      }
	  System.out.println(driver.getCurrentUrl());
	  Thread.sleep(5000);
	  
	  try {
		  driver.findElement(addToCartButton).click();
		  System.out.println("IN try block");
		
	} catch (Exception e) {
		driver.findElement(addToCartIcon).click();
		System.out.println("In Catch block");
	}

	  
	  
	  Thread.sleep(5000);
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productName));

	  String FlipkartProductName= driver.findElement(productName).getText();
	  String FlipkartProductPrice = driver.findElement(productPrice).getText().replaceAll("[^\\d.]", "");
	  finalPrice= Double.parseDouble(FlipkartProductPrice);
	  
	  System.out.println("Flipkart porduct name is:"+FlipkartProductName);
	  System.out.println("Flipkart Product price is:"+FlipkartProductPrice);
  }
  
  
  
}


// this.addToCartButton = page.getByRole('button', { name: 'Add to cart' });
//this.productName = page.locator('(//a[@class="T2CNXf QqLTQ-"])[1]');
//this.priceElement = page.locator('(//span[@class="LAlF6k re6bBo"])[1]');