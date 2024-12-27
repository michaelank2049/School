//Fig 3.2
//Create and manipulate Account

import java.util.Scanner;

public class AccountTest 
{
    public static void main(String[] args)
    {
        
        Scanner input = new Scanner(System.in);
        
//Create instance of account object        
        Account myAccount = new Account();
        
//display inital value which is null        
       // System.out.printf("Initial name is: %s%n%n", myAccount.getName());
        
//Prompt for and read name
        System.out.println("please enter the name:");
        String theName = input.nextLine();
     //   myAccount.setName(theName);
        System.out.println();
        
//Display name stored in myAccount
      //  System.out.printf("Name in object myAccount is: %n%s%n"), myAccount.getName());
        
    }
    
}
