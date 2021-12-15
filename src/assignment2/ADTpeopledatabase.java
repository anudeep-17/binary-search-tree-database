package assignment2;

import java.util.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;

/*
 * creates the ADTpeopledatabase using tree as the base
 * 
 * */
//people database creator using tree
public class ADTpeopledatabase 
{
	
	genericBST<people> peopleDB = new genericBST<people>(); //calls the tree constructor for creation of tree
	List<people> list= new ArrayList<people>(); //creates a list that is used to fill the data in list. 
	
	//constructor
	/*
	 * the constructor of the class that is used to initialize the database*/
	ADTpeopledatabase()
	{
        System.out.println("------------database is created----------------");
        System.out.println("");
	}
	
	/*
	 * the constructor of the class that is used to create the database by adding people.*/
	//class constructor to add all the data to tree
	ADTpeopledatabase(people person)
	{
		 ADTpeopledatabaseadd(person); //add method is invoked to add the data.
//		 System.out.println("the person is added as root");
//   	 System.out.println("");
	}
    
	//database methods for functions for altering and updating the data on tree.
	
	/*
	 * used to add the data to tree.
	 * called in constructor also to add.
	 * @param people person 
	 * */
	
	//---------------------------------------------------general methods of tree ----------------------------------
	//----------------------------------------------add---------------------------------------------------------
	void ADTpeopledatabaseadd(people person)
	{
		peopleDB.insert(person); //calls the generic method insert to add the people data on the database.
		 System.out.println("the person " + person.toString()+"  :   added");
	}
	
	/*
	 * used to delete the data to tree.
	 * @param people person 
	 * */
	//------------------------------------------------------delete----------------------------------------------- 
    void databasedelete(people person)
    {
    	if(peopleDB.search(person)) //if the entered person exists in database search is generic method called on peopel to find if exists 
    	{
		  peopleDB.delete(person); //then delete the person is initiated.
		  System.out.println("the person " + person.toString()+"  :   deleted"); //indicates the data is delete.
    
    	}
    	else
    	{
    		System.out.println("record not found"); //else it mentions no record found.
    	}
    }
    
    /*
	 * used to delete the data to tree by a given name and date of birth identification.
	 * @param String name, String date.
	 * */
    void databasedeletebyname_and_date(String name, int  date)
    {
    	
    	people person = new people(name, date); //creates a person with these details.
    	
    	if(peopleDB.search(person) == true) //checks if he exists in the record.
        {
		  peopleDB.delete(person); // deletes if exists. 
		  System.out.println("the person " + person.toString()+"  :   deleted");
	    
		}
		else 
		{
			System.out.println("record dont exist unable to finish task");// else record not found is prompted.
		}
    }
	
    /*
   	 * used to search the data in tree by a given person.
   	 * @param people person.
   	 * */
    //------------------------------------------search---------------------------------------
    void databasesearch(people person)
    {
    	if(peopleDB.search(person) == true) //if the person is found 
    	{
    	     System.out.println(person.toString()); //print the person and say hes found.
    	     System.out.println("found him in the database");
    	}
    	
    	else if (peopleDB.search(person) == false) //else doesnt exist is prompted.
    	{
    		System.out.println(person.toString());
   	        System.out.println("doesnt exist !! ");
    	}
    }
    
    /*
   	 * used to search the data in tree by a given person name.
   	 * @param String name.
   	 * */
    
    void databasesearchpersonname(String person)
    {
    	if(peopleDB.searchbyname(person) == true) //if found by calling the searchbyname to compare strings 
    	{
    	     System.out.println(person.toString()); //returns the person details. 
    	     System.out.println("found him in the database");
    	}
    	
    	else if (peopleDB.searchbyname(person) == false) //else kicks in prompt of non existance.
    	{
    		System.out.println(person.toString());
    	    System.out.println("doesnt exist !! ");
    	}
    }
      
    // -----------------------------------------modify-----------------------------------------------------
    /*
   	 * used to modify the data of person
   	 * @param people existingperson, people modifedperson
   	 * */
    void modifydatabase(people existingperson, people modifiedperson)
    {
        if(peopleDB.search(existingperson)) //if the given person exists in database.
        {
        peopleDB.delete(existingperson); //the record is deleted 
        peopleDB.insert(modifiedperson); //new data record is added.
        System.out.println("modification done");
		System.out.println(modifiedperson.toString());
        }
        else
        {
        	System.out.println(existingperson.toString()+": doesnt exist in the database"); //else prompt of non existance is reported.
        	System.out.println("modification failed!!!");
        }	
        
    }
    
    /*
   	 * used to modify the data of person when their names and a identification date is mentioned. 
   	 * @param string name, string toname, int date
   	 * */
    
    void modifydatabaseforname(String name, String toname, int date)
    {
    	//creates a people instance with given data
    	people person = new people(name, date);
    	people person2 = new people(toname, date);
    	modifydatabase(person, person2); //calls modify database on the call to modify them. 
    }
    
