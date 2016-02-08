///////////////////////////////////////////////////////////////////////////////
// Semester: CS302 Summer 2014
// Author: Si Xie (Ricki)
// Email: sxie27@wisc.edu
//
// Lecturer's Name: Nick Pappas 
//
// References and Credits
// (1) Nick's lecture notes on ArrayList, Random and Small Programs
// (2)ArrayList to Array: http://stackoverflow.com/questions/14223729/arraylist-to-array
// (3) Jagged Array: http://www.c-jump.com/bcc/c157c/Week09/Week09.html#W01_0360_jagged_array
// (5) TA Xiaoyuan Huang
// Other Credits: Friend Lincoln Huang and Frank Borden for helping me organize my program thoughts and logic; LearnUW  discussion forum
/////////////////////////////////////////////////////////////////////////////////

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;//<---import ArrayList for methods getNumericalRegionIn
import java.util.Random;//<--import Random class to generate desired number using with seed 
import java.util.Arrays;
/**
 * <p> This class contains 14 methods, and 5 additional private methods. 
 * The methods range from inserting elements, matching different strings, and even drawing a ASCII pictures using math equation.
 * <p> The methods used range of java methods that we learn from the course, such as constructing ArrayList, use nested Loop and 
 * and if condition. It aims to practice logical and computational thinking, and use program to build things.
 *
 * @author Si Xie (Ricki)
 */

