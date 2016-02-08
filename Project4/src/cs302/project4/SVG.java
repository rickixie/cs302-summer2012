package cs302.project4;
///////////////////////////////////////////////////////////////////////////////
//Semester: CS302 Summer 2014
//Author: Si Xie (Ricki)
//Email: sxie27@wisc.edu
//Lecturer's Name: Nick Pappas//
//
//Credits: (list anyone/anything who helped you write your program) 
//  1) http://stackoverflow.com/questions/389741/continue-keyword-in-java
//	2) http://stackoverflow.com/questions/13939675/java-string-split-i-want-it-to-include-the-empty-strings-at-the-end
//	3) http://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-a-numeric-type-in-java
//////////////////////////// 80 columns wide //////////////////////////////////


//import every class, new library and exceptions that will be needed
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This SVG stores a array of shapes that can be drew to the Pixmap that will presents all these shapes.
 * The array of shapes is expendable, and will include all the information that defines types of shape.
 * @author rickixie
 *
 */
public class SVG {

	private ArrayList<Shape> newShape;

	/**
	 * The default contructor of the SVG where it creates empty array list of shapes.
	 */
	public SVG(){
		//create a empty arraylist
		newShape = new ArrayList<Shape>();
	}
	/**
	 * This is the constructor for SVG that takes a argument of file that contains the command lines that can create a shape.
	 * @param fileName	The name of the file that contains the lines of command to create shape
	 * @throws FileNotFoundException if the file is read only or cannot be found
	 * @throws SVGFormatException if the command lines can't create a new shape due to the format mistakes
	 */
	public SVG(String fileName)throws FileNotFoundException, SVGFormatException{

		/*
		 * Logic: 
		 * This method will scan the command files line by lines and convert it to corresponding type of value, and
		 * create shape that will corresponding to these parameters. 
		 * In order to get the valid argument, a new scanner will be create and check each elements of a single command line
		 * with the help of several private methods, it will throw corresponding exception to the SVGExporter.
		 * 
		 * 
		 */
		Scanner myScanner = null;//scanner to read the whole file line by line

		File f = new File(fileName);//create a file object that represent a file that response to everything
		myScanner = new Scanner(f);//including throwing exception, printing

		newShape = new ArrayList<Shape>();//intialize the shape arraylist to store the shape


		while (myScanner.hasNextLine()) //as long as the file has line
		{
			String shapeArguement = myScanner.nextLine();//store it for evaluation if it is the right format to create a shape


			String[] arguementComponenent = shapeArguement.split(" ", -1);//by breaking it down by component

			Scanner scn = new Scanner(shapeArguement);//a new scanner to scan each element
			try
			{
				if(scn.hasNext()&&checkShapeArguementComponent(arguementComponenent))
				//as long as the argument is valid after the checking, and the method will take each element to construct the shape
				{

					//list of variables that used to store shape parameters
					Color c = new Color (0,255,0);
					double originX = 0;
					double originY = 0;
					double radiusP = 0;
					double widthY = 0;
					double heightY = 0;
					double sizeP = 0;
					double outerRadiusP = 0;
					double innerRadiusP = 0;
					double baseP = 0;
					//check each element
					switch(scn.next())//Separate the argument by shape type
					{
					case "circle":
						c = new Color (scn.nextInt(), scn.nextInt(), scn.nextInt());
						originX = scn.nextDouble(); 
						originY = scn.nextDouble();
						radiusP = scn.nextDouble();
						Circle newCircle = new Circle(c,originX, originY,radiusP);//create a new shape object
						newShape.add(newCircle);//add to the arraylist
						break;
					case "triangle":
						c = new Color (scn.nextInt(), scn.nextInt(), scn.nextInt());
						originX = scn.nextDouble(); 
						originY = scn.nextDouble();
						baseP  = scn.nextDouble();
						Triangle newTriangle = new Triangle(c,originX, originY,baseP);
						newShape.add(newTriangle);
						break;
					case "triangle_right_down":
						c = new Color (scn.nextInt(), scn.nextInt(), scn.nextInt());
						originX = scn.nextDouble(); 
						originY = scn.nextDouble();
						baseP  = scn.nextDouble();
						Triangle_Right_Down newTriangleRightDown = new Triangle_Right_Down(c,originX, originY,baseP);
						newShape.add(newTriangleRightDown);
						break;	
					case "triangle_right_up":
						c = new Color (scn.nextInt(), scn.nextInt(), scn.nextInt());
						originX = scn.nextDouble(); 
						originY = scn.nextDouble();
						baseP  = scn.nextDouble();
						Triangle_Right_Up newTriangleRightUp = new Triangle_Right_Up(c,originX, originY,baseP);
						newShape.add(newTriangleRightUp);
						break;
					case "triangle_left_down":
						c = new Color (scn.nextInt(), scn.nextInt(), scn.nextInt());
						originX = scn.nextDouble(); 
						originY = scn.nextDouble();
						baseP  = scn.nextDouble();
						Triangle_Left_Down newTriangleLeftDown = new Triangle_Left_Down(c,originX, originY,baseP);
						newShape.add(newTriangleLeftDown);
						break;
					case "crescent":
						c = new Color (scn.nextInt(), scn.nextInt(), scn.nextInt());
						originX = scn.nextDouble(); 
						originY = scn.nextDouble();
						radiusP = scn.nextDouble();
						Crescent newCrescent = new Crescent(c,originX, originY,radiusP);
						newShape.add(newCrescent);
						break;
					case "square_ring":
						c = new Color (scn.nextInt(), scn.nextInt(), scn.nextInt());
						originX = scn.nextDouble(); 
						originY = scn.nextDouble();
						radiusP = scn.nextDouble();
						Square_Ring newSquareRing = new Square_Ring(c,originX, originY,radiusP);
						newShape.add(newSquareRing);
						break;
					case "rectangle":
						c = new Color (scn.nextInt(), scn.nextInt(), scn.nextInt());
						originX = scn.nextDouble(); 
						originY = scn.nextDouble();
						widthY = scn.nextDouble();
						heightY = scn.nextDouble();
						Rectangle newRectangle = new Rectangle(c,originX, originY,widthY,heightY);
						newShape.add(newRectangle);

						break;
					case "square":
						c = new Color (scn.nextInt(), scn.nextInt(), scn.nextInt());//ALSO COLOR SHOULD BE BETWEEN 0-255
						originX = scn.nextDouble(); 
						originY = scn.nextDouble();
						sizeP = scn.nextDouble();
						Square newSquare = new Square(c, originX,originY,sizeP);
						newShape.add(newSquare);
						break;	
					case "ring":

						c = new Color (scn.nextInt(), scn.nextInt(), scn.nextInt());
						originX = scn.nextDouble();
						originY = scn.nextDouble();
						outerRadiusP = scn.nextDouble();
						innerRadiusP = scn.nextDouble();

						Ring newRing = new Ring(c, originX,originY,outerRadiusP, innerRadiusP);
						newShape.add(newRing);
						break;
					case "quadrant":
						c = new Color (scn.nextInt(), scn.nextInt(), scn.nextInt());
						originX = scn.nextDouble();
						originY = scn.nextDouble();
						sizeP = scn.nextDouble();
					
						Quadrant newQuadrant = new Quadrant(c, originX,originY,sizeP);
						newShape.add(newQuadrant);
						break;
					default:
						throw new SVGFormatException();//if the first shape type argument was wrong, throw the SVGFormatException

					}//END OF SWITCH
				}//IF THE STRING HAS VALID LENGTH AND ELEMENTS
				//IF doesn't has NEXT ELEMENT, or the argument is invalid after the checking (return false)
				else{
					throw new SVGFormatException();
				}
			}//END OF INNER TRY

			finally//close the scanner if we have done something
			{
				if (scn != null) 
				{
					scn.close();
				}
			}
		}//END OF WHILE and scanning the whole file
		myScanner.close();
	}


