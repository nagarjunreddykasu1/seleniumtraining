package suite.SeleniumTraining;

import java.time.LocalDateTime;

public class DateTest {
	
	public static void main(String[] args) {
		
		//LocalDate, LocalTime LocalDateTime
		
		LocalDateTime ld=LocalDateTime.now();
		System.out.println(ld); //2024-02-02T11:22:32.968962600  2024-02-02T11:22:42.946439500
		
		String datetime=ld.toString();
		System.out.println(datetime);//2024-02-02T11:23:59.811533400
		
		//20240202T112359811533400
		
		String currenttimestamp=datetime.replace("-", "").replace(":", "").replace(".", "");
		System.out.println(currenttimestamp);
		
		
	}

}
