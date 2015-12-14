package ss.week5;

import ss.week5.tictactoe.Board;
import ss.week5.tictactoe.Mark;
import ss.week5.tictactoe.Player;

public class ComputerPlayer extends Player{

	private Strategy strategy;
	private Mark mark;
	
	public ComputerPlayer(Strategy s, Mark m) {
		super(s.getName() + "-" + m.toString(), m);
		this.strategy = s;
		this.mark = m;
	}
	
	public ComputerPlayer(Mark mark){
		this(new NaiveStrategy(), mark);
	}

	@Override
	public int determineMove(Board board) {
		return strategy.determineMove(board, mark);
	}
}
