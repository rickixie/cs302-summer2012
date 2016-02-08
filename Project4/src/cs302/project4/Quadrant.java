package cs302.project4;

import java.awt.Color;

/**
 * This shape extend the square shape and create a 1/4 circle in the 4th quadrant, its origin is the center of the circle.
 * @author rickixie
 *
 */
public class Quadrant extends Square implements AreaMeasurable{

	
	private double size;
	/**
	 * This is the default constructor for quadrant, which is a sub-type of square.
	 * It takes parameters of its color, origins and shape specific area.
	 * @param c			The Color of the shape
	 * @param originX	Origin X relative to the pixmap width
	 * @param originY	Origin Y relative to the pixmap height
	 * @param sizeP		The side length of the square in relative to pixmap width that will be used as the radius of the quarter circle
	 * @throws SVGFormatException if given size is negative
	 */
	public Quadrant(Color c, double originX, double originY, double sizeP)
			throws SVGFormatException {
		super(c, originX, originY, sizeP);
		if(sizeP<0)
			throw  new SVGFormatException();
			else
		//radius = radiusP;
		size = sizeP;
	}
	@Override
	public void draw(PortablePixmap p) {
		
		
		int realOriginY = (int)(this.originY*p.getHeight());
		int realOriginX = (int)(this.originX*p.getHeight());
		int realSize = (int)(p.getWidth()*size);
		for(int i=realOriginY; i<realOriginY+realSize; i++){
			for(int j = realOriginX; j<realOriginX+realSize; j++){
				if (Math.sqrt((realOriginY-i)*(realOriginY-i)+(realOriginX-j)*(realOriginX-j))<=realSize)
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
	
	
	
	public double getArea(PortablePixmap p) {
		// TODO Auto-generated method stub
		double area = 0.25*Math.PI*(p.getWidth()*size*p.getWidth()*size);//area is only only 1/4 of the whole circle
		return area;
	}

}
