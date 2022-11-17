import java.util.Scanner;
import java.util.ArrayList;

public class UserPlayer extends Player{
	private String name;
	private Scanner input;
	private String opponent;
	
	public UserPlayer(Scanner i, String name){
		input = i;
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
	
	private String toString(char[][] a){
		String s = "";
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				s += a[i][j];
			}
			s += "\n";
		}
		return s;
	}
	
	public TicTacToe chooseMove(TicTacToe b){
		ArrayList<char[][]> options = b.possibleMoves(this);
		System.out.println("Current board");
		System.out.println(b.toString());
		System.out.println("Player "+ name + "'s turn!");
		for(int i = 0; i < options.size(); i++){
			System.out.println("Move: #" + i);
			System.out.println(toString(options.get(i)));
		}
		System.out.print("Player "+ name + " input a value from 0-" + (options.size()-1) + " ");
		b.setBoard(options.get(input.nextInt()));
		return b;
	}
	
}