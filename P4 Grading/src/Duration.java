///////////////////////////////////////////////////////////////////////////////
// Semester: CS302 Summer 2014
// Author: Si Xie (Ricki)
// Email: sxie27@wisc.edu
// Lecturer's Name: Nick Pappas 
//////////////////////////// 80 columns wide //////////////////////////////////


/**
 * This is simple time calculator that take arguments to construct appropriate hours-minutes-seconds
 * duration that measure the time to the nearest second. This class is designed to be used for any other programs that
 * want to calculate and measure time. 
 * 
 * @author Si Xie (Ricki)
 *
 */
public class Duration {

	//Since we will be only used three different variables to construct the duration output
	//In order to use the three instance variables throughout the class, we declare them within in the class but outside
	//any other methods.
	private int hours;
	private int minutes;
	private int seconds;


	/**
	 * This is the default constructor that initialized all the instance variables of the duration. The default value for
	 * all three instance variables (hours, minutes, seconds) are zero.
	 */
	public Duration()
	{
		hours = 0;
		minutes = 0;
		seconds = 0;	
	}//END OF DEFAULT CONSTRUCTOR


	/**
	 *<p>This is the customizable constructor that take three arguments and construct the duration object in appropriate format.
	 * 
	 *<p>For instance, if the input for hours, minutes, seconds is (1, 20, 30), the constructor will create a duration object 
	 *that is one hour, twenty minutes and thirty seconds long.
	 * 
	 * @param hoursP	The hours parameter of the duration
	 * @param minutesP	The minutes parameter of the duration
	 * @param secondsP	The seconds parameter of the duration
	 */
	public Duration (int hoursP, int minutesP, int secondsP)
	{
		/*
		 * Since there is 60 seconds in a minute and 60 minutes in a second. If the parameter for either of these 
		 * two is over 60, the constructor should be able to add appropriate amount to the prior position and 
		 * decrease the output to the right level.
		 * 
		 * Here, we did not consider the case where the parameter is negative or over appropriate one day duration.
		 * The readiness of the parameter will be filter and prepared through the client/user interface 
		 * (which in our case, is the ExerciseCalculator Class).
		 *  
		 *  In terms of logic, this class will evaluate the parameter from right(seconds) to left (hours) since 
		 *  the increment will be implemented from seconds to hours.
		 */
		if(secondsP>59)//check seconds first (from right to left)
		{
			seconds = secondsP%60;//get the remainder amount from the division
			minutes = minutesP+secondsP/60;//add the quotient to the prior position
			hours = hoursP;
		}
		else
		{
			seconds = secondsP;
			minutes = minutesP;
			hours = hoursP;
		}
		if(minutes>59)//then check the minute
		{
			hours = hoursP+minutes/60;
			minutes = minutes%60;


		}
		//		else//otherwise, nothing need to be change
		//		{
		//			//minutes = minutes;
		//			hours = hoursP;
		//		}
	}//END OF DURATION CONSTRUCTOR

	/**
	 * This is another constructor that take only one argument to construct the duration. The user can declare a duration by giving 
	 * the total seconds in a time period, and the constructor will initialize the object by translate the seconds into appropriate
	 * hour-minute-second duration format.
	 * 
	 * @param totalSecondP The total second parameter for constructing the duration
	 */
	public Duration (int totalSecondP)
	{
		/*
		 * Similar to the previous duration constructor, this constructor only handle seconds within the appropriate region (non-negative, less than 24 hours),
		 * the client side will transform the input into appropriate format before calling the method. 
		 * Here we have two situation, either the second is less than 60 or over 60 (more than a minute). 
		 */


		if (totalSecondP>59)//if more than one minute but less than 24 hours
		{
			int toHours = totalSecondP/3600;//to hours
			int toMinutes = (totalSecondP%3600)/60;//to minutes
			int toSeconds = (totalSecondP%3600)%60;//to seconds

			if(toHours>0){//means there is more than one hour (1hr=60mins=3600secs)
				hours = toHours;
				minutes = toMinutes;
				seconds = toSeconds;
			}
			else{//if less than one hour
				hours =0;
				minutes = totalSecondP/60;
				seconds = totalSecondP%60;
			}
		}
		else//less than one minute
		{
			hours=0;
			minutes=0;
			seconds = totalSecondP;
		}
	}//END OF SECOND DURATION CONSTRUCTOR


