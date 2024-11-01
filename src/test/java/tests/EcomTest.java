package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.Amazonpage2;
import pages.FlipkartHome;
import pages.Flipkartpage2;
import pages.Homepage;

public class EcomTest {
	WebDriver driver = new ChromeDriver();
  @Test(priority=0)
  public void test1() {
	  
	  driver.get("https://www.amazon.in/");
	  Homepage pg = new Homepage(driver);
	  pg.searchProduct();
	  
	  
  }
  @Test(priority=1)
  public void test2() throws InterruptedException {
	 
	  Amazonpage2 pg = new Amazonpage2(driver);
	  pg.Cart();
	
	  
 }
  @Test (priority=2)
  public void test3() throws InterruptedException {
	  
	  driver.get("https://www.flipkart.com/"); 
	  FlipkartHome pg = new FlipkartHome(driver);
	  pg.SearchProduct();
 }

  @Test (priority=3)
  public void test4() throws InterruptedException {
	  Flipkartpage2 pg = new Flipkartpage2(driver);
	  pg.Cart();
  }
  
  @Test (priority=4)
  public void test5() {
	  double amzPrice = Amazonpage2.finalPrice;
	  double flpPrice = Flipkartpage2.finalPrice;
	  System.out.println(amzPrice+""+flpPrice);
	  double priceDifference = Math.abs(amzPrice-flpPrice);
	    // Compare prices and print the result
	    if (Amazonpage2.finalPrice < Flipkartpage2.finalPrice) {
	        System.out.println("Amazon has a lower price: " + Amazonpage2.finalPrice);
	        System.out.println("Price difference: " + priceDifference);
	    } else if (Flipkartpage2.finalPrice < Amazonpage2.finalPrice) {
	        System.out.println("Flipkart has a lower price: " + Flipkartpage2.finalPrice);
	        System.out.println("Price difference: " + priceDifference);
	    } else {
	        System.out.println("Both prices are the same: " + Amazonpage2.finalPrice);
	    }
	  
  }
 
  
}
