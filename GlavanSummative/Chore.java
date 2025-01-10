
/**
 * This Class is the superclass of chore, which will create chore objects for each individual
 * So that its easy to keep track of the chores that each person object has. Within this superclass
 * there will be one variable the chores name, 1 constrcutor to intilise that, a getter to be able to acess
 * the name of the chore, and a toString method, to be able to places the chore information into an 
 * arraylist and 2D array as a string not an object. 
 *
 * @author (Karina Glavan)
 * @version (2024/01/10)
 */
// Implementing the java.io.Serilizable to be able to properly write and read from a file 
public class Chore implements java.io.Serializable 
{
    // Declaring the chores name variable and setting it to private for secure data
    private String strName ; 
    
    /**
     * This method is a constructor that will initilise the chores classes singular variable
     * This is not a default contructor, the user will be forced to put in a name of the chore
     * So that this type of contructor is used
     * @author(Karina Glavan)
     * @version(2024/01/10)
     */
    public Chore(String n)
    {
        // Setting the name variable to the value brought in from where the method was called
        // Or more accuratley where the object was created. Using the key word this so that it
        // References it specifically
        this.strName = n ; 
        
    }
    
    /**
     * This method will be a toString method so that this object can be easily formed to a
     * toString when its implicated within an arraylist and / or 2D array
     * @author(Karina Glavan)
     * @version(2024/01/18)
     */
    public String toString()
    {
        // Within the toString returning the name as a string and adding a new line for the
        // Other toStrings within the subclasses 
        return this.strName + "," ; 
    }
}
