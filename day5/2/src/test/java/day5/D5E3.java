package day5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class D5E3 {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(co);
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        WebElement cust_id = driver.findElement(By.name("cusid"));
        WebElement submit = driver.findElement(By.name("submit"));
        cust_id.sendKeys("401");
        submit.click();
        Alert alert1 = driver.switchTo().alert();
        alert1.dismiss();
        Thread.sleep(3000);
        cust_id.clear();
        cust_id.sendKeys("402");
        submit.click();
        Alert alert2 = driver.switchTo().alert();
        alert2.accept();
        Alert alert3 = driver.switchTo().alert();
        String txt = alert3.getText();
        alert3.accept();
        System.out.println(txt);
	}

}
