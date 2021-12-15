package assignment2;

import java.text.DateFormat; 
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter; //import statements for the LocalDate usage. that help in formating the string to ddmmyyyy format



/*
 * @author anudeep
 * 
 * people class that implements the details of a person that has to be stored in the database
 * contains name as string and date as LocalDate in format ddmmyyyy.
 * LocalDate reference : https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
 * */

//people declaration class
public class people implements Comparable<people> //comparable is used to compare generic objects by condition given in Overridden compare to method.
{
	String name; //String name for the person name
	LocalDate date; //date for the date of birth of the person.
	
	/*
	 * constuctor of the class
	 * @param name, date
	 **/
	//constructor of the class when the date is given as string 
	people(String name, String date)	
	{
		this.name = name; //initailized the name 
		this.date= LocalDate.parse(date, DateTimeFormatter.ofPattern("ddMMyyyy")); //initialized taken date in ddmmyyyy format to LocalDate variable. 
	}

	/*
	 * constuctor of the class
	 * @param name, [int]date
	 **/
	//overridden constructor of the class thats called when date is in integer format 
	people(String name, int date)
	{
		this.name = name; //initialized the name of the person.
		this.date= LocalDate.parse(String.valueOf(date), DateTimeFormatter.ofPattern("ddMMyyyy"));//initialized taken date in ddmmyyyy format to LocalDate variable. 
	}
	
	
	
	//methods to retreive the details of a person
	
	/*
	 * this method is used to get the name of the person
	 * @return String name
	 */	
	public String getname() 
	{
		// TODO Auto-generated method stub
		return this.name; //returns the specified people object's name 
	}
	
	/*
	 * this method is used to get the date of birth of the person
	 * @return String name
	 */	
	
	public LocalDate getDate()
	{
		return this.date;//returns the specified people object's date of birth
	}
	
	/*
	 * this method is used to print the object of people class in string format
	 * @return String object name and date
	 */	
	public String toString()
	{
		return ""+ name +" "+ date;
	}
	
	/*
	 * additional method for getting name in String format
	 * @return String name
	 */	
	public String Stringname() 
	{
		return name;
		
	}
	
	
	//setter methods for the people class 

	/*
	 * initialized the name to the given name in parameter
	 * @param String name
	 */	
	
	public void setname(String name)
	{
		this.name = name;
	}
	
	/*
	 * initialized the date to the given date in parameter
	 * @param LocalDate date
	 */	
	public void setdate(LocalDate date)
	{
		this.date = date;
	}
	
	/*
	 * return the date of birth of a given person
	 * @param String name
	 * @return date 
	 */	
	public LocalDate getDatefromname(String person)
	{
		if(name == person)
		{
			return date;
		}
		
		return null;
	}
	
	
	//compareTo method that compares the names and helps in adding the info in tree.
	/*
	 * method to compare the names of the objects and enter them alphabetically.
	 * @param people object
	 * @return integer value basing on comparision of names.
	 */
	
	//method to compare people on their name
	@Override
	public int compareTo(people o) 
	{
		// TODO Auto-generated method stub
		
		return getname().compareTo(o.getname()) ; //returns a positive negative or a 0 basing on the entered name.
		 
	}

	public int compareto(String name)
	{
		return getname().compareTo(name);
	}
	
	

}
