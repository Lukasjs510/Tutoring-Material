import java.util.*;
class Sevens {
	public static void main(String[] args) {
		double players = Double.parseDouble(args[0]);
		double noSevens = Math.pow((5.0/6.0), players);
		noSevens *= 100;
		String s = String.format("You have a %.2f", noSevens) + "% chance of keeping your cards until next turn";
		System.out.println(s);
	}
}