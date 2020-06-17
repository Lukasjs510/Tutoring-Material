import java.util.*;
import java.io.*;

class MemDriver {
	private static Mem mem = null;
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("***Welcom to SimpleMem!***");
		while (true){
			System.out.print("***Menu A:***\n***Option \"1\": Make a memory unit with an initial value of 0***\n***Option \"2\": Make a memory unit with a custom initial value***\n***Please select an option:***\n* ");
			String x = scan.nextLine();
			if (x.equals("1")){
				mem = new Mem();
				break;
			} else if(x.equals("2")){
				System.out.print("***What is the initial integer value?***\n* ");
				int val = scan.nextInt();
				scan.nextLine();
				mem = new Mem(val);
				break;
			} else { 
				System.out.println("***Invalid Input Try Again***");
			}
		}
		
		while (true){
			System.out.print("***Menu B:***\n***Option \"1\": Set memory integer value***\n***Option \"2\": Print memory integer value***\n***Please select an option:***\n* ");
			String input = scan.nextLine();
			if (input.equals("1")){
				System.out.print("***Enter value:***\n* ");
				int x = scan.nextInt();
				scan.nextLine();
				mem.setMem(x);
			} else if (input.equals("2")){
				mem.printMem();
			} else if (input.equals("q")){
				System.out.println("***Exiting...***");
				break;
			} else {
				System.out.println("***Invalid Input Try Again***");
			}
			System.out.println();
		}
	}
}