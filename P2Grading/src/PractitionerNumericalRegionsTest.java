import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class PractitionerNumericalRegionsTest {

	String single = "   .0000.999.  ";
	String single2 = ".00.0003";
	String single3 = "18000003.";
	String single4 = "   .0000.999.0  ";
	String single5 = ".-00.0003.2";
	String single6 = "180 00003.3";
	String single7 = " 23"+'\n'+"euhreuh";
	String single8 = " 23"+'\n'+"euhr9euh";
	String single9 = "12 dfhud 5.4 8,3.4 jhh 8";
	String single10 = "";
	String many = "hi4.3.3.5.3.4.3.44.3. .44. .33. .4 .4.. 444..4..4.45";
	String none =" hi there!! you";
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testHasSingleNumericalRegionInIt() {
		assertTrue(Practitioner.hasSingleNumericalRegionInIt(single)==true);
		assertTrue(Practitioner.hasSingleNumericalRegionInIt(single2)==true);
		assertTrue(Practitioner.hasSingleNumericalRegionInIt(single3)==true);
		assertTrue(Practitioner.hasSingleNumericalRegionInIt(single4)==false);
		assertTrue(Practitioner.hasSingleNumericalRegionInIt(single5)==false);
		assertTrue(Practitioner.hasSingleNumericalRegionInIt(single6)==false);
		assertTrue(Practitioner.hasSingleNumericalRegionInIt(single7)==true);
		assertTrue(Practitioner.hasSingleNumericalRegionInIt(single8)==false);
		assertTrue(Practitioner.hasSingleNumericalRegionInIt(single9)==false);
		assertTrue(Practitioner.hasSingleNumericalRegionInIt(single10)==false);
		assertTrue(Practitioner.hasSingleNumericalRegionInIt(none)==false);
	}

	@Test
	public void testGetNumericalRegionsIn() { 
		String[] s = Practitioner.getNumericalRegionsIn(single4);
		assertTrue(s.length == 2 && s[0].equals("0000.999") && s[1].equals("0"));
		s = Practitioner.getNumericalRegionsIn(single8);
		assertTrue(s.length == 2 && s[0].equals("23") && s[1].equals("9"));
		s = Practitioner.getNumericalRegionsIn(many);
		String[] m = {"4.3","3.5", "3.4","3.44", "3", "44", "33", "4", "4", "444", "4","4.45"};
		//System.out.println(Arrays.toString(s));
		//System.out.println(Arrays.toString(m));
		assertTrue(s.length == 12 && Arrays.equals(s, m));
		System.out.println(Practitioner.getNumericalRegionsIn(none)[0]);
		assertTrue(Practitioner.getNumericalRegionsIn(none)[0].equals("\" hi there!! you\" contains no numerical regions.") ||
				Practitioner.getNumericalRegionsIn(none)[0].equals("\" hi there!! you\" contains no numerical regions"));
	}

	@Test
	public void testExtractFirstNumericalArea() {
		String s = Practitioner.extractFirstNumericalArea(many);
		assertTrue(s.equals("4.3"));
		String s2 = Practitioner.extractFirstNumericalArea(single);
		//System.out.println(s2);
		assertTrue(s2.equals("0000.999"));
		String s3 = Practitioner.extractFirstNumericalArea(single6);
		assertTrue(s3.equals("180"));
		String s4 = Practitioner.extractFirstNumericalArea(single5);
		assertTrue(s4.equals("00.0003"));
		String s5 = Practitioner.extractFirstNumericalArea(none);
		assertTrue(s5.equals("\" hi there!! you\" contains no numerical regions")||
				s5.equals("\" hi there!! you\" contains no numerical regions."));
		
	}

}
