package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class D5E2 {

	public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(co);
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        Actions a=new Actions(driver);
        WebElement source_ele=driver.findElement(By.id("draggable"));
        WebElement dest_ele=driver.findElement(By.id("droppable"));
        a.clickAndHold(source_ele).release(dest_ele).build().perform();
        
	}

}