package cs302.project4;

import java.awt.Color;
/**
 * This is a class for the shape Triangle_Right_Up, which is a subclass of triangle that construct a shape that
 * that has a base of a same size square, but is the isosceles right triangle on the right top side.
 * @author rickixie
 *
 */
public class Triangle_Right_Up extends Triangle implements AreaMeasurable {

	private double base;
	
	/**
	 * This is the default constructor for Triangle_Right_Up, which is a type of triangle.
	 * @param c			The Color of the shape
	 * @param originX	Origin X relative to the pixmap width
	 * @param originY	Origin Y relative to the pixmap height
	 * @param baseP		The based of the isosceles right triangle relative to the pixmap width
	 * @throws SVGFormatException	if given size is negative
	 */
	public Triangle_Right_Up(Color c, double originX, double originY,
			double baseP) throws SVGFormatException {
		super(c, originX, originY, baseP);
		// TODO Auto-generated constructor stub
		if(baseP<0)
			throw new SVGFormatException();
		else
		base = baseP;
	}
	
	
public void draw(PortablePixmap p) {
		
		
		int realOriginY = (int)(this.originY*p.getHeight());
		int realOriginX = (int)(this.originX*p.getWidth());
		int realBase = (int)(p.getWidth()*base);
		
		for(int i=realOriginY; i<realOriginY+realBase; i++){
			for(int j = realOriginX; j<realOriginX+realBase; j++){
				
				if(i>=p.getHeight()||j>=p.getWidth()||(j-realOriginX<(i-realOriginY))){
					continue;
				}
				else
					{
					p.setPixel(i, j, this.color);
					}
				
			}
		}
		
	}
	

}
