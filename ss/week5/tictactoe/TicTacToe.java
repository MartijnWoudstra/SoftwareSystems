package ss.week5.tictactoe;

import ss.week5.ComputerPlayer;
import ss.week5.NaiveStrategy;
import ss.week5.SmartStrategy;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
	public static void main(String[] args) {
		assert args.length != 2;
		Player p1;
		Player p2;
		if (args[0].equals("-N") || args[1].equals("-N")) {
			p2 = new ComputerPlayer(new NaiveStrategy(), Mark.OO);
			if (args[0].equals("-N"))
				p1 = new HumanPlayer(args[1], Mark.XX);
			else
				p1 = new HumanPlayer(args[0], Mark.OO);
		} else if (args[0].equals("-S") || args[1].equals("-S")) {
			p2 = new ComputerPlayer(new SmartStrategy(), Mark.OO);
			if (args[0].equals("-S"))
				p1 = new HumanPlayer(args[1], Mark.XX);
			else
				p1 = new HumanPlayer(args[0], Mark.XX);
		}
		else {
			p1 = new HumanPlayer(args[0], Mark.XX);
			p2 = new HumanPlayer(args[1], Mark.OO);
		}
		Game g = new Game(p1, p2);
		g.start();
	}
}