import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PractitionerInsertAtTest {

	String s1 = " hi there   ";
	@Before
	public void setUp() throws Exception {
	}

	
	//=======================insertAt,  with double
	@Test
	public void testInsertAtStringIntDoubleBooleanNegative() {
		assertTrue(Practitioner.insertAt(s1, -2, -12.3, true).equals(s1));//negative should leave unaltered
	}
	@Test
	public void testInsertAtStringIntDoubleBooleanBiggerThanLength() {
		assertTrue(Practitioner.insertAt(s1, 23, -12.3, true).equals(s1));//bigger than length should leave unaltered
	}
	@Test
	public void testInsertAtStringIntDoubleBooleanAt0() {
		assertTrue(Practitioner.insertAt(s1, 0, -12.3, true).equals("-12.3"+s1));//insert at the very first position
	}
	@Test
	public void testInsertAtStringIntDoubleBooleanAtLength() {
		assertTrue(Practitioner.insertAt(s1, s1.length(), -12.3, true).equals(s1+"-12.3"));//insert at the very last position
	}
	@Test
	public void testInsertAtStringIntDoubleBooleanAtSomePlaceInside() {
		//System.out.println(Practitioner.insertAt(s1, 3, -12.3, true));
		assertTrue(Practitioner.insertAt(s1, 3, -12.3, true).equals(" hi-12.3 there   "));//insert somewhere inside
	}
	
	//================= insertAt, keeping only integral part
	@Test
	public void testInsertAtStringIntDoubleBooleanNegative2() {
		assertTrue(Practitioner.insertAt(s1, -2, 12.3, false).equals(s1));//negative index should leave unaltered
	}
	@Test
	public void testInsertAtStringIntDoubleBooleanBiggerThanLength2() {
		assertTrue(Practitioner.insertAt(s1, 23, 12.3, false).equals(s1));//bigger than length should leave unaltered
	}
	@Test
	public void testInsertAtStringIntDoubleBooleanAt0_2() {
		assertTrue(Practitioner.insertAt(s1, 0, 12.3, false).equals("12"+s1));//insert at the very first position
	}
	@Test
	public void testInsertAtStringIntDoubleBooleanAtLength2() {
		assertTrue(Practitioner.insertAt(s1, s1.length(), 12.3, false).equals(s1+"12"));//insert at the very last
	}
	@Test
	public void testInsertAtStringIntDoubleBooleanAtSomePlaceInside2() {
		//System.out.println(Practitioner.insertAt(s1, 3, 12.3, false));
		assertTrue(Practitioner.insertAt(s1, 3, 12.3, false).equals(" hi12 there   "));//insert somewhere inside
	}
	
	
	//=======================insertAt,  with String
			
	@Test
	public void testInsertAtStringIntStringNegative() {
		assertTrue(Practitioner.insertAt(s1, -3, " ").equals(s1));//negative index than length should leave unaltered

	}

	@Test
	public void testInsertAtStringIntStringLargerThanLength() {
		assertTrue(Practitioner.insertAt(s1, 2323, " ").equals(s1));//bigger than length should leave unaltered

	}
	
	@Test
	public void testInsertAtStringIntStringAt0() {
		System.out.println(Practitioner.insertAt(s1, 0, " "));
		assertTrue(Practitioner.insertAt(s1, 0, "P").equals("P"+s1));//at the front

	}
	@Test
	public void testInsertAtStringIntStringAtLength() {
		assertTrue(Practitioner.insertAt(s1, s1.length(), " ").equals(s1+" "));//at the end

	}
	
	@Test
	public void testInsertAtStringIntStringSomewhereInside() {
		String a ="p"+'\n'+"q";
		//System.out.println(Practitioner.insertAt(s1, 1, a));
		assertTrue(Practitioner.insertAt(s1, 1, a).equals(" "+a+"hi there   "));//inside

	}
	
	@Test
	public void testInsertAtStringIntStringSomewhereInside2() {
		String a ="";
		//System.out.println(Practitioner.insertAt(s1, 1, a));
		assertTrue(Practitioner.insertAt(s1, 1, a).equals(" "+a+"hi there   "));//inside

	}
	
	
	//--------insertAt sequence   //
	@Test
	public void testInsertAtSequence() {
		String swissCheese = "swissCheese";
		//System.out.println(swissCheese);
		swissCheese = Practitioner.insertAt(swissCheese, -2, 0.0, true);
		assertTrue(swissCheese.equals("swissCheese"));

		swissCheese = Practitioner.insertAt(swissCheese, 0, 0.0, true);
		assertTrue(swissCheese.equals("0.0swissCheese"));

		swissCheese = Practitioner.insertAt(swissCheese, 90, 0.0, true);
		assertTrue(swissCheese.equals("0.0swissCheese"));

		swissCheese = Practitioner.insertAt(swissCheese, 1, 0.0, false);
		assertTrue(swissCheese.equals("00.0swissCheese"));

		swissCheese = Practitioner.insertAt(swissCheese, 5, "W00T");
		assertTrue(swissCheese.equals("00.0sW00TwissCheese"));

		swissCheese = Practitioner.insertAt(swissCheese, 14, "00");
		assertTrue(swissCheese.equals("00.0sW00TwissC00heese"));

		swissCheese = Practitioner.insertAt(swissCheese, 1900, "00");
		assertTrue(swissCheese.equals("00.0sW00TwissC00heese"));

		swissCheese = Practitioner.insertAt(swissCheese, 3, "");
		assertTrue(swissCheese.equals("00.0sW00TwissC00heese"));


	}

}
