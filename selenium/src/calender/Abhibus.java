package calender;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		ab.Date_of_Journey("march", 5);
		Thread.sleep(1000);
		driver.quit();

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

	void select_Date_of_Journey(String Which_month, int Which_date) {
		driver.findElement(By.xpath("//input[@id='datepicker1']")).click();

		String month_path = "/html[1]/body[1]/div[7]//div[@class='ui-datepicker-title']/span[text()='" + Which_month
				+ "']";
		String Date_path = "/../../..//td[@data-handler='selectDay']//a[text()='" + Which_date + "']";

		try {
			driver.findElement(By.xpath(month_path + Date_path)).click();
		} catch (Exception e) {
			System.out.println(
					"Invalid Date or Month \nNOTE:Month Should Starts with Capital Letter and Short-form  not allowed");
		} finally {
			driver.quit();
		}

	}

	void Date_of_Journey(String Which_month, int Which_date) throws Exception {
		driver.findElement(By.xpath("//input[@id='datepicker1']")).click();
		Thread.sleep(100);
		List<WebElement> c_name = driver.findElements(By.xpath("//html[1]/body[1]//span[@class='ui-datepicker-month']"));
		ListIterator<WebElement> list_it = c_name.listIterator();
		process:
		for (int i = 1; i <= c_name.size(); i++) {
			
			
			
			if(list_it.hasNext()) {
			String m= list_it.next().getText();
			if (m.equalsIgnoreCase(Which_month)) {
				
				
				System.out.println("got it ");
				break;
			} else {
					if (driver.findElement(By.xpath("//span[text()='Next']")).isEnabled()) {
						driver.findElement(By.xpath("//span[text()='Next']")).click();
					}else {
						System.out.println("button not enable");
					}
					c_name = driver.findElements(By.xpath("//html[1]/body[1]//span[@class='ui-datepicker-month']"));//use to get next 2 month name
					
			}
				
				
				while(m.equalsIgnoreCase(Which_month)){
					
					System.out.println("got it ");
					
					continue process;
				}
			}else {
				
			}
			
			
			
		}

	}

}
