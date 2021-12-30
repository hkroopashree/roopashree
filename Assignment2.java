package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\SeleniumBrowserDrivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();       
		driver.manage().window().maximize();
		driver.get("http://zero.webappsecurity.com/");
		//--------By tagname
        driver.findElement(By.tagName("button")).click();
        //-------- By CSS selector #id
        driver.findElement(By.cssSelector("#user_login")).sendKeys("username");
        //--------by id
        driver.findElement(By.id("user_password")).sendKeys("password");
        //--------By name
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.id("details-button")).click();
        //--------by link text
        driver.findElement(By.linkText("Proceed to zero.webappsecurity.com (unsafe)")).click();
        //---- by partial link text
        driver.findElement(By.partialLinkText("Pay Bil")).click();
        //xpath with contains() with href
        driver.findElement(By.xpath("//a[contains(@href ,'#ui-tabs-2')]")).click();
        Thread.sleep(1000);
        //-------by Relative xpath   
        WebElement payeeName =  driver.findElement(By.id("np_new_payee_name"));
        		payeeName.sendKeys("Richie"); 
       // -----------by css selector #id
        driver.findElement(By.cssSelector("#np_new_payee_address")).sendKeys("S S puram, Tumkur");   
        // ----------Absolute xpath
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/article[1]/fieldset[1]/div[3]/div[1]/input[1]")).sendKeys("Account123456");
        //------------. sign
        driver.findElement(By.xpath(".//input[@id='np_new_payee_details']")).sendKeys("Details234");
        // --------- css selector tag#id
        driver.findElement(By.cssSelector("input#add_new_payee")).click();
        //----------xpath with contains() with text
        driver.findElement(By.xpath("//a[contains(text(),'Zero Bank')]")).click();
        Thread.sleep(2000);
        //------- by xpaths
        driver.findElement(By.xpath("(//*[@class = 'dropdown-toggle'])[2]")).click();
        driver.findElement(By.xpath("//a[@id='logout_link']")).click();
		Thread.sleep(2000);
		
		//======Feedback Form

		//Feedback Form
		driver.findElement(By.xpath("//strong[contains(text(),'Feedback')]")).click();
		Thread.sleep(1000);
		//----------cssSelector("[type = 'value']")
		driver.findElement(By.cssSelector("[placeholder = 'Your Name']")).sendKeys("Richie");
		//----------cssSelector("tag[type = 'value']")
		driver.findElement(By.cssSelector("input[placeholder = 'Your email address']")).sendKeys("xyz@abc.com");
		driver.findElement(By.id("subject")).sendKeys("Registration page not available");
		driver.findElement(By.id("comment")).sendKeys("Registration page not available for login page");
		driver.findElement(By.name("submit")).click();
		
		driver.close();

		// kill/quit driver
		driver.quit();

	}
}