    /*
   	 * used to modify the data of person when the date is mentioned and a identification name is mentioned. 
   	 * @param string name,  int givendate, int modifieddate
   	 * */
    
    void modifydatabasefordate(String name, int givendate, int modifieddate)
    {
    	//cretes peoples instance with given data
    	people person = new people(name, givendate);
    	people person2 = new people(name, modifieddate);
       
    	//runs through the tree
    	if(peopleDB.search(person))
        {
        peopleDB.delete(person); //if exists deletes the record.
        peopleDB.insert(person2); //inserts new record
        System.out.println("modification done");
		System.out.println(person2.toString());
        }
        else
        {
        	//else prompts the no record found.
        	System.out.println(person.toString()+": doesnt exist in the database");
        	System.out.println("modification failed!!!");
        }	
        
    }
    
    
    
   //-----------------------------------------------------list methods and searched begin here ----------------------------------
    
    
    /*
    * calls to fill the list with the data of the tree
    * fills and prints the list */
    
    //filling the data in list for special node
    void fillinlist()
    {
    	System.out.println("---------------printing list------------------");
    	list.addAll(peopleDB.fillinlist()); //fills the list with the returned by fillinlist.
    	peopleDB.printlist(list);//prints the list using printlist. 
    }
    
   /*
    * special search method for a given date of birth
    * @param int givendate.
    * */
    
    void specialsearchfordate_of_birth(int givendate) // for a givendate
    {
    	//indicates the date mentioned for verification.
    	System.out.println("for a given date : "+ givendate + "  " );
    	System.out.println(" ");
    	System.out.println("searching database: ");
    	System.out.println(" ");
    	
    	//creates a localDate instance with the given data to compare
    	LocalDate checkdate = LocalDate.parse(String.valueOf(givendate), DateTimeFormatter.ofPattern("ddMMyyyy"));
    	
//    	System.out.println(checkdate);
    	
    	//creates a list of specialpeople from the list we created.
    	List<people> specialpeople = new ArrayList<people>();
    	
    	
    	if(givendate == (int)givendate) //if the givendate is appropriate data
    	{
    			for(int i = 0; i < list.size(); i++) //it will run through the list and 
    			{
    				LocalDate date = ((people) list.get(i)).getDate(); //for every list element date 
//					System.out.println(date);
//    				System.out.println(Month.of(month).getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
    				if(checkdate.equals(date)) //if the date is same as given date
    				{	
    					specialpeople.add(list.get(i)); //adds to the specialpeople list 
    				}
    			}
    	  
    			peopleDB.notnullcheck_and_print(specialpeople); //specialpeople list is printed only if it is not null.
    	} 
    	else
    	{
    		System.out.println("invalid date!!!!!"); //else kicks the prompt of invalid date.
    	}
    		
    }
    
    
    /*
     * special search method for a given date of birth month
     * @param int givenmonth
     * */

    void specialsearchformonth(int givenmonth)
    {
    	//prompts the givenmonth
    	System.out.println("for a given Month : "+ givenmonth + "th month" );
    	System.out.println(" ");
    	System.out.println("searching database: ");
    	System.out.println(" ");
    	
    	//initialized the list of special people to have a record.
    	List<people> specialpeople = new ArrayList<people>();
    	
    	//since it is 1 to 12 months only we filter the input 
    	if(givenmonth<=12 && givenmonth>=1)
    	{
    		//check through the list
    			for(int i = 0; i < list.size(); i++)
    			{
    				int month = ((people) list.get(i)).getDate().getMonthValue(); //for every month of the date of the list element  
//    				System.out.println(Month.of(month).getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
    				if(givenmonth == month )//if same with the given date
    				{	
    					specialpeople.add(list.get(i)); //adds to special people
    				}
    			}
    	 
    			peopleDB.notnullcheck_and_print(specialpeople); //prints the list only if it is not null 
    	}
    	else
    	{
    		System.out.println("invalid month!!!!!!"); //else prompts invalid month.
    	}
    		
    }
    
    
    
    /*
     * special search method for a given date of birth day
     * @param int givenday
     * */
    void specialsearchforday(int givenday)
    {
    	//prompts the given day
    	System.out.println("for a given date : "+ givenday + " of month" );
    	System.out.println(" ");
    	System.out.println("searching database: ");
    	System.out.println(" ");
    	
    	//initialized special people list. 
    	List<people> specialpeople = new ArrayList<people>();
    	
    	//if given day is not less than 0 and greater than 30 while it is a integer also
    	if(givenday == (int)givenday && (givenday > 0 || givenday <= 30))
    	{
    			for(int i = 0; i < list.size(); i++) //we run through the list 
    			{
    				int day = ((people) list.get(i)).getDate().getDayOfMonth(); //for every dat of the month mentioned in the day 
//    				System.out.println(Month.of(month).getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
    				if(givenday == day) //if same as the given day
    				{	
    					specialpeople.add(list.get(i)); //we add them to the list. 
    				}
    			}
    	 
    			peopleDB.notnullcheck_and_print(specialpeople); //list is printed only if the list is not null
    	} 
    	else
    	{
    		System.out.println("invalid entry!!!!!!");
    	}
    		
    }
    
