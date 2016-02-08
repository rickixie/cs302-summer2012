package cs302.project4;

import java.awt.Color;
/**
 * The crescent shape extend the circle shape and create a moon like shape with a two circles overlapped with a radius of distance
 * between their centers.
 * @author rickixie
 *
 */
public class Crescent extends Circle implements AreaMeasurable{
	
	private double radius;//a buffered like variables to use it to draw thing

/**
 * This is the default constructor for Crescent, which is a type of circle.
 * It takes parameter of its color, origins and shape specific area.
 * @param c			The Color of the shape
 * @param originX	Origin X relative to the pixmap width
 * @param originY	Origin Y relative to the pixmap height
 * @param radiusP	The radius of the circle relative to the pixmap width
 * @throws SVGFormatException if given size is negative
 */
	public Crescent(Color c, double originX, double originY, double radiusP)
			throws SVGFormatException {
		super(c, originX, originY, radiusP);//call super class
		if(radiusP<0)
			throw new SVGFormatException();
		else
		radius = radiusP;
		// TODO Auto-generated constructor stub
	}
	
	public void draw(PortablePixmap p) {
		
		
		int realOriginY = (int)(this.originY*p.getHeight());
		int realOriginX = (int)(this.originX*p.getWidth());//getHeight

		//draw the big circle first
		for(int i=0; i<(int)p.getHeight(); i++){
			for(int j = 0; j<(int)p.getWidth(); j++){
				if (Math.sqrt((realOriginY-i)*(realOriginY-i)+(realOriginX-j)*(realOriginX-j))<=radius*p.getWidth()&&Math.sqrt((realOriginY-i)*(realOriginY-i)+(realOriginX+radius*p.getWidth()-j)*(realOriginX+radius*p.getWidth()-j))>=radius*p.getWidth())
					
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
	//http://www.physicsforums.com/showthread.php?t=502475
	public double getArea(PortablePixmap p) {
		
		//double area = p.getWidth()*Math.PI*(radius*radius);
		double area = (radius*p.getWidth()*p.getWidth()*radius)*(2*Math.PI/3 - Math.sqrt(3)/2);
		// TODO Auto-generated method stub
		return area;
	}
	

}
