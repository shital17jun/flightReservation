package mavent1m1;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Main_holiday {
Utilies u=new Utilies();
String HOLIDAY="//a[@class='tab-holidays tab-nav']";
String FROM="//input[@id='search-b2c-from--surf-type-ahead-1-3']";
String TO="//input[@id='search-b2c-to--surf-type-ahead-1-3']";
String FROM1="//div[@class='surf-input has-value']";
String FROM_DIV="//div[@class='surf-type-ahead__suggetion active']";
String COMMOM_LIST="//div[@class='surf-type-ahead__suggetion active']//span[1]";
String FROM_LIST_BOX="//div[@class='surf-type-ahead__suggetion active']";
String DATES="//i[@class='fa fa-calendar fz-search-form-input__icon']";
String CHECK_IN_DATE="//div[@id='calendar-right']";
String CHECK_OUT_DATE="//div[@id='calendar-left']";
String property="//div[@class='const-raw__date']//span";
String ADULT_INPUT="//span[@id='search-pax-search-widget']";
String ADULT_MINUS="//button[@id='spinner-adult-0-plus']";
String ADULT_PLUS="//button[@id='spinner-adult-0-plus']";
String KIDS_MINUS="//button[@id='spinner-child-0-plus']";
String KIDS_PLUS="//button[@id='spinner-child-0-minus']";
String CLASS="//div[contains(@class,'fz-search-form__item fz-search-form__item--cabin-class o-inline-form-group__item')]//div[@class='m-form-item__input fz-search-form-input']";
String SERACH="//button[@id='fz-search']";
String AGE="//button[@class='surf-dropdown__trigger override']";
String AGE_LIST="//div[@id='dd3']//label";
String SERACH_AGAIN="//button[contains(text(),'Search again')]";
String MODIFY_SERACH="//span[contains(text(),'Modify search')]";
String DIV_MODIFY_SERACH="//div[@class='fz-search']";
public void init() {
		u.gets("https://www.flydubai.com/en/");
	}
	
	public void Holiday_Serach() {
		WebDriver driver;
		WebDriverWait wait;
		Actions action;
		init();
	u.click(HOLIDAY);
		u.switchtootherwindw();
		u.windowMaximize();
		u.scrollWindow();
		u.findElement(FROM);
	//	u.clear(FROM);
//u.findAndSendKey(FROM,"Aqaba, Aqaba Airport (AQJ), Jordan (AQJ)");
		
	u.findAndClick(TO);
	//u.findAndSendKey(TO, "tur");
	u.findAndSendKey(TO,"Abha");
	u.waitForElementclickable(COMMOM_LIST);
	u.retrive_List(COMMOM_LIST,1);
	u.findAndClick(DATES);
	u.specificDateResult(CHECK_IN_DATE, 30,property);
	u.specificDateResult(CHECK_OUT_DATE ,1,property);
	u.findAndClick(ADULT_INPUT);
	u.findAndClick(ADULT_PLUS);
	u.findAndClick(KIDS_PLUS);
	
	u.findAndClick(AGE);
	u.retrive_List(AGE_LIST, 6);
	u.findAndClick(CLASS);
	u.findAndClick(SERACH);
	if(u.isDisplayed(SERACH_AGAIN)) {
		u.scrollWindowUp();
		u.findAndClick(DATES);
		u.specificDateResult(CHECK_OUT_DATE,2, property);
	u.specificDateResult(CHECK_OUT_DATE, 5, property);
	u.click(SERACH);
		
	}
	else
	{	System.out.println("No result found try again");

	}
	u.findAndClick(MODIFY_SERACH);
	u.findAndClick(DIV_MODIFY_SERACH);
	//Holiday_Serach();
	
	}
	

	
	
	
}
		
	