public class Practitioner {
	public static void main(String[] args) 
	{
		String s1 = " hi there   ";

		assertTrue(insertAt(s1, -2, -12.3, true).equals(s1));// == true; //negative should leave unaltered

		assertTrue(insertAt(s1, 23, -12.3, true).equals(s1));// == true; //bigger than length should leave unaltered

		assertTrue(insertAt(s1, 0, -12.3, true).equals("-12.3"+s1));// == true; //insert at the very first position

		assertTrue(insertAt(s1, s1.length(), -12.3, true).equals(s1+"-12.3"));// == true; //insert at the very last position

		assertTrue(insertAt(s1, 3, -12.3, true).equals(" hi-12.3 there "));// == true; //insert somewhere inside

		assertTrue(insertAt(s1, -2, 12.3, false).equals(s1));// == true; //negative index should leave unaltered

		assertTrue(insertAt(s1, 23, 12.3, false).equals(s1));// == true; //bigger than length should leave unaltered

		assertTrue(insertAt(s1, 0, 12.3, false).equals("12"+s1));// == true; //insert at the very first position

		assertTrue(insertAt(s1, s1.length(), 12.3, false).equals(s1+"12"));// == true; //insert at the very last

		assertTrue(insertAt(s1, 3, 12.3, false).equals(" hi12 there "));// == true; //insert somewhere inside

		assertTrue(insertAt(s1, -3, " ").equals(s1));// == true; //negative index than length should leave unaltered

		assertTrue(insertAt(s1, 2323, " ").equals(s1));// == true; //bigger than length should leave unaltered

		assertTrue(insertAt(s1, 0, "P").equals("P"+s1));// == true; //at the front

		assertTrue(insertAt(s1, s1.length(), " ").equals(s1+" "));// == true //at the end

//		assertTrue(String a1 ="p"+'\n'+"q";  insertAt(s1, 1, a1).equals(" "+a+"hi there   "));// == true
//
//		assertTrue(String a2 ="";  insertAt(s1, 1, a2).equals(" "+a2+"hi there   "));// == true

		String swissCheese = "swissCheese"; 

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

		//numericalGegions //15 points, 3 methods, each 5 points

		String single = " .0000.999. ";
		String single2 = ".00.0003";
		String single3 = "18000003.";
		String single4 = " .0000.999.0 ";
		String single5 = ".-00.0003.2";
		String single6 = "180 00003.3";
		String single7 = " 23"+'\n'+"euhreuh";
		String single8 = " 23"+'\n'+"euhr9euh";
		String single9 = "12 dfhud 5.4 8,3.4 jhh 8";
		String single10 = "";
		String many = "hi4.3.3.5.3.4.3.44.3. .44. .33. .4 .4.. 444..4..4.45";
		String none =" hi there!! you";

		//hasSingleNumericalRegionInIt() // 5 points, 11 cases, fail one take 0.5 point off

		assertTrue(hasSingleNumericalRegionInIt(single));//true
		assertTrue(hasSingleNumericalRegionInIt(single2));//true
		assertTrue(hasSingleNumericalRegionInIt(single3));//true
		assertTrue(!hasSingleNumericalRegionInIt(single4));//false
		assertTrue(!hasSingleNumericalRegionInIt(single5));//false
		assertTrue(!hasSingleNumericalRegionInIt(single6));//false
		assertTrue(hasSingleNumericalRegionInIt(single7));//true
		assertTrue(!hasSingleNumericalRegionInIt(single8));//false
		assertTrue(!hasSingleNumericalRegionInIt(single9));//==false;
		assertTrue(!hasSingleNumericalRegionInIt(single10));//==false;
		assertTrue(!hasSingleNumericalRegionInIt(none));//==false;

		//getNumericalRegionsIn() // 5 points, 4 cases, fail one take 1 point off

		String[] sA = Practitioner.getNumericalRegionsIn(single4);
		assertTrue((sA.length == 2 && sA[0].equals("0000.999") && sA[1].equals("0")));// == true

		sA = Practitioner.getNumericalRegionsIn(single8);

		assertTrue((sA.length == 2 && sA[0].equals("23") && sA[1].equals("9")));// == true

		sA = getNumericalRegionsIn(many);
		String[] m = {"4.3","3.5", "3.4","3.44", "3", "44", "33", "4", "4", "444", "4","4.45"};

		assertTrue((sA.length == 12 && Arrays.equals(sA, m)));// == true

		assertTrue((Practitioner.getNumericalRegionsIn(none)[0].equals("\" hi there!! you\" contains no numerical regions.") ||
		Practitioner.getNumericalRegionsIn(none)[0].equals("\" hi there!! you\" contains no numerical regions")));// == true

		//ExtractFirstNumericalArea() // 5 points, 5 cases, fail one take 1 point

		String s = Practitioner.extractFirstNumericalArea(many);
		assertTrue(s.equals("4.3"));// == true;
		String s2 = Practitioner.extractFirstNumericalArea(single);
		assertTrue(s2.equals("0000.999"));// ==true;
		String s3 = Practitioner.extractFirstNumericalArea(single6);
		assertTrue(s3.equals("180"));// ==true;
		String s4 = Practitioner.extractFirstNumericalArea(single5);
		assertTrue(s4.equals("00.0003"));// ==true;
		String s5 = Practitioner.extractFirstNumericalArea(none);
		assertTrue((s5.equals("\" hi there!! you\" contains no numerical regions")||s5.equals("\" hi there!! you\" contains no numerical regions.")));// == true;

		//wordString // 30 points, 3 methods, each one 10 points

		String s01 = "supercalifRAgilisticexpialidocious";
		String s20 = "this is a word and this is another word.";
		String s30 = "this "+'\n'+"String";
		String s40 = "sdifj*7^^#*jfj2saaaa(3(+----oeiorei76tt";

		//doesThisStringHasThisOtherStringInIt() // 10 points, 9 cases, fail one take 1 point

		assertTrue(doesThisStringHasThisOtherStringInIt(s01, "k"));//==true;
		assertTrue(doesThisStringHasThisOtherStringInIt(s20, "hawaiord"));//==true;
		assertTrue(doesThisStringHasThisOtherStringInIt(s20, "HAWAIORD"));//==true;
		assertTrue(!doesThisStringHasThisOtherStringInIt(s20, "banana"));//==false;
		assertTrue(!doesThisStringHasThisOtherStringInIt(s20, "dRow"));//==false;
		assertTrue(doesThisStringHasThisOtherStringInIt(s30, "hit"));//==true;

		assertTrue(doesThisStringHasThisOtherStringInIt("banana", "banana"));//==true;
		assertTrue(doesThisStringHasThisOtherStringInIt("1i2c3what4is5going6on", "gongon"));//==true;
		assertTrue(doesThisStringHasThisOtherStringInIt(s40, "diiit"));//==true;

		//doesThisStringHasThisOtherStringInItReversed() // 10 points, 4 cases, fail one take 2 points off

		assertTrue(!doesThisStringHasThisOtherStringInItReversed(s3, "hit"));//==false;
		assertTrue(!doesThisStringHasThisOtherStringInItReversed("1i2c3what4is5going6on", "gongon"));//==false;
		assertTrue(doesThisStringHasThisOtherStringInItReversed(s2, "DROW"));//==true;
		assertTrue(doesThisStringHasThisOtherStringInItReversed(s, "direp"));//==true;

		//highlightWordInString() // 5 cases, 1 point each


//		highlightWordInString(s, "uriiLiixoo", 2).equals("s  U  pe  R  cal  I  frag  ILI  st  I  ce  X  pialid  O  ci  O  us")
//
//		highlightWordInString(s, "uriiLiixoo", 3).equals("s   U   pe   R   cal   I   frag   ILI   st   I   ce   X   pialid   O   ci   O   us")
//
//		highlightWordInString(s, "uriiLiixoo", 0).equals("sUpeRcalIfragILIstIceXpialidOciOus")
//
//		highlightWordInString(s, "superGistias", 2).equals("SUPER  califra  GI  li  STI  cexpi  A  lidociou  S")
//
//		highlightWordInString(s2, "thisisawordandthisisanotherword", 4).equals("THIS         IS         A         WORD         AND         THIS         IS         ANOTHER         WORD    .")

		 

		//draw cases // 40 points, 6 methods, I give eah 7 points if your method is totally correct

		//drawTop()

		// please all the charater displaying correct and aligning well


		drawTop((byte) 1, (byte) 5);

		drawTop((byte) 9, (byte) 9);

		drawTop((byte) -12, (byte) 5);

		drawTop((byte) 12, (byte) 23);

		drawTop((byte) 3, (byte) 4);

		drawTop((byte) 3, (byte) 1);

		//drawTop()  random seed

		char[][] top = drawTop(1111);

		assertTrue(top.length==2);
		Arrays.toString(top[0]).equals("[ , 4, *, 4, , , =, , , 1, 6]");
		Arrays.toString(top[1]).equals("[4, 4, *, 4, 4, , =, , 1, 9, 3, 6]");

		//drawBase()

		drawBase((byte) 1, (byte) 5);

		drawBase((byte) 121, (byte) 8);

		drawBase((byte) -1, (byte) -15);

		drawBase((byte) 34, (byte) 34);

		//drawBase() random seed

		char[][] base = drawBase(1111);

		assertTrue(base.length==5);
		Arrays.toString(base[0]).equals("[ , , , , 1, *, 5, +, 1, , =, , 6]");
		Arrays.toString(base[1]).equals("[ , , , 1, 2, *, 5, +, 2, , =, , 6, 2]");
		Arrays.toString(base[2]).equals("[ , , 1, 2, 3, *, 5, +, 3, , =, , 6, 1, 8]");
		Arrays.toString(base[3]).equals("[ , 1, 2, 3, 4, *, 5, +, 4, , =, , 6, 1, 7, 4]");
		Arrays.toString(base[4]).equals("[1, 2, 3, 4, 5, *, 5, +, 5, , =, , 6, 1, 7, 3, 0]");

		//drawBody()


		drawBody((byte) 9, 12345679);

		drawBody((byte) 5, 999999999);

		drawBody((byte) -3, -999999999);

		//drawBody() random seed;


		char[][] body = drawBody(1111);

		assertTrue(body.length==4);
		Arrays.toString(body[0]).equals("[8, 8, 2, 0, 7, 6, 0, 7, *, 0, 4, , =, , 0, 3, 5, 2, 8, 3, 0, 4, 2, 8]");
		Arrays.toString(body[1]).equals("[8, 8, 2, 0, 7, 6, 0, 7, *, 1, 3, , =, , 1, 1, 4, 6, 6, 9, 8, 8, 9, 1]");
		Arrays.toString(body[2]).equals("[8, 8, 2, 0, 7, 6, 0, 7, *, 2, 2, , =, , 1, 9, 4, 0, 5, 6, 7, 3, 5, 4]");
		Arrays.toString(body[3]).equals("[8, 8, 2, 0, 7, 6, 0, 7, *, 3, 1, , =, , 2, 7, 3, 4, 4, 3, 5, 8, 1, 7]");
	}

