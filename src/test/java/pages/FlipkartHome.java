package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartHome {
	WebDriver driver;
	public FlipkartHome(WebDriver driver) {
		this.driver=driver;
	}
	By searchBar = By.xpath("//input[@title='Search for Products, Brands and More']");
	By selectItem = By.xpath("//div[text()='Apple iPhone 15 Plus (Blue, 128 GB)']");
//	By addToCart = By.xpath("//*[text()='Add to cart']");

  
  public void SearchProduct() throws InterruptedException {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
		driver.findElement(searchBar).sendKeys("Apple iPhone 15 Plus (Blue, 128 gb)");
		driver.findElement(searchBar).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(selectItem).click();
  }
}




//Apple iPhone 15 Plus (Blue,256 gb)
//this.searchBar = page.getByPlaceholder("Search for Products, Brands");
//this.noResultsMessage = page.locator('._1o9WnF');
//this.selectItem = page.getByRole('link', { name: 'Apple iPhone 14 Plus (Blue, 128 GB) Add to Compare Apple iPhone 14 Plus (Blue,' });
//this.addToCartButton = page.getByRole('button', { name: 'Add to cart' });
//this.productName = page.locator('(//a[@class="T2CNXf QqLTQ-"])[1]');
//this.priceElement = page.locator('(//span[@class="LAlF6k re6bBo"])[1]');
//}

//async searchForProduct(productName) {
//await this.searchBar.fill(productName);
//await this.searchBar.press('Enter');
//}

//async checkNoResults() {
//return await this.noResultsMessage.isVisible();
//}

//async selectProduct() {
//await this.selectItem.click();
//}

//async addToCart() {
//await this.addToCartButton.click();
//}

//async getProductName() {
//return await this.productName.textContent();
//}

//async getProductPrice() {
//const priceText = await this.priceElement.textContent();
//return parseFloat(priceText.replace(/[^0-9.-]+/g, ""));
//}
