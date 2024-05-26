package com.jdc.assignment;

import java.util.Scanner;

public class NumberToWordTranslator {

	static String[] numbers = { "တစ်", "နှစ်", "သုံး", "လေး", "ငါး", "ခြောက်", "ခုနစ်", "ရှစ်", "ကိုး" };

	static String[] units = { "ဆယ်", "ရာ", "ထောင်", "သောင်း", "သိန်း", "သန်း" };

	public static void main(String[] args) {
		new NumberToWordTranslator().run();
	}

	void run() {
		renderAsWords(getUserInput());
	}

	private void renderAsWords(String userInput) {
		String translateVal = "";
		int unitIndex = userInput.length() - 2;

		for (int i = 0; i < userInput.length(); i++) {
			int temp = Integer.parseInt(userInput.charAt(i) + "");

			if (temp != 0) {
				translateVal += numbers[temp - 1];
				if (unitIndex >= 0) {
					translateVal += units[unitIndex];
				}
			}

			unitIndex--;
		}

		System.out.println(userInput + " = " + translateVal.concat("ကျပ်"));
	}

	private String getUserInput() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter your amount : ");
		int amount = sc.nextInt();

		while (amount <= 0 || amount >= 10000000) {
			System.out.println("The amount must be between 0 and 10,000,000 !!!");
			System.out.print("Enter your amount again : ");
			amount = sc.nextInt();
		}

		return String.valueOf(amount);
	}

}