	////////////////////////////////////// Two insertAt Method //////////////////////////////////////////////////
	/**
	 * <p>This method insert a numeric value (can be either a double or a integer) to another string in a specify position.
	 * The method will return the modify string back to the main method
	 * Besides the string input for modification, the integer input is for the index position where the program will insert the element
	 * The insert value is in the form of double and will evaluated based on the boolean value on whether should keep the decimal
	 * <p>For example, if the input combination is (String, 1, 20.0, true), the output will be S20.0tring.
	 * If the input combination is  (String, 1, 20.0, false), the output will be S20tring. Notice that the decimal is omitted 
	 * @param sP					The String to be modified.
	 * @param indexP				The position where the value should be inserted.To modify the sP, the value should between 0 and the length of sP, otherwise the sP remain unmodified
	 * @param valueP				The double value that will be inserted. 
	 * @param shouldKeepDecimal		The boolean value to determine the form of valueP. If it is true, the decimal will be kept
	 * @return 						The modified string will be returned.
	 */
	public static String insertAt(String sP, int indexP, double valueP, boolean shouldKeepDecimal)
	{
		/*
		 * My method will first evaluate if the indexP is valid; if not, it will return the sP unmodified, otherwise it will start the insert method
		 * If the the shoudKeepDecimal is true, no casting will be made to the valueP
		 * Otherwise the else condition will case the double to integer, and insert the number to the string
		 */

		//Initialize a empty string to refer the return String;
		String output  = "";

		if (indexP >= 0 && indexP <= sP.length()-1)

			if (shouldKeepDecimal == true)
			{
				double newValueP = (double) valueP;
				output = sP.substring(0, indexP) + newValueP + sP.substring(indexP);
				//construct the string using the indexP as breakpoint, and fill the rest of string
			}
			else//cast the double if the boolean was false
			{
				int newValueP = (int) valueP;
				output = sP.substring(0, indexP) + newValueP + sP.substring(indexP);
			}
		else
		{
			output = sP;//if the indexP is invalid, return unaltered sP
		}	
		return output;
	}//end of insertAt method for Number to String

	/**
	 * <p>This method insert a string to another string based on a specified position.
	 * It takes three parameter to construct the output, and will return a string after the method.
	 * <p>For example, if the input combination is (String, 1, String), the result will be (SStringtring).
	 * 
	 * @param sP 		The string to be modified
	 * @param indexP	The position of the sP to insert. If the value is negative or bigger than the length of the sP, sP will be unaltered
	 * @param valueP	The string to insert to sP
	 * @return			The return type will be String after the insert method
	 */
	public static String insertAt(String sP, int indexP, String valueP)
	{	//Initialize a empty string to refer for the final return
		String output = "";
		//if condition to exam if the indexP is within the valid range
		if (indexP >= 0 && indexP <= sP.length()-1)
		{	
			//construct the string using the indexP as breakpoint, and fill the rest of string
			output = sP.substring(0, indexP) + valueP + sP.substring(indexP);
		}
		else
		{
			//otherwise the sP remain the same and will be refer to the output
			output = sP;
		}	
		return output;	//return the result
	}//end of insertAt method (for String to String)

	////////////////////////////////////// Three Numeric Methods ///////////////////////////////////////////////
	/**
	 * <p>This method exam a String input and evaluate get all the numeric region in it.
	 * The numeric region means any number combination (e.g.: 01, 20, 15), including numbers with decimal such as (0.2),
	 * it will return a String array will all the number region in it, and each region is one of the elements in the Array,
	 * and will be separates by commas. Notice that there will only one decimal for doubles, and each number will only be used once
	 * by the each region.
	 * <p>If the string has no numeric region in it, the method will return the whole string unaltered in array form with single element
	 * <p>For example, for St2ring10.0..1, the method will return [2, 10.0 ,1] 
	 *  
	 * @param sP 	The String element to be evaluated and extract numeric region
	 * @return		A String type Array with all the numeric element, or with the invalid result (string without numeric region)
	 */
	public static String[] getNumericalRegionsIn(String sP) 
	{
		/*
		 * My approach is to first scan the whole string and if encounter any number region, then 
		 * fill into a String ArrayList (since the length can be modified); then convert it back to the String array to match
		 * the same return type
		 * If the scanning encounter a decimal '.', than I will mark it as in region, and continue to scan for the next '.' or non-numeric character,
		 * when encounter the next exception, I will exit the region and fill the numeric region
		 * 
		 */

		//Create a ArrayList for filling elements, since the length of the Array is uncertain, ArrayList works better than Array
		ArrayList<String> numericalRegionArrayList = new ArrayList<String>();

		for(int i = 0; i<sP.length(); i++)//start the scanning of the string that we are going to evaluate
		{
			int counter = 0;//marker for us to evaluate if the decimal is already found

			boolean inRegion = false;//To include situation where numbers are next to each other, or has decimal in between (e.g. 23 and 2.3)
			boolean decimalFound = false;//a boolean to help us determine if the region has decimal, and won't get it for the second time

			if(Character.isDigit(sP.charAt(i)))//get the first number that is a digit --> a match!
			{
				inRegion = true;//now we are in the region
				while(inRegion)//continue to scan until out of the region
				{
					int j;//Initialize a integer j to to get the ending position of the region
					for(j =i+1; j<sP.length()&&inRegion; j++)
					{
						if(sP.charAt(j) =='.')	//if it is a decimal 
							//note that the reason that didn't check decimal before finding the first number is because it is invalid
						{
							if(decimalFound)//found a decimal!
							{
								inRegion = false;//you don't want to get a second one, so mark it to go out the while inRegion loop if encounter a next one
								j--;//since the next one is not in region, go back one position
							}
							else//otherwise, continue to scan for the next number
							{
								counter = j;
								decimalFound = true;		
							}
						}
						else if(!Character.isDigit(sP.charAt(j)))//if the character is not a number or decimal anymore, exit the loop
						{
							inRegion = false;
							j--;////since the next one is not a number, go back one position
						}
					}
					inRegion = false;//if ever exit the region, mark it back to false
					//now we are going to get the region
					if(j==counter+1)
						//since we might find the next decimal, or special character right after first decimal
						//we want to eliminate the first as well, so the region should be go back one more position
					{
						numericalRegionArrayList.add(sP.substring(i,j-1));
						i++;
					}
					else
					{
						numericalRegionArrayList.add(sP.substring(i,j));//else just get the region
					}
					i=j;//start from the end of the previous region, don't start from the beginning!
				}
			}
		}

		//now convert the result back to the appropriate return type
		//Reference here-->http://stackoverflow.com/questions/14223729/arraylist-to-array
		String[] numericalRegionArray = numericalRegionArrayList.toArray(new String[numericalRegionArrayList.size()]);

		if(numericalRegionArrayList.size()==0)//if there is no numerical region it it, the size will be zero
		{
			String[] notValid = {"\"" +sP+ "\""+ " contains no numerical regions"};//return the original string plus the message
			return notValid;
		}
		else
		{
			return numericalRegionArray;//otherwise, you get your numeric regions! 
		}

	}//end of getNumericalRegionIn method

