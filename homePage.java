package pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {

	public static void main (String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.tendable.com");
		driver.manage().window().maximize();
		
		By homePage = By.xpath("//div[@class='navbar7_container']//a[@aria-label='home']//img");
		By homePageMenu = By.xpath("//div[@class='navbar7_menu-left']//a[@class='navbar7_link w-nav-link']");
		By homePageHiddenMenu = By.xpath("//div[@class='navbar7_menu-left']//a[@class='navbar7_link hide w-nav-link']");
		
		List<WebElement> elements = driver.findElements(homePageMenu);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		
		WebElement image = driver.findElement(homePage);
		String imagesrc = image.getAttribute("src");
		List<WebElement> homeLogo = driver.findElements(homePage);
		for(WebElement home : homeLogo ) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(home));
				System.out.println(imagesrc + " Element is accessibe");		
			}catch(Exception e) {
				System.out.println(imagesrc + " Element is not accessibe");
				}
			}
		
		
		for(WebElement menuItems : elements) {
		
			try {
				wait.until(ExpectedConditions.elementToBeClickable(menuItems));
				System.out.println(menuItems.getText() + " element is accessibe");		
			}catch(Exception e) {
				System.out.println(menuItems.getText() + " element is not accessibe");
				}
			}
		List<WebElement> hiddenElements = driver.findElements(homePageHiddenMenu);
		
		for(WebElement menuItems : hiddenElements) {
			
			String hiddenElement = menuItems.getAttribute("innerText");
			
			try {
				wait.until(ExpectedConditions.elementToBeClickable(menuItems));
				System.out.println(hiddenElement + " element is accessibe");		
			}catch(Exception e) {
				System.out.println(hiddenElement + " element is not accessibe");
				}
			}	driver.quit();
		}
	
	
}
