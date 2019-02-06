package calender;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abhibus {
	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws Exception {

		Abhibus ab = new Abhibus();
		System.out.println();
		ab.get_Firefox("https://www.abhibus.com/");
		ab.select_Date_of_Journey("February", 5);
		
	

	}

	void get_Firefox(String Web_Addres_URL) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(Web_Addres_URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	void Explicit_Wait(int time_in_SEC, String Xpath_Of_Element) {
		wait = new WebDriverWait(driver, time_in_SEC);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Xpath_Of_Element)));

	}
	void select_Date_of_Journey(String Which_month,int Which_date  ) {
		driver.findElement(By.xpath("//input[@id='datepicker1']")).click();
		
		String month_path = "/html[1]/body[1]/div[7]//div[@class='ui-datepicker-title']/span[text()='" + Which_month
				+ "']";
		String Date_path = "/../../..//td[@data-handler='selectDay']//a[text()='" + Which_date + "']";
		
		try {
			driver.findElement(By.xpath(month_path + Date_path)).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid Date or Month \nNOTE:Month Should Starts with Capital Letter and Short name not allowed");
		}finally {
			driver.quit();
		}
		
	}

}
