package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class D4E3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://demo.opencart.com/index.php?route=checkout/voucher&language=en-gb");
		WebElement rname = driver.findElement(By.xpath("//*[@id=\"input-to-name\"]"));
		rname.sendKeys("Akshaya Hariram");
		WebElement remail = driver.findElement(By.xpath("//*[@id=\"input-to-email\"]"));
		remail.sendKeys("akshayahariram@gmail.com");
		WebElement name = driver.findElement(By.xpath("//*[@id=\"input-from-name\"]"));
		name.sendKeys("Akshaya");
		WebElement email = driver.findElement(By.xpath("//*[@id=\"input-from-email\"]"));
		email.sendKeys("akshaya@gmail.com");
		WebElement gift = driver.findElement(By.xpath("//*[@id=\"input-theme-7\"]"));
		gift.click();
		WebElement msg = driver.findElement(By.xpath("//*[@id=\"input-message\"]"));
		msg.sendKeys("Hello!!!");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)","");
		Thread.sleep(3000);
		WebElement amount = driver.findElement(By.xpath("//*[@id=\"input-amount\"]"));
		amount.clear();
		amount.sendKeys("5");
		WebElement check = driver.findElement(By.xpath("//*[@id=\"form-voucher\"]/div[8]/div/div/input"));
		check.click();
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"form-voucher\"]/div[8]/div/button"));
		btn.click();
	}

}
