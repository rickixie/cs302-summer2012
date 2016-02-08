package cs302.project4;
///////////////////////////////////////////////////////////////////////////////
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
import java.awt.Color;//<-----import color information
import java.io.File;//<------import file object in order to create file and read file
import java.io.FileNotFoundException;//<------import the exception if the file can't be access or manipulated
import java.io.FileWriter;//<------import file writer to write the ppm code
import java.io.IOException;//<------import file writer for any input/output errors
import java.io.PrintWriter;//<------import print write to read the file and write the lines
/**
 * This class create a 2D grid that contains color information for each pixel. By default, it will generate a
 * white canvas with given width and height.
 * @author rickixie
 *
 */
public class PortablePixmap {

	//create instance variable to construct the pixmap
	private int width;
	private int height;
	public Color [][] myColorArray;
	
	/**
	 * This constructor create a default white canvas that takes in a width and height as int arguments.
	 * 
	 * @param width	 The specified value for the width of the canvas
	 * @param height The specified value for the height of the canvas
	 */
	public PortablePixmap(int width, int height)
	{
		this.width = width;//set the dimension of the canvas
		this.height = height;
		this.myColorArray = new Color[height][width];//start to paint each pixel to white
		for(int i = 0; i<height; i++)
		{
			myColorArray[i] = new Color [width];//for each row 
			for (int j = 0; j<width; j++)
			{
				myColorArray[i][j] = new Color (255,255,255);//painted white
			}
		}
	}//END of creating a pixmap
	
	

	/**
	 * A getter that request the value of the pixmap's width
	 *  
	 * @return The int value of the width
	 */
	public int getWidth()
	{
		return width;
	}
	/**
	 * A getter that request the value of the pixmap's height
	 * 
	 * @return The int value of the height
	 */
	public int getHeight()
	{
		return height;
	}
	
	/**
	 * The setPixel method will change the color of a specified pixel within a pixmap 
	 * 
	 * @param row
	 * @param column
	 * @param color
	 */
	public void setPixel(int row, int column, Color color)
	{
		//System.out.println("row: "+row+" col: "+column);
		this.myColorArray[row][column] = color;//change the pixel color
	}
	
	/**
	 * This method writeToFile convert the information of the pixmap (including canvas size and color information) and write
	 * to a image file using the PPM format. The method will also throw a FileNotFoundException if the file cannot be opened for writing.
	 * If the input for file name is not in PPM format, the method will convert in to appropriate file name.
	 * 
	 * @param sP The fileName to write
	 * @throws FileNotFoundException  if the file is read only or cannot be found
	 * @throws IOException if can't create a new ppm file
	 */
	public void writeToFile  (String sP) throws FileNotFoundException, IOException{
		//make sure that we create a appropriate ppm file
		String fileName = "";
		if(sP.contains(".ppm"))
		{
			fileName = sP;
		}
		else
		{
			fileName = sP+".ppm";
		}
		
		// Place to store the stream reference
		
		
		
		File f = new File(fileName);//create a file in memory that doesn't exist 
		//f.setReadOnly();
		
			PrintWriter p = new PrintWriter (new FileWriter(f));
			

			p.println("P3");
			p.println(width+" "+height);
			p.println("255");
			

			//fill in the color by row
			for(int i=0; i<height; i++)
			{
				for(int j=0; j<width; j++)//then by each column of a row
				{

					p.println(getRGB(this.myColorArray[i][j]));	//for each pixel			
				}
			}
			p.close();//close the filewriter once finish the writing

	}
	
	/**
	 * This method convert the Color Object input and return a string that contains three numerics value of a color.
	 * 
	 * @param color The Color object to convert
	 * @return	A string that contains the numeric information for a color's Red, Green and Blue value
	 */
	private String getRGB(Color color)
	{
		String myRGBCode = "";
		myRGBCode += color.getRed()+" " + color.getGreen()+" "+color.getBlue();
		return myRGBCode;
		
	}
	
}
