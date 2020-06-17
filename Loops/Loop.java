import java.util.*;

class Loop {
	public static void main(String[] args){
		System.out.println(isPrime(13));
		System.out.println(isPrime(10));
		
		System.out.println(multiply(10,5));
		
		printTriangle(5);
		
		reveal(8);
	}
	
	public static boolean isPrime(int n){
		for (int i = 2; i < n; i++){
			if (n%i == 0){
				return false;
			}
		}
		return true;
	}
	
	public static int multiply(int a, int b){
		int product = 0;
		for (int i = 0; i < b; i++){
			product += a;
		}
		return product;
	}
	
	public static void printTriangle(int n){
		for (int i = 0; i <= n; i++){
			if (i != 0){
				for(int j = 0; j < n-i; j++){
					System.out.print(" ");
				}
				for (int k = 0; k < i; k++){
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
	
	public static void reveal(int n){
		for (int i = 0; i <= n; i++){
			for (int k = 1; k <= i; k++){
				System.out.print(k);
			}
			for(int j = 0; j < n-i; j++){
				System.out.print("-");
			}
			System.out.println();
		}
	}
}