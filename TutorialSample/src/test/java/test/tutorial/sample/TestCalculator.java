package test.tutorial.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.tutorial.sample.Calculator;
//import static org.junit.A

public class TestCalculator {

	private int a = 20;
	private int b = 10;
	
	Calculator cal = null;
	
	@Before
	public void setUp(){
		cal = new Calculator();
	}
	
	
	@After
	public void tearDown(){
		cal = null;
	}
	
	
	@Test
	public void testAdd(){
		int sum = a+b;
		Assert.assertEquals(sum, cal.add(a, b));
	}
	
	@Test
	public void testMockAdd(){
		Calculator cala = Mockito.mock(Calculator.class);
		Mockito.when(cala.add(10, 20)).thenReturn(30);
	}
}