	/**
	 * <p>Now this method will test if the String input has only one numeric region and give a true or false answer.
	 * This method will simply call the getNumericalRegionsIn, to get all the numerical region, if the length of the String array is not 1, than this
	 * method will return false; else it will examine the content to make sure it not a string array with a element that is not a number (can be a string element)
	 * <p>For example, string "12hello" will return true while string "12hello12" will return false
	 * @param sP	The String input for evaluation
	 * @return		A boolean value on if there is only one numeric region 	
	 */

	public static boolean hasSingleNumericalRegionInIt(String sP) 
	{
		/*
		 * My method will first call the getNumericalRegionIn method to evaluate the sP, which will return a String Array
		 * Then I will get the length of the array, if it is bigger than 1, than simply pass the false result;
		 * If it is one, there might be the case that the String Array has a non-numeric element in it, so we need to test if the element is all number
		 * by calling the private method checkIfStringhasIsAllNumer, if it is true, than the it will return true.
		 * 
		 */

		//call the getNumericalRegionsIn method and received a string array, then get the length for examination
		int length = (getNumericalRegionsIn(sP)).length;

		boolean hasSingleRegion = false;

		if(length ==1)
		{
			//check in case it is the string case
			if(checkIfStringhasIsAllNumer(getNumericalRegionsIn(sP)[0]))//call a private method that I wrote to evaluate the element
			{
				hasSingleRegion = true;
			}
			else
			{
				hasSingleRegion = false;
			}
		}
		else//if the length is bigger than 1
		{
			hasSingleRegion = false;
		}
		return hasSingleRegion;
	}//end of hasSingleNumericalRegionInIt method

	/**
	 * <p>This method will extract the first numerical region of from a string
	 * The program is based on the previous two program, where it will call the getNumericalRegionsIn 
	 * method to receive all the region in String array and return the first element in the array and convert them
	 * back to a string.
	 * <p> For example, for String "12hello90.0" will return "12".
	 * 
	 * @param sP	The string to extract element	
	 * @return		A string with all the numeric element from the string's first numeric region
	 */
	public static String extractFirstNumericalArea(String sP) 
	{
		//simply call the getNumericalRegionsIn method and get the element at the first position, which has a index of 0
		String extractFirstRegion = getNumericalRegionsIn(sP)[0].toString();
		//convert it to the string using the same method that convert an string ArrayList to a string 
		//(i simply use the java library and find the method when i type '.' after a string array

		return extractFirstRegion;
	}//end of extractFirstNumericalArea method

	/**
	 * <p> This private method check if a String has only number in it to help me delegate task from the previous three methods
	 * 
	 * @param sP The string to evaluate
	 * @return	 Return if the condition is true
	 */
	private static boolean checkIfStringhasIsAllNumer(String sP)
	{
		//initialize a boolean for reference the condition
		boolean isAllNumber = true;

		String s = sP;
		//to check the next char in case the number has more than one digit or even has a decimal
		boolean checkNextCharInString = true;

		for(int i =0; i<s.length()&&checkNextCharInString; i++)
		{
			if(Character.isDigit(s.charAt(i))||(i>0 &&s.charAt(i) == '.'))
				//the condition is reasonable since the getting the numerical region already eleminate the possiblity of having
				//two decimals or even special character in the region
			{

				checkNextCharInString = true;
				if(i==s.length()-1)//stop the checking since it is at the end of the string
				{
					isAllNumber = true;
				}
			}
			else
			{
				isAllNumber = false;
				checkNextCharInString = false;
			}	
		}
		return isAllNumber;
	}//end of checkIfStringhasIsAllNumer method


	////////////////////////////////////enhancedSub to CheckString and Highlight//////////////////////////////////
	/**
	 * <p>This method will check if one string has another string in it. 
	 * It will evaluate two parameter, the sP, which is the outer string, and enhancedSub the inside string.
	 * However, the method is not case sensitive, so 'A' and 'a' will be
	 * treated as the same letter. The method will only continue to evaluate if the inside String is composed of all letter.
	 * Otherwise, it will return a false.
	 * <p> For example, if the enhancedSub is "letter" and the sP is "LETT2ER", it will return true.
	 * If the enhancedSub is "lett2er", and the sP is "LETT2ER", it will return false right away.
	 * 
	 * @param sP			The string to check if has another string in it.
	 * @param enhancedSub	The string to be evaluate as a insider of the sP
	 * @return				Return a boolean value of the result
	 */
	public static boolean doesThisStringHasThisOtherStringInIt(String sP, String enhancedSub) 
	{

		/* My logic was first convert both of the parameter to lower case in order to compare them
		 * Then I will convert the larger string sP to character array, to help me check each character with the
		 * enahncedSub
		 * Once all the element of the enhancedSub is found or not found after finish the scanning
		 * The program will return the corresponding boolean value
		 */

		//convert both string to lower case since the method is not case sensitive
		String sPLowerCase =sP.toLowerCase();
		String enhancedSubLowerCase =enhancedSub.toLowerCase();

		//since we need to exam every character of the sP, instead of using the String.charAt(index), character array with
		//enhanced loop with ease the process (textbook on enhanced loop)
		//also, when i am debugging, i can see the element updated in the variable table
		char[] sPToCharArray = sPLowerCase.toCharArray();//same reference to the ArrayList to Array

		boolean hasStringInOtherString = false;

	
		boolean finished = false;//a marker to check if we finish finding the enhanceSub 
		int j =0;//a value to make sure that we check every element of the enhancedSub
		int counter =0;//to check if we finish the enhancedSub before finish scanning the whole sP

		//Special case:the string enhancedSub is empty, so it is equal to every other string
		if(enhancedSubLowerCase.equals("")) {hasStringInOtherString = true;}
		//if it is not a letter, we wont even exam it
		else if(checkIfStringhasNoLetter(enhancedSub)) {hasStringInOtherString = false;}
		//or if every match
		else 
		{
			while(!finished)//prevent exiting the loop before finishing the scanning
			{

				for(char element:sPToCharArray)
					//Equivalent for a for loop where the method will check every element of the sP, and increase by one
					//for every loop, and will stop at the end of the element
				{ 
					boolean checkNextOne = false;

					for(int i=j; i<enhancedSubLowerCase.length()&&!checkNextOne; i++)
					{
						if(element ==enhancedSubLowerCase.charAt(i))
						{
							counter++;
							i++;
							if(counter==enhancedSubLowerCase.length())
								//means that we already found all the enhancedSub element in the sP and can exit the while loop
							{
								finished = true;
								hasStringInOtherString = true;
							}
						}
						checkNextOne = true;
						j=i;
					}
					finished = true;
				}
			}
		}
		return hasStringInOtherString;
	}//end of the doesThisStringHasThisOtherStringInIt method

