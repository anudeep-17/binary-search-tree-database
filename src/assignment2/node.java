package assignment2;

/*
 * class containing left right children of the current node and the key value
 * the base of the binary search tree and used for creating the tree methods like add, delete search.*/

//node class for the generic bst
public class node<T> //extends the comparable people for comparing people objects
{
	
	T value; //generic T datatype value
    node<T> left, right; //generic left and right values 
    
    //constructor
    /*constructor of the class
     * @param generic data to initialize node of the tree.*/
    public node(T data)
    {
    	value =  data; //initializes the date of the node 
    	left=right=null; //sets the left and right to null until they are added using mutators. 
    	
    }
    
    //getter method of the node.
    
    /* the method to get the value of the node
     * @return generic value of the node.
     * */
    public T getvalue()
    {
    	return value; //returns the generic value of the node.
    }
    /* the method to get the left of the node
     * @return generic value of the left node.
     * */
    public node<T> getleft()
    {
    	return left;
    }
    /* the method to get the right of the node
     * @return generic value of the right of node.
     * */
    public node<T> getright()
    {
    	return right;
    }
    
    //end of getters
    
    
    //setters methods of the value 
    /* the method to set the value of the node
     * @param generic value of the node.
     * */
    public void setvalue(T value)
    {
    	this.value =  value; //initializes the value of the node.
    }
    
    /* the method to get the left of the node
     * @param generic value of the left of node.
     * */
    public void setleft(node<T> left)
    {
    	this.left =  left; //initializes the left value of the node.
    }
    
    /* the method to set the right of the node
     * @param generic value of the right of node.
     * */
    public void setright(node<T> right)
    {
    	this.right = right; //initializes the right value of the node.
    }
    
    
    /*
     * used to compare the generic value and return a boolean value
     * @param T value1, T value2
     * @return boolean value.**/
    public boolean equals(T value1, T value2)
    {
    	if(value1 == value2)
    	{
    		return true; //if equals return true.
    	}
    	else return false;
    }
    
    //end of node class
}
