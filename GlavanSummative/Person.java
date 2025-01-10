
/**
 * This class is the person class that will create person objects. So that when a family class
 * Is made, they can add as many person instances as they want corresponding to their family.
 * Within this class each person will have an ArrayList of type Chore, which will be a list of
 * their chores. Corresponding to that arraylist there will be some sort of method with an 
 * Object choreType variable, that will determine the object type of the chore when its getting
 * Added to the arraylist. 
 * 
 * @author (Karina Glavan)
 * @version (2024/01/11)
 */

// Importing the java util class for the arraylist, so that arraylists can be used in this
// Class for the choreList 
import java.util.ArrayList;
// Implementing the java.io.Serilizable to be able to properly write and read from a file 
public class Person implements java.io.Serializable 
{
    // Declaring a variable of type String for the persons name that is private
    private String strName ; 
    
    // Declaring an arraylist of type Chore for each persons individual chore list
    // The arraylist is of type chore since the subclasses are still technically of 
    // Type chore so for simplicity sake its of type Chore
    ArrayList<Chore> choreList = new ArrayList<Chore>() ; 
    
    /**
     * Coding a constructor that initilises the persons name, no default constructor
     * Since the way the program works the user will be forced to input a name they cant
     * Leave that pieace of information blank
     * @author(Karina Glavan)
     * @version(2024/01/11)
     */
    public Person(String n)
    {
        // Setting the String name variable to the parameter value 
        this.strName = n ; 
    
    }
    
    /**
     * Coding a get method for the persons name, since the variable is private a getter
     * method would be needed to acess this variable from another class
     * @author(Karina Glavan)
     * @version(2024/01/11)
     */
    public String getName()
    {
        // Returning the string name value
        return this.strName ; 
    }
    
    /**
     * Coding a method called addChores to add Chores to the persons arraylist 
     * So that we can add as many chores to the persons chore list  
     * @author(Karina Glavan)
     * @version(2024/01/11)
     */
    public void addChores(Chore c)
    {
       choreList.add(c) ; 
    }
    
    /**
     * Coding a method called remove Chores that will remove chores from the persons arraylist
     * As the user see's fit. Thus the benefit of an arraylist, can remove and add elements
     * Whenever
     * @author(Karina Glavan)
     * @version(2023/01/15)
     */
    public void removeChores(Chore c)
    {
        choreList.remove(c) ; 
    }
   
    /**
     * This method will output the persons chore list, so that in the family class
     * The user can easily select the chore for the corresponding person on the weekleyChore
     * List 
     * @author(Karina Glavan)
     * @version(2024/01/12)
     */
    public void outputChoreList()
    {
        for(int i = 1 ; i <= this.choreList.size() ; i++)
        {
            System.out.println(i + ": " + this.choreList.get(i-1)) ; 
        }
    }
    
    /**
     * Coding a toString method so that its easy to save the person class to a file
     * So that person instances are saved easily witin a file 
     * @author(Karina Glavan)
     * @version(2024/01/11)
     */
    public String toString()
    {
        return this.strName; 
    }
    
    
}