	/**
	 * <p>This method will check if a string has another string in it (for a reversed form).
	 * Similar to the previous idea, this will exam if the larger string sP has the enhancedSub in it, but
	 * in a reverse form (e.g.: string as gnirts). The program will only evaluate if the enhancedSub has only letter, otherwise
	 * it will return false.
	 * 
	 * @param sP			The string to check if has another string in it.
	 * @param enhancedSub	The string to be evaluate as a insider of the sP 
	 * @return				Return a boolean value of the result
	 */
	public static boolean doesThisStringHasThisOtherStringInItReversed(String sP, String enhancedSub) 
	{
		/*
		 * My method will be similar to the previous one (transform to lower case, exam if enhancedSub is all letter, and
		 * start the scanning loop) except that i will add a reverse string private method
		 * to help me convert the enhancedSub before evaluating it
		 * 
		 */
		
		//convert both string to lower case since the method is not case sensitive
		String sPLowerCase =sP.toLowerCase();
		String enhancedSubLowerCase =enhancedSub.toLowerCase();

		//char[] enhancedSubToCharArray = enhancedSub.toCharArray();
		char[] sPToCharArray = sPLowerCase.toCharArray();

		boolean hasStringInOtherString = false;

		
		boolean finished = false;
		int j =0;

		int counter =0;

		if(enhancedSubLowerCase.equals("")) {hasStringInOtherString = true;}
		else if(checkIfStringhasNoLetter(enhancedSub)) {hasStringInOtherString = false;}
		else 
		{ 
			String enhancedSubLowerCaseReversed = reverseString(enhancedSubLowerCase);//reverse the string before evaluate it
			while(!finished)
			{
				for(char element:sPToCharArray)
				{ 
					boolean checkNextOne = false;

					for(int i=j; i<enhancedSubLowerCaseReversed.length()&&!checkNextOne; i++)
					{
						if(element ==enhancedSubLowerCaseReversed.charAt(i))
						{
							counter++;
							i++;
							if(counter==enhancedSubLowerCaseReversed.length())
							{
								finished = true;
								hasStringInOtherString = true;
							}
						}
						checkNextOne = true;
						j=i;
					}
					finished = true;
				}
			}
		}
		return hasStringInOtherString;
	}//end of the doesThisStringHasThisOtherStringInItReversed


	/**
	 *<p>This method will highlight one string (enhancedSub) in another string(sP) if they are inclusive.
	 *The highlight will be achieved by inserting specified number of space(howManySpacesP) between the founded element.
	 *If the letter are found next to each other, it will only insert before and after the found region.
	 *It will also capitalized all the enhancedSub element and lower case those are not, and modify the sP.
	 *<p> For example, if enhanceSub is banana, and the sP is 1ba2n2a3na, and the space is 1. The output will be
	 *1 BA 2 N 2 A 3 NA . If the sP has no enhancedSub in it, it will return unmodified. If the enhancedSub is a empty 
	 *string "", it will return sP in all lower cases.
	 *
	 * @param sP				The string to be modified and check if it has another string in it
	 * @param enhancedSub		The string to be highlighted
	 * @param howManySpacesP	The space to insert between the highlight element
	 * @return					Return the highlighted string or in other form based on the condition
	 */
	public static String highlightWordInString(String sP, String enhancedSub, int howManySpacesP) 
	{
		/*	My approach is to first check if the enhancedSub is valid letter string, if so
		 * then I will test if the string has another string in it. If the above two assumption are matched, then the program will
		 * start scanning the character and capitalize and add space as it go.
		 */
		String toHighlight = enhancedSub;//rename them to help me track the change
		String toModify = sP;
		String toInsert = "";

		for (int i = 0; i < howManySpacesP; i++) {
			toInsert = toInsert + " ";
		}

		if(!checkIfStringhasNoLetter(enhancedSub)&& enhancedSub !="")//Test if the enhancedSub is a valid string of letters, otherwise, it will return the original string unaltered
		{
			if(doesThisStringHasThisOtherStringInIt(toModify, toHighlight))//if  
			{			
				toHighlight = toHighlight.toLowerCase();
				toModify = toModify.toLowerCase(); // change whole string to lower case, and capitalize only those are appeared in the enhancedSub

				int k = 0;//a marker to prevent scanning the same position again 
				for(int j = 0; j < toHighlight.length(); j++)//take the element of the enhancedSub for the scanning
				{
					for(int i = k; i < toModify.length(); i++) //start the scanning from the sP
					{
						if(toHighlight.charAt(j) == toModify.charAt(i))
						{
							if (k < i) //prevent scanning the same position again
							{
								k = i;
								toModify = toModify.substring(0, i) + toModify.substring(i, i+1).toUpperCase() + toModify.substring(i+1, toModify.length());
								//capitalize the highlight element
							}

							// to insert space to the right side of highlight
							if (i < toModify.length()-1 && j < toHighlight.length()-1 && toModify.toLowerCase().charAt(i+1) != toHighlight.charAt(j+1)) 
							{
								toModify = insertAt(toModify, i+1, toInsert);
							}
							// to insert space to  the left side of highlight
							if (i != 0 && j != 0 && toModify.toLowerCase().charAt(i-1) != toHighlight.charAt(j-1)) 
							{
								toModify = insertAt(toModify, i, toInsert);
							}
							// Special Case for if found the first letter of enhancedSub 
							if (j == 0) 
							{
								if(i!=0)//to add a space if the first letter of enhancedSub isn't found at the first position of sP
								{
									toModify = insertAt(toModify, i, toInsert);
								}
								toModify = toModify.substring(j,j+1).toUpperCase() + toModify.substring(j+1);//transfer them to the upper case
							}
							// Special Case if found the last letter of enhancedSub's character
							if (j == toHighlight.length()-1) 
							{
								toModify = insertAt(toModify, i+howManySpacesP*2, toInsert);//insert space
							}
							break;//exit and scan for the next possible region 
						}
					}
				}
				return toModify;
			}
			else
			{
				return toModify;
			}
		}
		else if (enhancedSub.equals(""))
		{
			return toModify.toLowerCase();
		}
		else	
		{
			return toModify;
		}
	}	


/**
 * <p>This method is to check if a string has element that is not letter.
 * This can be used for any method above that need to exam if the enhancedSub has only letter in it.
 * This program is similar to the checkIfStringIsAllNumber
 * 
 * @param charArrayFromString	A string to be scanned if only has letters in it
 * @return 						A boolean value on if the evaluation give true or false
 */
	private static boolean checkIfStringhasNoLetter(String charArrayFromString)
	{
		boolean hasNoLetter = true;
		String s = charArrayFromString;
		boolean checkNextCharInString = true;

		for(int i =0; i<s.length()&&checkNextCharInString; i++)
		{
			if(Character.isLetter(s.charAt(i)))//if the character is a letter (similar to the isDigit method)
			{
				checkNextCharInString = true;
				if(i==s.length()-1)
				{
					hasNoLetter = false;
				}
			}
			else
			{
				hasNoLetter = true;
				checkNextCharInString = false;
			}	
		}
		return hasNoLetter;
	}


