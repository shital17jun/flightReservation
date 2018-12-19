package mavent1m1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilies {
	public static WebDriver driver ;
	public static WebDriverWait wait=null;
	
	WebElement w = null;
	Actions action=null;
	  List<WebElement> wl ;	
		JavascriptExecutor js ;

	  public Utilies(){
		Properties obj = new Properties();					
	    FileInputStream objfile = null;
		try {
			objfile = new FileInputStream("D:\\workspace\\hopscotch\\src\\hopscotch\\pro.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}									
	    try {
			obj.load(objfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   // wait = new WebDriverWait(driver, 30);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shital\\Downloads\\chromedriver_win32\\chromedriver.exe");
		this.driver=new ChromeDriver();
		action=new Actions(driver);
		js = (JavascriptExecutor) driver;
	  }

	public void gets(String URL) {
		driver.get(URL);
	}
	public WebElement findAndSendKey(String locator,String text) {
		w =driver.findElement(By.xpath(locator));
		if(w.equals(null)) {
			System.out.println("Element not found");
		}
		w.sendKeys(text);
		return w;
	}	
	
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

	}
	public WebElement findElement(String locator) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		w =driver.findElement(By.xpath(locator));
		if(w.equals(null)) {
			System.out.println("Element not found");
		}
		return w;
	}
	
	
	public void refresh() {
		driver.navigate().refresh();
	}
	public void waitandClick(String locator) {
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;
		
		w=findElement(locator);
		w.click();
	}
	
	
	/**
	 * This methods click on the web element, 
	 * @param locator , xpath of the locator
	 */
	public void click(String locator) {
		w=findElement(locator);
		w.click();
	}
	public void position(String locator)
	{
		w= findElement(locator);
		System.out.println(w);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,"+w.getLocation().y+")");
					w.click();
	}
	public void doubleClick(String locator) {
		w=findElement(locator);
		action.doubleClick(w);
	}
	
	
	
	public void findAndClick(String locator) {
		w=findElement(locator);
		w.click();
	}
public void click(WebElement e) {
	e.click();
}

	public void waitForElementclickable(String locator) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));

	}
	public void waitForElementsclickable(String locator) {
	wl=findElements(locator);	
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(wl));

	}
	
public void waitForVisibility(String locator) {
	wl=findElements(locator);
	wait.until(ExpectedConditions.visibilityOfAllElements(wl));
	}
	public void moveToElementandClick(String locator) {
		w=findElement(locator);
		action.moveToElement(w).click().build().perform();	
	}
	public Utilies moveToElements(String locator) {
		Utilies u=null;
		w=findElement(locator);
		action.moveToElement(w).perform();	
	return u;
	}
	public void moveToElementandClick(WebElement e) {

		action.moveToElement(e).click().build().perform();	
	}

	public void scrollWindow(){
		js.executeScript("window.scrollBy(0,1000)");
	}
	public void scrollWindowstillElement(String locator) {
		//Identify the WebElement which will appear after scrolling down
		 w=findElement(locator);
	// now execute query which actually will scroll until that element is not appearedw on page.
	js.executeScript("arguments[0].scrollIntoView(true);",w);
	}
	public boolean PageReady() {
		if (js.executeScript("return document.readyState").toString().equals("complete")){ 
			   System.out.println("Page Is loaded.");
			   return true; 
			  } 
		else 
			return false;
	}
	
	
	public void scrollWindowUp(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)");
	}

	public void moveToElement(String locator) {
		w=findElement(locator);
		action.moveToElement(w).build().perform();
	}


	public void clickAndHold(String locator) {
		w=findElement(locator);
		action.clickAndHold(w).release().build().perform();
	}


		
	public void windowMaximize() {
		driver.manage().window().maximize();
	
	}

	public boolean isDisplayed(String locator){ 
		try{
			w=findElement(locator); 
			return w.isDisplayed();
		}catch (Exception e) {
			System.err.println("Element not found or not");
		}
		return false;
	}
public void clear(String locator) {
findElement(locator).clear();
}
	public boolean doubleClicks(String locator) {
		try{
			// WebElement w= findElement(locator);
			w = null;
			w = findElement(locator);
			if (w != null) {
				action.doubleClick(w).perform();
			}
			return true;
		} catch (Exception e) {
			System.err.println("Exception occured"+e.getStackTrace());
		}
		return false;
	}
	 public List<WebElement> findElements(String locator){
	        List<WebElement> wl = null;

	try {
		 wl =driver.findElements(By.xpath(locator));
		
	 } catch (Exception e) {
			System.err.println("Exception occured"+e.getStackTrace());
		}
	 return wl;
	 
	 
	 }
	 
	public void   retrive_List(String locator,int index) {
	 //   List<WebElement> wl = null;
	    List<WebElement> w1 = findElements(locator);
	    w1.get(index).click();

	}

	public void close(){
		driver.close();	
	}


	//select the dropdown using "select by visible text", so pass VisibleText as 'Yellow' to funtion
	public static void selectByVisibleText(WebElement w, String s){
	Select selObj=new Select(w);
	selObj.selectByVisibleText(s);
	}
	
	public void selectByIndex(String locator, int i){
		w= findElement(locator);
		Select selObj=new Select(w);
	selObj.selectByIndex(i);
	}
	
	 
	//select the dropdown using "select by value", so pass Value as 'thirdcolor'
	public static void selectByValue(WebElement w, String value){
	Select selObj=new Select(w);
	selObj.selectByValue(value);
	}

	 //Get The Current Day
    public  String getCurrentDay (){
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
         //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
             //Integer to String Conversion
                String todayStr = Integer.toString(todayInt);
                return todayStr;
    
}

    public void selectDate(String locator)
    {String today;
    	today = getCurrentDay();      
    List<WebElement> columns =findElement(locator).findElements((By.tagName("td")));

    //DatePicker is a table. Thus we can navigate to each cell
    //and if a cell matches with the current date then we will click it.
    for (WebElement cell: columns) {
        /*
        //If you want to click 18th Date
        if (cell.getText().equals("18")) {
        */
        //Select Today's Date
    		        
        if (cell.getText().equals(today)) {
            cell.click();
            break;
        }
    }	}
	
    
    public void specificDateResult(String locator,Integer date,String property) {
    
    	//td[@data-comp-id='ct-calendar-date-true']
    	List<WebElement> columns =findElement(locator).findElements(By.xpath(property)); 
    	String s= Integer.toString(date);
    	for (WebElement cell: columns) 
    	           //Select Today's Date
    	   {      if (cell.getText().equals(s)) {
    		   cell.click();
   	            break;
    	        }
    	    }	}
    		
   
    public void specificDate(String locator,Integer date) {
    	//td[@data-comp-id='ct-calendar-date-true']
    	List<WebElement> columns =findElement(locator).findElements((By.tagName("td"))); 
    	String s= Integer.toString(date);
    	for (WebElement cell: columns) 
    	           //Select Today's Date

    	   {      if (cell.getText().equals(s)) {
    	            cell.click();
    	            break;
    	        }
    	    }	}
    		
    	
    
    public void switchTowindow() {
    	String handle=driver.getWindowHandle();
    	          	driver.switchTo().window(handle);
    	          	System.out.println(handle);
        
    }
    public void switchtootherwindw() {
    String parentwindow=driver.getWindowHandle();
    for(String c:driver.getWindowHandles())
    {driver.switchTo().window(c);
    }
    }
    
    
    
    
}

