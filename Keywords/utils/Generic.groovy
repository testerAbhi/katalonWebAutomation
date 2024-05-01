package utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

public class Generic {
	public static int generateRandomNumber(int max, int min) {
		return min+(int)(Math.random()*((max-min)+1))
	}

	public static String generateRandomDOB(int yearsToSubtract) {
		int randomDay=new Random().nextInt(31);
		int randomMonth=new Random().nextInt(12)+1;
		int currentYear=LocalDate.now().getYear();
		int dobYear=currentYear-yearsToSubtract;
		LocalDate dob=LocalDate.of(dobYear,randomMonth, randomDay)
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy")
		return dob.format(formatter)
	}
}
