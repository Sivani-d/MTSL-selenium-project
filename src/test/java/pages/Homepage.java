package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
	WebDriver driver;
	public Homepage (WebDriver driver) {
		this.driver=driver;
	}
	By searchBar = By.id("twotabsearchtextbox");
	By searchIcon =  By.id("nav-search-submit-button");
	By selectItem = By.xpath("(//*[text()='Apple iPhone 15 Plus (256 GB) - Blue'])");
	
	public void searchProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
		driver.findElement(searchBar).sendKeys("Apple iPhone 15 Plus (256 GB) - Blue");
		driver.findElement(searchIcon).click();
		driver.findElement(selectItem).click();
	}

}