	/**
	 * This is a copy constructor for duration object that takes one argument of type Duration. 
	 * It will take the value of the input duration object and use it to create a new duration object based on the input object's parameters.
	 * 
	 * @param copyDuration The duration object input to used and copy to another duration object.
	 */
	public Duration (Duration copyDuration)
	{
		//we will get the hour, minute, and second value from the input object using the appropriate getter/accessor.
		//then initialize these values to a new object
		hours = copyDuration.getHours();
		minutes = copyDuration.getMinutes();
		seconds = copyDuration.getSeconds();
	}//END OF COPY METHOD

	//managing properties of an object using getters and setters
	//three getters
	/**
	 * This is a getter that will access the value of hour in the duration that use the method. It will return only the hour value 
	 * back to the object.
	 * 
	 * @return Return the hour value of the duration object.
	 */
	public int getHours()
	{
		return hours;
	}
	/**
	 * This is a getter that will access the value of minute in the duration that use the method. It will return only the minute value 
	 * back to the object.
	 * @return	Return the minute value of the duration object.
	 */
	public int getMinutes()
	{
		return minutes;
	}
	/**
	 * This is a getter that will access the value of minute in the duration that use the method. It will return only the second value 
	 * back to the object.
	 * @return Return the second value of the duration object.
	 */
	public int getSeconds()
	{
		return seconds;
	}


	//three setters
	/**
	 * This is a setter that set or change the hour value of a duration object. It will only affect the hour value.
	 * 
	 * @param hoursP The hour parameter of the object that need to be set/changed to. 
	 */
	public void setHours(int hoursP)
	{
		hours = hoursP;//return only the hours part
		//Similarly, this class didn't have to consider the situation that is longer than 24 hours as the user/client side will filter the input
	}
	/**
	 * This is a setter that set or change the minute value of a duration object. It will only affect the minute value.
	 * 
	 * @param minutesP	The minute parameter of the object that need to be set/changed to. 
	 */
	public void setMinutes(int minutesP)
	{
		if(minutesP>59)//longer than an hour, so need to increment the prior position
		{
			minutes = minutesP%60;
			hours += minutesP/60;
		}
		else
		{
			minutes = minutesP;
		}	
	}
	/**
	 * This is a setter that set or change the second value of a duration object. It will only affect the second value.
	 * 
	 * @param secondsP	The second parameter of the object that need to be set/changed to. 
	 */
	public void setSeconds(int secondsP)
	{
		if (secondsP>59&&secondsP<86399)//if longer than an hour
		{

			int toHours = secondsP/3600;//to hours
			int toMinutes = (secondsP%3600)/60;//to minutes
			int toSeconds = (secondsP%3600)%60;//to seconds

			if(toHours>0){//means there is more than one hour (1hr=60mins=3600secs)
				hours += toHours;
				minutes += toMinutes;
				seconds = toSeconds;
			}

			else{//if less than one hour
				minutes += secondsP/60;
				seconds = secondsP%60;
			}
		}
		else//nothing needs to be changed
		{
			seconds = secondsP;		
		}
	}

	/**
	 * <p>This method will create a new duration object and its values is determined by adding two duration together. 
	 * <p>For examples, the Duration 3 = Duration2.add(Duration1). If the Duration1 is 1:00:00 and Duration2 is 2:00:00, then
	 * the Duration3 will be 3:00:00. The method will add the the hour-minute-second of two duration together and return the appropriate
	 * Duration with the right format. 
	 * 
	 * 
	 * @param durationP The duration to add on with the argument
	 * @return A new duration that is composed of the two duration objects using the add method
	 */
	public Duration add(Duration durationP)
	{
		/*
		 * Since the two durations that used the method will remain the same, we create a new duration and set its parameters by getting each
		 * value independently, and call the duration constructor to create a new object
		 * 
		 */

		//determine the value that needs to be changed to
		int hoursP = this.getHours()+durationP.getHours();
		int minutesP = this.getMinutes()+durationP.getMinutes();
		int secondsP = this.getSeconds()+durationP.getSeconds();
		//create a new object taking the new value
		Duration newDuration = new Duration(hoursP, minutesP, secondsP);

		//and return it
		return newDuration;
	}//END OF ADD METHOD

