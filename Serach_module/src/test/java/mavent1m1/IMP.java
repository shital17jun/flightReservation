package mavent1m1;
import mavent1m1.MainPage;
import org.testng.annotations.Test;


public class IMP {
	// MainPage f= new MainPage();

	@Test
	public void finaltest() {
		 MainPage f= new MainPage();
	//  f.flightReservation_RoundTrip();
	// f.flightReservation_One_Way_Trip();
//Main_car c=new Main_car();
//c.car_Serach();
//c.car_Serach_different("McAllen Miller International Airport (Texas)");
	//	 Main_hotel hotel=  new Main_hotel();
	//hotel.Serach_Hotel();
	Main_holiday h=  new Main_holiday();
	h.Holiday_Serach();
	
	}
	}
