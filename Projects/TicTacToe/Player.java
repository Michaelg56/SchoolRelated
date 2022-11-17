public abstract class Player{
	public abstract TicTacToe chooseMove(TicTacToe f);
	public double boardValue(TicTacToe f){
		double Val = 0.0;
		if(f.checkWin(this)){
			Val = 1.0;
		}
		else if(f.checkLose(this)){
			Val = -1.0;
		}
		return Val;
	}
}