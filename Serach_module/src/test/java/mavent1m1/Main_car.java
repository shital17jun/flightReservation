package mavent1m1;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main_car {
	String CAR="//a[@class='tab-car']";
	String PICKUP_LOCATION ="//input[@id='ct_s1_pickup_loc']";
	String PICKUP_DATE="//input[@id='ct_s1_pickup_date']";
	String CALENDER_ICON1="//i[@id='ct_s1_pickup_date_cal']";
	String CALENDER_ICON2="//i[@id='ct_s1_dropoff_date_cal']";
	String DATA_PICKER_FIRST="//div[contains(@class,'ui-datepicker-group ui-datepicker-group-first')]//a[contains(@href,'#')][contains(text(),'24')]";
	String DATA_PICKER_LAST="//div[contains(@class,'ui-datepicker-group ui-datepicker-group-last')]//a[contains(@href,'#')][contains(text(),'24')]";
	String  DROPOFF_TIME="//select[@id='ct_s1_dropoff_time']";
	String DROPOFF_DATE="//input[@id='ct_s1_dropoff_date']";
	String  PICKUP_TIME="//select[@id='ct_s1_pickup_time']";
	String CALENDR_DIV="//div[@id='ui-datepicker-div']";
	String SERACH="//button[@id='ct_s1_search_button']";
	String SELECT_FIRST="//button[contains(text(),'Select')]";
	String RETURN_DIFFERNT="//i[@class='ct-icon-checkmark-square']";
	String RETURN_LOCATION="//label[contains(.,'Return to a different location')]";
	String DROP_UP_LOCATION="//input[@id='ct_s1_dropoff_loc']";
	String PICK_UP="//input[@id='pickupLocation']";
	String PICK_UP_LIST="//ul[@id='div-options-id-0']//span[2]";
	String DROP_UP="//input[@id='returnLocation']";
	String DROP_UP_LIST="//ul[@id='div-options-id-1']//span[2]";
	//div[contains(@placeholder,'Start date')]
	String  SERACH_RESULT_RETURN_DATE="//div[@input-id='returnDate']";
	String SERACH_RESULT_PICKUP_DATE="//input[@id='pickupDate']";
	String SERACH_RESULT_CAL_DIV="//div[contains(@class,'ct-datepicker ct-calendar__dynamic-datepicker')]";
	String SERACH_RESULT_FIRST_TABEL="//div[contains(@class,'ct-datepicker ct-calendar__dynamic-datepicker')]//div[1]/table";
	String SERACH_RESULT_SECOND_TABEL="//div[contains(@class,'ct-datepicker ct-calendar__dynamic-datepicker')]//div[2]/table";
	String SERACH_RESULT_PICKUP_TIME="//input[@id='pickupTime']";
	String SERACH_RESULT_RETURN_TIME="//input[@id='returnTime']";
	String SERACH_RESULT_PICKUP_TIME_LIST="//ct-time-picker-custom[contains(@name,'pickupTime')]//a";
	String SERACH_RESULT_RETURN_TIME_LIST="//ct-time-picker-custom[contains(@name,'returnTime')]//a";
	String property="//td[@data-comp-id='ct-calendar-date-true']";
	//td[@data-comp-id='ct-calendar-date-true']
	
	Utilies u=new Utilies();
	
	public void init() {
		u.gets("https://www.flydubai.com/en/");
	}
	
	
	public void car_Serach() {
		WebDriver driver;
		WebDriverWait wait;
		Actions action;
		init();
		u.click(CAR);
		u.switchtootherwindw();
		u.findElement(PICKUP_LOCATION);
		u.findAndSendKey(PICKUP_LOCATION, "Mexico City - Benito Juárez Intl Airport ");
		String text="//a[contains(.,'Mexico City - Benito Juárez Intl Airport')]";
		u.click(text);
		//ul[@id='ui-id-1']//a//following::label
		//u.findAndClick(CALENDER_ICON1);
		u.findElement(PICKUP_DATE).clear();
		u.findAndSendKey(PICKUP_DATE, "21/11/2018").sendKeys(Keys.RETURN);
		u.selectByIndex(PICKUP_TIME, 5);
		u.findElement(DROPOFF_DATE).clear();
		u.findAndSendKey(DROPOFF_DATE, "25/11/2018").sendKeys(Keys.RETURN);
		u.selectByIndex(DROPOFF_TIME, 5);
		u.findAndClick(SERACH);
		//Select first 
		u.findAndClick(SELECT_FIRST);
	}
	
	public void car_Serach_different(String location) {
		WebDriver driver;
		WebDriverWait wait;
		Actions action;
		init();
		u.click(CAR);
		u.switchtootherwindw();
		u.findElement(PICKUP_LOCATION);
		u.findAndSendKey(PICKUP_LOCATION, "Mexico City - Benito Juárez Intl Airport ");
		String text="//a[contains(.,'Mexico City - Benito Juárez Intl Airport')]";
		u.click(text);
		u.moveToElement(RETURN_LOCATION);
		u.clickAndHold(RETURN_LOCATION);
		u.findElement(DROP_UP_LOCATION);
		u.findAndSendKey(DROP_UP_LOCATION, location);
		String text1="//a[contains(.,'McAllen Miller International Airport (Texas)')]";
		u.click(text1);
		u.findElement(PICKUP_DATE).clear();
		u.findAndSendKey(PICKUP_DATE, "24/11/2018").sendKeys(Keys.RETURN);
		u.selectByIndex(PICKUP_TIME, 5);
		u.findElement(DROPOFF_DATE).clear();
		u.findAndSendKey(DROPOFF_DATE, "25/11/2018").sendKeys(Keys.RETURN);
		u.selectByIndex(DROPOFF_TIME, 5);
		u.findAndClick(SERACH);
		//Select first 
		if(u.isDisplayed(SELECT_FIRST)) {
			u.click(SELECT_FIRST);
		}
		else 
			System.out.println("Serach have no result");
		 u.windowMaximize();
		 //u.findAndClick(PICK_UP);
		 u.waitandClick(PICK_UP );
		u.findAndSendKey(PICK_UP,"tex");
		 u.retrive_List(PICK_UP_LIST, 5);
		 //u.findAndClick(DROP_UP);
		 u.waitandClick(DROP_UP);
		 u.clear(DROP_UP);
		 u.findAndSendKey(DROP_UP," texas");
		 u.retrive_List(DROP_UP_LIST, 5);
		 u.findAndClick(SERACH_RESULT_PICKUP_DATE);
		 u.findElement(SERACH_RESULT_CAL_DIV);
		 u.specificDateResult(SERACH_RESULT_FIRST_TABEL,25,property);
		 u.moveToElement(SERACH_RESULT_RETURN_DATE);
		 u.findAndClick(SERACH_RESULT_RETURN_DATE);
		 u.findElement(SERACH_RESULT_CAL_DIV);
		u.specificDateResult(SERACH_RESULT_SECOND_TABEL, 6,property);
		//u.findAndSendKey(SERACH_RESULT_RETURN_DATE,"Keys.RETURN");
		//u.findAndClick(SERACH_RESULT_PICKUP_TIME);
		u.implicitWait();
		u.retrive_List(SERACH_RESULT_RETURN_TIME_LIST, 7);
		u.findAndClick(PICKUP_TIME);
		u.retrive_List(SERACH_RESULT_PICKUP_TIME_LIST, 6);
	
	}


}