	/**
	 * This private method used to check if the line argument for creating shape is valid by checking every element of the shape.
	 * @param sP The shape argument to evaluate
	 * @return	Return a boolean that indicate whether the shape argument is valid or not
	 */
	private boolean checkShapeArguementComponent(String[] sP)
	{
	/*
	 * Logic of the method: check first shape type -> check if the element size is correct -> then check each element and if it is match
	 * to the desired format (E.g. integer for color code and double for other parameters)
	 */

		//boolean to store the result and return
		boolean isValid = false;

		switch(sP[0])//first element of the argument
		{
		case "circle":
			if(sP.length==7)//corresponding size of the argument
			{
				//check if each element has the correct type by calling the parse each element with a private program (see below)
				if(isNumericInt(sP[1])&&isNumericInt(sP[2])&&isNumericInt(sP[3])&&isNumericDouble(sP[4])&&isNumericDouble(sP[5])&&isNumericDouble(sP[6]))
				{
					//if all valid, still need to check if the color is correct
					//note that the negative number will be check when try to create a new shape, since we have the individual shape constructor to evaluate this factor
					if(Integer.parseInt(sP[1])<=255&&Integer.parseInt(sP[1])>=0&&Integer.parseInt(sP[2])<=255&&Integer.parseInt(sP[2])>=0&&Integer.parseInt(sP[3])<=255&&Integer.parseInt(sP[3])>=0)

						isValid = true;//yes, we got a valid output
				}
			}
			break;
		case "crescent":
			if(sP.length==7)
			{
				if(isNumericInt(sP[1])&&isNumericInt(sP[2])&&isNumericInt(sP[3])&&isNumericDouble(sP[4])&&isNumericDouble(sP[5])&&isNumericDouble(sP[6]))
				{
					if(Integer.parseInt(sP[1])<=255&&Integer.parseInt(sP[1])>=0&&Integer.parseInt(sP[2])<=255&&Integer.parseInt(sP[2])>=0&&Integer.parseInt(sP[3])<=255&&Integer.parseInt(sP[3])>=0)

						isValid = true;
				}
			}
			break;
		case "square_ring":
			if(sP.length==7)
			{
				if(isNumericInt(sP[1])&&isNumericInt(sP[2])&&isNumericInt(sP[3])&&isNumericDouble(sP[4])&&isNumericDouble(sP[5])&&isNumericDouble(sP[6]))
				{
					if(Integer.parseInt(sP[1])<=255&&Integer.parseInt(sP[1])>=0&&Integer.parseInt(sP[2])<=255&&Integer.parseInt(sP[2])>=0&&Integer.parseInt(sP[3])<=255&&Integer.parseInt(sP[3])>=0)

						isValid = true;
				}
			}
			break;
		case "rectangle":
			if(sP.length==8)
			{
				if(isNumericInt(sP[1])&&isNumericInt(sP[2])&&isNumericInt(sP[3])&&isNumericDouble(sP[4])&&isNumericDouble(sP[5])&&isNumericDouble(sP[6])&&isNumericDouble(sP[7]))
				{
					if(Integer.parseInt(sP[1])<=255&&Integer.parseInt(sP[1])>=0&&Integer.parseInt(sP[2])<=255&&Integer.parseInt(sP[2])>=0&&Integer.parseInt(sP[3])<=255&&Integer.parseInt(sP[3])>=0)

						isValid = true;
				}
			}
			break;
		case "ring":
			if(sP.length==8)
			{
				if(isNumericInt(sP[1])&&isNumericInt(sP[2])&&isNumericInt(sP[3])&&isNumericDouble(sP[4])&&isNumericDouble(sP[5])&&isNumericDouble(sP[6])&&isNumericDouble(sP[7]))
				{
					if(Integer.parseInt(sP[1])<=255&&Integer.parseInt(sP[1])>=0&&Integer.parseInt(sP[2])<=255&&Integer.parseInt(sP[2])>=0&&Integer.parseInt(sP[3])<=255&&Integer.parseInt(sP[3])>=0)

						isValid = true;
				}
			}
			break;
		case "square":
			if(sP.length==7)
			{
				if(isNumericInt(sP[1])&&isNumericInt(sP[2])&&isNumericInt(sP[3])&&isNumericDouble(sP[4])&&isNumericDouble(sP[5])&&isNumericDouble(sP[6]))
				{
					if(Integer.parseInt(sP[1])<=255&&Integer.parseInt(sP[1])>=0&&Integer.parseInt(sP[2])<=255&&Integer.parseInt(sP[2])>=0&&Integer.parseInt(sP[3])<=255&&Integer.parseInt(sP[3])>=0)

						isValid = true;
				}
			}
			break;
		case "triangle":
			if(sP.length==7)
			{
				if(isNumericInt(sP[1])&&isNumericInt(sP[2])&&isNumericInt(sP[3])&&isNumericDouble(sP[4])&&isNumericDouble(sP[5])&&isNumericDouble(sP[6]))
				{
					if(Integer.parseInt(sP[1])<=255&&Integer.parseInt(sP[1])>=0&&Integer.parseInt(sP[2])<=255&&Integer.parseInt(sP[2])>=0&&Integer.parseInt(sP[3])<=255&&Integer.parseInt(sP[3])>=0)

						isValid = true;
				}
			}
			break;
		case "triangle_right_down":
			if(sP.length==7)
			{
				if(isNumericInt(sP[1])&&isNumericInt(sP[2])&&isNumericInt(sP[3])&&isNumericDouble(sP[4])&&isNumericDouble(sP[5])&&isNumericDouble(sP[6]))
				{
					if(Integer.parseInt(sP[1])<=255&&Integer.parseInt(sP[1])>=0&&Integer.parseInt(sP[2])<=255&&Integer.parseInt(sP[2])>=0&&Integer.parseInt(sP[3])<=255&&Integer.parseInt(sP[3])>=0)

						isValid = true;
				}
			}
			break;
		case "triangle_right_up":
			if(sP.length==7)
			{
				if(isNumericInt(sP[1])&&isNumericInt(sP[2])&&isNumericInt(sP[3])&&isNumericDouble(sP[4])&&isNumericDouble(sP[5])&&isNumericDouble(sP[6]))
				{
					if(Integer.parseInt(sP[1])<=255&&Integer.parseInt(sP[1])>=0&&Integer.parseInt(sP[2])<=255&&Integer.parseInt(sP[2])>=0&&Integer.parseInt(sP[3])<=255&&Integer.parseInt(sP[3])>=0)

						isValid = true;
				}
			}
			break;
		case "triangle_left_down":
			if(sP.length==7)
			{
				if(isNumericInt(sP[1])&&isNumericInt(sP[2])&&isNumericInt(sP[3])&&isNumericDouble(sP[4])&&isNumericDouble(sP[5])&&isNumericDouble(sP[6]))
				{
					if(Integer.parseInt(sP[1])<=255&&Integer.parseInt(sP[1])>=0&&Integer.parseInt(sP[2])<=255&&Integer.parseInt(sP[2])>=0&&Integer.parseInt(sP[3])<=255&&Integer.parseInt(sP[3])>=0)

						isValid = true;
				}
			}
			break;
		case "quadrant":
			if(sP.length==7)
			{
				if(isNumericInt(sP[1])&&isNumericInt(sP[2])&&isNumericInt(sP[3])&&isNumericDouble(sP[4])&&isNumericDouble(sP[5])&&isNumericDouble(sP[6]))
				{
					if(Integer.parseInt(sP[1])<=255&&Integer.parseInt(sP[1])>=0&&Integer.parseInt(sP[2])<=255&&Integer.parseInt(sP[2])>=0&&Integer.parseInt(sP[3])<=255&&Integer.parseInt(sP[3])>=0)

						isValid = true;
				}
			}
			break;
		default:
			isValid = false;
		}

		return isValid;

	}