    /*
     * special search method for a given date of birth year
     * @param int givenyear
     * */
    void specialsearchforyear(int givenyear)
    {
    	//prompts the given year
    	System.out.println("for a given date : "+ givenyear + " " );
    	System.out.println(" ");
    	System.out.println("searching database: ");
    	System.out.println(" ");
    	
    	//initialized special people list. 
    	List<people> specialpeople = new ArrayList<people>();
    	//if given year is integer
    	if(givenyear == (int)givenyear)
    	{
    			for(int i = 0; i < list.size(); i++)//we run through the list 
    			{
    				int year = ((people) list.get(i)).getDate().getYear();//for every year mentioned in the date of the list element  
//    				System.out.println(Month.of(month).getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
    				if(givenyear == year)//if same as the given day
    				{	
    					specialpeople.add(list.get(i)); //we add them to the list. 
    				}
    			}
    	 
    			peopleDB.notnullcheck_and_print(specialpeople);//list is printed only if the list is not null
    	}
    	else
    	{
    		System.out.println("invalid entry!!!!!!");
    	}
    		
    }
    
    /*
     * special search method for a given name
     * @param String name.
     * */
    
    void specialsearchforname(String givenname)
    {
    	//prompts the given name, 
    	System.out.println(" ");
    	System.out.println("for a given name : "+ givenname + "  " );
    	System.out.println(" ");
    	System.out.println("searching database: ");
    	System.out.println(" ");
    	
    	List<people> specialpeople = new ArrayList<people>(); //creates special people list.
    	
    	if(!(givenname.isEmpty())) //if the entered is not empty.
    	{
    			for(int i = 0; i < list.size(); i++) //runs through the list.
    			{
    				String name = ((people) list.get(i)).getname(); //extracts the name of the list element 
//    				System.out.println(Month.of(month).getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
    				if(name.equals(givenname))//if same as the given name
    				{	
    					specialpeople.add(list.get(i));//we add them to the list.
    				}
    			}
    	 
    			peopleDB.notnullcheck_and_print(specialpeople);//list is printed only if the list is not null
    	}
    	else
    	{
    		System.out.println("invalid entry!!!!!!");
    	}
    		
    }
    
    /*
     * special search method for a given partial name like a part of the name.
     * @param String givenname.
     * */
   
    void specialsearchforfirst_or_last_partialname(String givenname)
    {
    	//prompts the given name or partial name.
    	System.out.println(" ");
    	System.out.println("for a given name : "+ givenname + "  " );
    	System.out.println(" ");
    	System.out.println("searching database: ");
    	System.out.println(" ");
    	
    	//list for special people track.
    	List<people> specialpeople = new ArrayList<people>();
    	
    	if(!(givenname.isEmpty())) //if the entered is not empty.
    	{
    			for(int i = 0; i < list.size(); i++)//runs through the list.
    			{ 
    				String name = ((people) list.get(i)).getname(); //extracts name of list element.
//    				System.out.println(Month.of(month).getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
    				if(name.contains(givenname)) //if the name contains given name
    				{	
    					specialpeople.add(list.get(i)); //added to the list
    				}
    			}
    	 
    			peopleDB.notnullcheck_and_print(specialpeople); //the list is printed.
    	}
    	else
    	{
    		System.out.println("invalid entry!!!!!!");
    	}
    		
    }
    
    /*
     * special search method for a given start letter of name.
     * @param String givenletter.
     * */
    void specialsearchforfirstletter_inname(char givenletter)
    {
    	System.out.println(" ");
    	System.out.println("for a given name : "+ givenletter + "  " );
    	System.out.println(" ");
    	System.out.println("searching database: ");
    	System.out.println(" ");
    	
    	List<people> specialpeople = new ArrayList<people>(); //initializes the special people list 
    	
    	if(givenletter != ' ')//if given character is not an empty character
    		
    	{
    			for(int i = 0; i < list.size(); i++) 
    			{
    				char letter = ((people) list.get(i)).getname().charAt(0); // first character of the name of the list element 
//    				System.out.println(Month.of(month).getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
    				if(Character.compare(letter, givenletter) == 0) //if the character is same as the given character 
    				{	
    					specialpeople.add(list.get(i)); //add to the list
    				}
    			}
    	 
    			peopleDB.notnullcheck_and_print(specialpeople); //if the list is not null then print the list.
    	}
    	else
    	{
    		System.out.println("invalid entry!!!!!!"); //else invalid in entry
    	}
    }
    		
    
    /*
     * print the database using the inorderprinting method.
     * */
    
    //printing database 
    void printDB()
    {
    	peopleDB.inorderprinting(); //it will print the tree in inrder style.
    }
    
    void printlist()
    {
    	peopleDB.notnullcheck_and_print(list);
    }

}
