package ss.week4.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ss.week4.math.Polynomial;
import ss.week4.math.Sum;

public class PolynomialTest {

	private Polynomial p;
	private double[] d = {2,3,4};
	
	@Before
	public void setup() {
		p = new Polynomial(d);
	}
	
	@Test
	public void testPolynomial(){
		assertEquals(p.apply(2), 96,0);
		assertEquals(p.apply(0), 0,0);
		assertEquals(p.apply(-1), 3,0);
	}
	
	@Test
	public void testDerivative(){
		assertEquals(p.derivative().apply(2), 172,0);
		assertTrue(p.derivative() instanceof Sum);
	}

	@Test
	public void testIntergrand(){
		System.out.println(p.intergrand().apply(2));
		assertTrue(p.intergrand().apply(2) < 43 && p.intergrand().apply(2) > 42.9);
		assertTrue(p.intergrand() instanceof Sum);
	}
}
