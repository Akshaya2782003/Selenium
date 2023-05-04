package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class E1 {
    public static void main( String[] args ) throws InterruptedException
    {
    	ChromeOptions co = new ChromeOptions();
    	co.addArguments("--remote-allow-origins=*");
    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(co);
        driver.get("https://www.amazon.in/Casio-Analog-Digital-Black-Dial-Watch-GM-2100G-1A9DR/dp/B0BJ7RRWS1/ref=sr_1_1_sspa?crid=11D7UNWFMKNX0&keywords=gshock&qid=1683195183&sprefix=gshock%2Caps%2C973&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        String etitle = "Casio Analog-Digital Black Dial Men's Watch-GM-2100G-1A9DR\n";
        System.out.println(title);
        if(title.equals(etitle)) {
        	System.out.println("Title is matching");
        }
        else {
        	System.out.println("Title Mismatch");
        }
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
        Thread.sleep(5000); 
        driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();
        System.out.println("Item added to cart:" + etitle);
        driver.get("https://www.amazon.in/gp/cart/view.html/ref=dp_atch_dss_cart?");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@value=\"Delete\"]")).click();
        Thread.sleep(2000);
        String removeText = driver.findElement(By.xpath("//*[@id=\"sc-active-cart\"]/div/div[1]/div/h1")).getText();
        String extext = "Your Amazon Cart is empty.";
        if(removeText.equals(extext)) {
        	System.out.println("Product is removed");
        }
        driver.get("https://www.amazon.in/Casio-Analog-Digital-Black-Dial-Watch-GM-2100G-1A9DR/dp/B0BJ7RRWS1/ref=sr_1_1_sspa?crid=11D7UNWFMKNX0&keywords=gshock&qid=1683195183&sprefix=gshock%2Caps%2C973&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1");
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
        Thread.sleep(2000);
        driver.get("https://www.amazon.in/gp/cart/view.html/ref=dp_atch_dss_cart?");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"quantity_2\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@name=\"proceedToRetailCheckout\"] "));
        Thread.sleep(1000);
        String sign = driver.getTitle();
        System.out.println(sign);
        String esign = "Amazon Sign In";
        driver.findElement(By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input")).click();
        WebElement phno = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
        phno.sendKeys("8300730877");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
        pass.sendKeys("Akshaya@2003");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
    }
}