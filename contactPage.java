package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class contactPage {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.tendable.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		By homePageMenu = By.xpath("//div[@class='navbar7_menu-left']//a[text()='Contact']");
		driver.findElement(homePageMenu).click();
		
		By etxtEmail = By.xpath("//Form[@name='Form']//input[@name='email']");
		By etxtFirstName = By.xpath("//Form[@name='Form']//input[@name='firstname']");
		By etxtLastName = By.xpath("//Form[@name='Form']//input[@name='lastname']");
		By etxtCompany = By.xpath("//Form[@name='Form']//input[@name='company']");
		By etxtMessage = By.xpath("//Form[@name='Form']//textarea[@name='message']");
		By eDropdown = By.xpath("//Form[@name='Form']//select");
		By eCheckbox = By.xpath("//Form[@name='Form']//input[@type='checkbox']");
		By ebtnSubmit = By.xpath("//Form[@name='Form']//button[@type='submit']");
		By eAlert = By.xpath("//Form[@name='Form']//div[text()='Form Submission Failed']");
		
		
		driver.findElement(etxtEmail).sendKeys("varunkumar.chougule@gmail.com");
		driver.findElement(etxtFirstName).sendKeys("Varunkumar");
		driver.findElement(etxtLastName).sendKeys("Chougule");
		driver.findElement(etxtCompany).sendKeys("Infosys");
		
		Select select = new Select(driver.findElement(eDropdown));
		select.selectByVisibleText("Marketing");
		
		driver.findElement(eCheckbox).click();
		driver.findElement(ebtnSubmit).click();
		Thread.sleep(4000);
		
		WebElement eError = driver.findElement(eAlert);
		if(eError.isDisplayed()) {
			System.out.println("Error alert is displayed");
		}else {
			System.out.println("Error alert is not displayed");
		}
		driver.quit();
	}
}
