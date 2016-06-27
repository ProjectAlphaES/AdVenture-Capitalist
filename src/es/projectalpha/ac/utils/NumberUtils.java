package es.projectalpha.ac.utils;

public class NumberUtils {

	public static double getMillions(String amount){
		return Double.parseDouble(amount) * 1000000;
	}

	public static double getBillions(String amount){
		return getMillions(amount) * 1000;
	}

	public static double getTrillions(String amount){
		return getBillions(amount) * 1000;
	}
	
	public static String getMillions(double amount){
		double money = amount/100000;
		return String.valueOf(money) + " Million";	
	}
	
	public static String getBillions(double amount){
		double money = getBillions(getMillions(amount)) / 1000;
		return String.valueOf(money) + " Billion";
		
	}
	
	public static String getTrillions(double amount){
		double money = getTrillions(getBillions(amount)) / 1000;
		return String.valueOf(money) + " Trillion";
		
	}
}