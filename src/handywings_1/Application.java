package handywings_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Application {
	
	static Integer pricePerHour = 50;
	static Integer priceFirstFourHors = 40;

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String checkIn = scanner.nextLine();
		String checkOut = scanner.nextLine();

		SimpleDateFormat format = new SimpleDateFormat("HH.mm");
		Date dateCheckin = null;
		Date dateCheckout = null;

		try {
			dateCheckin = format.parse(checkIn);
			dateCheckout = format.parse(checkOut);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		long duration = dateCheckout.getTime() - dateCheckin.getTime();

		//System.out.println(duration / (1000*60)+" Min");
		System.out.println(CalTotalFee(duration));

	}

	public static Integer CalTotalFee(long duration) {
		int totalPrice = 0;
		//int totalMin = (int) (duration / (1000 * 60));
		int totalHour = (int) (duration / (1000 * 60 * 60));

		if (totalHour < 4) {
			totalPrice = priceFirstFourHors;
			return totalPrice;
		} else {
			totalPrice = priceFirstFourHors + (totalHour - 4) * pricePerHour;
			return totalPrice;
		}

	}

}
