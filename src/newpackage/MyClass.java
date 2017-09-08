package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MyClass 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","/Users/jackson/eclipse-workspace/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//Simple test case to check if title is correct and display it
		String baseUrl = "https://accounts.housing.com/";
        String expectedTitle = "Employees | Housing.com";
        String actualTitle = "";
        driver.get(baseUrl);
        actualTitle = driver.getTitle();
        if (actualTitle.contentEquals(expectedTitle))
        {
            System.out.println("Test Passed!");
        } else 
        {
            System.out.println("Test Failed");
        }
        
        driver.findElement(By.id("employee_email")).sendKeys("jackson.chelote@housing.com");
        driver.findElement(By.id("employee_password")).sendKeys("cagexander");
        driver.findElement(By.name("commit")).click();
        driver.findElement(By.xpath("//a[@href='https://flats.housing.com/admin/flats']")).click();  
        try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        WebElement cityid = driver.findElement(By.id("token-input-city_id"));
        Actions cityidbuilder = new Actions(driver);
        Action cityidbuilderaction = cityidbuilder.sendKeys(cityid, "Mumbai").pause(1500).sendKeys(cityid, "\ue004").build();
        cityidbuilderaction.perform();
        
        driver.findElement(By.xpath("//a[@href='/admin/flats/new?city_id=1']")).click();  
        driver.findElement(By.id("profile_type_broker")).click();
        driver.findElement(By.className("btn-success")).click();
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        WebElement usernumber = driver.findElement(By.cssSelector("input[id *=token-input-flat_user_flats]"));
        Actions usernumberbuilder = new Actions(driver);
        Action usernumberactionaction = usernumberbuilder.sendKeys(usernumber, "9967345427").pause(1500).sendKeys(usernumber, "\ue004").build();
        usernumberactionaction.perform();
        
        WebElement userstatus = driver.findElement(By.cssSelector("input[value='ACTIVE']"));
        userstatus.click();
        
        WebElement userpitch = driver.findElement(By.cssSelector("input[id *='flat_details_pitch']"));
        userpitch.sendKeys("Pitch");
        
        WebElement userisrent = driver.findElement(By.cssSelector("input[id *='is_rent']"));
        userisrent.click();
        
        

        
        
       // driver.close();

	}
}
