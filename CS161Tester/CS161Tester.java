import java.io.*;
import java.util.*;

class CS161Tester {
	static int iResult;
	static double fResult;
	static boolean bResult;
	
	public static void main(String[] args) {
		System.out.println("Welcome to CS161 Tester");
		Scanner scan = new Scanner(System.in);
		while (true){
			System.out.println("Enter a letter a - h or q to exit:");
			iResult = 10;
			fResult = 20.2;
			bResult = false;
			String s = scan.nextLine();
			if (s.equals("a")){
				a();
			} else if (s.equals("b")){
				b();
			} else if (s.equals("c")){
				c();
			} else if (s.equals("d")){
				d();
			} else if (s.equals("e")){
				e();
			} else if (s.equals("f")){
				f();
			} else if (s.equals("g")){
				g();
			} else if (s.equals("h")){
				h();
			} else if (s.equals("q")){
				System.out.println("Exiting...");
				break;
			} else {
				System.out.println("Error Invalid Input");
			}
			System.out.println();
		}
	}
	
	public static void a(){
		System.out.println("bResult--;\nWILL NOT COMPILE");
	}
	
	public static void b(){
		System.out.println("bResult = bResult && (iResult == fResult);");
		bResult = bResult && (iResult == fResult);
		System.out.println(bResult);
	}
	
	public static void c(){
		System.out.println("iResult = fResult;\nWILL NOT COMPILE");	
	}
	
	public static void d(){
		System.out.println("iResult = (int) fResult;");
		iResult = (int) fResult;
		System.out.println(iResult);
	}
	
	public static void e(){
		System.out.println("fResult = iResult;");
		fResult = iResult;
		System.out.println(fResult);
	}
	
	public static void f(){
		System.out.println("fResult = (double) (iResult / 3);");
		fResult = (double) (iResult / 3);
		System.out.println(fResult);
	}
	
	public static void g(){
		System.out.println("iResult = (int) fResult % 3;");
		iResult = (int) fResult % 3;
		System.out.println(fResult);
	}
	
	public static void h(){
		System.out.println("bResult = (iResult % 10 == 0) || false && (int) fResult > 0;");
		bResult = (iResult % 10 == 0) || false && (int) fResult > 0;
		System.out.println(bResult);
	}
}