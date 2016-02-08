package cs302.project4;

/**
 * This is a interface contains the AreaMeasurable method for calculating the area for the shape the program created.
 * @author rickixie
 *
 */
public interface AreaMeasurable {

	/**
	 * This method calculate a shape's actual area given the parameters of the PortablePixmap that the shape is drew.
	 * @param p The portable pixmap object with parameters of width and height
	 * @return The value of the shape's area.
	 */
	public double getArea(PortablePixmap p);
}
