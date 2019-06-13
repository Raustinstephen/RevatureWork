package com.revature.util;
//exceptionCatcher just makes sure that all numbers input by users are actually numbers
public class ExceptionCatcher {
	public Integer parseIntCheck(String input) {
		Integer choice;
		try {
			choice = Integer.parseInt(input);
		}
		catch (NumberFormatException e) {
			System.out.println("Invalid Input");
    		System.out.println("=================================================================");
			choice = 99999999;
		}
		return choice;
	}
	public Double parseDoubCheck(String input) {
		Double choice;
		try {
			choice = Double.parseDouble(input);
		}
		catch (NumberFormatException e) {
			System.out.println("Invalid Input");
    		System.out.println("=================================================================");
			choice = 0.0;
		}
		return choice;
	}
}
