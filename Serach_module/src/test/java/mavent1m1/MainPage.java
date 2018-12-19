package mavent1m1;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import mavent1m1.Utilies;
import mavent1m1.*;
public class MainPage
{
	Utilies u=new Utilies();
	String ORIGIN="//*[@id='airport-origin']";
	String DESTINATION ="//input[@id='airport-destination']";
	String MULTICITY ="//a[@id='advanceBooking']";
	String FORMMODEL_DEPATUERDATE ="//input[@id='departureDate']";
	String RETURN_DATE =" //input[@id='return-date']";
	String ADULTS="//select[@id='select-adults-0']";
	String KIDS="//select[@id='select-children-0']";
	String INFANT="//select[@id='select-infants-0']";
	String CLASS="//select[@id='select-flight-class']";
	String  PROMO_CODE="//input[@id='promotion-code']";
	String FIND_FIGHT="//button[@id='find-flights']";
	String AIRPORT_PICKER="//span[contains(@class,'airport-picker')]";
	String AIRPORT_SUGGESTIONS="//span[@class='airport-destination-container']//div[@class='airport-suggestions']";
	String ONEW_WAY="//input[@id='return-trip-0']";
	String SUGGESTION_LIST="//ul[contains(@class,'suggestions-container')]//li/span[1]";
	String MODULE_FOR="//form[contains(@name,'make-a-booking-form')]";
	String ORIGIN_VALUE="//'"+MODULE_FOR+"'//span[contains(@class,'airport-origin-container')]//div[contains(@class,'airport-suggestions')]//span[1]";
	String DESTINATION_VALUES="//span[contains(@class,'airport-destination-container')]//li";
	String DATE="//div[6]//div[1]//table[1]//tbody[1]//tr[2]//td[5]";
	String DATE2="//div[6]//div[1]//table[1]//tbody[1]//tr[2]//td[4]";
	String ONE_WAY="//input[@id='return-trip-0']";
	String RETURN_TRIP="//input[@id='return-trip-1']";
	String  AIRPORT_DESTINATION_ITEM  ="//span[@class='airport-destination-container']//div[@class='airport-suggestions']//li[5]";
	String DATEWIDGETFROM="//div[5]//div[1]//table[1]//tbody[1]";
	String DATEWIDEGETTO="//div[6]//div[1]//table[1]//tbody[1]";
	String ACTIVE_RESULT="//div[@class='boxed-date ng-scope active']";
	String RESULT="//div[@class='boxed-date ng-scope']";
	String CAR="//a[@class='tab-car']";
	WebDriver driver;
	
	WebDriverWait wait;
	Actions action;
	public  String gender=null;
	private WebElement serach1;

	
public void init() {
	u.gets("https://www.flydubai.com/en/");
	
}
	
	public void flightReservation_RoundTrip() {
		init();
		u.findAndClick(FIND_FIGHT);
		u.findElement(DESTINATION);
		u.click(DESTINATION);
		u.moveToElements(AIRPORT_PICKER);
		u.moveToElements(AIRPORT_SUGGESTIONS);
		u.moveToElement(AIRPORT_DESTINATION_ITEM);
		u.moveToElementandClick(AIRPORT_DESTINATION_ITEM);
		u.findAndClick(DATEWIDGETFROM);    
		u.specificDate(DATEWIDGETFROM,29);
		u.findAndClick(DATEWIDEGETTO);
		u.specificDate(DATEWIDEGETTO,30);
		u.selectByIndex(ADULTS, 4);
		u.selectByIndex(KIDS, 2);
		u.selectByIndex(INFANT, 1);
		u.selectByIndex(CLASS,1);
		u.findAndClick(FIND_FIGHT);
		if(u.isDisplayed(ACTIVE_RESULT)) {
			u.click(ACTIVE_RESULT);
		}
		else
			if(u.isDisplayed(RESULT))
				u.click(RESULT);
			System.out.println("Sorry, there are no flights available on the date you've selected. Please choose another date from the table above to view available flights and fares.");
		}
	
	public void flightReservation_One_Way_Trip() {
		init();
		u.findAndClick(FIND_FIGHT);
		u.findElement(DESTINATION);
		u.click(DESTINATION);
		u.moveToElements(AIRPORT_PICKER);
		u.moveToElements(AIRPORT_SUGGESTIONS);
		u.moveToElement(AIRPORT_DESTINATION_ITEM);
		u.moveToElementandClick(AIRPORT_DESTINATION_ITEM);
		u.moveToElement(ONE_WAY);
		
		//u.findAndClick(ONE_WAY);
		u.findAndClick(DATEWIDGETFROM);    
		u.specificDate(DATEWIDGETFROM,29);
		u.selectByIndex(ADULTS, 4);
		u.selectByIndex(KIDS, 2);
		u.selectByIndex(INFANT, 1);
		u.selectByIndex(CLASS,1);
		u.findAndClick(FIND_FIGHT);
		if(u.isDisplayed(ACTIVE_RESULT)) {
			u.moveToElement(ACTIVE_RESULT);
			u.findAndClick(ACTIVE_RESULT);
			}
		else
			if(u.isDisplayed(RESULT))
				u.click(RESULT);
			System.out.println("Sorry, there are no flights available on the date you've selected. Please choose another date from the table above to view available flights and fares.");
		}
	}
	


	