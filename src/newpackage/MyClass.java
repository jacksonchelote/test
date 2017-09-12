package newpackage;

//import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.util.Calendar;


public class MyClass 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","/Users/jackson/eclipse-workspace/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
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
        WebElement userbroker = driver.findElement(By.id("profile_type_broker"));
        userbroker.click();
        
        
        driver.findElement(By.xpath("//A[@class='btn btn-success add_fields'][text()='Add new associated user']")).click();
        //driver.findElement(By.className("btn-success")).click();
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id *=token-input-flat_user_flats]")));

        
        WebElement usernumber = driver.findElement(By.cssSelector("input[id *=token-input-flat_user_flats]"));
        Actions usernumberbuilder = new Actions(driver);
        Action usernumberaction = usernumberbuilder.sendKeys(usernumber, "9967345427").pause(5000).sendKeys(usernumber, "\ue004").build();
        usernumberaction.perform();
        
        WebElement userstatus = driver.findElement(By.cssSelector("input[value='ACTIVE']"));
        userstatus.click();
        
        WebElement userpitch = driver.findElement(By.cssSelector("input[id *='flat_details_pitch']"));
        userpitch.sendKeys("Pitch");
        
        WebElement userisrent = driver.findElement(By.cssSelector("input[id *='is_rent']"));
        userisrent.click();
        
        WebElement rentprice = driver.findElement(By.cssSelector("input[class *='numeric integer optional rent_value rent_input']"));
        rentprice.sendKeys("90000");
        
        WebElement rentbrokerage = driver.findElement(By.cssSelector("input[class *='numeric integer required _brokerage rent_input']"));
        rentbrokerage.sendKeys("25000");
        
        WebElement securitydeposit = driver.findElement(By.cssSelector("input[class *='numeric integer required rent_input']"));
        securitydeposit.sendKeys("350000");

        
        
        /* Code to add one more user...Need to check on how to add with same id
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollTo(0,0)");
        
        
        
        WebElement userowner = driver.findElement(By.id("profile_type_user"));
        userowner.click();
        driver.findElement(By.className("btn-success")).click();
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        
        
        js.executeScript("window.scrollBy(0,500)");
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        WebElement usernumber2 = driver.findElement(By.cssSelector("input[id *=token-input-flat_user_flats]"));
        Actions usernumberbuilder2 = new Actions(driver);
        Action usernumberactionaction2 = usernumberbuilder2.sendKeys(usernumber2, "9967345427").pause(1500).sendKeys(usernumber2, "\ue004").build();
        usernumberactionaction2.perform();
 */
        
        
        
        WebElement localityid = driver.findElement(By.id("token-input-flat_locality_id"));
        Actions localityidbuilder = new Actions(driver);
        Action localityidaction = localityidbuilder.sendKeys(localityid, "Powai").pause(1500).sendKeys(localityid, "\ue004").build();
        localityidaction.perform();
        
        //Code not working to enter LR ID
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0,250)");
        
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        WebElement lrID = driver.findElement(By.xpath("//INPUT[@class='string optional mb-input']"));
        Actions lridbuilder = new Actions(driver);
        Action lridaction = lridbuilder.click().sendKeys(lrID, "24536").sendKeys(lrID, "\ue007").build();
        lridaction.perform();
        
        //Code not working to enter LR ID

        driver.findElement(By.id("flat_latitude")).sendKeys("19.111312");
        driver.findElement(By.id("flat_longitude")).sendKeys("72.908422");
        driver.findElement(By.id("flat_floor_number")).sendKeys("3");
        driver.findElement(By.id("flat_flat_number")).sendKeys("B3");
        driver.findElement(By.id("flat_building_name")).sendKeys("Supreme Business Park");
        driver.findElement(By.id("flat_wing")).sendKeys("B");
        driver.findElement(By.id("flat_street")).sendKeys("South Avenue");
        driver.findElement(By.id("flat_landmark")).sendKeys("Kensington");
        driver.findElement(By.id("flat_block")).sendKeys("Hiranandani");
        
        Select drpPropertytype = new Select(driver.findElement(By.name("flat[property_type_id]")));
        drpPropertytype.selectByVisibleText("Apartment");
        
        Select drpApartmenttype = new Select(driver.findElement(By.name("flat[apartment_type_id]")));
        drpApartmenttype.selectByVisibleText("5 BHK");
        
       WebElement addbedroom = driver.findElement(By.xpath("//A[@class='btn btn-success add_fields'][text()='add bedroom']"));
        addbedroom.click();
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        WebElement attachbathroom = driver.findElement(By.xpath("//A[@class='btn btn-success add_fields'][text()='add attached bathroom']"));
        attachbathroom.click();
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
      /*
       Unable to click on bathroom types
       WebElement attachbathroomwestern = driver.findElement(By.xpath("//INPUT[@id='flat_bedrooms_attributes_1505129283949_bathrooms_attributes_1505129285238_toilet_type_id_2']"));
      attachbathroomwestern.click();
      */
        WebElement commonbathroom = driver.findElement(By.xpath("//A[@class='btn btn-success add_fields'][text()='add common bathroom']"));
        commonbathroom.click();
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Select drpMainEntrance = new Select(driver.findElement(By.xpath("//SELECT[@id='flat_flat_details_main_entrance_facing']")));
        drpMainEntrance.selectByVisibleText("South");
        
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_built_up_area']")).sendKeys("1650");
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_carpet_area']")).sendKeys("1020");
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_plot_area']")).sendKeys("1500");
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_floor_height']")).sendKeys("2.0");
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_maintenance_charges_buy']")).sendKeys("15000");
        
        
        driver.findElement(By.xpath("//INPUT[@id='has_parking_true']")).click();
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_visitor_parking_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_parking_count']")).sendKeys("2");
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_parking_type_id_3']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_parking_slot_rent']")).sendKeys("9000");
        
        
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_has_swimming_pool_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_has_gym_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_has_garden_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_is_gated_community_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_has_servant_room_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_has_lift_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_has_kids_area_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_has_sports_facility_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_has_gas_pipeline_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_has_intercom_true']")).click();
        
        
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_age_of_property']")).sendKeys("8");
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_floor_count']")).sendKeys("30");
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_number_of_lifts']")).sendKeys("3");
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_lift_type_id_1']")).click();
        
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_employee_comments']")).sendKeys("Employee Comments");
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_power_backup_type_id_3']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_water_supply_type_id_35']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_security_type_id_3']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_flooring_type_id_6']")).click();
        
        WebElement availablefromdate = driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_available_from']"));
        availablefromdate.click();
        availablefromdate.click();
        
        //need to click somewhere on form to hide date
        driver.findElement(By.xpath("(//LABEL[@class='radio_buttons required control-label'])[20]")).click();
        
        
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_show_contextual_address_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_overidden_address_value']")).sendKeys("Contextual Address");
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_show_loan_option_true']")).click();
        
        
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_lock_in_period']")).sendKeys("12");
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_lease_type_ids_1']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_lease_type_ids_2']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_lease_type_ids_3']")).click();
        
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_furnish_type_id_1']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_maintenance_charges_rent']")).sendKeys("9000");
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_ac_count']")).sendKeys("5");
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_tv_count']")).sendKeys("2");
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_bed_count']")).sendKeys("4");
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_cupboard_count']")).sendKeys("5");
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_geyser_count']")).sendKeys("1");
        
        
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_has_sofa_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_has_dining_table_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_has_washing_machine_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_has_microwave_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_has_stove_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_has_fridge_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_has_water_purifier_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_has_cctv_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_has_clubhouse_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_has_community_hall_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_has_regular_water_supply_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_has_vastu_compliant_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_owner_time_of_availability_3']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_owner_in_same_building_true']")).click();
        driver.findElement(By.xpath("//INPUT[@id='flat_flat_details_pet_allowed_true']")).click();
        
        
        
        WebElement broadband = driver.findElement(By.xpath("//INPUT[@id='token-input-flat_flat_details_broadband_ids']"));
        Actions broadbandbuilder = new Actions(driver);
        Action broadbandaction = broadbandbuilder.click().sendKeys(broadband, "ace").pause(2500).pause(1500).sendKeys(broadband, "\ue007").build();
        broadbandaction.perform();

        
        
        WebElement datacollector = driver.findElement(By.xpath("//INPUT[@id='token-input-flat_data_collector_id']"));
        Actions datacollectorbuilder = new Actions(driver);
        Action datacollectoraction = datacollectorbuilder.click().sendKeys(datacollector, "dummy").pause(2500).sendKeys(datacollector, "\ue007").build();
        datacollectoraction.perform();
        
        driver.findElement(By.xpath("//INPUT[@id='flat_is_uc_property_false']")).click();
        
        
        
		
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       // driver.close();

	}
}