	/**
	 * <p>This method will create a new duration object and multiply each element of its parameter to a constant. 
	 * <p>For example, if the duration to multiply is 01:20:10, and the constant is 2, the method will return a new duration
	 * as 02:40:10. Note that the old duration will remain the same, and the change will only affect on another duration object.
	 * 
	 * @param nP	 The constant to multiply with that will change the duration parameter.
	 * @return 		 A new duration object populated with manipulated values.
	 */
	public Duration multiply(int nP)
	{
		;	//create new duration object
		//set its three parameter's value to the multiplied values
		int k = nP*getSeconds();
		
		int j = nP*getMinutes();
		int i = nP*getHours();
		
		Duration newDuration = new Duration(i,j,k);

		return newDuration;//return the new duration
	}//END OF MULTIPLY METHOD

	/**
	 *<p>This method will allow the printing of the duration object to be consistent in terms of format. The standard format
	 * for the duration is hh:mm:ss. 
	 *<p>For example, for duration (20,45,2), the duration will be printed as 20:45:20. 
	 * 
	 */
	public String toString()
	{
		String toString = "";

		String hoursString = "";
		String minutesString = "";
		String secondsString = "";

		//Since we want two digit for each section, we will add appropriate number of zeros based on its value.
		if(hours<10)//if the number is less than 10 (e.g.: 0-9)
		{
			hoursString +="0"+hours;//add a 0 before the number
		}
		else{
			hoursString +=hours;
		}
		if(minutes<10)
		{
			minutesString +="0"+minutes;
		}
		else{
			minutesString +=minutes;
		}
		if(seconds<10)
		{
			secondsString +="0"+seconds;
		}
		else{
			secondsString +=seconds;
		}

		toString = hoursString +":" + minutesString + ":" + secondsString;//constructor the string that we want to print
		//need to be two digits!
		return toString;
	}//END OF TOSTRING METHOD

	/**
	 * <p>This method will check if two duration is equal to each other with the same value for each parameter.
	 * <p>For example, if Duration1(0,0,0) is evaluate with Duration2(0,0,1), the method will return false. 
	 * <p>Note that if the duration that is comparing to is null, it will always returns false.
	 * 
	 * 
	 * @param durationP	 The duration parameter to compare with
	 * @return	Return a boolean value that is either equals to (true) or not equal (false) to the input duration parameter.
	 */
	public boolean equals(Duration durationP)
	{
		boolean ifEqual=true;//create a boolean to store the if condition result

		//if the duration is not null, and all of its three parameters are equals to the one we are comparing to
		if(durationP!=null&&this.getHours()==durationP.getHours()&&this.getMinutes()==durationP.getMinutes()&&this.getSeconds()==durationP.getSeconds())
		{
			ifEqual = true;//then it is true that they are equal to each other
		}
		else
		{
			ifEqual = false;
		}
		return ifEqual;//return the result
	}//END OF EQUALS TO


	/**
	 * This method compare two Duration, and determine which one is longer or equals to one and another. The method
	 * will compare both object in terms of its three duration parameters, and return a value that means the previous one is either shorter than (-1), 
	 * equal to (0), or longer than (1) the later one. 
	 * 
	 * @param durationP 	The duration to compare with.
	 * @return				Return a value that determine the relationship between two duration. 
	 */
	public int compareTo(Duration durationP)
	{
		//first get the duration parameter from the former duration
		int secondsToCompare = this.getSeconds();
		int minutesToCompare = this.getMinutes();
		int hoursToCompare = this.getHours();

		int toReturn = 0;//store the result

		//if all three parameter is equal
		if(hoursToCompare==durationP.getHours()&&minutesToCompare==durationP.getMinutes()&&secondsToCompare==durationP.getSeconds())
		{
			toReturn = 0;
		}
		//if either one of the parameter is longer that the other (evaluate from left to right since hours is more significant to second)
		//if so, it is bigger (returns 1)
		else if(hoursToCompare>=durationP.getHours())
		{
			if(hoursToCompare>durationP.getHours()){
				toReturn = 1;
			}
			else if(hoursToCompare==durationP.getHours()){
				if(minutesToCompare>=durationP.getMinutes())
				{
					if(minutesToCompare>durationP.getMinutes()){
						toReturn = 1;
					}
					else if(minutesToCompare==durationP.getMinutes()){
							if(secondsToCompare>durationP.getSeconds())
							{
								toReturn = 1;
							}
							else
								toReturn = -1;
					}
					else
						toReturn = -1;
				}
				else{
					toReturn = -1;
				}
			}

		}

		else//otherwise, it is smaller
		{
			toReturn = -1;
		}	
		return toReturn;
	}//END OF COMPARETO METHOD


}
