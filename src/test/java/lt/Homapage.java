package lt;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Homapage {
	public static void main(String [] args) throws InterruptedException, IOException, TesseractException {
		WebDriver driver= new ChromeDriver();
		
		try {
		driver.manage().window().maximize();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://partners.lntecc.com/PartnerMgmtApp/login");
		
		WebElement username = driver.findElement(By.xpath("//*[@id=\"Username\"]"));
		username.sendKeys("gypso");
		WebElement pass = driver.findElement(By.xpath("//input[@onpaste=\"return false\"]"));
		pass.sendKeys("Gypso@1308");
		
	
		WebElement imagelement = driver.findElement(By.xpath("//canvas[@class=\"vue-captcha-img\"]"));
		File src = imagelement.getScreenshotAs(OutputType.FILE);
		String path = "F:\\javafile_october\\com.lt\\captchaimages\\captcha.png";
		
		FileHandler.copy(src, new File(path));
		
		Thread.sleep(2000);
		
		ITesseract image = new Tesseract();
		
		String str = image.doOCR(new File(path));
		
		System.out.println("image OCR done ");
		System.out.println(str);
		

		WebElement login = driver.findElement(By.xpath("//div[@class=\"card logincard card-layout\"]"));
		login.click();
		
		}catch(Exception e) {
			System.out.println("exception caught : "  +e.getMessage());
		}
		

		//WebElement login = driver.findElement(By.xpath("//div[@class=\"card logincard card-layout\"]"));
		//login.click();
		//System.out.println("jksbdkuawsd");

}
}
