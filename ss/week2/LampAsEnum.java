package ss.week2;

public class LampAsEnum {
	public enum State { OFF, LOW, MED, HIGH }
	
	private State state;
	
	/*@ ensures light() == State.OFF; */
	public LampAsEnum() { 
		state = State.OFF;
	}
	//@ ensures \result instanceof State;
	/*@ pure */
	public State light() {
		return state;
	}
	
	/*@ ensures light() instanceof State;*/ 
	public void change() {
		switch (light()) {
			case OFF: state = State.LOW; break;
			case LOW: state = State.MED; break;
			case MED: state = State.HIGH; break;
			case HIGH: state = State.OFF; break;
			default: assert false;
		}
	}
}