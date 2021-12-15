package assignment2;


import java.io.*;
import java.util.Scanner;
/*
 * driver class of the whole project that calls methods and used them
 */
//main class of the driver that takes a file in
public class driver 
{
	/*
	 * main class that calls the filereader_and_tester method with the path of the file that has the data to create the tree.  */
	public static void main(String[]args) throws Exception //throws the exception if the path not found.
	{
		
		String path = "C:\\Users\\Owner\\OneDrive\\eclipse\\assignment2\\src\\assignment2\\details"; //path of the details file with data. 
		filereader_and_tester(path); //calls the data that fills the data. 
	    
	}
	
	/*
	 * the method that takes the file as argument and reads the path 
	 * @param path 
	 */
	
	static void filereader_and_tester(String path) throws Exception
	{
		//file and buffer reader is used to read the file and process the data line by line.
		File file = new File(path);  //creats a file with file path
 		String[] fillindata = null;
 		ADTpeopledatabase databaseinfo = new ADTpeopledatabase(); //creates a ADTpeopledatabase that initiates empty tree
  		people person ; //creates a people person to initialize.
 		int count = 1; //count check for the first object, which will create the root of the tree and the rest will be nodes.
 		try(BufferedReader br = new BufferedReader(new FileReader(file))) // buffere reader is used to read a line and try and catch to use Exception 
 		{
 			for(String line; (line = br.readLine())!=null; ) // if the read line is not null
 			{
 				 				
 				fillindata = line.split(",");// we split the line with , as the name and date of birth seperated by ,
 				if(count == 1)  //since it is the first node.
 				{
 					
 				person = new people(fillindata[0], fillindata[1]); //creates the person object with the data of the first line
 				databaseinfo = new ADTpeopledatabase(person); //creates the root root of the tree.
 				count++; //increments count to indicate the node.
 				
 				}
 				
 				else
 				{
 					person = new people(fillindata[0],fillindata[1]); //person object that creates the data with the name and date.
 					databaseinfo.ADTpeopledatabaseadd(person); //uses add method to add the person.
 				}
 				
 			}
 			
 		}catch(Exception e) //if there is a exception 
 		
 		{
 			System.out.println(" " + e); // we print the exceptions.
 		}
 		
 		//calling tester method on databaseinfo
 		tester(databaseinfo); //we call all the methods on the tree and uses to test. 
 		
	}
	
	
	/*
	 * method that test all the functions of the ADTpeopledatabase
	 * 
	 * @param ADTpeopledatabase datbaseinfo*/
	
	
	 
