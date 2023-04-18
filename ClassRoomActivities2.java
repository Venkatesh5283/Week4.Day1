package week4.Day1;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ClassRoomActivities2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--diableNotification");
		ChromeDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://erail.in/");
		
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		from.sendKeys("ms",Keys.ENTER);
		
		WebElement to = driver.findElement(By.id("txtStationTo"));
		to.clear();
		to.sendKeys("co",Keys.ENTER);
		Thread.sleep(2000);
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		Thread.sleep(3000);
		
		List<WebElement> namelist = driver.findElements(By.xpath("//div[@id='divTrainsList']/table/tbody/tr/td[2]"));
		int namesize=namelist.size();
		for(int i=1;i<namesize;i++)
		{
			String trainname=driver.findElement(By.xpath("//div[@id='divTrainsList']/table/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(trainname);
		}
		Thread.sleep(5000);
		driver.close();
		
	}

}
