package ss.week2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ss.week2.LampAsEnum;

public class LampTest {
		
	LampAsEnum l = new LampAsEnum();
	
	@Test
    public void testLight() {
		assertEquals(LampAsEnum.State.OFF, l.light());
		l.change();
		assertEquals(LampAsEnum.State.LOW, l.light());
		l.change();
		assertEquals(LampAsEnum.State.MED, l.light());
		l.change();
		assertEquals(LampAsEnum.State.HIGH, l.light());
		l.change();
		assertEquals(LampAsEnum.State.OFF, l.light());
    }
}