	/**
	 * <p>A private method to reverse a string enhancedSub for the method that exam if a string has another string in reversed form in it
	 * 
	 * @param stringToReverse 	The string to be reversed its order
	 * @return					The string be reversed
	 */
	private static String reverseString(String stringToReverse)
	{

		String s = stringToReverse;
		String output = "";
		//recreate the string by add the string's character element from right to left
		for(int i=s.length()-1; i>=0; i--)
		{
			output += s.charAt(i);
		}
		return output;

	}


	///////////////////////////////////////DrawThings///////////////////////////////////////////////
	/**
	 * <p>This method will draw two tree shape ASCII pictures by taking two parameter to determine its base and height.
	 * The left side of the tree will be construct by repeating the same parameter, which will be determined by the times that is
	 * need to repeat, then it will square the element for each row, and receive a math result for the left part of the drawing.
	 * The two parameter need to be between the range of [1,9], or it will be decreased to 9 or increased to 1 as needed.
	 * Each line of the drawing will consist of the the equation as well as the result of the calculation. To construct the pyramid shape,
	 * the drawing will add appropriate number of space based on the parameters.
	 * 
	 * @param whichDigitP			The digit to construct the left side of the number to multiply each other
	 * @param howManyTimesP			The digit to determine how many rows that will be needed
	 * @return						A char type 2D array that store all the element with one character for each subArray, though the length
	 * 								will vary based on he calculation
	 */

	public static char[][] drawTop(byte whichDigitP, byte howManyTimesP)//remember to change void back to char[][]
	{
		/*
		 * My method will first convert the parameter to the proper range, and then start getting the right side of the numbers using for loop
		 * and store it in a String Array form. 
		 * While I am creating the right part, I will convert string element into number form using the model that
		 * Nick gave us during the lecture. I will store them as long to fit the multiplication. 
		 * Then I will use these numbers to get the math result and store them in another long.
		 * After I have all the element for each row, I will fill all the element through a string array, and each row will be one element.
		 * Then I will convert it back to a jagged char [][] with variable length size. 
		 *
		 * To print them, I used the notes that Nick provided during the class in the Pratice2d.java and 
		 * modified it to print char [][] and use it for the main method.
		 * 
		 */
		//convert the input parameter to the proper range
		if(whichDigitP>9 || whichDigitP <1)
		{
			if(whichDigitP>9)
				{
					whichDigitP = 9; 
				}
			else
			{
				whichDigitP = 1; 
			}
		}	
		
		if(howManyTimesP>9 || howManyTimesP <1)
		{
			if(howManyTimesP>9)
				{
				howManyTimesP = 9; 
				}
			else
			{
				howManyTimesP = 1; 
			}
		}

		//construct the left sides as string format and convert it to number
		String constructNumertoMultiply = "";
		String [] getLeftNumberAsString = new String [howManyTimesP];
		long [] convertLeftStringToNumber = new long [howManyTimesP];//at the same time store them as numbers array

		for (int i=0; i<howManyTimesP; i++)
		{
			constructNumertoMultiply += whichDigitP;//get the number
			getLeftNumberAsString[i] = constructNumertoMultiply;//store them in string
			convertLeftStringToNumber[i] = convertStringToNumber(getLeftNumberAsString[i]); //convert them to number right away as we are looping
		}

		//then I can use those numbers to calculate the math result, and store them in another numeric array. 
		long [] mathResult = new long [howManyTimesP];
		for(byte i=0; i<howManyTimesP; i++)
		{
			mathResult[i] = convertLeftStringToNumber[i]*convertLeftStringToNumber[i];
		}



		//now start the drawing by initializing a string with the length of the row (which is howManyTimesP)
		String [] getEachRowToString = new String [howManyTimesP];


		for(int i=0; i<howManyTimesP; i++)//print this many lines
		{
			getEachRowToString[i]= new String();//initialize each time, otherwise it will point to a null object (chap8.2.1)
			//print space
			for(int j=0; j<howManyTimesP-i-1; j++)//print this many space 
				//since for each lines, we will have one more space than the previous line on both side, we use howManyTimesP-i-1
			{
				getEachRowToString[i] +=" ";

			}

			//print left number to multiply 
			getEachRowToString[i] += getLeftNumberAsString[i];
			//print the multiplier
			getEachRowToString[i] +="*";
		
			getEachRowToString[i] += getLeftNumberAsString[i];//print the left side of space

			for(int j=0; j<howManyTimesP-i-1; j++)
			{
				getEachRowToString[i] +=" ";

			}
			getEachRowToString[i] +=" = ";//fill the equal side

			for(int j=0; j<howManyTimesP-i-1; j++)//fill the space after the equal side
			{
				getEachRowToString[i] +=" ";

			}

			if (whichDigitP == 3 &&i==0&&howManyTimesP>1)//for special case where 3*3=9, which is not symmetric for the next line, we will add a zero
			{
				getEachRowToString[i] += "0" + mathResult[i];
			}
			else
			{
				getEachRowToString[i] += mathResult[i];//otherwise, fill whatever is in it
			}
		}
		//now convert the string to jagged character array
		
		char [][] output = new char [howManyTimesP][];

		for(int i=0; i<howManyTimesP; i++)
		{
			output[i]= new char[getEachRowToString[i].length()]; //Initialize the char 2D array since now we have the size for each row by getting the string length
					

			for(int j=0; j<getEachRowToString[i].length(); j++)//this is actually similar to the print 2D array method that nick gave us
			{
				output[i][j] = getEachRowToString[i].charAt(j);
			}
	
		}
		return output;
	}//end of drawTop!
	
