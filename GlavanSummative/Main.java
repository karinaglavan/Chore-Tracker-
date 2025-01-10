
/**
 * This class is the main class / the test class. A lot of the funactionality happens within this
 * Class. Like the login and sign up fetures. Creating the family and person instances. Having access
 * To the main menu where diffrent things can be done. Like see specific chore list, see weekley chores
 * clear weekley chores, add chores to person, remove chores
 * @author (Karina Glavan)
 * @version (2024/01/15)
 */
// Importing the whole java util library since multiple classes from it will be used
import java.util.* ; 
public class Main
{
    public static void main(String[] args)
    {
        // Declaring a Family Object since while the program is running only 1 family will 
        // Be used / decalred, but multiple families can be made
        Family family = null ;  

        // Declaring a byte variable that will be used as an option variable. For when the menu 
        // Is presented to them 
        byte bytUserOption = 0; 

        // Additional byte Option variable to keep the two slightlt seperate 
        byte bytOption = 0 ; 

        // Declaring a boolean value that will be used for the looped try catch blocks
        boolean bolTryCatch = false ; 

        // Decalring a boolean value for the first doWHile loop 
        boolean bolDoWhile = false ;  

        // Creating a Writer Object to write the family to the File 
        Writer writer = new Writer() ; 

        // Creating a Reader Object to read from the file if they choose to login
        Reader reader = new Reader() ; 

        // Outputting a hello message to the user so that they know what the application is
        System.out.println("***Hello***") ; 
        System.out.println("Welcome to the Chore Tracker. Where you and your family can track your chores efficiently") ; 
        System.out.println("Let's get started \n") ; 

        // Coding a do while loop that will either have the user login or sign up
        do
        {
            // Resetting the boolean try catch value to false so that it can be countinusly
            // Used while this do while loop is running 
            bolTryCatch = false ; 

            // Outputting the options to the user to either login or sign up 
            // Using a while loop so that a try catch block is used 
            while(!bolTryCatch)
            {
                try
                {
                    // Asking the user to either Login or SignUp 
                    System.out.println("Please choose one of the following") ; 
                    System.out.println("(1) Login") ; 
                    System.out.println("(2) SignUp") ;
                    
                    // Setting the byte value to the users variable 
                    bytUserOption = new Scanner(System.in).nextByte() ; 
                    
                    // Using an if statement to make sure the user enters in a valid number 
                    if(bytUserOption == 1 || bytUserOption == 2)
                    {
                        // Setting the boolean value to true so that the while loop can break 
                        // If the user inputs a correct value 
                        bolTryCatch = true ; 
                    }
                    else
                    {
                        // Setting the boolean value to false so that the while loop loops again
                        bolTryCatch = false ; 

                        // Ouputting an error type of message 
                        System.out.println("Please enter either 1 or 2") ; 
                    }
                }
                catch(Exception e)
                {
                    // Ouputtting an error message to the user
                    System.out.println("Incorrect value inputted please try again") ; 
                }
            }

            // Using an if statement to check what option the user chose
            // If they chose to login fileIO will be used to allow them to sign in 
            // If they choose the SignUp option additional methods will be called so that
            // They can create a family instance 
            if(bytUserOption == 1)
            {
                // Setting the family object to the fileReader 
                family = reader.FileReader() ; 

                // Checking to see if an object or a null value was returned 
                if(family != null)
                {
                    // Exiting the loop and going to the menu loop
                    bolDoWhile = true ; 
                }
                else
                {
                    // Incorrect user name or password returning them to login or sign up 
                    bolDoWhile = false ; 
                }

            }
            // Creating a new family instance 
            else
            {
                // Calling the method that will start the creation of the family
                family = createFamily() ; 
                
                // Using the writer class to write the family to the file
                writer.FileWriter(family) ; 

                // To exit the doWhile loop to actualy enter the menu
                bolDoWhile = true ; 

            }
        }
        while(bolDoWhile != true) ; 

        // Setting the boolean doWhile back to false to be able to use it again 
        bolDoWhile = false ; 

        // Coding the actual menu that the user will see, where the actual functanilty will happen 
        // (1) Where they can set up the weekley chores list
        // (2) Output a persons chore list
        // (3) Output family list
        // (4) Add / Remove Chores from Person
        // (5) Add / Remove Person from Family 
        // (6) Change Username or Password 
        // (7) Exit Program

        // Output another message to the user 
        System.out.println("\nWelcome Family " + family.getGroupName() + "\n") ; 

        // Using a do while loop for the entire menu 
        do
        {   // Declaring the boolean try catch to false to be able to use it within the loop
            bolTryCatch = false ; 

            // Using a looped try catch block for when the user selects their menu option
            while(!bolTryCatch)
            {
                try
                {   
                    //Outputting the menu options to the user
                    System.out.println() ; 
                    System.out.println("***Menu***") ; 
                    System.out.println("(1) Set up Weekley Chores ") ; 
                    System.out.println("(2) See Weekley Chores ") ; 
                    System.out.println("(3) See Person Chore List") ; 
                    System.out.println("(4) See Family List") ; 
                    System.out.println("(5) Add / Remove Chores from Person List") ; 
                    System.out.println("(6) Add / Remove Person from Family") ; 
                    System.out.println("(7) Exit Program") ; 

                    // Setting the byte option to the users inputted value
                    bytUserOption = new Scanner(System.in).nextByte() ; 

                    // If structure to make sure a menu option is inputted 
                    if(bytUserOption >= 1 && bytUserOption <= 7)
                    {
                        bolTryCatch = true ; 
                    }
                    else
                    {
                        // Outputting an error message for wrong input
                        bolTryCatch = false ; 
                        System.out.println("Please enter in a Menu Option") ; 
                    }

                }
                catch(Exception e)
                {
                    // Outputting an error message 
                    System.out.println("Please enter in one of the menu options ") ; 
                }
            }

            // Coding an if statement for the different menu options, differnt code executed based
            // On the different chosen menu option 
            if(bytUserOption == 1)
            {
                // Calling the method from the family class of setting up Weekley Chores
                family.settingWeekleyChores() ; 
                
                // Saving to a file so anychanges are saved and can be acessed again later on 
                writer.FileWriter(family) ; 
            }

            else if(bytUserOption == 2)
            {
                // Checking to see if the 2D array has been populated 
                if(family.weekleyChores != null && family.weekleyChores.length > 0 && 
                family.weekleyChores[0][1] != null)
                {
                    // Calling the method from the family class of outputting the weekley chores
                    family.outputWeekleyChores() ; 
                }
                else
                {   
                    // Outputting an error type of message 
                    System.out.println("Weekley Chores hasnt been set up yet") ;
                    System.out.println("Please set it up and come back later") ; 
                }
            }

            else if(bytUserOption == 3)
            {    
                // Setting the bytOption value to the method that has the user choose the correponding person from the family
                bytOption = choosePerson(family, "Please select whos Chore list you would like to see") ; 

                // Outputting the chore list 
                System.out.println("Chore List: ") ; 
                family.personList.get(bytOption -1).outputChoreList() ; 

            }

            else if(bytUserOption == 4)
            {
                // Calling the method from the family class of outputting the Family List 
                System.out.println("\nFamily List:") ; 
                family.outputPersonList() ; 
            }

            else if(bytUserOption == 5)
            {
                // This will have the same logic as the Removing / Adding Persons part of the code
                bolTryCatch = false ; 
                
                // Calling the choose person method and asking whos list they would like to edit 
                
                bytOption = choosePerson(family, "Please select whos Chore list you would like to edit") ;

                // Within a while loop asking the user if they would rather add a Chore or remove a chore
                while(!bolTryCatch)
                {
                    try
                    {
                        // Asking the user if they would like to add a chore or remove a chore
                        System.out.println("Please choose one of the following:") ; 
                        System.out.println("(1) Add Chore") ; 
                        System.out.println("(2) Remove Chore") ; 

                        // Setting a byte value to the users inputted value
                        bytUserOption = new Scanner(System.in).nextByte() ; 

                        // Using an if struture to make sure the user enters either 1 or 2
                        if(bytUserOption == 1 || bytUserOption == 2)
                        {
                            bolTryCatch = true ; 
                        }
                        else
                        {
                            // Outputting an error message and setting the boolean false 
                            System.out.println("Please enter either 1 or 2") ; 
                            bolTryCatch = false ; 
                        }
                    }
                    catch(Exception e)
                    {
                        // Outputing an error message 
                        System.out.println("Please enter either 1 or 2") ; 
                    }
                }

                // Using an if statment for which option the user chose
                if(bytUserOption ==1)
                {
                    // Calling the create chore method to add a chore to the persons chore list through the add Chores method
                    family.personList.get(bytOption -1).addChores(createChore()) ; 
                }
                
                else
                {
                    // If only two chores within the person list not allowed to remove
                    if(family.personList.get(bytOption-1).choreList.size() <= 2)
                    {
                        // Outputting an error message 
                        System.out.println("Only 2 chores within list. Need minimum three to remove") ; 
                    }
                    else
                    {   
                        // Resetting the boolean value to false to be able to use it 
                        bolTryCatch = false ; 
                        
                        while(!bolTryCatch)
                        {
                             try
                             {
                                 // Outputting the chore list 
                                System.out.println("Chore List: ") ; 
                                family.personList.get(bytOption -1).outputChoreList() ;
                                
                                // Populating the bytUserOption
                                bytUserOption = new Scanner(System.in).nextByte() ; 
                                
                                // If statment to make sure within the right parameters 
                                if(bytUserOption >= 1 && bytUserOption <= family.personList.get(bytOption - 1).choreList.size() )
                                {
                                    bolTryCatch = true ; 
                                }
                                else
                                {
                                    // Outputting an error message while also setting the boolean to false 
                                    System.out.println("Please enter in a corresponding value") ; 
                                    bolTryCatch = false ; 
                                }
                             }
                             catch(Exception e)
                             {
                                 // Outputting an error message
                                 System.out.println("Please enter in a correct corresponding value") ; 
                             }
                        }
                        
                        // Removing the chore from the persons chore list 
                        family.personList.get(bytOption -1).removeChores(family.personList.get(bytOption - 1).choreList.get(bytUserOption -1)) ; 
                    }
                }
                
                // Saving the changed information to the file 
                writer.FileWriter(family) ; 
            }

            else if(bytUserOption == 6)
            {   
                // Resetting the value to false to be able to use it 
                bolTryCatch = false ; 
                
                // Asking the user what they want to do either add a Person to the list or remove a Person
                while(!bolTryCatch)
                {
                    try
                    {
                        // Asking the user which they would rather do 
                        System.out.println("\nPlease choose one of the following:") ; 
                        System.out.println("(1) Add Person") ; 
                        System.out.println("(2) Remove Person") ; 

                        // Populating the value
                        bytOption = new Scanner(System.in).nextByte() ;

                        if(bytOption == 1 || bytOption == 2)
                        {
                            bolTryCatch = true ; 
                        }
                        else
                        {
                            System.out.println("Please enter in one of the options") ; 
                            bolTryCatch = false ; 
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("Please enter in a valid number") ; 
                    }
                }

                if(bytOption == 1)
                {
                    // Creating a person instance and adding it to the family list 
                    family.addPerson(createPerson()) ; 
                }
                else
                {
                    // Checking to see if the weekley chores has been populated
                    if(family.personList.size() == 1)
                    {
                        // Return the user to main menu not allowed to remove
                        System.out.println("Cannot Remove person, only 1 individual within Family") ; 
                    }
                    else
                    {        
                        // Setting the bytOption to the chooosePerson so they can remove who they want from the family
                        bytOption = choosePerson(family, "From the above list please enter which individual you would like to remove") ; 

                        // Removing the person from the family list 
                        family.removePerson(family.personList.get(bytOption)) ; 

                    }

                }

                // Saving the changed information to the file 
                writer.FileWriter(family) ; 
            }
            else
            {
                // Outputting a farewell message to the user 
                System.out.println("Thank you for using this program!") ; 
                System.out.println("Have a Good Day!!") ; 

                // Setting the doWhile boolean to true to exit the program
                bolDoWhile = true ; 
            }

        }
        while(bolDoWhile != true) ; 

    }

    /**
     * This method will create a family instance if the user chooses to signup
     * This method will populate the instance variables and return a Family to the 
     * Main method 
     * @author(Karina Glavan)
     * @version(2024/01/16)
     */
    public static Family createFamily()
    {
        // Declaring the instance variables that corresspond to the Family class
        // This mean the GroupName, username, and password
        String strGroupName ; 
        String strUserName ; 
        String strPassword ; 

        // Declaring a boolean value for the do while loop for how many persons they want 
        // To add, it runs once at first then if they want to add more the loop will run again
        boolean bolDoWhile = false ; 

        // Createing a byte variable based on the user's choise
        byte bytChoice ; 

        // Populating the variables 
        System.out.println("Please enter your Family Name / Group Name ") ; 
        System.out.println("Example: Smith") ; 
        strGroupName = new Scanner(System.in).nextLine() ; 

        System.out.println("Please enter in a username") ; 
        strUserName = new Scanner(System.in).nextLine() ; 

        System.out.println("Please enter in a password") ; 
        strPassword = new Scanner(System.in).nextLine() ; 

        // Creating the family instance of the object while using the constructor
        Family family = new Family(strGroupName, strUserName, strPassword) ; 

        // Using a do while loop to call the person class multiple times
        // For creating as many person instances as needed
        do
        {
            // Creating a person instance for every person made within the family
            Person person = createPerson() ; 

            // Adding person to family personList 
            family.addPerson(person) ; 

            // Ask the user if they want to add another person to the family using a helper method
            bytChoice = yesNo("Do you want to add another person to the family?") ; 

            if(bytChoice == 1)
            {
                bolDoWhile = false ; 
            }
            else
            {
                bolDoWhile = true ; 
            }
        }
        while(bolDoWhile!= true) ; 

        // Returning the family value to the main method
        return family ; 
    }

    /**
     * This method will create 1 person instances. Which will create the person instnaces
     * Of the family and add the persons to the family arraylist of person. This method
     * will also add the chores of each person 
     * @author(Karina Glavan)
     * @version(2024/01/16)
     */
    public static Person createPerson()
    {
        // Declaring a variable of type String for the Person's name 
        String strName ; 

        // Declaring a boolean value for the do while loop for adding chores 
        boolean bolDoWhile = false ; 

        // Populating the strName variable 
        System.out.println("Please enter the Individuals Name") ; 
        strName = new Scanner(System.in).nextLine() ; 

        // Creating the person instances 
        Person person = new Person(strName) ; 

        // Declaring a variable for the users choice
        byte bytChoice ; 

        // Setting a default chore of No Chore 
        Chore defaultChore = new Chore("No Chore") ;
        
        // Adding the default Chore to the persons chore list 
        person.addChores(defaultChore) ; 

        // Coding a do while loop to add the chores to the persons arraylist of chores
        do
        {
            // Creating a chore instance to add to the person list 
            Chore chore = createChore() ; 

            // Adding the chore to the list 
            person.addChores(chore) ; 

            // Ask the user if they want to add another person to the family
            bytChoice = yesNo("Do you want to add another chore for this person?") ; 

            // If statment based on the users choice 
            if(bytChoice == 1)
            {
                bolDoWhile = false ; 
            }
            else
            {
                bolDoWhile = true ; 
            }
        }
        while(bolDoWhile!= true) ; 

        // Returning the person value 
        return person ; 
    }

    /**
     * This method will add chores to the Person's chore list same concept of the Persons
     * Class within a doWhile loop this class will be called from the Person class etc. 
     * All of them are interconnected 
     * @author(Karina Glavan)
     * @version(2024/01/16)
     */
    public static Chore createChore() 
    {
        // Declaring the Chore variable of chore name
        String strChoreName ; 

        // Declaring variables that are present within the Chore subclasses
        // In the case of a GeneralCleaning or Dishes Chore being created 

        // GeneralCleaning possible variable(s) 
        boolean bolDeepClean = false; 

        // Dishes possible varaible(s) 
        boolean bolDishwasher ; 

        // Declaring a boolean value for a try catch block for option options 
        boolean bolTryCatch = false ; 

        // Declaring a byte options variable for the options the user will choose 
        byte bytOptions = 0 ; 

        // Declaring a byte variable for the users yes or no values 
        byte bytChoice = 0 ; 

        // Creating a chore instance 
        Chore chore ; 

        //Asking the user what type of Chore they want to enter either Chore, General
        // Cleaning, or Dishes 
        while(bolTryCatch!= true)
        {
            try
            {
                System.out.println("What type of Chore is the Chore for this Person?") ; 
                System.out.println("(1) General Chore") ; 
                System.out.println("(2) General Cleaning ") ; 
                System.out.println("(3) Dishes") ; 
                bytOptions = new Scanner(System.in).nextByte() ; 

                // Ensuring the user enters in a correct value 
                if(bytOptions == 1 || bytOptions == 2 || bytOptions == 3)
                {
                    bolTryCatch = true ; 
                }
                else
                {
                    bolTryCatch = false ; 
                    System.out.println("Please enter one of the above options") ; 
                }
            }
            catch(Exception e)
            {
                // Outputting an error message to the user
                System.out.println("Incorrect value inputted. Please try again") ; 
            } 
        } 

        // Asking the user whats the chores name 
        System.out.println("What is the name of your chore?") ; 
        strChoreName = new Scanner(System.in).nextLine() ; 

        if(bytOptions == 1)
        {
            chore = new Chore(strChoreName) ; 
        }
        
        // Based on the users previous choice creating a General Cleaning type of chore 
        else if(bytOptions == 2) 
        {
            // Populating the users choice variable by calling a helper method 
            bytChoice = yesNo("Does this chore require Deep Cleaning?") ; 
            
            if(bytChoice == 1)
            {
                bolDeepClean = true ; 
            }
            else
            {
                bolDeepClean = false ; 
            }

            // Creating the chore of type General Cleaning (sub)
            chore = new GeneralCleaning(strChoreName , bolDeepClean) ; 
        }
        
        // Now doing it if they chose to create a type of dish
        else
        {
            // Populating the users choice variable by calling a helper method
            bytChoice = yesNo("Are you using a dishwasher?") ; 
            
            if(bytChoice == 1)
            {
                bolDishwasher = true ; 
            }
            else
            {
                bolDishwasher = false ; 
            }

            // Creating the chore of type Dishes 
            chore = new Dishes(strChoreName,bolDishwasher) ; 
        }

        // Returning the chore value 
        return chore ; 
    }

    /**
     * Coding a helper method similar to that within the Family class, that gives you two
     * Options to choose from either yes or no, this allows the code to not be repetive
     * @author(Karina Glavan)
     * @version(2024/01/16)
     */
    public static byte yesNo(String message)
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
                System.out.println(message) ;
                System.out.println("(1) Yes") ; 
                System.out.println("(2) No") ; 
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
     * Creating a method that outputs the person list for the user to choose a person from 
     * That list. This will be used in the See Person Chore List, Add/Remove Chores from list and 
     * Add / Remove Persons from family 
     * @author(Karina Glavan)
     * @version(2021/01/17)
     */
    public static byte choosePerson(Family family, String message)
    {
        // Decalring a variable of type boolean to false to be able to use it for the try catch
        boolean bolTryCatch = false ; 
        
        // Declaring a varible for the users choise 
        byte bytOption = 0 ; 

        // Outputting Family List so user can choose who to remove 
        family.outputPersonList() ; 

        // Coding a looped while loop for the user to choose a person based on whatever message 
        while(!bolTryCatch)
        {
            try
            {
                System.out.println(message) ; 
                System.out.println("Corresponding to their number") ; 
                bytOption = new Scanner(System.in).nextByte() ; 

                if(bytOption >= 1 && bytOption <= family.personList.size() )
                {
                    bolTryCatch = true ; 
                }
                else
                {
                    bolTryCatch = false ; 
                    System.out.println("Please enter in a Person number correspondant") ; 
                }
            }
            catch(Exception e)
            {
                System.out.println("Please enter in a whole number value") ; 
            }
        }
    
        // Retunring the byte value
        return bytOption ; 
    }

}
