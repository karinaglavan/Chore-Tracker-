
/**
 * This class is the Family class, where most of the main chore information is. Like 
 * The family Group Name, the username and password, an arraylist of type person that 
 * Holds every person within a family. It will also have a 2D array that outputs the weekley
 * Chores of the entire family. 
 * @author (Karina Glavan)
 * @version (2024/01/12)
 */
// Importing the java util class for the arraylist, so that arraylists can be used in this
// Class for the choreList 
import java.util.ArrayList;

// Importing the java util Scanner class since user input is used within this class
import java.util.Scanner;

// Implementing the java.io.Serilizable to be able to properly write and read from a file 
public class Family implements java.io.Serializable 
{
    // Declaring a private variable of type String for the Family / Group Name, this will
    // Typically be the last name or a group decided name. I.E my families last name is
    // Glavan so Glavan would be the strGroupName 
    private String strGroupName ; 
    
    // Declaring a private variable of type String for the users main username
    // So that they can login and their information will be stored and seperated specifically
    private String strUserName ;
    
    // Declaring a private variable also of type String for the family password 
    // So that when they login they have to enter in both their username and password
    private String strPassword ; 
    
    // Declaring an arraylist of type Person, so that there is a list of Persons within each family
    // Since the Persons is connected to the family. The family class is sort of overarching 
    // Holding a great deal of the information of the program 
    ArrayList<Person> personList = new ArrayList<Person>() ; 
    
    // Declaring a 2D array of type String also. This will show to the user each Persons task 
    // For an entire week thats why the dimensions of the 2D array is amount of persons by 7
    // Since there are 7 days in a week. 
    String[][] weekleyChores ; 
    
    /**
     * Creating a default constructor for when we are reading from the file, a default 
     * Contsurctor is needed 
     * @author(Karina Glavan)
     * @version(2024/01/16)
     */
    public Family()
    {
        // Setting the instance variables to deafult values
        this.strGroupName = "UNKNOWN" ; 
        this.strUserName = "UNKNOWN" ; 
        this.strPassword = "UNKNOWN" ; 
    }
    
    /**
     * Creating a constructor method that populated the Famillies group name, their username
     * And password. Only those three variables since the personList and weklekey chores will
     * Be populated in another way
     * @author(Karina Glavan)
     * @version(2024/01/12)
     */
    public Family(String gn, String us, String p)
    {
        // Setting each instance variable to their corresponding brought in value 
        this.strGroupName = gn ; 
        this.strUserName = us ; 
        this.strPassword = p ; 
    }
    
    /**
     * Creating get Methods for both the username and password variables. These will 
     * Most likeley be used in the reader class, when reading from a file to make sure the
     * Username and password inputted is the same as in the file 
     * @author(Karina Glavan)
     * @version(2024/01/12)
     */
    public String getUserName()
    {
        return this.strUserName ; 
    }
    
    public String getPassword()
    {
        return this.strPassword ; 
    }
    
    public String getGroupName()
    {
        return this.strGroupName ; 
    }
    
    /**
     * Creating a method that adds Person objects to the personList arraylist, everytime 
     * A person is needed to be added to a Family this method is called and the Person is 
     * Added to the arraylist
     * @author(Karina Glavan)
     * @version(2024/01/12)
     */
    public void addPerson(Person p)
    {
        personList.add(p) ; 
    }
    
    /**
     * Creating a method that removes a Person object from the personList arraylist
     * @author(Karina Glavan)
     * @version(2024/01/12)
     */
    public void removePerson(Person p)
    {
        personList.remove(p) ; 
    }
    
