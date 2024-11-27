package pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class navigatePage {

	public static void main(String[] args) throws InterruptedException {
	By bookADemo= By.xpath("//a[text()='Book a demo']");
	By homePageMenu = By.xpath("//div[@class='navbar7_menu-left']//a[@class='navbar7_link w-nav-link']");
	By close = By.xpath("//div[@id='interactive-close-button']");
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.tendable.com");
	driver.manage().window().maximize();
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	WebElement eElement = driver.findElement(bookADemo);
	Thread.sleep(6000);
	
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//	WebElement closeButton = driver.findElement(close); 
//	js.executeScript("arguments[0].click();", closeButton); 
	
		List<WebElement> activeMenu = driver.findElements(homePageMenu);
		for(int i =0; i<=activeMenu.size();i++) {
			try {
			WebElement menuItem = driver.findElements(homePageMenu).get(i);
            menuItem.click();
			Thread.sleep(2000);
			
				wait.until(ExpectedConditions.elementToBeClickable(bookADemo));
				if (eElement.isDisplayed()) {
				System.out.println(((WebElement) bookADemo).getText() + " element is present & active on the page");
				}else {
				System.out.println(((WebElement) bookADemo).getText() + " element is present however its not active on this "+ activeMenu + "page");
					}
				}catch(StaleElementReferenceException e) {
					System.out.println("Element is stale, retrying...");
//					e.printStackTrace();
					i--;
				}
		}
		driver.quit();
	}
}

