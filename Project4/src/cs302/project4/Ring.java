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
 * This a subclass of Shape - Ring, which is a circle like shape that have a inner and outer radius to 
 * construct a circle that is surrounding by another circle. 
 * 
 * @author rickixie
 *
 */
public class Ring extends Shape implements AreaMeasurable{

	//Initialize additional parameter to construct the ring
	//protected variables so its subclass can use it!
	protected double outerRadius;
	protected double innerRadius;
	
	/**
	 * This is the default constructor for Ring, which is a type of shape.
	 * It takes parameters of its color, origins and shape specific area.
	 * @param c 		The Color of the shape
	 * @param originX	Origin X relative to the pixmap width
	 * @param originY	Origin Y relative to the pixmap height
	 * @param outerRadiusP The outer radius of the ring relative to the pixmap width
	 * @param innerRadiusP The inner radius of the ring relative to the pixmap width
	 * @throws SVGFormatException if given size is negative
	 */
	public Ring(Color c, double originX, double originY, double outerRadiusP, double innerRadiusP) throws SVGFormatException {
		super(c, originX, originY);//call super class shape
		if(outerRadiusP<0||innerRadiusP<0)
			throw new SVGFormatException();
		else
		outerRadius =outerRadiusP;
		innerRadius =innerRadiusP;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw(PortablePixmap p) {
		
		
		int realOriginY = (int)(this.originY*p.getHeight());
		int realOriginX = (int)(this.originX*p.getWidth());//getHeight
		
		//draw the big circle first
		for(int i=0; i<(int)p.getHeight(); i++){
			for(int j = 0; j<(int)p.getWidth(); j++){
				//omit the portion that is smaller than the inner radius circle
				if (Math.sqrt((realOriginY-i)*(realOriginY-i)+(realOriginX-j)*(realOriginX-j))<=outerRadius*p.getWidth()&&Math.sqrt((realOriginY-i)*(realOriginY-i)+(realOriginX-j)*(realOriginX-j))>=innerRadius*p.getWidth())
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
		// TODO Auto-generated method stub
		double area = Math.PI*(p.getWidth()*outerRadius*p.getWidth()*outerRadius-p.getWidth()*innerRadius*p.getWidth()*innerRadius);
		return area;
	}
	

}
