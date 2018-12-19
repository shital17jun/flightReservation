package mavent1m1;
import mavent1m1.Utilies;
import mavent1m1.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Main_hotel1 {
	
	String  HOTEL="//a[@class='tab-hotel dynamic-hotel-tab-link-desktop']";
String CITY="//input[@id='ss']";
String CITY_SERACH_LISt="//ul[contains(@class,'c-autocomplete__list sb-autocomplete__list sb-autocomplete__list-with_photos -visible')]//span";
//ul[contains(@class,'c-autocomplete__list sb-autocomplete__list sb-autocomplete__list-with_photos -visible')]//span
String DATE_DIV="//div[contains(@class,'xp__dates xp__group')]";
String CHECK_IN="//div[contains(@class,'xp__dates-inner xp__dates__checkin')]";
String CAL_FIRST_TABLE="//div[contains(@class,'bui-calendar__content')]//div[1]//table";
String CAL_SECOND_TABLE="//div[contains(@class,'bui-calendar__content')]//div[2]//table";
String CAL_DIV="//div[contains(@class,'bui-calendar__main')]";
String COUNT="//label[@id='xp__guests__toggle']";
String property="//td[@class='bui-calendar__date']";
String PLUS="//button[@class='bui-button bui-button--secondary bui-stepper__add-button']";
String MINUS="//button[@class='bui-button bui-button--secondary bui-stepper__add-button']";
String SERACH="//button[@type='submit']";
Utilies u=new Utilies();
	public void init() {
		u.gets("https://www.flydubai.com/en/");
	}
	public void Serach_Hotel() {
	
	
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	init();
	String s="http://hotels.flydubai.com/index.en-us.html?aid=947244;label=flydubai-homepage-sb;sid=eaa736655082906e3f451cad515bf2fc;keep_landing=1&sb_price_type=total&";
	u.gets(s);
	//u.findAndClick(HOTEL);
	u.switchtootherwindw();
u.findElement(CITY);
u.windowMaximize();
u.findAndSendKey(CITY, "tex");
u.retrive_List(CITY_SERACH_LISt, 2);

//u.findAndClick(CHECK_IN);
u.findAndClick(CAL_DIV);
u.moveToElement(CAL_FIRST_TABLE);
u.specificDateResult(CAL_FIRST_TABLE, 27, property);
u.findElement(CAL_SECOND_TABLE);
u.specificDateResult(CAL_SECOND_TABLE, 6,property);
u.findAndClick(COUNT);
u.click(SERACH);
	
	
	}
}