package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import pages.Amazonpage2;
import pages.FlipkartHome;
import pages.Flipkartpage2;
import pages.Homepage;

public class EcomTest {
    
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeSuite
    public void setUpExtentReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/EcomTestReport.html");
        sparkReporter.config().setDocumentTitle("E-commerce Test Report");
        sparkReporter.config().setReportName("Price Comparison Report");
        sparkReporter.config().setTheme(Theme.STANDARD);
        
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void test1() {
        test = extent.createTest("Test1: Amazon Search Product");

        // Step 1: Open Amazon and search for a product
        driver.get("https://www.amazon.in/");
        test.log(Status.INFO, "Navigated to Amazon homepage");

        Homepage pg = new Homepage(driver);
        pg.searchProduct();
        test.log(Status.INFO, "Searched for product on Amazon");
    }

    @Test(priority = 1)
    public void test2() throws InterruptedException {
        test = extent.createTest("Test2: Amazon Add to Cart");

        // Step 2: Add product to Amazon cart
        Amazonpage2 pg = new Amazonpage2(driver);
        pg.Cart();
        test.log(Status.INFO, "Attempted to add product to Amazon cart");
    }

    @Test(priority = 2)
    public void test3() throws InterruptedException {
        test = extent.createTest("Test3: Flipkart Search Product");

        // Step 3: Open Flipkart and search for a product
        driver.get("https://www.flipkart.com/");
        test.log(Status.INFO, "Navigated to Flipkart homepage");

        FlipkartHome pg = new FlipkartHome(driver);
        pg.SearchProduct();
        test.log(Status.INFO, "Searched for product on Flipkart");
    }

    @Test(priority = 3)
    public void test4() throws InterruptedException {
        test = extent.createTest("Test4: Flipkart Add to Cart");

        // Step 4: Add product to Flipkart cart
        Flipkartpage2 pg = new Flipkartpage2(driver);
        pg.Cart();
        test.log(Status.INFO, "Attempted to add product to Flipkart cart");
    }

    @Test(priority = 4)
    public void test5() {
        test = extent.createTest("Test5: Compare Amazon and Flipkart Prices");

        // Step 5: Compare prices from Amazon and Flipkart
        double amzPrice = Amazonpage2.finalPrice;
        double flpPrice = Flipkartpage2.finalPrice;
        double priceDifference = Math.abs(amzPrice - flpPrice);

        test.log(Status.INFO, "Amazon price: " + amzPrice);
        test.log(Status.INFO, "Flipkart price: " + flpPrice);

        if (amzPrice < flpPrice) {
            test.log(Status.INFO, "Amazon has a lower price: " + amzPrice);
            test.log(Status.INFO, "Price difference: " + priceDifference);
        } else if (flpPrice < amzPrice) {
            test.log(Status.INFO, "Flipkart has a lower price: " + flpPrice);
            test.log(Status.INFO, "Price difference: " + priceDifference);
        } else {
            test.log(Status.INFO, "Both prices are the same: " + amzPrice);
        }
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Skipped");
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void tearDownExtentReport() {
        extent.flush();
    }
}
