package week4.Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		Assignment 2:
//			=============
//			1) Go to https://www.nykaa.com/
//			2) Mouseover on Brands and Search L'Oreal Paris
//			3) Click L'Oreal Paris
//			4) Check the title contains L'Oreal Paris(Hint-GetTitle)
//			5) Click sort By and select customer top rated
//			6) Click Category and click Hair->Click haircare->Shampoo
//			7) Click->Concern->Color Protection
//			8)check whether the Filter is applied with Shampoo
//			9) Click on L'Oreal Paris Colour Protect Shampoo
//			10) GO to the new window and select size as 175ml
//			11) Print the MRP of the product
//			12) Click on ADD to BAG
//			13) Go to Shopping Bag 
//			14) Print the Grand Total amount
//			15) Click Proceed
//			16) Click on Continue as Guest
//			17) Check if this grand total is the same in step 14
//			18) Close all windows
		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.nykaa.com/");
		
		WebElement moveover = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder=new Actions(driver);
		builder.moveToElement(moveover).perform();
		
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		String title = driver.getTitle();
		if(title.contains("L'Oreal Paris"))
		{
		System.out.println("Title is Checked and L'Oreal Paris Contains in the Title");
		}
		else
		{
			System.out.println("Title is Checked and L'Oreal Paris is not Contains in the Title");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[name() = 'svg'][contains(@class, 'arrow-icon')]")).click();
		driver.findElement(By.xpath("(//div[@class='control-indicator radio '])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='category']")).click();
		Thread.sleep(2000);
		
		WebElement findElement1 = driver.findElement(By.xpath("(//li[@class='MegaDropdownHeadingbox']/a)[3]"));
		builder.moveToElement(findElement1).perform();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Shampoo")).click();
		Thread.sleep(8000);
		//driver.findElement(By.xpath("(//*[name() = 'svg'][contains(@class, 'arrow-icon')])[8]")).click();
		//span[text()='Concern']
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allList=new ArrayList<String>(windowHandles);
			
		driver.switchTo().window(allList.get(1));
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("(//label[@for='checkbox_Color Protection_10764']//div)[2]")).click();
		Thread.sleep(3000);
		String colorProtection = driver.findElement(By.xpath("//span[text()='Color Protection']")).getText();
		if(colorProtection.equals("Color Protection"))
		{
			System.out.println("Filter Applied Successfully");
		}
		else
		{
			System.out.println("Filter is not Applied");
		}
		driver.findElement(By.xpath("//div[@id='product-list-wrap']/div[19]/div[1]/div[1]/a[1]/div[2]/div[1]")).click();
		Thread.sleep(3000);
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> allList1=new ArrayList<String>(windowHandles1);
			
		driver.switchTo().window(allList1.get(2));
		
		
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//span[text()='180ml']")).click();
		driver.findElement(By.xpath("//span[text()='180ml']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class=' css-13zjqg6']")).click();
		
		
		
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//button[@class='css-aesrxy']")).click();
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		String Grandtotal = driver.findElement(By.xpath("(//span[@color='#001325'])[2]")).getText();
		System.out.println("Grand Total : "+Grandtotal);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class=' css-1l4d0ex e171rb9k3']")).click();
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		String finaltotal = driver.findElement(By.xpath("//p[@class='css-1e59vjt eka6zu20']")).getText();
		if(finaltotal.equals(Grandtotal))
		{
			System.out.println("Grand Total and Final total was Same");
		}
		else
		{
			System.out.println("Grand Total and Final total was not Same");
		}
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

}
