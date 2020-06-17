import java.util.Scanner;
import java.nio.channels.*;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		OrcaCard card = new OrcaCard();
		while(true){
			menu();
			int selection = scan.nextInt();
			if (selection == 1){
				System.out.println();
				
				card.getBalance();
				System.out.println("How much would you like to add?");
				double add = scan.nextDouble();
				card.topUp(add);
				
				scan.nextLine();
				scan.nextLine();
				System.out.println();
			} else if (selection == 2){
				System.out.println();
				
				card.getBalance();
				System.out.println("Enter Trip Cost: ");
				double cost = scan.nextDouble();
				card.butTrip(cost);
				
				scan.nextLine();
				scan.nextLine();
				System.out.println();
			} else if (selection == 3){
				System.out.println();
				
				card.getBalance();
				
				scan.nextLine();
				scan.nextLine();
				System.out.println();
			} else if (selection == 4){
				System.out.println();
				
				card.getTotalTax();
				
				scan.nextLine();
				scan.nextLine();
				System.out.println();
			} else if (selection == 5){
				System.out.println();
				
				card.getTotalTrips();
				
				scan.nextLine();
				scan.nextLine();
				System.out.println();
			} else if (selection == 6){
				System.out.println();
				System.out.print("Exiting...\nBye!");
				break;
			} else {
				System.out.println();
				System.out.println("Invalid Input Try Again");
				scan.nextLine();
				scan.nextLine();
				System.out.println();
			}
		}
	}
	
	private static void menu(){
		System.out.print("Menu\n1.Top Up\n2.Buy Trip\n3.Get Balance\n4.Get Total Tax\n5.Get Trips Total\n6.Quit\nEnter Selection:\n");
	}
}