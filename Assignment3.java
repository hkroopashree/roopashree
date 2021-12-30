package SeleniumBasics;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {

	  System.setProperty("webdriver.chrome.driver","C:\\SeleniumBrowserDrivers\\chromedriver.exe");
      WebDriver driver = new ChromeDriver();       
      driver.manage().window().maximize();
//      1. On Zero Bank app
//      Automate 'Purchase foreign currency cash' flow by keeping all the field empty and click on 'purchase' button.
//      It will give an Alert, you have to handle it.
      driver.get("http://zero.webappsecurity.com/");
      assertEquals(driver.getTitle(),"Zero - Personal Banking - Loans - Credit Cards");
      driver.findElement(By.tagName("button")).click();
      driver.findElement(By.cssSelector("#user_login")).sendKeys("username");
      driver.findElement(By.id("user_password")).sendKeys("password");
      driver.findElement(By.name("submit")).click();
      driver.findElement(By.id("details-button")).click();
      driver.findElement(By.linkText("Proceed to zero.webappsecurity.com (unsafe)")).click();
      driver.findElement(By.partialLinkText("Pay Bil")).click();
      driver.findElement(By.xpath("//a[contains(@href ,'#ui-tabs-3')]")).click();
      Thread.sleep(1000);
      driver.findElement(By.id("purchase_cash")).click();
      Alert purchaseAlert = driver.switchTo().alert();
      String alertText = purchaseAlert.getText();
      System.out.println("The text on the Alert box is -' "+ alertText +"'");
      purchaseAlert.accept();
      driver.findElement(By.xpath("(//*[@class = 'dropdown-toggle'])[2]")).click();
      driver.findElement(By.xpath("//a[@id='logout_link']")).click();
     
//      ========== 2nd Question
//      2. On naukri.com
//      on home page handle location confirmation popup // Handle in W3schools
      
//      driver.navigate().to("https://www.naukri.com/");
//      assertEquals(driver.getTitle(),"Jobs - Recruitment - Job Search - Employment -Job Vacancies - Naukri.com");
//      driver.findElement(By.xpath("//h2[contains(text(),'Best Places to Work')]")).click();
//      Thread.sleep(4000);
//      
//      Alert locationConfirm = driver.switchTo().alert();
//      String confirmText = locationConfirm.getText();
//      System.out.println("The text on the confirmation pop up is -' "+ confirmText +"'");
//      Thread.sleep(2000);
//      locationConfirm.accept();
//      Thread.sleep(2000);
//      //assertEquals(driver.findElement(By.id("result")).getText(),"You clicked: Ok","Failed - confirmation!! ");
     
        driver.navigate().to("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm");
        Thread.sleep(1000);
        assertEquals(driver.getTitle(),"Tryit Editor v3.7");
        driver.findElement(By.id("runbtn")).click();
        WebElement iframe = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(iframe);
         driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
        Alert jsConfirm = driver.switchTo().alert();
        String confirmText = jsConfirm.getText();
        System.out.println("The text on the confirmation pop up is -' "+ confirmText +"'");
        Thread.sleep(2000);
        jsConfirm.accept();
        Thread.sleep(2000);
       
        

      
        //3.  On naukri.com
        //click on company brand logs, it will open child window, handle those multiple windows.
        driver.navigate().to("https://www.naukri.com/");
        assertEquals(driver.getTitle(),"Jobs - Recruitment - Job Search - Employment -Job Vacancies - Naukri.com");    
        String pHandle = driver.getWindowHandle();
        System.out.println(pHandle);
        driver.findElement(By.className("bannerItemLink")).click();
        Thread.sleep(2000);
        Set <String> handles = driver.getWindowHandles();
        System.out.println(handles);
        Thread.sleep(2000);
        
        for(String h : handles) {
        	System.out.println("the value of current handle is ----"+ h);
        	driver.switchTo().window(h);
        	System.out.println(driver.getTitle());
        	
        	Thread.sleep(2000);
        }
        		
      driver.switchTo().window(pHandle);
      
      Thread.sleep(3000);
      driver.close();

      // kill/quit driver
      driver.quit();

	}

}
