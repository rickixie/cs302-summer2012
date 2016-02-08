

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DurationTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDuration() {
		Duration d = new Duration();
		assertTrue(d.toString().equals("00:00:00"));
	}

	@Test
	public void testDurationIntIntIntNORMALINPUT() 
	{
		Duration d =  new Duration(12, 61, 1);
		assertTrue(d.getHours()==13 && d.getMinutes()==1 &&d.getSeconds()==1);
	}
	
	@Test
	public void testDurationIntIntInt() 
	{
		Duration d =  new Duration(125, 131, 121);
		assertTrue(d.getHours()==127 && d.getMinutes()==13 &&d.getSeconds()==1);
	}
	
	@Test
	public void testDurationInt()
	{
		Duration d = new Duration(3600);
		assertTrue(d.getHours()== 1 && d.getMinutes()==0 && d.getSeconds()==0);
	}

	@Test
	public void testDurationDuration() {
		Duration d = new Duration(600);
		Duration d2 = new Duration(d);
		assertTrue(d2.getHours()== 0 && d2.getMinutes()==10 && d2.getSeconds()==0);
		d.setHours(10);
		assertTrue(d2.getHours()== 0 && d2.getMinutes()==10 && d2.getSeconds()==0);
		assertTrue(d.getHours()== 10 && d2.getMinutes()==10 && d2.getSeconds()==0);
	}

	@Test
	public void testGetHours() {
		Duration d = new Duration(3661);
		assertTrue(d.getHours()== 1);// && d.getMinutes()==0 && d.getSeconds()==0);
	}

	@Test
	public void testGetMinutes() {
		Duration d = new Duration(3661);
		assertTrue(d.getMinutes()== 1);// && d.getMinutes()==0 && d.getSeconds()==0);
	}

	@Test
	public void testGetSeconds() {
		Duration d = new Duration(3661);
		assertTrue(d.getSeconds()== 1);// && d.getMinutes()==0 && d.getSeconds()==0);

	}

	@Test
	public void testSetHours() 
	{
		Duration d = new Duration(3,61, 0);
		
		//we have a duration 04:01:00
		d.setHours(120);
		//we will have a duration: 120:00:00
		assertTrue(d.getHours() == 120 && d.getMinutes()== 1 && d.getSeconds()== 0);
	}

	@Test
	public void testSetMinutes() 
	{
		Duration d = new Duration(3,61, 0);
		
		//we have a duration 04:01:00
		d.setMinutes(120);
		//we will have a duration: 06:00:00
		assertTrue(d.getHours() == 6 && d.getMinutes()== 0 && d.getSeconds()== 0);
	}

	@Test
	public void testSetSeconds() {
		Duration d = new Duration(3,61, 0);
		
		//we have a duration 04:01:00
		d.setSeconds(120);
		//we will have a duration: 4:03:00
		
		assertTrue(d.getHours() == 4 && d.getMinutes()== 3 && d.getSeconds()== 0);
	}

	@Test
	public void testAdd() {
		Duration d = new Duration(3,30, 30);
		d = d.add(d);

		assertTrue(d.getHours() == 7 && d.getMinutes()== 1 && d.getSeconds()== 0);

	}
	@Test
	public void testAdd2() {
		Duration d = new Duration(3,30, 30);
		Duration d2 = new Duration(0,0, 0);
		d = d.add(d2);
		assertTrue(d.getHours() == 3 && d.getMinutes()== 30 && d.getSeconds()== 30);

	}
	@Test
	public void testMultiply() {
		Duration d = new Duration(3,30, 30);
		d = d.multiply(2);

		assertTrue(d.getHours() == 7 && d.getMinutes()== 1 && d.getSeconds()== 0);

	}

	@Test
	public void testToString() {
		Duration d = new Duration(3,30, 30);
		assertTrue(d.toString().equals("03:30:30"));
		Duration d2 = new Duration(1200);
		assertTrue(d2.toString().equals("00:20:00"));
	}

	@Test
	public void testEqualsDuration() {
		Duration d = new Duration(3661);
		Duration d2 = new Duration(1,1, 1);
		assertTrue(d.equals(d2));

	}

	@Test
	public void testCompareTo() {
		Duration d = new Duration(3600);
		Duration d2 = new Duration(2,0, 0);
		int i = d.compareTo(d2);
		assertTrue(i<0);
		i = d2.compareTo(d);
		assertTrue(i>0);
		Duration d3 = new Duration(7200);
		System.out.println(d3.toString());
		i = d2.compareTo(d3);
		assertTrue(i==0);

		
		Duration d4 = new Duration(0, 602, 602);
		Duration d5 = new Duration(100, 0, 0);
		Duration d6 = new Duration (343434);
		System.out.println(d4.toString() + " " + d5.toString()+" "+ d6.toString());
		int k = d4.compareTo(d6); //-
		int j = d4.compareTo(d5);//--
		int h = d5.compareTo(d6);//++
		assertTrue(k<0 && j<0 && h>0);
	}

}
