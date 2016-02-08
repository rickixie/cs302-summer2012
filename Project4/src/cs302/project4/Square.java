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
 * Square is a subclass of the rectangle shape with a same size for both of the side length (width and height).
 * @author rickixie
 *
 */
public class Square extends Rectangle implements AreaMeasurable {

	//for subclass to use it
	protected double sidelength;
	
/**
 * This is the default constructor for the square that take parameters of its color, origins and shape specific area.
 * @param c			The Color of the shape
 * @param originX	Origin X relative to the pixmap width
 * @param originY	Origin Y relative to the pixmap height
 * @param sizeP 	Side length of the square relative to the pixmap width
 * @throws SVGFormatException if given size is negative
 */
	public Square(Color c, double originX, double originY, double sizeP) throws SVGFormatException{
		//call its super class rectangle to construct the shape
		super(c, originX, originY, sizeP, sizeP);
		if(sizeP<0)
			throw new SVGFormatException();
		else
			sidelength = sizeP;
		
		// TODO Auto-generated constructor stub
	}
	
	//to get not distorted square, we overwrite the rectangle draw method
	@Override
	public void draw(PortablePixmap p) {
		
		 
		int realOriginY = (int)(this.originY*p.getHeight());
		int realOriginX = (int)(this.originX*p.getHeight());
		int realSize = (int)(p.getWidth()*sidelength);
		for(int i=realOriginY; i<realOriginY+realSize; i++){
			for(int j = realOriginX; j<realOriginX+realSize; j++){
				if(i>=p.getHeight()||j>=p.getWidth()){
					continue;//stop the drawing when over the size of the pixmap, 
					//but continue to draw for the rest that is not exceed the area
				}
				else
					{
					p.setPixel(i, j, this.color);
					}
			}
		}
		
	}


}
