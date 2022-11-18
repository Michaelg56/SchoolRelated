import java.util.ArrayList;

public class AIPlayer extends Player{
	private String name;
	private Player opponent;
	
	public Player getOpponent(){
		return opponent;
	}
	public void setOpponent(Player a){
		opponent = a;
	}
	
	public String toString(){
		String s = name + " (AI)";
		return s;
	}
	
	public AIPlayer(String n, Player p){
		name = n;
		opponent = p;
	}


	private boolean partialWin(TicTacToe f, Player n){
		char check = f.markerforPlayer(n);
		boolean win = false;
		if((f.getBoard()[0][0] == check && f.getBoard()[0][1] == check && f.getBoard()[0][2] == '_') ||
				(f.getBoard()[0][2] == check && f.getBoard()[0][1] == check && f.getBoard()[0][0] == '_') ||
				(f.getBoard()[0][2] == check && f.getBoard()[0][0] == check && f.getBoard()[0][1] == '_')){
			win = true;
		}
		else if((f.getBoard()[1][0] == check && f.getBoard()[1][1] == check && f.getBoard()[1][2] == '_') ||
				(f.getBoard()[1][2] == check && f.getBoard()[1][1] == check && f.getBoard()[1][0] == '_') ||
				(f.getBoard()[1][2] == check && f.getBoard()[1][0] == check && f.getBoard()[1][1] == '_')){
			win = true;
		}
		else if((f.getBoard()[2][0] == check && f.getBoard()[2][1] == check && f.getBoard()[2][2] == '_') ||
				(f.getBoard()[2][2] == check && f.getBoard()[2][1] == check && f.getBoard()[2][0] == '_') ||
				(f.getBoard()[2][2] == check && f.getBoard()[2][0] == check && f.getBoard()[2][1] == '_')){
			win = true;
		}
		else if((f.getBoard()[0][0] == check && f.getBoard()[1][0] == check && f.getBoard()[2][0] == '_') ||
				(f.getBoard()[1][0] == check && f.getBoard()[2][0] == check && f.getBoard()[0][0] == '_') ||
				(f.getBoard()[0][0] == check && f.getBoard()[2][0] == check && f.getBoard()[1][0] == '_')){
			win = true;
		}
		else if((f.getBoard()[0][1] == check && f.getBoard()[1][1] == check && f.getBoard()[2][1] == '_') ||
				(f.getBoard()[1][1] == check && f.getBoard()[2][1] == check && f.getBoard()[0][1] == '_') ||
				(f.getBoard()[0][1] == check && f.getBoard()[2][1] == check && f.getBoard()[1][1] == '_')){
			win = true;
		}
		else if((f.getBoard()[0][2] == check && f.getBoard()[1][2] == check && f.getBoard()[2][2] == '_') ||
				(f.getBoard()[1][2] == check && f.getBoard()[2][2] == check && f.getBoard()[0][2] == '_') ||
				(f.getBoard()[0][2] == check && f.getBoard()[2][2] == check && f.getBoard()[1][2] == '_')){
			win = true;
		}
		else if((f.getBoard()[0][0] == check && f.getBoard()[1][1] == check && f.getBoard()[2][2] == '_') ||
				(f.getBoard()[1][1] == check && f.getBoard()[2][2] == check && f.getBoard()[0][0] == '_') ||
				(f.getBoard()[2][2] == check && f.getBoard()[0][0] == check && f.getBoard()[1][1] == '_')){
			win = true;
		}
		else if((f.getBoard()[2][0] == check && f.getBoard()[1][1] == check && f.getBoard()[0][0] == '_') ||
				(f.getBoard()[1][1] == check && f.getBoard()[0][2] == check && f.getBoard()[2][0] == '_') ||
				(f.getBoard()[0][2] == check && f.getBoard()[2][0] == check && f.getBoard()[1][1] == '_')){
			win = true;
		}
		return win;
	}
	public double maxValue(TicTacToe b){
		double Val = 0.0;
		if(b.checkWin(this)){
			Val = 1.0;
		}
		else if(b.checkWin(opponent)){
			Val = -1.0;
		}
		else if(b.checkDraw()){
			Val = 0.0;
		}
		else{
			ArrayList<char[][]> opt = b.possibleMoves(this);
			ArrayList<Double> Out = new ArrayList<>();
			for(int i =0; i< opt.size(); i++){
				b.setBoard(opt.get(i));
				if(b.checkWin(this)){
					Out.add(2.0);
				}
				else if(partialWin(b, this) || partialWin(b, opponent)){
					Out.add(-1.0);
				}
				else if(partialWin(b, this)){
					Out.add(1.0);
				}
				else if(partialWin(b, opponent)){
					Out.add(-1.0);
				}
				else{
					Out.add(0.0);
				}
			}
			double highest = Out.get(0);
			int index = 0;
			if(Out.contains(2.0)){
				index = Out.indexOf(2.0);
			}
			else if(Out.contains(0.0)){
				index = Out.indexOf(0.0);
			}
			else {
				for (int j = 0; j < Out.size(); j++) {
					if (Out.get(j) > highest) {
						highest = Out.get(j);
						index = j;
					}
				}
			}
			b.setBoard(opt.get(index));
			Val = minValue(b);
		}
		return Val;
	}
	public double minValue(TicTacToe b){
		double Val = 0.0;
		if(b.checkWin(this)){
			Val = 1.0;
		}
		else if(b.checkWin(opponent)){
			Val = -1.0;
		}
		else if(b.checkDraw()){
			Val = 0.0;
		}
		else{
			ArrayList<char[][]> opt = b.possibleMoves(opponent);
			ArrayList<Double> Out = new ArrayList<>();
			for(int i =0; i< opt.size(); i++){
				b.setBoard(opt.get(i));
				if(b.checkWin(opponent)){
					Out.add(-2.0);
				}
				else if(partialWin(b, opponent) && partialWin(b, this)){
					Out.add(1.0);
				}
				else if(partialWin(b, opponent)){
					Out.add(-1.0);
				}
				else if(partialWin(b, this)){
					Out.add(1.0);
				}
				else{
					Out.add(0.0);
				}
			}
			double lowest = Out.get(0);
			int index = 0;
			for(int j = 0; j< Out.size(); j++){
				if (Out.get(j) < lowest){
					lowest = Out.get(j);
					index = j;
				}
			}
			b.setBoard(opt.get(index));
			Val = maxValue(b);
		}
		return Val;
	}

	public TicTacToe chooseMove(TicTacToe f){
		int s = f.possibleMoves(this).size();
		ArrayList<char[][]> options = f.possibleMoves(this);
		ArrayList<Double> outComes = new ArrayList<>();
		TicTacToe tmp;
		if(f.markerforPlayer(this) == 'O') {
			tmp = new TicTacToe(opponent, this);
		}
		else{
			tmp = new TicTacToe(this, opponent);
		}
		int index = 0;
		for(int i = 0; i < s; i++){
			tmp.setBoard(options.get(i));
			if(tmp.checkWin(this)){
				outComes.add(-2.0);
				return tmp;
			}
			else if(partialWin(f, this) && !partialWin(f, opponent)){
				outComes.add(-2.0);
				return tmp;
			}
			else if(partialWin(f, opponent)){
				outComes.add(-2.0);
			}
			else{
				outComes.add(minValue(tmp));
			}
		}


		double highest = outComes.get(0);
		for(int i = 0; i < outComes.size(); i++){
			if(outComes.get(i) > highest){
				highest = outComes.get(i);
				index = i;
			}
		}
		f.setBoard(options.get(index));
		return f;
	}
}