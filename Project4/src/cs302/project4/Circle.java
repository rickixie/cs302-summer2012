package cs302.project4;

//////////////////////////////////////////////////////////////////////////////
//Semester: CS302 Summer 2014
//Author: Si Xie (Ricki)
//Email: sxie27@wisc.edu
//Lecturer's Name: Nick Pappas//
//
//Credits: (list anyone/anything who helped you write your program) 
//1) http://stackoverflow.com/questions/389741/continue-keyword-in-java
//2) http://stackoverflow.com/questions/13939675/java-string-split-i-want-it-to-include-the-empty-strings-at-the-end
//3) http://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-a-numeric-type-in-java
////////////////////////////80 columns wide //////////////////////////////////
import java.awt.Color;

/**
 * This is a class of a type of Ring, Circle. It is directly inherent from the Ring object with a innerRadius of zero.
 * @author rickixie
 *
 */
public class Circle extends Ring implements AreaMeasurable{

	/**
	 * This is the default constructor for Circle, which is a type of Ring that have a inner radius of zero.
	 * It takes parameter of its color, origins and shape specific area.
	 * 
	 * @param c			The Color of the shape.
	 * @param originX	Origin X relative to the pixmap width
	 * @param originY	Origin Y relative to the pixmap height
	 * @param radiusP	The radius of the circle relative to the pixmap width
	 * @throws SVGFormatException if given size is negative
	 */
	public Circle(Color c, double originX, double originY, double radiusP)  throws SVGFormatException {
		super(c, originX, originY, radiusP, 0);
		if(radiusP<0)
			throw new SVGFormatException();
		// TODO Auto-generated constructor stub
	}


}