	/**
	 * <p>This method will draw a rectangular shape ASCII picture by taking two parameter to determine its base and height.
	 * The left side of the tree will be construct by a one digit parameter (howManyTimesP) two digits number. It will increase the first digit from 0 to the parameter, and
	 * decrease the second digit from the parameter to 1.
	 * <p> For example, if we have 4 for the parameter, the method will construct 04,13,22,31. 
	 * Then it will multiply these string of numbers to another parameter (theNumberP), then construct each result and the calculation to the drawing.
	 * <p>Note that the valid range for the howManyTimesP is [1,9], and for theNumberP is [1,99999999]
	 *
	 * 
	 * @param howManyTimesP			The byte type digit to construct the left side of the number to multiply each other
	 * @param theNumberP			The integer type number to multiply the previous constructed number
	 * @return						A char type 2D array that store all the element with one character for each subArray, and the length for each row will be the same
	 *
	 */
	public static char[][] drawBody(byte howManyTimesP, int theNumberP)//change name back!
	{
		/*
		 * Same logic as the previous method: get the proper form of numbers, construct the left side to a string array, and transform to a number to calculate the
		 * math result, then construct the drawing into a string array first, and then transform it back to the char 2D Array
		 */
		
		//check and transform the parameter to a proper form
		if(howManyTimesP>9 || howManyTimesP <1)
		{
			if(howManyTimesP>9)
				{
				howManyTimesP = 9; 
				}
			else
			{
				howManyTimesP = 1; 
			}
		}	
		
		if(theNumberP>99999999 || theNumberP <1)
		{
			if(theNumberP>99999999)
				{
				theNumberP = 99999999; 
				}
			else
			{
				theNumberP = 1; 
			}
		}	

		//construct the number from the left side
		String constructNumer = "";
		String [] getLeftNumber = new String [howManyTimesP];//by creating a string array
		long [] convertLeftStringToNumberforBody = new long [howManyTimesP];//and use the private method to convert it to numbers for calculation

		//construct math result
		for (int i=0; i<howManyTimesP; i++)
		{
			constructNumer = i+""+(howManyTimesP-i);
			getLeftNumber[i] = constructNumer;//get the string array first
			convertLeftStringToNumberforBody[i] = convertStringToNumber(getLeftNumber[i]); //then convert it to a long numeric array
		}


		//now start the drawing
		long [] mathResult = new long [howManyTimesP];
		String [] getMathResult = new String [howManyTimesP];//get the string array in order to convert use for character array

		for(byte i=0; i<howManyTimesP; i++)
		{
			mathResult[i] = convertLeftStringToNumberforBody[i]*theNumberP;
			getMathResult[i] = ""+ mathResult[i];
		}

		String [] getEachRowToString = new String [howManyTimesP];
		for(int i=0; i<howManyTimesP; i++)
		{
			getEachRowToString[i]= new String();//initialize the string array so it won't point to a null object

			getEachRowToString[i] += theNumberP + "*" +getLeftNumber[i] + " = " ;

					
			if ((i+1<howManyTimesP)&&(getMathResult[i]+"").length()<(getMathResult[i+1]+"").length())
			{
				getEachRowToString[i] += "0" + getMathResult[i];//for case that the length of the result is less than the next result, we want it to be symmetric by adding a 0

			}
			else
			{
				getEachRowToString[i] += getMathResult[i];//otherwise, you fill in what you got!
			}
		}

		//construct your char [][] for the drawing by convert the string to jagged character array
		char [][] output = new char [howManyTimesP][];
		for(int i=0; i<howManyTimesP; i++)
		{
			output[i]= new char[getEachRowToString[i].length()];

			for(int j=0; j<getEachRowToString[i].length(); j++)
			{
				output[i][j] = getEachRowToString[i].charAt(j);
			}
		}
		return output;
	}//end of drawBody method
	
	/**
	 * <p>This method will draw a one triangle shape ASCII picture by taking two parameter to determine its base and height.
	 * The left side of the triangle will be construct by getting a sequence of numbers using the howManyTimesP.
	 * <p> For example, if we have 4 for the parameter, the method will construct 1,12,123,1234. 
	 * Then it will multiply these string of numbers to another parameter (factor), then add the multiplied result to the row number. 
	 * Then it will take the math result and build the equation. It will add appropriate amount of space on the left to construct the triangle shape
	 * <p> For example, if howManyTimesP is 4, and theNumberP is 1. We will have
	 * <p>1*1+1 = 2
	 * <p>12*1+2 = 14
	 * <p>123*1+3 = 126
	 * 
	 * <p>Note that the valid range for the howManyTimesP is [1,14], and for theNumberP is [1,14]
	 * 
	 * @param howManyTimesP
	 * @param factorP
	 * @return
	 */
	public static char[][] drawBase(byte howManyTimesP, byte factorP)//char[][]
	{
		/*
		 * Same logic as the previous method: get the proper form of numbers, construct the left side to a string array, and transform to a number to calculate the
		 * math result, then construct the drawing into a string array first, and then transform it back to the char 2D Array.
		 */
		if(howManyTimesP>14 || howManyTimesP <1)
		{
			if(howManyTimesP>14)
				{
					howManyTimesP = 14; 
				}
			else
			{
				howManyTimesP = 1; 
			}
		}	
		if(factorP>14 || factorP <1)
		{
			if(factorP>14)
				{
					factorP = 14; 
				}
			else
			{
				factorP = 1; 
			}
		}
		
		String constructNumertoMultiply = "";
		String [] getLeftNumberAsString = new String [howManyTimesP];
		long [] convertLeftStringToNumber = new long [howManyTimesP];

		//construct the number
		for (int i=0; i<howManyTimesP; i++)
		{
			constructNumertoMultiply += (1+i);

			getLeftNumberAsString[i] = constructNumertoMultiply;
			convertLeftStringToNumber[i] = convertStringToNumber(getLeftNumberAsString[i]);
		}
		//calculate the result
		long [] mathResult = new long [howManyTimesP];
		for(byte i=0; i<howManyTimesP; i++)
		{
			mathResult[i] = (long)(convertLeftStringToNumber[i]*factorP+i+1);
		}

		String [] getEachRowToString = new String [howManyTimesP];

		for(int i=0; i<howManyTimesP; i++)//print this many lines
		{
			getEachRowToString[i]= new String();

			
			//print space since this is the only place have variable length that need to loop
			for(int j=0; j<howManyTimesP-i-1; j++)
			{
				getEachRowToString[i] +=" ";

			}
			//print the rest of things in a row 
			getEachRowToString[i] += getLeftNumberAsString[i] +"*"+factorP+"+"+(i+1)+ " = " + mathResult[i];

		}

		char [][] output = new char [howManyTimesP][];
		for(int i=0; i<howManyTimesP; i++)
		{
			output[i]= new char[getEachRowToString[i].length()];

			for(int j=0; j<getEachRowToString[i].length(); j++)
			{
				output[i][j] = getEachRowToString[i].charAt(j);
			}	
		}
		return output;
	}//end of drawBase method

