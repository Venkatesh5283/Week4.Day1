package week4.Day1;

import java.io.File;
import java.io.*;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.model.Screencast;
import com.mongodb.MapReduceCommand.OutputType;

import dev.failsafe.internal.util.Assert;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		
//		Assignment 1:
//			============
//			1. Launch https://www.snapdeal.com/
//			2. Go to Mens Fashion
//			3. Go to Sports Shoes
//			4. Get the count of the sports shoes
//			5. Click Training shoes
//			6. Sort by Low to High
//			7. Check if the items displayed are sorted correctly
//			8.Select the price range (500-1200)
//			9.Filter with color yellow 
//			10 verify the all applied filters 
//			11. Mouse Hover on first resulting Training shoes
//			12. click QuickView button
//			13. Print the cost and the discount percentage
//			14. Take the snapshot of the shoes.

		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disableNotification");
		ChromeDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.snapdeal.com/");
		
		WebElement onmouse=driver.findElement(By.xpath("//span[contains(text(),' Fashion')]"));
		Actions builder=new Actions(driver);
		builder.moveToElement(onmouse).perform();
		driver.findElement(By.xpath("//span[contains(text(),'Sports Shoes')]")).click();
		String count = driver.findElement(By.xpath("(//div[@class='child-cat-count '])[2]")).getText();
		System.out.println(count);
		driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
		
		String lowvalue = driver.findElement(By.xpath("//input[@name='fromVal']")).getAttribute("value");
		int lowvalue1=Integer.parseInt(lowvalue);
		String highvalue = driver.findElement(By.xpath("//input[@name='toVal']")).getAttribute("value");
		int highvalue1=Integer.parseInt(highvalue);
		if(lowvalue1<highvalue1)
		{
			System.out.println("Items are Sorted Correctly from Low to High Price");
		}
		else
		{
			System.out.println("Items are not Sorted Correctly from Low to High Price");
		}
		
		Thread.sleep(8000);
		driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
		Thread.sleep(8000);
		WebElement findElement1 = driver.findElement(By.xpath("//input[@name='fromVal']"));
		findElement1.clear();
		findElement1.sendKeys("500");
		Thread.sleep(2000);
		WebElement findElement2=driver.findElement(By.xpath("//input[@name='toVal']"));
		findElement2.clear();
		findElement2.sendKeys("1200");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//button[@class='view-more-button btn btn-line btn-theme-secondary viewMoreFilter']")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//label[@for='Color_s-Yellow']")).click();
		
		
		boolean checklowhigh=driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).isSelected();
		if(checklowhigh)
		{
			System.out.println("Low to High sort is Enabled");
		}
		else
		{
			System.out.println("Low to High sort is not Enabled");
		}
		
		String checklowvalue = driver.findElement(By.xpath("//input[@name='fromVal']")).getAttribute("value");
		int checklowvalue1=Integer.parseInt(checklowvalue);
		String checkhighvalue = driver.findElement(By.xpath("//input[@name='toVal']")).getAttribute("value");
		int checkhighvalue1=Integer.parseInt(checkhighvalue);
		if((checklowvalue1==500) || (checkhighvalue1==1200))
		{
			System.out.println("Low value 500 and High Value 1200 is Verified and it was correct");
		}
		else
		{
			System.out.println("Low value 500 and High Value 1200 is Verified and it was not correct");
		}
		boolean checkyellow = driver.findElement(By.xpath("//label[@for='Color_s-Yellow']")).isSelected();
		if(checkyellow)
		{
			System.out.println("Yellow CheckBox is Selected");
		}
		else
		{
			System.out.println("Yellow CheckBox is not Selected");
		}
		Thread.sleep(2000);
		WebElement moveover=driver.findElement(By.xpath("//div[@class='col-xs-6  favDp product-tuple-listing js-tuple ']"));
		builder.moveToElement(moveover).perform();
		driver.findElement(By.xpath("//div[@class='center quick-view-bar  btn btn-theme-secondary  ']")).click();
		String price = driver.findElement(By.xpath("//Span[@class='payBlkBig']")).getText();
		System.out.println("Rs."+price);
		String disprice = driver.findElement(By.xpath("//Span[@class='percent-desc ']")).getText();
		System.out.println("Rs."+disprice);
		Thread.sleep(2000);
		driver.close();
//		File File = ((TakesScreenshot)driver)
//                .getScreenshotAs(OutputType.MERGE);
//
//        String FileName="shoe";
//		FileUtils.copyFile(File,
//                   new File("image location"
//                            + FileName + ".jpeg"));
	

	
	}

}
