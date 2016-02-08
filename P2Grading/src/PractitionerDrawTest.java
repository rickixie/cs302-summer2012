import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;


public class PractitionerDrawTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDrawTopByteByte() {
		char[][] top = Practitioner.drawTop((byte) 1, (byte) 5);
//		for (int i = 0; i<top.length; i++)
//			System.out.println(Arrays.toString(top[i]));
//		//[ ,  ,  ,  , 1, *, 1,  ,  ,  ,  ,  , =,  ,  ,  ,  ,  , 1]
		assertTrue(top.length==5);
		assertTrue(Arrays.toString(top[0]).equals("[ ,  ,  ,  , 1, *, 1,  ,  ,  ,  ,  , =,  ,  ,  ,  ,  , 1]"));
		assertTrue(Arrays.toString(top[1]).equals("[ ,  ,  , 1, 1, *, 1, 1,  ,  ,  ,  , =,  ,  ,  ,  , 1, 2, 1]"));
		assertTrue(Arrays.toString(top[2]).equals("[ ,  , 1, 1, 1, *, 1, 1, 1,  ,  ,  , =,  ,  ,  , 1, 2, 3, 2, 1]"));
		assertTrue(Arrays.toString(top[3]).equals("[ , 1, 1, 1, 1, *, 1, 1, 1, 1,  ,  , =,  ,  , 1, 2, 3, 4, 3, 2, 1]"));
		assertTrue(Arrays.toString(top[4]).equals("[1, 1, 1, 1, 1, *, 1, 1, 1, 1, 1,  , =,  , 1, 2, 3, 4, 5, 4, 3, 2, 1]"));
		char[][] top2 = Practitioner.drawTop((byte) 9, (byte) 9);
//		for (int i = 0; i<top2.length; i++)
//			System.out.println(Arrays.toString(top2[i]));
		assertTrue(top2.length==9);
		assertTrue(Arrays.toString(top2[0]).equals("[ ,  ,  ,  ,  ,  ,  ,  , 9, *, 9,  ,  ,  ,  ,  ,  ,  ,  ,  , =,  ,  ,  ,  ,  ,  ,  ,  ,  , 8, 1]"));
		assertTrue(Arrays.toString(top2[8]).equals("[9, 9, 9, 9, 9, 9, 9, 9, 9, *, 9, 9, 9, 9, 9, 9, 9, 9, 9,  , =,  , 9, 9, 9, 9, 9, 9, 9, 9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 1]"));
		
		
		char[][] top3 = Practitioner.drawTop((byte) -12, (byte) 5);
		assertTrue(top3.length==5);
		assertTrue(Arrays.toString(top3[0]).equals("[ ,  ,  ,  , 1, *, 1,  ,  ,  ,  ,  , =,  ,  ,  ,  ,  , 1]"));
		assertTrue(Arrays.toString(top3[1]).equals("[ ,  ,  , 1, 1, *, 1, 1,  ,  ,  ,  , =,  ,  ,  ,  , 1, 2, 1]"));
		assertTrue(Arrays.toString(top3[2]).equals("[ ,  , 1, 1, 1, *, 1, 1, 1,  ,  ,  , =,  ,  ,  , 1, 2, 3, 2, 1]"));
		assertTrue(Arrays.toString(top3[3]).equals("[ , 1, 1, 1, 1, *, 1, 1, 1, 1,  ,  , =,  ,  , 1, 2, 3, 4, 3, 2, 1]"));
		assertTrue(Arrays.toString(top3[4]).equals("[1, 1, 1, 1, 1, *, 1, 1, 1, 1, 1,  , =,  , 1, 2, 3, 4, 5, 4, 3, 2, 1]"));
	
	
		char[][] top4 = Practitioner.drawTop((byte) 12, (byte) 23);
//		for (int i = 0; i<top2.length; i++)
//			System.out.println(Arrays.toString(top2[i]));
		assertTrue(top4.length==9);
		assertTrue(Arrays.toString(top4[0]).equals("[ ,  ,  ,  ,  ,  ,  ,  , 9, *, 9,  ,  ,  ,  ,  ,  ,  ,  ,  , =,  ,  ,  ,  ,  ,  ,  ,  ,  , 8, 1]"));
		assertTrue(Arrays.toString(top4[8]).equals("[9, 9, 9, 9, 9, 9, 9, 9, 9, *, 9, 9, 9, 9, 9, 9, 9, 9, 9,  , =,  , 9, 9, 9, 9, 9, 9, 9, 9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 1]"));
		
		
		char[][] top5 = Practitioner.drawTop((byte) 3, (byte) 4);