	//covert the string to a double
	/**
	 * This method check if a string can convert to a double
	 * @param sP The numeric string to evaluate
	 * @return A boolean that indicate the result
	 */
	private boolean isNumericDouble(String sP)
	{

		try  
		{  
			Double.parseDouble(sP);

		}  
		catch(NumberFormatException e)  
		{  
			return false;  
		}  
		return true;  
	}

	/**
	 * This method check if a string can convert to a integer
	 * @param sP	The numeric string to evaluate
	 * @return	A boolean that indicate the result
	 */
	private boolean isNumericInt(String sP)
	
	{
		try  
		{  
			Integer.parseInt(sP);
		}  
		catch(NumberFormatException e)  
		{  
			return false;

		}  
		return true;  
	}


	/**
	 * The method that we can add the shape to the SVG Shape type arraylist.
	 * @param aShape A shape that need to be added into
	 */
	public void addShape(Shape aShape){

		newShape.add(aShape);
	}

	/**
	 * The method that draw a shape into a pixmap. It will go through every pixel of a shape and change the color corresponding to
	 * the position of the pixel of a ppm by calling each shape's own draw method.
	 * @param p The pixmap that the shape will be drew to
	 */ 
	public void drawPixmap(PortablePixmap p)
	{
		//draw all the shapes
		for(int i=0;i <newShape.size();i++)
		{
			newShape.get(i).draw(p);//call the corresponding draw methods!
		}

	}

}


