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
		if((f.getBoard()[0][0] == check && f.getBoard()[0][1] == check) ||
				(f.getBoard()[0][2] == check && f.getBoard()[0][1] == check) ||
				(f.getBoard()[0][2] == check && f.getBoard()[0][0] == check)){
			win = true;
		}
		else if((f.getBoard()[1][0] == check && f.getBoard()[1][1] == check) ||
				(f.getBoard()[1][2] == check && f.getBoard()[1][1] == check) ||
				(f.getBoard()[1][2] == check && f.getBoard()[1][0] == check)){
			win = true;
		}
		else if((f.getBoard()[2][0] == check && f.getBoard()[2][1] == check) ||
				(f.getBoard()[2][2] == check && f.getBoard()[2][1] == check) ||
				(f.getBoard()[2][2] == check && f.getBoard()[2][0] == check)){
			win = true;
		}
		else if((f.getBoard()[0][0] == check && f.getBoard()[1][0] == check) ||
				(f.getBoard()[1][0] == check && f.getBoard()[2][0] == check) ||
				(f.getBoard()[0][0] == check && f.getBoard()[2][0] == check)){
			win = true;
		}
		else if((f.getBoard()[0][1] == check && f.getBoard()[1][1] == check) ||
				(f.getBoard()[1][1] == check && f.getBoard()[2][1] == check) ||
				(f.getBoard()[0][1] == check && f.getBoard()[2][1] == check)){
			win = true;
		}
		else if((f.getBoard()[0][2] == check && f.getBoard()[1][2] == check) ||
				(f.getBoard()[1][2] == check && f.getBoard()[2][2] == check) ||
				(f.getBoard()[0][2] == check && f.getBoard()[2][2] == check)){
			win = true;
		}
		else if((f.getBoard()[0][0] == check && f.getBoard()[1][1] == check) ||
				(f.getBoard()[1][1] == check && f.getBoard()[2][2] == check) ||
				(f.getBoard()[2][2] == check && f.getBoard()[0][0] == check)){
			win = true;
		}
		else if((f.getBoard()[2][0] == check && f.getBoard()[1][1] == check) ||
				(f.getBoard()[1][1] == check && f.getBoard()[0][2] == check) ||
				(f.getBoard()[0][2] == check && f.getBoard()[2][0] == check)){
			win = true;
		}
		return win;
	}
	public double maxValue(TicTacToe b){
		double Val = 0.0;
		if(b.checkWin(opponent)){
			Val = 1.0;
		}
		else if(b.checkLose(opponent)){
			Val = -1.0;
		}
		else if(b.checkDraw()){
			Val = 0.0;
		}
		else{
			ArrayList<char[][]> opt = b.possibleMoves(this);
			ArrayList<Double> Out = new ArrayList<>();
			for(int i =0; i< opt.size(); i++){
				if(partialWin(b, this)){
					Out.add(1.0);
				}
				else if(partialWin(b, opponent)){
					Out.add(-1.0);
				}
				else{
					Out.add(0.0);
				}
			}
			if (Out.contains(1.0)){
				b.setBoard(opt.get(Out.indexOf(1.0)));
				maxValue(b);
			}
			else if (Out.contains(0.0)){
				b.setBoard(opt.get(Out.indexOf(0.0)));
				maxValue(b);
			}
			else{
				b.setBoard(opt.get(Out.indexOf(-1.0)));
				maxValue(b);
			}
		}
		return Val;
	}
	public double minValue(TicTacToe b){
		double Val = 0.0;
		if(b.checkWin(this)){
			Val = 1.0;
		}
		else if(b.checkLose(this)){
			Val =  -1.0;
		}
		else if(b.checkDraw()){
			Val = 0.0;
		}
		else{
			ArrayList<char[][]> opt = b.possibleMoves(opponent);
			ArrayList<Double> Out = new ArrayList<>();
			for(int i =0; i< opt.size(); i++){
				if(partialWin(b, opponent)){
					Out.add(1.0);
				}
				else if(partialWin(b, this)){
					Out.add(-1.0);
				}
				else{
					Out.add(0.0);
				}
			}
			if (Out.contains(1.0)){
				b.setBoard(opt.get(Out.indexOf(1.0)));
				maxValue(b);
			}
			else if (Out.contains(0.0)){
				b.setBoard(opt.get(Out.indexOf(0.0)));
				maxValue(b);
			}
			else{
				b.setBoard(opt.get(Out.indexOf(-1.0)));
				maxValue(b);
			}
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
		for (int i = 0; i < s; i++){
			tmp.setBoard(options.get(i));
			outComes.add(minValue(tmp));
		}

		if(outComes.contains(0.0)){f.setBoard(options.get(outComes.indexOf(0.0)));}
		else if(outComes.contains(1.0)){f.setBoard(options.get(outComes.indexOf(1.0)));}
		else{
			f.setBoard(options.get(outComes.indexOf(-1.0)));}
		return f;
	}
}