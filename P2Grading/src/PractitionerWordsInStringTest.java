import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PractitionerWordsInStringTest {

	String s = "supercalifRAgilisticexpialidocious";
	String s2 = "this is a word and this is another word.";
	String s3 = "this "+'\n'+"String";
	String s4 = "sdifj*7^^#*jfj2saaaa(3(+----oeiorei76tt";
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDoesThisStringHasThisOtherStringInIt() {
		String k = "perradous";
		assertTrue(Practitioner.doesThisStringHasThisOtherStringInIt(s, k)==true);
		assertTrue(Practitioner.doesThisStringHasThisOtherStringInIt(s2, "hawaiord")==true);
		assertTrue(Practitioner.doesThisStringHasThisOtherStringInIt(s2, "HAWAIORD")==true);
		assertTrue(Practitioner.doesThisStringHasThisOtherStringInIt(s2, "banana")==false);
		assertTrue(Practitioner.doesThisStringHasThisOtherStringInIt(s2, "dRow")==false);
		assertTrue(Practitioner.doesThisStringHasThisOtherStringInIt(s3, "hit")==true);
		
		assertTrue(Practitioner.doesThisStringHasThisOtherStringInIt("banana", "banana")==true);
		assertTrue(Practitioner.doesThisStringHasThisOtherStringInIt("1i2c3what4is5going6on", "gongon")==true);
		assertTrue(Practitioner.doesThisStringHasThisOtherStringInIt(s4, "diiit")==true);
	}

	@Test
	public void testDoesThisStringHasThisOtherStringInItReversed() {
		assertTrue(Practitioner.doesThisStringHasThisOtherStringInItReversed(s3, "hit")==false);
		assertTrue(Practitioner.doesThisStringHasThisOtherStringInItReversed("1i2c3what4is5going6on", "gongon")==false);
		assertTrue(Practitioner.doesThisStringHasThisOtherStringInItReversed(s2, "DROW")==true);
		assertTrue(Practitioner.doesThisStringHasThisOtherStringInItReversed(s, "direp")==true);
	
	}

	@Test
	public void testHighlightWordInString() {
//		System.out.println(Practitioner.highlightWordInString(s, "uriiLiixoo", 2));
//		assertTrue(Practitioner.highlightWordInString(s, "uriiLiixoo", 2).equals("s  U  pe  R  cal  I  frag  ILI  st  I  ce  X  pialid  O  ci  O  us"));
//		System.out.println(Practitioner.highlightWordInString(s, "uriiLiixoo", 3));
//		assertTrue(Practitioner.highlightWordInString(s, "uriiLiixoo", 3).equals("s   U   pe   R   cal   I   frag   ILI   st   I   ce   X   pialid   O   ci   O   us"));
//		System.out.println(Practitioner.highlightWordInString(s, "uriiLiixoo", 0));
//		assertTrue(Practitioner.highlightWordInString(s, "uriiLiixoo", 0).equals("sUpeRcalIfragILIstIceXpialidOciOus"));
		System.out.println(Practitioner.highlightWordInString(s, "superGistias", 2));
		assertTrue(Practitioner.highlightWordInString(s, "superGistias", 2).equals("SUPER  califra  GI  li  STI  cexpi  A  lidociou  S"));
		System.out.println(Practitioner.highlightWordInString(s2, "thisisawordandthisisanotherword", 4));
		assertTrue(Practitioner.highlightWordInString(s2, "thisisawordandthisisanotherword", 4).equals("THIS         IS         A         WORD         AND         THIS         IS         ANOTHER         WORD    ."));
		
		
	}

}
