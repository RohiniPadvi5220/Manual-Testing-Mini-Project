package insurance;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.google.common.io.Files;

public class Health_insurance {

	public static void main(String[] args) throws InterruptedException, IOException {
		//Launch the browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Ashok\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		
		d.get("https://www.policybazaar.com/");
		Thread.sleep(3000);
		
		//get url
		d.getCurrentUrl();
		System.out.println("Current URL IS:" + d.getCurrentUrl());
		
		//get title of page
		d.getTitle();
		System.out.println("Title of page is:" + d.getTitle());
		
		//Click on main health insurance icon
		d.findElement(By.xpath("//body/cclink[1]/main[1]/div[2]/section[1]/div[2]/a[1]/div[1]")).click();
		Thread.sleep(3000);
		
		//Click on gender,name,no.
		d.findElement(By.xpath("//body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[3]/form[1]/div[1]/div[1]/div[1]/label[2]/p[1]")).click();
		d.findElement(By.id("fullname")).sendKeys("Rohini");
		d.findElement(By.id("pmobile")).sendKeys("8888888888");
		Thread.sleep(2000);
		
		//click on continue button
		d.findElement(By.className("btn")).click();
		Thread.sleep(3000);
		
		//Select family plan for me
		d.findElement(By.xpath("//body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/label[1]/p[1]")).click();
	    
		//select age
		WebElement age=d.findElement(By.id("eldestMemberAge"));
		Select s=new Select(age);
		s.selectByValue("26");
		Thread.sleep(2000);
		
		//click on continue button.
		d.findElement(By.className("btn")).click();
		Thread.sleep(3000);
		
		//Enter city and continue.
		d.findElement(By.id("txtcity")).sendKeys("Pune");
		Thread.sleep(3000);
		d.findElement(By.className("active")).click();
		Thread.sleep(2000);
		
		//Do you take any daily medication? Click on No option
		d.findElement(By.id("nopedselection")).click();
		Thread.sleep(3000);
		
		//Click on sort by functionality.Select low premiun and apply
		d.findElement(By.id("QuoteSorting")).click();
		d.findElement(By.id("SortLow")).click();
        Thread.sleep(2000);
		d.findElement(By.className("apply_button")).click();
		
		//Click on ClickInsurerList functionality.Select insurance provider company and apply
		d.findElement(By.id("ClickInsurerList")).click();
	    d.findElement(By.xpath("(//*[contains(@id,'SelectOneInsurer')])[2]")).click();
	    Thread.sleep(2000);
		d.findElement(By.xpath("(//*[contains(@class,'apply_button')])[1]")).click();
		
		
		//Click on cover functionality.Select range and apply
		d.findElement(By.xpath("//*[contains(@id,'SumInusredFilter')]")).click();
		d.findElement(By.xpath("//span[contains(text(),'₹ 3 - ₹ 5 Lacs')]")).click();
		Thread.sleep(2000);
		d.findElement(By.id("ApplySIFilter")).click();
		
		//Click on Features.Click on conditions and apply
		d.findElement(By.id("FeaturesFilter")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//body/div[@id='root']/div[1]/div[3]/div[4]/div[2]/div[2]/div[1]/div[1]/div[1]/label[1]/span[1]")).click();
		d.findElement(By.xpath("//body/div[@id='root']/div[1]/div[3]/div[4]/div[2]/div[2]/div[1]/div[2]/div[1]/label[1]/span[1]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//*[contains(@class,'apply_button')])[3]")).click();
		
		//Click on premium.Select range and apply.
		d.findElement(By.id("ClickOnPremiumFilter")).click();
	    d.findElement(By.xpath("//span[contains(text(),'₹ 300 - ₹ 500')]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//*[contains(@class,'apply_button')])[4]")).click();
		
		
		//Click on plan filter and select base plan
		d.findElement(By.xpath("(//*[contains(@id,'ClickonPlanFilter')])[2]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//span[contains(text(),'Base Plans')])[2]")).click();
		Thread.sleep(2000);
		
		System.out.println("Successfully displayed the Insurance Plans per month");
		
		//Take screenshot of displayes premium plans of health insurance
        TakesScreenshot t=(TakesScreenshot)d;
		File scr=t.getScreenshotAs(OutputType.FILE);
		Files.copy(scr, new File ("C:\\Users\\Ashok\\Pictures\\Saved Pictures\\picture.png"));
        Thread.sleep(2000);
        
        
        //Click on edit members and close
        d.findElement(By.xpath("(//*[contains(@class,'edit_insured_member')])[1]")).click();
        Thread.sleep(2000);
        d.findElement(By.xpath("(//*[contains(@class,'close_button')])[1]")).click();
         
        
		//for scroll down and scroll up
        JavascriptExecutor js =(JavascriptExecutor)d;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		
		
		//Mousehovr to the Call Us button
		Actions A=new Actions(d);
		A.moveToElement(d.findElement(By.xpath("//*[contains(@class,'toll-link')]"))).perform();
		Thread.sleep(2000);
		
		//count no. of links available on page.
		List<WebElement> Links= d.findElements(By.tagName("a"));
	    int Total_links=Links.size();
	    System.out.println("Total links are:" + Total_links);
	    
	    
	    //count no. of buttons available on page
	    List<WebElement> button= d.findElements(By.tagName("input"));
	    int Total_buttons=button.size();
	    System.out.println("Total buttons are:" + Total_buttons);
	    
	    //Click on rs 552/month plan by care health insurance.
	    d.findElement(By.xpath("(//*[contains(@id,'ProceedToProduct')])[1]")).click();
        Thread.sleep(2000);
        
        //navigate back to the page
        d.navigate().back();
        
        //close the current window
	    d.close();

		
	}

}