    /**
     * Creating a method that will actually populate the weekleyChores 2D array
     * Some parts will be set by be i.e Day 1 Day 2 etc. The Persons will be set as the
     * Rows and the user will place each person and what chores they want for each day
     * @author(Karina Glavan)
     * @version(2024/01/12)
     */
    public void settingWeekleyChores()
    {
        // Declaring a boolean value that will be used within a tryCatch block for when the
        // User chooses their chore options 
        boolean bolTryCatch = false ; 
        
        // Declaring a byte value for the chore options, so that the user can choose which 
        // Chores need to be done when on the weekley chores list / outline 
        byte bytChoreOptions = 0 ;
        
        // Declaring a byte value for some user decisons within the loops
        byte bytUserChoise = 0 ; 
        
        // Declaring a boolean value for the do while loop so that the user can add as many 
        // Chores as they want for each day 
        boolean bolDoWhile = true ; 
        
        // Creating a new arraylist that will remove chores as chores are added to the 
        // Weekley chore list, this is used within the for loop since the list changes
        // Based on each loop itteration 
        //ArrayList<Chore> editedChores = new ArrayList<Chore>() ; 
        
        // Setting the dimensions of the 2D Array
        weekleyChores = new String[personList.size() + 1][8] ;
        
        // Presetting some aspects of the 2D array like the days and empty box
        weekleyChores[0][0] = " " ; 
        weekleyChores[0][1] = "Day 1" ; 
        weekleyChores[0][2] = "Day 2" ; 
        weekleyChores[0][3] = "Day 3" ; 
        weekleyChores[0][4] = "Day 4" ; 
        weekleyChores[0][5] = "Day 5" ; 
        weekleyChores[0][6] = "Day 6" ; 
        weekleyChores[0][7] = "Day 7" ; 
        
        for(int i = 0 ; i < personList.size() ; i++)
        {
           // Telling the user which person they will be setting up their weekley chores with first, second etc.
           System.out.println("The following person is who you need to set up their weekley chores") ; 
           
           // Using the arraylist.get to go through sequentially the arraylist for setting
           // Up each persons corresponding chores for the week
           System.out.println(personList.get(i)) ; 
           
           // Setting the person to the corresponding spot in the array
           weekleyChores[i+1][0] = personList.get(i).toString() ;
           
           // Setting the edited chores arraylist to the corresponding person lists persons
           // Chore list 
           //editedChores = personList.get(i).choreList ; 
                      
           // Coding a for loop that itterates 7 times since there are only 7 days in a week
           for(int j = 0 ; j < 7 ; j++)
           {   
               // Resetting the do while for each day itteraiton 
               bolDoWhile = true ; 
               
               // Coding a do while loop so that they can add as many times as they want 
               // Within each day
               do
               {
                   // Outputing the corresponding chores list to the user with numbers so they can see
                   // The selection of chores from the users chores arraylist 
                   System.out.println("\nCurrent Chores available:") ; 
                   personList.get(i).outputChoreList() ; 
                   
                   // Setting the boolean value to false again so it can be used through the loop iterations
                   bolTryCatch = false ; 
                   
                   // Using a while loop for error trapping asking the user which chore they
                   // Would like to add for the persons day 1
                   while(!bolTryCatch)
                   {
                       try
                       {
                           // Asking the user to choose a chore to add to the 2D array weekley chores
                           // And populating the variable with that value 
                           System.out.println("\nFrom the above shown list please choose a chore to add to " + personList.get(i) + "'s Day " + (j+1)) ; 
                           bytChoreOptions = new Scanner(System.in).nextByte(); 
                           
                           // Ensuring they can't enter 0 or a number less then 0
                           if(bytChoreOptions <= 0)
                           {
                               // Outputting an error message to the user 
                               System.out.println("Invalid number inputted. Please enter a positive value") ; 
                               
                               // Setting the boolean value to false since its an incorrect type of input so the user
                               // Would be forced to input a correct value again, since their is no negative number
                               bolTryCatch = false ;
                           }
                           
                           // Ensuring the user doesn't enter in a value greater then the chore list 
                           else if(bytChoreOptions > personList.get(i).choreList.size())
                           {
                               // Outputting an error message to the user
                               System.out.println("Invalid number inputted. Please enter a value on the present List") ; 
                               
                               // Setting the boolean value to false since the user chose a number greater then the actual list
                               bolTryCatch = false ;  
                           }
                           // If all proper conditions are met set the boolean to true so exit the while loop 
                           else
                           {
                               // Setting the boolean value to true, if there where no errors present 
                               bolTryCatch = true ;  
                           }
                       }
                       catch(Exception e)
                       {
                            // Outputting an error message to the user 
                            System.out.println("Error! Please enter a whole number") ; 
                       }
                       
                   }
                   
                   // Changing any possible null values within the 2D array to a string value 
                   if(weekleyChores[i+1][j+1] == null)
                   {
                        weekleyChores[i+1][j+1] = "" ; 
                   }
                   // Adding an else for the weekley chores comma, for if more chores are addded
                   else
                   {
                       weekleyChores[i+1][j+1] += ", "  ; 
                   }
                   
                   // Setting that chosen chore within the 2D array
                   weekleyChores[i+1][j+1] += personList.get(i).choreList.get(bytChoreOptions -1).toString() ; 
                   
                   // Calling the yesNo method to see if the user wants to add more chores for the day
                   bytUserChoise = yesNo("\nAre you adding any more chores for Day " + (j+1)) ; 
                   
                   // Based on the users choice re looping so they can add another chore
                   if(bytUserChoise == 1)
                   {
                       // Setting is to false so that the user can add another chore for that specific day 
                       bolDoWhile = false ; 
                   }
                   
                   else
                   {
                       // Setting it to true to break the dowhile loop so the for loop moves onto the next itteration
                       bolDoWhile = true ;  
                       
                      //# Removing the idea of removing chores, from the edited list 
                      //# Because it was simlutainusly removing from the regular chore list
                      //# Was saving weird
                      // Calling the yesNo method to see if the user wants this chore again through the week 
                      //bytUserChoise = yesNo("\nIs this chore being used again in this week?") ; 
                   
                      //Coding an if statement based on if the chore is used again within the 2D
                      // if(bytUserChoise == 2)
                       {
                       // Removing that chore option from the edited Arraylist 
                       //editedChores.remove(bytChoreOptions - 1) ; 
                       }
                   }
                   
               }
               // So that it loops while the boolean value is not true
               while(bolDoWhile != true) ; 
           }
           
        }
     
    }
    
    
    /**
     * Creating a sort of helper method for when the user can only choose between 1 or 2 / yes or no
     * This method is used to avoid repetive code instead of having the same pieace of code multiple times
     * Just calling a method
     */
    public byte yesNo(String message)
    {
        // Decalring a boolean value for the try catch to loop multiple times within a try catch
        boolean bolTryCatch = false ; 
        
        // Decalring a byte value for the users choise of either 1 or 2
        byte bytUserChoise = 0 ;  
        
        // Asking the user if this chore will be preformed again using a looped tryCatch again
        while(!bolTryCatch)
        {
            try
            {
                // Ouputting the message where the users only options are yes or no
                System.out.println(message) ;
                System.out.println("Enter 1 for 'yes' and 2 for 'no'") ; 
                bytUserChoise = new Scanner(System.in).nextByte() ; 
                        
                // Using a if statment to make sure the users input is within the right parameteres
                if(bytUserChoise == 1 || bytUserChoise == 2)
                {
                    // Setting the boolean value to true, because this part only allows it if its equal to the 
                    // Two possible correct values
                    bolTryCatch = true;                             
                }
                else
                {
                    // Outputting an error message to the user
                    System.out.println("Please enter either 1 or 2") ; 
                                
                    // Setting the boolean value to false since anything besides 1 or 2 is wrong
                    bolTryCatch = false ; 
                }
            }
            catch(Exception e)
            {
                    // Outputting an error message to the user 
                    System.out.println("Please enter either 1 or 2") ; 
            }
                       
        }           

        // Returning the users choise value to where it was called in the creating the 2D array method
        return bytUserChoise ; 
 
    }
    
