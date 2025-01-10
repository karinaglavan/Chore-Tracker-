
/**
 * This is the Reader Class that will read from the file and bring back in the information 
 * So that the user can log back in after exiting the program and having all the information
 * They previously had saved, so they can use the information
 * @author (Karina Glavan)
 * @version (2024/01/17)
 */
import java.io.* ;
import java.util.Scanner ;  
public class Reader
{
   // Returning a family value to the main menu when it is read from the file 
   public Family FileReader()
   {
        // Creating a variable of type String called fileName to be able to search for the
        // Users file 
        String fileName ; 
        
        try
        {
            // Declaring a variable of type family ; 
            Family family ;
            
            // Declaring a variable to store the ObjectInputStream (OIS)
            // Called in 
            ObjectInputStream in ; 
            
            // Building an object of type family using the default constructor 
            family = new Family() ; 
            
            // Asking the user to input their username and password so I can first check 
            // If a file exists based on the username 
            System.out.println("Please enter in your username") ; 
            String un = new Scanner(System.in).nextLine() ; 
            
            System.out.println("Please enter in your password") ; 
            String p = new Scanner(System.in).nextLine() ; 
            
            // Creating a file name based on the inputted username 
            fileName = un + ".txt" ; 
        
            // Creating a "file" to check if it exits
            File file = new File(fileName) ; 
            
            // Checking if the file exits or not 
            // And returning null if it doesnt exiist 
            if(!file.exists())
            {
               System.out.println("Error: No file matching username") ; 
               return null; 
            }
            
            // Build the OIS and connect FileInputStrea = specific objects
            in = new ObjectInputStream(new FileInputStream(fileName)) ; 
            
            // The object gets set to the class with the OIS.readObject
            family = (Family)in.readObject() ; 
            
            // Calling the toString
            //System.out.println(family) ; 
            
            // Checking to see if the username and password are correct or incorrec
            // If correct returning family if not returning null 
            if(un.equals(family.getUserName()) && p.equals(family.getPassword()))
            {
                return family ; 
            }
            else
            {
                System.out.println("Username or password incorrect") ;
                in.close() ; 
                return null;
            }
            
        }
        // File doesnt exist 
        catch(ClassNotFoundException e)
        {
            System.out.println("Error: Cannot open file for reading") ; 
        }
        // Cannot access the file No file of that name 
        catch(FileNotFoundException e)
        {
             System.out.println("Error: EOF encountered, file may be corrupt") ; 
        }
        // Cannot read the file Read and Write privlages 
        catch(IOException e)
        {
             System.out.println("Error: Cannot read from file") ;    
        }
        
        // Returning null 
        return null ;             
   }
}
