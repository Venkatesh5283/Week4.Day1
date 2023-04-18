package week4.Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ClassRoomActivities {

	public static void main(String[] args) {
		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--diableNotification");
		ChromeDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/draggable/");
		
		driver.switchTo().frame(0);
		WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']/p"));
		Actions builder=new Actions(driver);
		builder.dragAndDropBy(drag, 183, 150).perform();
		
		
	}

}
