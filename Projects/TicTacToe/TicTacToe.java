import java.util.ArrayList;
public class TicTacToe{
	private char[][] board = new char[3][3];
	private Player x;
	private Player o;
	
	public TicTacToe(Player x, Player o){
		this.x = x;
		this.o = o;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				board[i][j] = '_';
			}
		}
	}
	
	public char[][] getBoard(){
		return board;
	}
	public Player getX(){
		return x;
	}
	public Player getO(){
		return o;
	}
	public void setBoard(char[][] b){
		board = b;
	}
	public void setX(Player x){
		this.x = x;
	}
	public void setO(Player o){
		this.o = o;
	}
	
	public int countBlanks(){
		int counter = 0;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(board[i][j] == '_'){
					counter++;
				}
			}
		}
		return counter;
	}

	public char markerforPlayer(Player a){
		if(a == x){
			return 'X';
		}
		else{
			return 'O';
		}
	}

	public boolean checkWin(Player a){
		char check = markerforPlayer(a);
		boolean win = false;
		if(board[0][0] == check && board[0][1] == check && board[0][2] == check){
			win = true;
		}
		else if(board[1][0] == check && board[1][1] == check && board[1][2] == check){
			win = true;
		}
		else if(board[2][0] == check && board[2][1] == check && board[2][2] == check){
			win = true;
		}
		else if(board[0][0] == check && board[1][1] == check && board[2][2] == check){
			win = true;
		}
		else if(board[2][0] == check && board[1][1] == check && board[0][2] == check){
			win = true;
		}
		else if(board[0][0] == check && board[1][0] == check && board[2][0] == check){
			win = true;
		}
		else if(board[0][1] == check && board[1][1] == check && board[2][1] == check){
			win = true;
		}
		else if(board[0][2] == check && board[1][2] == check && board[2][2] == check){
			win = true;
		}
		return win;
	}

	public boolean checkLose(Player a){
		boolean lose = false;
		if(!checkWin(a)){
			lose = true;
		}
		return lose;
	}
	
	public boolean checkDraw(){
		boolean draw = false;
		if(countBlanks() != 0){
			return false;
		}
		if(checkWin(x) == false && checkWin(o) == false){
			draw = true;
		}
		return draw;
	}
	
	public String toString(){
		String s = "";
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				s += board[i][j];
			}
			s += "\n";
		}
		return s;
	}
	
	public  ArrayList<char[][]> possibleMoves(Player a){
		ArrayList<char[][]> pM = new ArrayList<>();
		char mark = markerforPlayer(a);
		for(int c = 0; c < 3; c++){
			for(int k = 0; k < 3; k++){
				char[][] newBoard = new char[3][3];
				for(int i = 0; i < 3; i++){
					for(int j = 0; j < 3; j++){
						newBoard[i][j] = board[i][j];
					}
				}
				if(newBoard[c][k] == '_'){
					newBoard[c][k] = mark;
					pM.add(newBoard);
				}
			}
		}
		return pM;
	}
}