package assignment2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;



/*
 * the generic class that is used to create the tree, consists of add, delete, search, and printing methods.
 * */

//tree determiner of the class
public class genericBST<T extends Comparable<people>> //extends comparable people to use comparing people objects
{
	node<T> root; //declares a root value.
	 
	
	/*
	 * constructor of the class.
	 * only creates empty tree.
	 */
	//constructor for the generic tree
	genericBST()
	{
		root = null; //by default makes a empty root and hence a empty tree.
	} 
	
	/*
	 * constructor of the class that sets the root value
	 * @param node<T> root*/
	
	genericBST(node<T> root)
	{
		this.root = root;
	}
	
	
	//abstract method for tree function insert
	
	/*
	 * encapuslated method of insertnode making the call easy
	 * @param T value*/
	//---------------------------------------------------adding node------------------------------------------------
	void insert(T value)
	{
		root = addvalue(root, value); //calling the function that returns the node<T> value.
	}

	/*
	 * recursive function that is used to add the data to the tree
	 * @param root , value 
	 * @return node<T> root
	 * */
	//recursive methods for tree functions
	private node<T> addvalue(node<T> root, T value) 
	{
		// TODO Auto-generated method stub
		if(root == null) //if null 
		{
			root = new node(value); //if root doesnt exist it will create a root first.
//			System.out.println(root.value.toString());
//			System.out.println(" ");
			
		}
		
		if(value.compareTo((people) root.value) < 0) //else it will compare the root value with passed value and if its negative which means it less in value
		{
		 
			root.left = addvalue(root.left,value); // it will recursively call it setting the left value of the root
//			System.out.println("*****added left ******* ");
			
//			System.out.println(root.left.value.toString());
//			System.out.println("");
		}
		
		else if (value.compareTo((people) root.value)>0) // else if it is higher in compareTo return, it will go to the right 
		{
			root.right = addvalue(root.right, value); //it will fill the right side of the root recursively calling the add function.
//			System.out.println("*****added right ******* ");
//			System.out.println(root.right.value.toString());
//			System.out.println("");
		}
		
		
		return root; //at the end it will return root in every end of the call which is unchanged
	}
	
	// -----------------------------------adding done !!!----------------------------------------------------------
	
	
	//-------------------------------------delete starts here--------------------------------------------------------
	
	/*
	 * encapsulated delete method calling the delete node function on making the delete call easy.
	 * @param T value */
	void delete(T value)
	{
		root = deletenode(root, value); //calls the function to delete the node. 
		
	}

	/*
	 * delete functon that searches through the tree and delete the node
	 * @param node<T>root, T value
	 * @return node<T> root */
    node<T> deletenode(node<T> root, T value)
	{
		// TODO Auto-generated method stub
		if(root == null)
		{ 
			 return null; //base case if the root is null return null
			 
		}
		
		//else recurs down the tree and looks for the node
		
		if((value.compareTo((people) root.value)) < 0)
		{
			root.left = deletenode(root.left,value); //looks on the left of the node
			
		}
		//looks on the right of the root 
		else if ((value.compareTo((people)root.value)) > 0)
		{
			root.right = deletenode(root.right,value);
		}
		
		//if the the value and the node are same then we have to delete this node.  
		else
		{
			if(root.left == null)
			{
				return root.right; //if no left exists and right is returned 
			}
			else if (root.right == null)
			{
				return root.left; //if no right exists then left is returned.
			}
			
		}
		
		return root; //it will return the root at the end.
	}
	
	
	
	//----------------------------------------delete ends here----------------------------------------------
	
    /*
	 * encapsulated search method calling the searchnode function on making the search call easy.
	 * @param T value
	 * @return boolean value of true or false basing on existence of the value. */
	//search starts here 
	boolean search(T value)
	{
		return searchnode(root, value); //searchenode is called to check the value exist or not.
	}
	/*
	 * encapsulated search method calling the searchnodebystring function on making the search call easy if you pass just a string of name not a person object.
	 * @param String value
	 * @return boolean value of true or false basing on existence of the value. */	
	boolean searchbyname(String value)
	{
		return searchnodebystring(root, value);
	}


