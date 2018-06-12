package Aufgabe6;

import static org.junit.Assert.*;
import org.junit.Test;

public class UtilTest {

	@Test
	public void testistErstesHalbjahr() {
		assertEquals(true, Util.istErstesHalbjahr(1));
		assertEquals(true, Util.istErstesHalbjahr(6));
		assertEquals(false,Util.istErstesHalbjahr(7));
		assertEquals(false,Util.istErstesHalbjahr(12));

	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testkleinerAlsJahr(){
		Util.istErstesHalbjahr(0);
		
	}
	@Test(expected=IllegalArgumentException.class)
	public void testgroesserAlsJahr(){
		Util.istErstesHalbjahr(13);
		
	}
	

}