		assertTrue(top5.length==4);
		assertTrue(Arrays.toString(top5[0]).equals("[ ,  ,  , 3, *, 3,  ,  ,  ,  , =,  ,  ,  ,  , 0, 9]"));
		
		char[][] top6 = Practitioner.drawTop((byte) 3, (byte) 1);
//		for (int i = 0; i<top6.length; i++)
//			System.out.println(Arrays.toString(top6[i]));
		assertTrue(top6.length==1);
		//assertTrue(Arrays.toString(top5[0]).equals("[3, *, 3,  , =,  , 0, 9]"));		
	}

	@Test
	public void testDrawTopLong() {
		char[][] top = Practitioner.drawTop(1111);
		
		assertTrue(top.length==2);
		assertTrue(Arrays.toString(top[0]).equals("[ , 4, *, 4,  ,  , =,  ,  , 1, 6]"));
		assertTrue(Arrays.toString(top[1]).equals("[4, 4, *, 4, 4,  , =,  , 1, 9, 3, 6]"));
		
	}

	@Test
	public void testDrawBaseByteByte() {
		char[][] base = Practitioner.drawBase((byte) 1, (byte) 5);

		assertTrue(base.length==1);
		assertTrue(Arrays.toString(base[0]).equals("[1, *, 5, +, 1,  , =,  , 6]"));
		
		
		char[][] base2 = Practitioner.drawBase((byte) 121, (byte) 8);
		
		assertTrue(base2.length==14);
		assertTrue(Arrays.toString(base2[0]).equals("[ ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  , 1, *, 8, +, 1,  , =,  , 9]"));
		assertTrue(Arrays.toString(base2[1]).equals("[ ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  , 1, 2, *, 8, +, 2,  , =,  , 9, 8]"));
		assertTrue(Arrays.toString(base2[2]).equals("[ ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  , 1, 2, 3, *, 8, +, 3,  , =,  , 9, 8, 7]"));
		assertTrue(Arrays.toString(base2[3]).equals("[ ,  ,  ,  ,  ,  ,  ,  ,  ,  , 1, 2, 3, 4, *, 8, +, 4,  , =,  , 9, 8, 7, 6]"));
		assertTrue(Arrays.toString(base2[4]).equals("[ ,  ,  ,  ,  ,  ,  ,  ,  , 1, 2, 3, 4, 5, *, 8, +, 5,  , =,  , 9, 8, 7, 6, 5]"));
		assertTrue(Arrays.toString(base2[5]).equals("[ ,  ,  ,  ,  ,  ,  ,  , 1, 2, 3, 4, 5, 6, *, 8, +, 6,  , =,  , 9, 8, 7, 6, 5, 4]"));
		assertTrue(Arrays.toString(base2[6]).equals("[ ,  ,  ,  ,  ,  ,  , 1, 2, 3, 4, 5, 6, 7, *, 8, +, 7,  , =,  , 9, 8, 7, 6, 5, 4, 3]"));
		assertTrue(Arrays.toString(base2[7]).equals("[ ,  ,  ,  ,  ,  , 1, 2, 3, 4, 5, 6, 7, 8, *, 8, +, 8,  , =,  , 9, 8, 7, 6, 5, 4, 3, 2]"));
		assertTrue(Arrays.toString(base2[8]).equals("[ ,  ,  ,  ,  , 1, 2, 3, 4, 5, 6, 7, 8, 9, *, 8, +, 9,  , =,  , 9, 8, 7, 6, 5, 4, 3, 2, 1]"));
		assertTrue(Arrays.toString(base2[9]).equals("[ ,  ,  ,  , 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, *, 8, +, 1, 0,  , =,  , 9, 8, 7, 6, 5, 4, 3, 1, 2, 9, 0]"));
		assertTrue(Arrays.toString(base2[10]).equals("[ ,  ,  , 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 1, 1, *, 8, +, 1, 1,  , =,  , 9, 8, 7, 6, 5, 4, 3, 1, 2, 8, 0, 9, 9]"));
		assertTrue(Arrays.toString(base2[11]).equals("[ ,  , 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 1, 1, 1, 2, *, 8, +, 1, 2,  , =,  , 9, 8, 7, 6, 5, 4, 3, 1, 2, 8, 0, 8, 9, 0, 8]"));
		assertTrue(Arrays.toString(base2[12]).equals("[ , 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 1, 1, 1, 2, 1, 3, *, 8, +, 1, 3,  , =,  , 9, 8, 7, 6, 5, 4, 3, 1, 2, 8, 0, 8, 8, 9, 7, 1, 7]"));
		assertTrue(Arrays.toString(base2[13]).equals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 1, 1, 1, 2, 1, 3, 1, 4, *, 8, +, 1, 4,  , =,  , -, 8, 5, 7, 0, 2, 0, 0, 9, 4, 5, 6, 2, 0, 5, 8, 1, 0, 9, 0]"));
		
		char[][] base3 = Practitioner.drawBase((byte) -1, (byte) -15);

		assertTrue(base3.length==1);
		assertTrue(Arrays.toString(base3[0]).equals("[1, *, 1, +, 1,  , =,  , 2]"));
		
		char[][] base4 = Practitioner.drawBase((byte) 34, (byte) 34);
		
		assertTrue(Arrays.toString(base4[1]).equals("[ ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  , 1, 2, *, 1, 4, +, 2,  , =,  , 1, 7, 0]"));
		
		assertTrue(Arrays.toString(base4[13]).equals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 1, 1, 1, 2, 1, 3, 1, 4, *, 1, 4, +, 1, 4,  , =,  , -, 1, 1, 6, 2, 7, 9, 3, 5, 9, 9, 5, 5, 3, 8, 5, 3, 2, 0, 6]"));
		
	}

	@Test
	public void testDrawBaseLong() {
		char[][] base = Practitioner.drawBase(1111);
		
		assertTrue(base.length==5);
		assertTrue(Arrays.toString(base[0]).equals("[ ,  ,  ,  , 1, *, 5, +, 1,  , =,  , 6]"));
		assertTrue(Arrays.toString(base[1]).equals("[ ,  ,  , 1, 2, *, 5, +, 2,  , =,  , 6, 2]"));
		assertTrue(Arrays.toString(base[2]).equals("[ ,  , 1, 2, 3, *, 5, +, 3,  , =,  , 6, 1, 8]"));
		assertTrue(Arrays.toString(base[3]).equals("[ , 1, 2, 3, 4, *, 5, +, 4,  , =,  , 6, 1, 7, 4]"));
		assertTrue(Arrays.toString(base[4]).equals("[1, 2, 3, 4, 5, *, 5, +, 5,  , =,  , 6, 1, 7, 3, 0]"));

	}

	@Test
	public void testDrawBodyByteInt() {
		char[][] body = Practitioner.drawBody((byte) 9, 12345679);
		
		
		
		//assertTrue(body.length==9);
		assertTrue(Arrays.toString(body[0]).equals("[1, 2, 3, 4, 5, 6, 7, 9, *, 0, 9,  , =,  , 1, 1, 1, 1, 1, 1, 1, 1, 1]"));
		assertTrue(Arrays.toString(body[1]).equals("[1, 2, 3, 4, 5, 6, 7, 9, *, 1, 8,  , =,  , 2, 2, 2, 2, 2, 2, 2, 2, 2]"));
		assertTrue(Arrays.toString(body[2]).equals("[1, 2, 3, 4, 5, 6, 7, 9, *, 2, 7,  , =,  , 3, 3, 3, 3, 3, 3, 3, 3, 3]"));
		assertTrue(Arrays.toString(body[7]).equals("[1, 2, 3, 4, 5, 6, 7, 9, *, 7, 2,  , =,  , 8, 8, 8, 8, 8, 8, 8, 8, 8]"));
		assertTrue(Arrays.toString(body[8]).equals("[1, 2, 3, 4, 5, 6, 7, 9, *, 8, 1,  , =,  , 9, 9, 9, 9, 9, 9, 9, 9, 9]"));
		
		char[][] body2 = Practitioner.drawBody((byte) 5, 999999999);
		
		assertTrue(body2.length==5);
		assertTrue(Arrays.toString(body2[0]).equals("[9, 9, 9, 9, 9, 9, 9, 9, *, 0, 5,  , =,  , 0, 4, 9, 9, 9, 9, 9, 9, 9, 5]"));
		assertTrue(Arrays.toString(body2[1]).equals("[9, 9, 9, 9, 9, 9, 9, 9, *, 1, 4,  , =,  , 1, 3, 9, 9, 9, 9, 9, 9, 8, 6]"));
		assertTrue(Arrays.toString(body2[2]).equals("[9, 9, 9, 9, 9, 9, 9, 9, *, 2, 3,  , =,  , 2, 2, 9, 9, 9, 9, 9, 9, 7, 7]"));
		assertTrue(Arrays.toString(body2[3]).equals("[9, 9, 9, 9, 9, 9, 9, 9, *, 3, 2,  , =,  , 3, 1, 9, 9, 9, 9, 9, 9, 6, 8]"));
		assertTrue(Arrays.toString(body2[4]).equals("[9, 9, 9, 9, 9, 9, 9, 9, *, 4, 1,  , =,  , 4, 0, 9, 9, 9, 9, 9, 9, 5, 9]"));
		
		
		
	}
	@Test
	public void testDrawBodyByteIntIsTheLengthRight() 
	{
		char[][] body = Practitioner.drawBody((byte) 9, 12345679);
		
		
		
		assertTrue(body.length==9);
	}
	
	
	@Test
	public void testDrawBodyWithBogusInput()
	{
		char[][] body3 = Practitioner.drawBody((byte) -3, -999999999);
		
		//assertTrue(body3.length==1);
		//System.out.println(Arrays.toString(body3[0]));
		System.out.println("===================HERE IS THE DEBUGGING======================");
		System.out.println(Arrays.toString(body3[0]));
		System.out.println("we want the above to be equal to :");
		System.out.println("[1, *, 0, 1,  , =,  , 1]");
		System.out.println("===================HERE IS THE DEBUGGING======================");
		assertTrue(Arrays.toString(body3[0]).equals("[1, *, 0, 1,  , =,  , 1]"));
	}
	@Test
	public void testDrawBodyLong() {
		char[][] body = Practitioner.drawBody(1111);
		
		for (int i = 0; i<body.length; i++)
			System.out.println(Arrays.toString(body[i]));
		assertTrue(body.length==4);
		assertTrue(Arrays.toString(body[0]).equals("[8, 8, 2, 0, 7, 6, 0, 7, *, 0, 4,  , =,  , 0, 3, 5, 2, 8, 3, 0, 4, 2, 8]"));
		assertTrue(Arrays.toString(body[1]).equals("[8, 8, 2, 0, 7, 6, 0, 7, *, 1, 3,  , =,  , 1, 1, 4, 6, 6, 9, 8, 8, 9, 1]"));
		assertTrue(Arrays.toString(body[2]).equals("[8, 8, 2, 0, 7, 6, 0, 7, *, 2, 2,  , =,  , 1, 9, 4, 0, 5, 6, 7, 3, 5, 4]"));
		assertTrue(Arrays.toString(body[3]).equals("[8, 8, 2, 0, 7, 6, 0, 7, *, 3, 1,  , =,  , 2, 7, 3, 4, 4, 3, 5, 8, 1, 7]"));
		
	}

}
