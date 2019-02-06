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
		testdemo("0");
		
	//	Abhibus ab = new Abhibus();
		System.out.println();
		/*ab.get_Firefox("https://www.abhibus.com/");
		driver.findElement(By.xpath("//input[@id='datepicker1']")).click();	
		String month = "March";
		int id= 10;
		driver.findElement(By.xpath(""));
		*/
		
		
		
		
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
/**
 * @param str
 */
static	void testdemo(String str) {
		int x = 0;
		try {
			x = 10/(Integer.parseInt(str));
		}catch(ArithmeticException e) {
			
			System.out.println(x);
			System.exit(0);
		}finally {
			try {
				int arr[] = new int[-1];
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("finally ");
		}
		
	}

}
