package cia1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T1
{
	public static void main(String[] args) 
	{
      ChromeOptions co=new ChromeOptions();
      co.addArguments ("--remote-allow-origins=*");
      WebDriverManager.chromedriver().setup ();
      WebDriver driver=new ChromeDriver();
      driver.get ("https://www.saucedemo.com/");
      driver.manage().window().maximize();
      driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
      driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
      driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
      String initial = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
      driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
      String cart =  driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
      if(cart.equals(initial)) {
		System.out.println("successfully product added to the cart");
      }
      else 
      {
		System.out.println("oops");
      }
      String check_cart = driver.findElement(By.xpath("//*[@id=\"continue-shopping\"]")).getText();
      System.out.println(check_cart);
      if(check_cart.equals("Continue Shopping")) {
    	  System.out.println("Shoping... ");		
      }
      else 
      {
		System.out.println("oops");
      }
      driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
      String checkout = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
      if(checkout.equals("Checkout: Your Information")) 
      {
		System.out.println("Details Available");
      }
      else 
      {
		System.out.println("oops");
      }
      driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Akshaya");
      driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Hariram");
      driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("628008");
      driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
      String pro_name = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText(); 
      String pro_price = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
      if(pro_name.equals(cart)) 	
      {
		System.out.println("Overview");
		System.out.println("Product Name: "+pro_name);
		System.out.println("Product Price: "+pro_price);
      }
      else 
      {
		System.out.println(cart);
		System.out.println(pro_name);
      }
      String title = driver.getTitle();
      if(title.equals("Swag Labs")) 
      {
    	  System.out.println("Title Matched");
      }
      else 
      {
		System.out.println("title mismatched");
      }
      if(driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-two.html")) 
      {
    	  System.out.println("url matched");
      }
      else 
      {
		System.out.println("url mismatched");
      }
   }
}