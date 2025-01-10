
/**
 * This Class is a Subclass of the Superclass Chore. Within this class it gives you a specific 
 * type of chore of type General Cleaning. Where there is a variable(s) that checks if the type
 * of cleaning is a deep cleaning or light cleaning 
 *
 * @author (Karina Glavan)
 * @version (2024/01/10)
 */
// Implementing the java.io.Serilizable to be able to properly write and read from a file 
public class GeneralCleaning extends Chore implements java.io.Serializable 
{
   // Declaring a variable of type boolean that is private so that its easier to set the below
   // Variable that is of type string to a specific value
   private boolean bolDeepClean ;
   
   // Decalring a variable of type String so that based on the boolean value this variable can
   // Be set through the constructor 
   private String strCleaningType ; 
   
   /**
    * This method is a constructor that takes in a parameter of type boolean and initilises the
    * boolean variable, then based on that variable the string variable will be set to a specific 
    * value
    * @author(Karina Glavan)
    * @version(2024/01/10)
    */
   public GeneralCleaning(String n, boolean dc)
   {
       
       // Calling the superclasses constructor to initilise the string value
       super(n) ; 
        
       // Initisliing the boolean value to the brought in parameter value. Based on this 
       // Boolean value will determine the string variable type
       this.bolDeepClean = dc ; 
        
       // Using an if statemnt to set the String variables to specific values either
       // Light Cleaning or Deep Cleaning
       if(this.bolDeepClean == false)
       {
            this.strCleaningType = "Light Clean" ; 
       }
        
       else
       {
            this.strCleaningType = "Deep Clean" ; 
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
       return super.toString() + "Cleaning Type: " + this.strCleaningType ;  
   }
}
