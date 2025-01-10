
/**
 * This class is a subclass of the chore superclass of type Dishes. Within this class 
 * It checks if the chore of type dishes is done with a dishwasher or by hand. Exact same
 * Logic as that of the General Cleaning class. Using a boolean then based on that boolean 
 * Value setting the string variable to a specific value 
 *
 * @author (Karina Glavan)
 * @version (2024/01/10)
 */
// Implementing the java.io.Serilizable to be able to properly write and read from a file 
public class Dishes extends Chore implements java.io.Serializable 
{
   // Declaring a boolean value to check if this chore is done with a dishwasher or by hand
   private boolean bolDishwasher ; 
   
   // Declaring a string value where its actual string value is determined based on the booelan value
   private String strWashingType ;
   
   /**
    * This method is a constructor that will use the supers constructor to intilise the chores
    * Name, and also intilising the bolDishwasher and strWashingType variables. An if statement
    * Will be used to set the string variable to a specific value
    * @author(Karina Glavan)
    * @version(2024/01/10)
    */
   public Dishes(String n, boolean d)
   {    
       // Calling the superclass constructor to intilise the name of the chore
       super(n) ; 
       
       // Initisliing the boolean value to the brought in parameter value. Based on this 
       // Boolean value will determine the string variable type
       this.bolDishwasher = d ; 
       
       // Using an if statment to determine the value of the string either hand wash or
       // Using a dishwasher 
       if(bolDishwasher = false)
       {
           this.strWashingType = "Wash by Hand" ;  
       }
       
       else
       {
           this.strWashingType = "Use Dishwasher" ; 
       }
        
   }
   
   /**
    * This method is a toString method that will use the key work Override that tells the 
    * Compiler that this method will run instead of the one in the superclass, while also simultaneously
    * Using the toString that is in the super class
    * @author(Karina Glavan)
    * @version(2024/01/10)
    */
   @Override
   public String toString()
   {
       // Calling the toString from the super then adding the string variable to the toString
       return super.toString() + "Washing Type: " + this.strWashingType ;  
   }
}
