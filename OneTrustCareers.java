package OneTrustCareers;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OneTrustCareers {
	
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe"); //location of chormedriver
		WebDriver driver = new ChromeDriver();
		driver.get("https://onetrust.com/"); //website
		Thread.sleep(2000);
		WebElement company = driver.findElement(By.xpath("//a[@href = 'company.html']"));
		Actions action = new Actions(driver);
		action.moveToElement(company).build().perform();
		WebElement careers = driver.findElement(By.xpath("//a[@href = 'careers.html']"));
		careers.click();
		Thread.sleep(2000); 
		List<WebElement> cities = driver.findElements(By.cssSelector(".nav.nav-tabs li a")); //finds all available cities
		for(int i=0;i<cities.size();i++){
			WebElement header = driver.findElement(By.cssSelector(".nav.nav-tabs li a"));
			Actions action2 = new Actions(driver);
			action2.moveToElement(header);
			String Hash = cities.get(i).getAttribute("hash");
			WebElement City = driver.findElement(By.cssSelector(Hash));
			Actions action3 = new Actions(driver);
			action3.moveToElement(City).click();
			List<WebElement> Jobs = driver.findElements(By.cssSelector(Hash+" .job-listing")); //finds all jobs in each city
			System.out.println(cities.get(i).getAttribute("innerText")); //writes the city name
			for(int i1=0;i1<Jobs.size();i1++){
				System.out.println(Jobs.get(i1).getAttribute("innerText")); //writes each job 
			}
		}	
		driver.quit();
	}
}