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
 * Rectangle is the direct subclass of the shape that create a rectangle in relative to the pixmap
 * @author rickixie
 *
 */
public class Rectangle extends Shape implements AreaMeasurable {

	private double width;
	private double height;

/**
 * This is the default constructor for Rectangle, which is a type of shape.
 * It takes parameters of its color, origins and shape specific area.
 * @param c			The Color of the shape	
 * @param originX	Origin X relative to the pixmap width
 * @param originY	Origin Y relative to the pixmap height
 * @param widthY	The width of the rectangle in portportion of the pixmap width
 * @param heightY	The height of the rectangle in portportion of the pixmap height
 * @throws SVGFormatException if given size is negative
 */
	public Rectangle(Color c, double originX, double originY, double widthY, double heightY)  throws SVGFormatException {
		super(c, originX, originY);
		if(widthY<0||heightY<0)
		throw  new SVGFormatException();
		else
		width = widthY;
		height = heightY;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void draw(PortablePixmap p) {
		
		
		int realOriginY = (int)(this.originY*p.getHeight());
		int realOriginX = (int)(this.originX*p.getWidth());//getHeight?
		int realWidthR = (int)(p.getWidth()*width);
		int realHeightR = (int)(p.getHeight()*height);
	
		for(int i=realOriginY; i<realOriginY+realHeightR; i++){
			for(int j = realOriginX; j<realOriginX+realWidthR; j++){
				if(i>=p.getHeight()||j>=p.getWidth()){
					continue;
				}
				else
					{
					p.setPixel(i, j, this.color);
					}
			}
		}
		
	}
	
	@Override
	public double getArea(PortablePixmap p) {
		double area = p.getWidth()*width*p.getHeight()*height;
		return area;
	}

}