    /**
     * Creating a method that will output the weekleyChores 2D array, Essentially this
     * method will have a nested for loop that will loop through rows and columns 
     * To output everypart of the 2D array
     * @author(Karina Glavan)
     * @version(2024/01/12)
     */
    public void outputWeekleyChores()
    {
        // Ouputting the 2D array of weekley chores by going through rows then columns 
        for(int i = 0; i < this.weekleyChores.length; i++)
        {
            //System.out.println("This is line " + i) ; 
            for(int j = 0 ; j < this.weekleyChores[0].length ; j++)
            {
                System.out.print("\t\t" + this.weekleyChores[i][j].trim()) ; 
            }
            
            System.out.println("\n") ; 
        }
        
    }
    
    /**
     * Creating a method that will output the person arraylist
     * The list of people within the family arraylist so in case someone moves out or something
     * @author(Karina Glavan)
     * @version(2024/01/16)
     */
    public void outputPersonList()
    {
        // Outputting the arraylist of person with numbers corresponding to each person
        for(int i = 1 ; i <= personList.size() ; i++)
        {
            System.out.println(i +": " + personList.get(i -1)) ; 
        }
    }
    
    /**
     * Creating a toString method that will be used to save the family information to a
     * File, so that the information inputted by the user can be accessed again after 
     * exiting the program and logging back in
     * @author(Karina Glavan)
     * @version(2024/01/14)
     */
    // Not adding the arraylist and 2D array to the toString since those will be saved to 
    // A file through their methods
    public String toString()
    {
        return this.strGroupName + "\n" + this.strUserName + "\n" + this.strPassword ; 
    }
        
    
}
