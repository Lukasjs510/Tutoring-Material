class Change {
	public static void main(String[] args) {
		double dMoney = 45.15;
		int money = (int)(dMoney * 100);
		
		int hundreds = money / 10000;
		money -= (hundreds * 10000);
		
		int tens = money / 1000;
		money -= (tens * 1000);
		
		int fives = money / 500;
		money -= (fives * 500);
		
		int ones = money / 100;
		money -= (ones * 100);
		
		int quarters = money / 25;
		money -= (quarters * 25);
		
		int dimes = money / 10;
		money -= (dimes * 10);
		
		int nickles = money / 5;
		money -= (nickles * 5);
		
		int pennies = money;
		money -= pennies;
		
		System.out.println("To get $" + dMoney + " you need:");
		System.out.println("Hundreds: " + hundreds +
							"\nTens: " + tens +
							"\nFives: " + fives +
							"\nOnes: " + ones +
							"\nQuarters: " + quarters +
							"\nDimes: " + dimes +
							"\nNickels: " + nickles +
							"\nPennies: " + pennies);
	}
}