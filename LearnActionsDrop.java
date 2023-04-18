package week4.Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class LearnActionsDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--diableNotification");
		ChromeDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/droppable/");
		
		driver.switchTo().frame(0);
		WebElement Source=driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement Target=driver.findElement(By.xpath("//p[text()='Drop here']"));
		Actions builder=new Actions(driver);
		builder.dragAndDrop(Source, Target).perform();
	}

}