     static void tester(ADTpeopledatabase databaseinfo) throws Exception
     {
    	 
    	 
// --------------------------------------------------general database testing here --------------------------------------------
    	
	//printing database
			System.out.println(" ");
			System.out.print("--------------------general testing on database--------------------------------");
			System.out.println(" ");
			System.out.println(" ");
			databaseinfo.printDB(); //database is printed first
			
			
			
			
			
			
		
			System.out.println("------------------delete test----------------------");
			
			//------------------------------------------delete record testing.--------------------------------
			people person1 = new people("anudeep", 12021991); //creating a people instance to delete the record
			people person2 = new people("colin",21052000);
			people person9 = new people("damini",15062001);
			//deleting all three records
			databaseinfo.databasedelete(person1);
			
			//printing database after deleting 
		    System.out.println(" ");
			databaseinfo.printDB();
			
			
     		databaseinfo.databasedelete(person2);
     		
     		//printing database after deleting 
		    System.out.println(" ");
			databaseinfo.printDB();
			
     		databaseinfo.databasedelete(person9);
     		
     		//printing database after deleting 
		    System.out.println(" ");
			databaseinfo.printDB();
     		
			//deleting someone who isnt in database to check
     		
			databaseinfo.databasedeletebyname_and_date("anudeep sai",13021990);
			
			System.out.println(" "); //indentations
			
			//deleting by name and date not by creating a  person 
			databaseinfo.databasedeletebyname_and_date("kumar",10081991);
			//printing database after deleting 
		    System.out.println(" ");
			databaseinfo.printDB();
			
			
			//delete test ends....................!!!
			
			
			
			
			System.out.println("------------------ search test ----------------------");
			
			
			//---------------------------------searching a person total details---------------------------------
			people personn = new people("bheem", 11121991); //searching a person by creating a people instance
			databaseinfo.databasesearch(personn);  //calling search method
			//indentation purpouse.
			System.out.println(" ");
			
			//printing database after searching 
		    System.out.println(" ");
			databaseinfo.printDB();
			
			
			System.out.println("------------------search by name test----------------------");
			//searching by only name 
			String searchname = "jeel";
			databaseinfo.databasesearchpersonname(searchname);
			
			
			//indentation
		    System.out.println(" ");
		  //printing database after searching 
		    System.out.println(" ");
			databaseinfo.printDB();
			
			
			databaseinfo.databasesearchpersonname("sai vishnu anudeep kadiyala");
			
			//indentation
		    System.out.println(" ");
		  //printing database after searching 
		    System.out.println(" ");
			databaseinfo.printDB();
			
			
		    databaseinfo.databasesearchpersonname("bheem");
			
			//indentation
		    System.out.println(" ");
			
		  //printing database after searching 
		    System.out.println(" ");
			databaseinfo.printDB();
			
		    databaseinfo.databasesearchpersonname("AK");
			
			//indentation
		    System.out.println(" ");
			
		  //printing database after searching 
		    System.out.println(" ");
			databaseinfo.printDB();
			
			
		    databaseinfo.databasesearchpersonname("srinivas");
			
			//indentation
		    System.out.println(" ");
		  //printing database after searching 
		    System.out.println(" ");
			databaseinfo.printDB();
			
			
			databaseinfo.databasesearchpersonname("deepthi");
			
			//indentation
		    System.out.println(" ");
			//printing database after searching
		    System.out.println(" ");
			databaseinfo.printDB();
			
			
			
			//search test ends ......................!!!!
			
			
			
			
			
			
			System.out.println("------------------modification test----------------------");
			
			//---------------------------------modifying database---------------------------------------
			people person3= new people("anudeep", 12021991); //taking in a new record
			databaseinfo.ADTpeopledatabaseadd(person3);//adding it to the tree
			
			//printing database after adding
			  
			databaseinfo.printDB();
			
			//indentation
			 System.out.println(" ");
			 
			people person4 = new people("anudeep",17012002); //creating a altered record
			databaseinfo.modifydatabase(person3, person4); //modifying the data
		
			//printing database after modifying
		  
			databaseinfo.printDB(); //printing 
			
			//indentation
			 System.out.println(" ");
			 
			 people person5 = new people("sreya",12081991); //creating a people instace of existing data
			 people person6 = new people("shivam",12081991);//creating a a people instance with altered data
			databaseinfo.modifydatabase(person5,person6); //modifying database with new details.
			
			//printing database after modifying
			  
			databaseinfo.printDB();
			
			//indentation
			 System.out.println(" ");
			 
			 
			 
			 
			 
			 System.out.println("------------------modification on name----------------------");
			 
			 //----------------------------------modifying only name----------------------------------------
			 
		    //modifying just name of a person with date of birth given for identification.
		    databaseinfo.modifydatabaseforname("shivam","sreya",12081991); //first name is changed to second name mentioned with date of birth to authenticate person.
		    
		   //printing database after modifying
			  
			databaseinfo.printDB();
			
			//indentation
		    System.out.println(" ");
		    
		    //modifying just name of a person with date of birth given for identification.
		    databaseinfo.modifydatabaseforname("sreya","sreyaa",12081991); //first name is changed to second name mentioned with date of birth to authenticate person.
		    
		   //printing database after modifying
			  
			databaseinfo.printDB();
			
			//indentation
		    System.out.println(" ");
		    
		    
		    
		    
		    
		    
		    
		    
		    System.out.println("------------------modification test on date----------------------");
		    //-------------------------------modifying the database for date.----------------------------------------
		    
		   //changed first date of birth to second in the database. 
		    databaseinfo.modifydatabasefordate("sreya",12081991,12102002); //returns not existing in database as we changed name
		    
		    
		    //printing database after modifying. 
			  
			databaseinfo.printDB();
		    
			//indentation of the console
		    System.out.println(" ");
		  //indentation of the console
		    System.out.println(" ");
		    
		    //changing the date of birth of name from first date to second date.
	    
			databaseinfo.modifydatabasefordate("sreyaa",12081991,13102002); //changes the database for use
			     
			    
			    //printing database after modifying. 
				  
				databaseinfo.printDB();
			    
				//indentation of the console
			    System.out.println(" ");
			  //indentation of the console
			    System.out.println(" ");
		    
		    
			    
			    
			    
			    
			    
			    
//-----------------------------------------------special searches starts here---------------------------------------.
			 
		    
		    //searches for particular month, date, day, year and partial names and first letter of the name.
		    System.out.println("----------------------------------special searching on database----------------------------");
		  //indentation of the console
		    System.out.println(" ");
			//printing the list.
			databaseinfo.fillinlist(); //filling the tree to the list and printign the list. 
			System.out.println(" ");
			//indentation of the console
		    System.out.println(" ");
			
		    
		    
		    
		    
		    
		    //-------------------------------for a date -------------------------------------------------------------
			 
		    System.out.println("------------------date of birth search test----------------------");
			//searching for a particular date of birth
			databaseinfo.specialsearchfordate_of_birth(17012002); //sepical search for this date.
			
			//indentation
			 System.out.println(" ");
			
		    System.out.println("----------total database----------------");
		    
		  //printing database after searching
			  
			databaseinfo.printDB();
			
			//indentation
		    System.out.println(" ");
		    
		    
		    
		    
		  //searching for a particular date of birth
			databaseinfo.specialsearchfordate_of_birth(10051997); //special search for this date.
			
			//indentation
			 System.out.println(" ");
			//printing total database for check
		    System.out.println("----------total database----------------");
		    
		  //printing database after searching
			  
			databaseinfo.printDB();
			
			//indentation
		    System.out.println(" ");
		    
		    
		    
		    
		    
		    
		    
		    //----------------------------------------------for a month -------------------------------------------
		    
		    System.out.println("------------------particular month search test----------------------");
			
		    
		    
		    //searching for a particular month.
			databaseinfo.specialsearchformonth(5); //for  a specific month 
			
			//indentation
			 System.out.println(" ");
			
		     System.out.println("----------total database----------------");
		    
		    //printing database after searching
			  
			databaseinfo.printDB();
			
			//indentation
		    System.out.println(" ");
			//indentation
		    System.out.println(" ");
			
		    
		    
		    
		    
		    
		    
		  //searching for a particular month.
			databaseinfo.specialsearchformonth(10); //for  a specific month 
			
			//indentation
			 System.out.println(" ");
			
		     System.out.println("----------total database----------------");
		    
		    //printing database after searching
			  
			databaseinfo.printDB();
			
			//indentation
		    System.out.println(" ");
			//indentation
		    System.out.println(" ");
		    
		    
		    
		    
		    
		    
		    //--------------------------------------------------for a day---------------------------------------------
		    System.out.println("------------------particular day search test----------------------");
			
		    
		    
		    //searching for a particular day
			databaseinfo.specialsearchforday(11);
			
			//indentation
			 System.out.println(" ");
            System.out.println("----------total database----------------");
		    
		    //printing database after searching
			  
			databaseinfo.printDB();
			
			//indentation
		    System.out.println(" ");
			//indentation
			 System.out.println(" ");
			 
			 
			 
			 
			 
			 
			 
			//searching for a particular day
				databaseinfo.specialsearchforday(17);
				
				//indentation
				 System.out.println(" ");
	            System.out.println("----------total database----------------");
			    
			    //printing database after searching
				  
				databaseinfo.printDB();
				
				//indentation
			    System.out.println(" ");
				//indentation
				 System.out.println(" ");
				 
				 
			
			 
			 //------------------------------------------------for a year---------------------------------------------
			 System.out.println("------------------particular year search test----------------------");
			 
			 
			 
			 //searching for a particular year
			 databaseinfo.specialsearchforyear(2002);
			
			//indentation
			 System.out.println(" ");
			 System.out.println("----------total database----------------");
			    
			 //printing database after searching
				  
			 databaseinfo.printDB();
				
		    //indentation
		    System.out.println(" ");
			 
			//indentation
			 System.out.println(" ");
			
			 
			 
			 
			 
			 
			 //searching for a particular year
			 databaseinfo.specialsearchforyear(1990);
			
			//indentation
			 System.out.println(" ");
			 System.out.println("----------total database----------------");
			    
			 //printing database after searching
				  
			 databaseinfo.printDB();
				
		    //indentation
		    System.out.println(" ");
			 
			//indentation
			 System.out.println(" ");
			
			 
			 
			 
			 
			 //--------------------------------------------for a name -------------------------------------------------------------
			 System.out.println("------------------particular name search test----------------------");
			//searching for a particular name
			databaseinfo.specialsearchforname("colin");
			
			//indentation
			 System.out.println(" ");
		     System.out.println("----------total database----------------");
			//printing database after searching
			  
			 databaseinfo.printDB();
				
		    //indentation
		    System.out.println(" ");
			//for indentations
			System.out.println();
			
			
			
			
			
			//-------------------------------------------for partial name------------------------------------------------
			 System.out.println("-----------------partial name search test----------------------");
			
			 
			 
			 //searching for a particular name
		    databaseinfo.specialsearchforfirst_or_last_partialname("anu");
		   
		  //indentation
			 System.out.println(" ");
		    System.out.println("----------total database----------------");
		    //printing database after searching
			  
			 databaseinfo.printDB();
				
		    //indentation
		    System.out.println(" ");
		    
		    
		    
		    databaseinfo.specialsearchforfirst_or_last_partialname("sai");
		    
		  //indentation
			 System.out.println(" ");
		    System.out.println("----------total database----------------");
		    //printing database after searching
			  
			 databaseinfo.printDB();
				
		    //indentation
		    System.out.println(" ");
			
		    
		    
		    
		    
		    //------------------------------------------------for first letter--------------------------------------------
		    
		    System.out.println("------------------first letter match search test----------------------");
		   
		    
		    
		    //searching for first letter in name
		    databaseinfo.specialsearchforfirstletter_inname('a');
		   
		  //indentation
			 System.out.println(" ");
		    System.out.println("----------total database----------------");
		    //printing database after searching
			  
			 databaseinfo.printDB();
				
		    //indentation
		    System.out.println(" ");
		    
		    //searching for first letter in start name
		    databaseinfo.specialsearchforfirstletter_inname('s');
		   
		  //indentation
			 System.out.println(" ");
		    System.out.println("----------total database----------------");
		    //printing database after searching
			  
			 databaseinfo.printDB();
				
		    //indentation
		    System.out.println(" ");
		    
		    
		    
		    
		    //total indentation lines.
		    System.out.println(" ");
		    System.out.println(" ");
		    System.out.println(" ");
		    System.out.println(" ");
		    System.out.println(" ");  

		    
		    //one last time printing of the list and the tree.
		    
		    databaseinfo.printDB();
		    
		    System.out.println(" ");
		    
		    System.out.println("printing list .....!!!! ");
		    //last time printing list 
		    databaseinfo.printlist();

     }
}
