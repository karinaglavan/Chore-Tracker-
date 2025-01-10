
/**
 * The Writer Class will be an Object Output Steamer, since im writing an entire object
 * To a file, to be able to save all the information from each object class. The main object 
 * Saved will be the Family Class, then everything will be serialized so that everything saves
 * Properly
 * @author (Karina Glavan)
 * @version (2024/01/17)
 */

// Importing the java.io class 
import java.io.* ; 
public class Writer
{   
    // Bringing in a family object to write it to the file 
    public void FileWriter(Family family)
    {
        // Creating a string variable called fileName , so that a new fileName is made
        // Everytime a family is created 
        String fileName ; 
        
        try
        {   
            // Declaring an object of type family called fam 
            Family fam ; 
            
            // Declare a variable fo type OOS(Object Output Stream)
            // Which will write the entire object to the file 
            ObjectOutputStream out ; 
            
            // Setting the new declared family object to the imported family
            fam = family ; 
            
            // Setting the file name to the users username . txt
            fileName = fam.getUserName() + ".txt" ; 
            
            // Build an OOS object and connect it with a FOS to create the 
            // Text file (.txt)
            out = new ObjectOutputStream(new FileOutputStream(fileName)) ; 
            
            // Use the OOS method to writeObject and send in the name of the Object
            out.writeObject(fam) ;  
            
            // Closing the file 
            out.close() ; 
        }
        // Creating a catch for if the program cannot access the file or there is no 
        // Name of that file 
        catch(FileNotFoundException e)
        {
            System.out.println("Error: Cannot open file for writing") ; 
        }
        // Catch for if the file cannot be read, and or no read and write privlages 
        catch (IOException e)
        {
            System.out.println("Error: Cannot write to file") ; 
        }
    }
}
