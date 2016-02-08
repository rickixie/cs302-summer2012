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

//import the checked exception that will be needed
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * 
 * This class will take a command files from a file that contains the argument to create a series of shapes, and
 * then draw to another file in a ppm format. This last class will handle all the exception from other class, and 
 * print corresponding answers and response to the errors. The run configuration will take four lines
 * of arguments. Either the errors in the file, or the program argument will terminate the program. If everything run
 * smoothly, the method will draw a piece of "art" that save to a ppm file.
 * 
 * @author rickixie
 *
 */
public class SVGExporter {

	public static void main(String[] args) {

		printInstruction ();//print the instruction for the 4 assigned shapes and the 7 extra shapes that I maded. 
		try
		{

			if(args.length!=4)//the arguments are too many or not enough
			{
				throw new SVGFormatException();
			}
			else
			{
				int width = Integer.parseInt(args[1]);//can throw a number format exception
				int height = Integer.parseInt(args[2]);
				if(width<0||height<0)
				{
					throw new NumberFormatException();//if the canvas is negative 
				}
				else
				{
					SVG svg = new SVG (args[0]);//can throw either a filenotfound, svg format exception or io exception)
					PortablePixmap ppm2 = new PortablePixmap(width, height);

					svg.drawPixmap(ppm2);

					ppm2.writeToFile(args[3]);//can throw a IO exception
				}
			}
		}
		//now we will handle all the exceptions! and the program will be terminated after printing the error message
		catch(NumberFormatException e)
		{
			System.out.println("Invalid arguement!");
		}
		catch (SVGFormatException e)
		{
			System.out.println("The file is poorly formmatted. Bye!");
			//System.exit(-1);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Hey, the ppm file is read only!");
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Hey, I can't create the ppm file!");
		}

	}


	/**
	 * Private method that will print the instruction.
	 */
	private static void printInstruction ()
	{
		System.out.println("***INSTRUCTIONS:");
		System.out.println("The shape command that this program can understand is:");
		System.out.println("============================================================================================================================================");
		System.out.println("***BASIC SHAPES:"); 
		System.out.println("circle red(int) green(int) blue(int) originX(double) orginY(double) radius(double)");
		System.out.println("square red(int) green(int) blue(int) originX(double) orginY(double) sidelength(double)");
		System.out.println("rectangle red(int) green(int) blue(int) originX(double) orginY(double) width(double) height(double)");
		System.out.println("ring red(int) green(int) blue(int) originX(double) orginY(double) outerRadius(double) innerRadius(double)");
		System.out.println("============================================================================================================================================");
		System.out.println("***EXTRA SHAPES:"); 
		System.out.println("quadrant red(int) green(int) blue(int) originX(double) orginY(double) size(double)"); 
		System.out.println("crescent red(int) green(int) blue(int) originX(double) orginY(double) radius(double)");  
		System.out.println("triangle red(int) green(int) blue(int) originX(double) orginY(double) base(double)"); 
		System.out.println("triangle_left_down red(int) green(int) blue(int) originX(double) orginY(double) base(double)"); 
		System.out.println("square_ring red(int) green(int) blue(int) originX(double) orginY(double) radius(double)");  
		System.out.println("triangle_right_up red(int) green(int) blue(int) originX(double) orginY(double) base(double)");  
		System.out.println("triangle_right_down red(int) green(int) blue(int) originX(double) orginY(double) base(double)");  
		System.out.println("============================================================================================================================================");
	}

}
