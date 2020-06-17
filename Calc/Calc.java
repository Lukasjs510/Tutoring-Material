import java.util.*;
import java.io.*;

class Calc{
	
	private static int total;
	private static boolean useTotal;
	
	public static void main(String[] args) {
		total = 0;
		useTotal = false;
		System.out.println("Welcome to Calc.java");
		while (true){
			int selection = getUser();
			if (selection == 0){
				System.out.println("Go Fuck Yourself");
			} else if (selection == 1){
				add();
			} else if (selection == 2){
				sub();
			} else if (selection == 3){
				mult();
			} else if (selection == 4){
				div();
			} else if (selection == 5){
				System.out.println("Total = " + getTotal());
			}else if (selection == 6){
				break;
			} else {
				System.out.println("Invalid input try again.");
			}		
		}
		System.out.println("Thank you for using Calc.java!");
	}	
	
	private static void add(){
		int a;
		if (getUseTotal() == true){
			a = getTotal();
			System.out.println("First Operand = " + getTotal());
		} else {
			a = getNums(0); 	
		}
		
		int b = getNums(1);
		int c = a + b;
		System.out.println(a + " + " + b + " = " + c);
		total += c;
		useTotal();
	}
	
	private static void sub(){
		int a;
		if (getUseTotal() == true){
			a = getTotal();
			System.out.println("First Operand = " + getTotal());
		} else {
			a = getNums(0); 	
		}
		
		int b = getNums(1);
		int c = a - b;
		System.out.println(a + " - " + b + " = " + c);
		total += c;
		useTotal();
	}
	
	private static void mult(){
		int a;
		if (getUseTotal() == true){
			a = getTotal();
			System.out.println("First Operand = " + getTotal());
		} else {
			a = getNums(0); 	
		}
		int b = getNums(1);
		int c = a * b;
		System.out.println(a + " * " + b + " = " + c);
		total += c;
		useTotal();
	}
	
	private static void div(){
		int a;
		if (getUseTotal() == true){
			a = getTotal();
			System.out.println("First Operand = " + getTotal());
		} else {
			a = getNums(0); 	
		}
		int b = getNums(1);
		if (b == 0){
			System.out.println("Error: Divide by 0");
		} else {
			int c = a / b;
			int d = a % b;
			System.out.println(a + " / " + b + " = " + c + " remainder " + d);
			total += c;
			useTotal();
		}
	}
	
	
	private static int getUser(){
		Scanner scan = new Scanner(System.in);
		System.out.println("****MENU****\nEnter 1 for Addition\nEnter 2 for Subtraction\nEnter 3 for Multiplication\nEnter 4 for Division\nEnter 5 to Print Total\nEnter 6 to Quit");
		int selection = scan.nextInt();
		return selection;
	}
	
	private static int getNums(int op){
		Scanner scan = new Scanner(System.in);
		if (op == 0){
			System.out.println("Enter first operand");
		} else if (op == 1){
			System.out.println("Enter second operand");
		}
		int operand = scan.nextInt();
		return operand;
	}
	
	private static void useTotal(){
		while (true){
			Scanner scan = new Scanner(System.in);
			System.out.println("Note: \'N\' resets Total to 0\nDo you want to continue using current total?(Y/N)");
			char input = scan.next().charAt(0);
			if (input == 'y' || input == 'Y'){
				useTotal = true;
				break;
			} else if (input == 'n' || input == 'N'){
				useTotal = false;
				total = 0;
				break;
			} else {
				System.out.println("Invalid input try again.");
			}
		}
	}
	
	
	private static int getTotal(){
		return total;
	}
	
	private static boolean getUseTotal(){
		return useTotal;
	}
}