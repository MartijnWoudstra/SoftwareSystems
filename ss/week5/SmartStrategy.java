package ss.week5;

import java.util.Random;

import ss.week5.tictactoe.Board;
import ss.week5.tictactoe.Mark;

public class SmartStrategy implements Strategy {

	private String name;
	public static final int UNTRUE_VALUE = -1;

	public SmartStrategy() {
		name = "Smart";
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int determineMove(Board board, Mark mark) {
		int ans = UNTRUE_VALUE;
		boolean hasMove = false;
		int[] arrayOfEmptyTiles = getFreeTiles(board);
		//If one of the empty fields is middle, execute that move
		for (int index : arrayOfEmptyTiles) {
			if(isMiddleSlot(index, board)){
				ans = index;
				hasMove = true;
			}
		}
		//Otherwise execute a guaranteed move.
		if (!hasMove) {
			int possibleMove = garanteedWin(board, mark, arrayOfEmptyTiles);
			if (possibleMove != UNTRUE_VALUE) {
				ans = possibleMove;
				hasMove = true;
			}
		}
		//Otherwise block the opponent from winning.
		if (!hasMove){
			int possibleMove = opponentWinBlock(board, mark, arrayOfEmptyTiles);
			if (possibleMove != UNTRUE_VALUE) {
				ans = possibleMove;
				hasMove = true;
				System.out.println("blocked");
			}
		}
		//Otherwise make a random move.
		if (!hasMove) {
			ans = randomMove(arrayOfEmptyTiles);
		}
		System.out.println("ans = " + ans);
		return ans;
		
	}

	/**
	 * Chooses a random tile to make next move
	 * @param arrayOfEmptyTiles int[] with indexes of empty tiles
	 * @return int index where to play next move
	 */
	private int randomMove(int[] arrayOfEmptyTiles) {
		Random r = new Random();
		return arrayOfEmptyTiles[r.nextInt(arrayOfEmptyTiles.length)];
	}

	/**
	 * Calculates if a move can block the opponent from winning.
	 * This is done by deep copying the board, and simulating moves.
	 * @param board Board object the players play on
	 * @param mark Mark of the player
	 * @param tiles int[] of free tiles
	 * @return int index where to play next move
	 */
	private int opponentWinBlock(Board board, Mark mark, int[] tiles) {
		int t = UNTRUE_VALUE;
		Mark newMark;
		if (mark.equals(Mark.XX))
			newMark = Mark.OO;
		else
			newMark = Mark.XX;
		for (int tile : tiles) {
			Board copy = board.deepCopy();
			copy.setField(tile, newMark);
			if (copy.isWinner(newMark)) 
				t = tile;
		}
		System.out.println("t " + t);
		return t;
	}
	
	/**
	 * Calculates if a move can give a garanteed win.
	 * This is done by deep copying the board, and simulating moves.
	 * @param board Board object the players play on
	 * @param mark Mark of the player
	 * @param tiles int[] of free tiles
	 * @return int index where to play next move.
	 */
	private int garanteedWin(Board board, Mark mark, int[] tiles) {
		int t = UNTRUE_VALUE;
		for (int tile : tiles) {
			Board copy = board.deepCopy();
			copy.setField(tile, mark);
			if (copy.isWinner(mark))
				t = tile;
		}
		return t;
	}

	/**
	 * Calculates whether the slot is the middle slot.
	 * If that is possible, the player will return true, otherwise false.
	 * @param index Index of the slot
	 * @param board Board object where the players play on
	 * @return boolean True if index is middleslot otherwise false.
	 */
	public boolean isMiddleSlot(int index, Board board) {
		//System.out.println("Index: " + index);
		//System.out.println(((board.DIM - 1) / 2) * ((board.DIM - 1) / 2));
		int half = (board.DIM - 1) / 2;
		return (index == (half + (half) * board.DIM)) ;
	}

	/**
	 * Returns an int[] of free tiles.
	 * @param board Board object the players play on
	 * @return int[] of indexes of tiles which are free.
	 */
	public int[] getFreeTiles(Board board) {
		int[] a = new int[(board.DIM * board.DIM)];
		for (int i = 0; i < (board.DIM * board.DIM); i++) {
			if (board.isEmptyField(i)) {
				for (int j = 1; j < a.length; j++) {
					if (a[j] == 0) {

						a[j] = i;
						j = a.length;
					}
				}
			}
		}
		return a;
	}
}
