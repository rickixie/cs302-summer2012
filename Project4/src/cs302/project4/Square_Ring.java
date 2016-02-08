package cs302.project4;

import java.awt.Color;

/**
 * This square_ring shape extends the shape circle and create a square within a circle that has the side length of the radius.
 * @author rickixie
 *
 */
public class Square_Ring extends Circle {
	private double radius;//buffered like variables, it is actually the radius of the super circle
	/**
	 * This is the default constructor for the square_ring that take parameters of its color, origins and shape specific area.
	 * @param c			The Color of the shape
	 * @param originX	Origin X relative to the pixmap width
	 * @param originY	Origin Y relative to the pixmap height
	 * @param radiusP 	The size of the square that the ring will live in
	 * @throws SVGFormatException if given size is negative
	 */
	public Square_Ring(Color c, double originX, double originY, double radiusP)
			throws SVGFormatException {
		super(c, originX, originY, radiusP);
		if(radiusP<0)
			throw new SVGFormatException();
		else
		radius = radiusP;
		// TODO Auto-generated constructor stub
	}
	
	
	public void draw(PortablePixmap p) {
		
		
		int realOriginY = (int)(this.originY*p.getHeight());
		int realOriginX = (int)(this.originX*p.getWidth());
	
		for(int i=0; i<(int)p.getHeight(); i++){
			for(int j = 0; j<(int)p.getWidth(); j++){
				if (Math.sqrt((realOriginY-i)*(realOriginY-i)+(realOriginX-j)*(realOriginX-j))<=radius*p.getWidth())
					
					if(i>=p.getHeight()||j>=p.getWidth()||(j>=realOriginX-0.5*radius*p.getWidth()&&Math.abs(i-realOriginY)<=0.5*radius*p.getWidth()&&j-realOriginX<=0.5*radius*p.getWidth()))
					{
						continue;
					}
					else
						{
						p.setPixel(i, j, this.color);
						}
			}
		}
	}
	
	public double getArea(PortablePixmap p) {
		
		double area = (Math.PI*p.getWidth()*radius*p.getWidth()*radius)-(p.getWidth()*radius*p.getWidth()*radius);//REMEMBER TO TEST IT!!
		// TODO Auto-generated method stub
		return area;
	}

}