	/*
	 * searchnode method is used to search through the tree and return boolean value of true or false basing on existance.
	 * @param node<T> root, T value,
	 * @return boolean
	*/
	private boolean searchnode(node<T> root, T value)
	{
		boolean flag = false; //predefied boolean value as false.
		 
		if(root == null)
		{
			flag = flag; // if root is null it is false as tree is empty 
		}
		
		else if(value.compareTo((people)root.value) < 0) //else if value is smaller than root then it searched the node in left 
		{
		   return searchnode(root.left, value);	 //recursively calling searchnode with left child as parameter
		}
		
		else if(value.compareTo((people) root.value) > 0) //if the value is greater then it is in the right of the tree so searched in the right 
		{
			return searchnode(root.right, value);//recursively calling searchnode with right child as parameter
		}
		
		else //else if the node given is the value then return set the flag to true
		{
			flag = true;
		}
		
		return flag; //return the flag which will be a false or true 
		
		
	}
	
	
	private boolean searchnodebystring(node<T> root, String value)
	{
		boolean flag = false;
		
		if(root == null)
		{
			flag = flag;
		}
	
		else if(value.compareTo(((people)root.value).Stringname()) < 0)
		{
		   return searchnodebystring(root.left, value);	
		}
		
		else if(value.compareTo(((people) root.value).Stringname()) > 0)
		{
			return searchnodebystring(root.right, value);
		}
		
		else
		{
			flag = true;
		}
		
		return flag;
		
		
	}
	
	//search ends here
	
	
	//---------traversing the tree in inorder style for printing the tree///////
	
	//tree printing using inorder traversal
	/*
	 * encapulated method of traversal of the tree method that allows the printing of the tree.
	 */
	void inorderprinting()
	{
		System.out.println("printing database.....!"); //indicator of method call
		System.out.println(" "); // indentation purpouse
		
		inorder(root); //calls the inorder method that will print the tree.
		
		//indentation of the console.
		System.out.println(); 
		System.out.println();
		System.out.println();
		
	}
	
	/*used to fill the list with the generic values of the tree
	 * creates a list and adds the tree values to it.
	 * @return generic list*/
	 List<T> fillinlist()
	{
		List<T> list = new ArrayList<T>(); //creation of the list
		inorderlistfilling(root, list); //calling the inorderlist filling method to fill the list with inorder traversal values 
		
//		System.out.println(Arrays.toString(list.toArray()));
		return list; //returns the list. 
		
	}
	
	 /*
	 * traversal of the tree method that allows the printing of the tree.
	 * @param generic root value.
	 */
	private void inorder(node<T> root) 
	{
		// TODO Auto-generated method stub
		if(root == null)
		{
			return; //if null return empty tree.
		}
		
		inorder(root.left); //run through the left and starts there.
		System.out.println("" + root.value); //prints the node value.
		inorder(root.right); //runs throught the right of the tree.
	}
	
	
	/*
	 * inorder algorithm used to fill the list in the same order the tree printed.
	 * @param generic root, generic list
	 * */
	private void  inorderlistfilling(node<T> root, List<T> list)
	{
		if(root == null)
		{
			return; //if null returns a empty tree.
		}
		
        inorderlistfilling(root.left, list); //runs through the left side of the tree and fills the list.
		list.add(root.value);//list is added with the root value add() is a definded method of the list.
		inorderlistfilling(root.right, list); //runs through the right of the tree and fills the list.
		
	}
	
	/*
	 * printing list that is created using tree values. 
	 * @param generic list.*/

    void printlist(List<T> list)
    {
    	for (int i = 0 ; i < list.size(); i++)
    	{
    		System.out.println(list.get(i).toString()); //runs through loop  and prints the string values of the list.
    	}
    }
    
    /*
     * checks the list is not null and then prints the list so that it will not mark a null pointer error.
     * @param generic list*/
    void notnullcheck_and_print(List<T> list)
    {
    	if(list.isEmpty())
    	{
    		System.out.println("no record to fullfill the requirement"); //checks if empty and prints no record argument.
    		
    	}
    	else
    	{ 
    		printlist(list); //calls printlist method if the list have elements. 
    	}
    }
     // ---------------------------end of the generic class ------------------------------------------------------

}
