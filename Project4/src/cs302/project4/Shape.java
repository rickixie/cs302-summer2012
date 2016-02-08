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
 * This is the abstract class for the shape that "mother" of all the shape object. it implement the comparable and area measurable
 * interface in order to calculate the area and compare the area between shape objects.
 * @author rickixie
 *
 */
public abstract class Shape implements Comparable<Shape>, AreaMeasurable
{
	//set the instance variable public so all its subclass can use it
	Color color;
	double originX;
	double originY;
	
	/**
	 * This the default constructor of the shape object.
	 * @param c	 	The color for the shape
	 * @param originX	Origin X relative to the pixmap width
	 * @param originY	Origin Y relative to the pixmap height
	 */
	public Shape (Color c, double originX, double originY)
	{
		this.color = c;
		this.originX = originX;
		this.originY=originY;
	}
	
	/**
	 * This is the method for draw a shape that will go through all the pixels in the shapes and set the appropriate color for the corresponding position
	 * @param p
	 */
	public void draw(PortablePixmap p) {}
	
 
	/**
	 * This the implementation of the comparable interface that compare the areas of two shapes. It wil; return
	 * a int value: -1 means the former is smaller than the later; 1 means the opposite while 0 means the two areas
	 * are equal.
	 */
	public int compareTo(Shape otherShape) {
		
		PortablePixmap ppm = new PortablePixmap(100,100);
		
		
		if(this.getArea(ppm)<otherShape.getArea(ppm)) {return -1;}
		if(this.getArea(ppm)>otherShape.getArea(ppm)) {return 1;}
		return 0;

	}




	



	
	


	
	
	
}