	//	Nick's notes
	/**
	 * This private method help to print a 2D array and was given by Nick
	 * 
	 * @param chr 	The character arrays that will be print one by one character
	 */
	private static void printTheArray(char[][] chr)
	{
		for (int i = 0; i<chr.length; i++) 
		{ 
			for (int j = 0; j<chr[i].length; j++) 
			{ 
				System.out.print(chr[i][j]);
			}
			System.out.println();
		}
	}


	/**
	 * This private method convert a numeric string to its numbers.
	 * The method was given by Nick during the class as well.
	 * It used the switch (or if) approach to check each character of the string as see if it match the 0-9 number.
	 * 
	 * @param sP		The string to be evaluate one character by one character.
	 * @return			A integer that is constructed through the string.
	 */
	private static int convertStringToNumber(String sP) 
	{
		String theString = sP;

		int theIntegerIshouldReturn = 0;

		int howManyCharactersDoWeHave = theString.length();

		int whatToMultiplyWith = 1;

		for (int i=howManyCharactersDoWeHave-1; i>=0; i--)
		{
			char currentCharacter = theString.charAt(i);

			switch (currentCharacter)
			{
			case '0':
				theIntegerIshouldReturn = theIntegerIshouldReturn+0*whatToMultiplyWith;
				break;
			case '1':
				theIntegerIshouldReturn = theIntegerIshouldReturn+1*whatToMultiplyWith;
				break;
			case '2':
				theIntegerIshouldReturn = theIntegerIshouldReturn+2*whatToMultiplyWith;
				break;
			case '3':
				theIntegerIshouldReturn = theIntegerIshouldReturn+3*whatToMultiplyWith;
				break;
			case '4':
				theIntegerIshouldReturn = theIntegerIshouldReturn+4*whatToMultiplyWith;
				break;
			case '5':
				theIntegerIshouldReturn = theIntegerIshouldReturn+5*whatToMultiplyWith;
				break;
			case '6':
				theIntegerIshouldReturn = theIntegerIshouldReturn+6*whatToMultiplyWith;
				break;
			case '7':
				theIntegerIshouldReturn = theIntegerIshouldReturn+7*whatToMultiplyWith;
				break;
			case '8':
				theIntegerIshouldReturn = theIntegerIshouldReturn+8*whatToMultiplyWith;
				break;
			case '9':
				theIntegerIshouldReturn = theIntegerIshouldReturn+9*whatToMultiplyWith;
				break;
			default:
			{
				System.out.println(theString+" was not an integer");
				System.exit(0);
			}
			break;
			}
			whatToMultiplyWith = whatToMultiplyWith*10;
		}//end of for loop...so at this point we checked EVERY character
		return theIntegerIshouldReturn;
	}//end of checking method
	/**
	 * This method generate random numbers based on the seed Parameter. 
	 * The two random numbers is corresponding to the drawTop method, and will be transform back to the proper range.
	 * Then the method will call the drawTop method and input the two generated parameters.
	 * 
	 * @param seedP		The numeric parameter to construct the random method
	 * @return			A drawing constructed by a char 2D array
	 */
	public static char[][] drawTop(long seedP)
	{
		Random random = new Random(seedP);
		byte whichDigitP = (byte)(random.nextInt(9)+1);
		//since the range should no be bigger than 9, but has to consider 9, we use plus 9+1 and it won't decimal since it is a integer
		//casting it back to byte since we are getting a integer
		byte howManyTimesP = (byte)(random.nextInt(9)+1);
		return drawTop(whichDigitP, howManyTimesP);
	}
	/**
	 * This method generate random numbers based on the seed Parameter. 
	 * The two random numbers is corresponding to the drawTop method, and will be transform back to the proper range.
	 * Then the method will call the drawBase method and input the two generated parameters.
	 * 
	 * @param seedP		The numeric parameter to construct the random method
	 * @return			A drawing constructed by a char 2D array
	 */
	public static char[][] drawBase(long seedP) 
	{
		Random random = new Random(seedP);
		byte howManyTimesP = (byte)(random.nextInt(14)+1);//since the range should no be bigger than 14, but has to consider 14, we use plus 1
		//casting it back to byte since we are getting a integer
		byte factor = (byte)(random.nextInt(14)+1);
		return drawBase(howManyTimesP, factor);
	}
	/**
	 * This method generate random numbers based on the seed Parameter. 
	 * The two random numbers is corresponding to the drawTop method, and will be transform back to the proper range.
	 * Then the method will call the drawBody method and input the two generated parameters.
	 * 
	 * @param seedP		The numeric parameter to construct the random method
	 * @return			A drawing constructed by a char 2D array
	 */

	public static char[][] drawBody(long seedP)
	{
		Random random = new Random(seedP);
		byte howManyTimesP = (byte)(random.nextInt(9)+1);
		//since the range should no be bigger than 9, but has to consider 9, we use plus 9+1 and it won't decimal since it is a integer
		//casting it back to byte since we are getting a integer
		int theNumberP = random.nextInt(99999999)+1;//since the range should no be bigger than 9, but has to consider 99999999, we use plus 99999999+1 and it won't decimal since it is a integer
		return drawBody(howManyTimesP, theNumberP);	
	}


}	