import java.util.*;

public class TicTacToe{
	public static Scanner scan = new Scanner(System.in);
	public static Game game;
	
	public static void main(String[] args) {
		Player p1 = new Player(0);
		Player p2 = new Player(1);
		
		System.out.println("TicTacToe");
		
		while (true){
			game = new Game();
			game.printBoard();
			while (!game.isOver()){
				if (game.move == 0){
					System.out.println("Player 1 make a move (1-9): ");
					int box = getMove();
					game.makeMove(box,p1);
					game.move += 1;
					game.printBoard();
				} else if (game.move == 1){
					System.out.println("Player 2 make a move (1-9): ");
					int box = getMove();
					game.makeMove(box,p2);
					game.move += 1;
					game.printBoard();
				}
				game.moveCount++;
			}
			System.out.print("\n===MENU===\n1. New Game \n2. Print Stats\n3. Quit\n\n");
			int sel = scan.nextInt();
			scan.nextLine();
			if(sel == 1){
				;
			} else if (sel == 2){
				
			} else if (sel == 3){
				break;
			}
		}
		System.out.println("Exiting...");
	}


	private static int getMove(){
		int move = -1;
		String[] legalMoves = {"1","2","3","4","5","6","7","8","9"};
		short legalBit = 0;
		while(true){
			String s = scan.nextLine();
			for(String x : legalMoves){
				if (s.contains(x)){
					legalBit ++;
				}
			}
			if (legalBit == 1){
				move = Integer.parseInt(s);
				break;
			} else {
				System.out.println("Invalid input - enter a move (1-9): ");
			}
		}
		return move;
	}

}

class Game{
	char[][] board;
	int move;
	int moveCount;
	
	public Game(){
		moveCount = 0;
		move = 0;
		board = createBoard();
	}
	
	private char[][] createBoard(){
		char[][] board = new char[3][3];
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				board[i][j] = '*';
			}
		}
		return board;
	}
	
	public void printBoard(){
		System.out.println("Board at Move: " + move);
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void makeMove(int box, Player p){
		int errorBit = 0;
		char mark = p.getMark();
		while (true){
			errorBit = 0;
			if(box == 1){
				if (board[0][0] == '*'){
					board[0][0] = mark;
					break;
				} else {
					errorBit = 1;
				}
			} else if (box == 2){
				if (board[0][1] == '*'){
					board[0][1] = mark;
					break;
				} else {
					errorBit = 1;
				}
			} else if (box == 3){
				if (board[0][2] == '*'){
					board[0][2] = mark;
					break;
				} else {
					errorBit = 1;
				}
			} else if (box == 4){
				if (board[1][0] == '*'){
					board[1][0] = mark;
					break;
				} else {
					errorBit = 1;
				}
			} else if (box == 5){
				if (board[1][1] == '*'){
					board[1][1] = mark;
					break;
				} else {
					errorBit = 1;
				}
			} else if (box == 6){
				if (board[1][2] == '*'){
					board[1][2] = mark;
					break;
				} else {
					errorBit = 1;
				}
			} else if (box == 7){
				if (board[2][0] == '*'){
					board[2][0] = mark;
					break;
				} else {
					errorBit = 1;
				}
			} else if (box == 8){
				if (board[2][1] == '*'){
					board[2][1] = mark;
					break;
				} else {
					errorBit = 1;
				}
			} else if (box == 9){
				if (board[2][2] == '*'){
					board[2][2] = mark;
					break;
				} else {
					errorBit = 1;
				}
			} 
			Scanner scan = new Scanner(System.in);
			if (errorBit == 0){
				System.out.println("Invalid Box Selection: Out of Bounds\nTry Again (1-9):");
			} else if (errorBit == 1){
				System.out.println("Invalid Box Selection: Used Box\nTry Again (1-9):");
			}
			box = scan.nextInt();
			scan.nextLine();
		}
	}
	
	public boolean isOver(){
		if (moveCount >= 9){
			return true;
		}
		return false;
	}
} 

class Player{
	int turn;
	char mark;
	
	int wins;
	int moves;
	
	
	public Player(int turn){
		this.turn = turn;
		this.wins = 0;
		this.moves = 0;
		if (turn == 0){
			this.mark = 'X';
		} else if (turn == 1) {
			this.mark = 'O';
		}
	}
	
	public char getMark(){
		return mark;
	}
}