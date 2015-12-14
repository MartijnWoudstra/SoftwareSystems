package ss.week5;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import ss.week5.tictactoe.Board;
import ss.week5.tictactoe.Mark;

public class NaiveStrategy implements Strategy{

	private String name;
	
	public NaiveStrategy() {
		name = "naive";
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int determineMove(Board b, Mark m) {
		int[] a = new int[b.DIM*b.DIM];
		for(int i = 0; i < a.length;  i++) {
			if(b.isEmptyField(i)) {
				for(int j = 1; i < a.length; j++){
					if(a[j] == 0) a[j] = i;
					break;
				}
			}
		}
		Random r = new Random();
		return a[r.nextInt(a.length)];
	}
}