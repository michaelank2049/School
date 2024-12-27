//Fig 2.7
//Addition program that inputs 2 numbers and displays sum

import java.util.Scanner;

public class Addition 
{
    public static void main(String[] args)
    {

//Create Scanner        
        Scanner input = new Scanner(System.in);
        
//Declare variables        
        int number1;
        int number2;
        int sum;
    
//Prompt user for number and attach to variable        
        System.out.print("Enter first integer:");
        number1 = input.nextInt();
        
//Prompt user for number and attach to variable        
        System.out.print("Enter second integer:");
        number2 = input.nextInt();
        
//Calculate sum        
        sum = number1 +number2;
        
//Print sum        
        System.out.printf("Sum is: %d%n", sum);
    }
    
}
