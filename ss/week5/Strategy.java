package ss.week5;

import ss.week5.tictactoe.Board;
import ss.week5.tictactoe.Mark;

public interface Strategy {
	
	/**.
	 * Returns the name of the strategy
	 * @return String name of the strategy
	 */
	public String getName();
	
	/**.
	 * Determines the next move, depending on the strategy
	 * Each strategy has an own algorithm to calculate this.
	 * @param b Board The board object where the players play on
	 * @param m Mark The mark of the player
	 * @return int Index where player with Mark m should execute his next move.
	 */
	public int determineMove(Board b, Mark m);
}
