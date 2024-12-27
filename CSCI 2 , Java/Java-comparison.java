//Fig 2.15
//Compare integers using if statements, relational operators, and equality operators

import java.util.Scanner;

public class Comparison 
{
    public static void main(String[] args)
    {
        
//Create Scanner        
        Scanner input = new Scanner(System.in);
        
//Declare Variables        
        int number1;
        int number2;
      
//Prompt user and assign to variable         
        System.out.print("Enter first integer:");
        number1 = input.nextInt();
        
//Prompt user and assign to variable        
        System.out.print("Enter second integer:");
        number2 = input.nextInt();
        
//1st comparison statement         
        if(number1 == number2)
        {
            System.out.printf("%d == %d%n", number1, number2);
        }
        
//2cd comparison statement         
        if(number1 != number2)
        {
            System.out.printf("%d != %d%n", number1, number2);
        }

//3rd comparison statement         
        if(number1 < number2)
        {
            System.out.printf("%d < %d%n", number1, number2);
        }

//4th comparison statement         
        if(number1 > number2)
        {
            System.out.printf("%d > %d%n", number1, number2);
        }

//5th comparison statement         
        if(number1 <= number2)
        {
            System.out.printf("%d <= %d%n", number1, number2);
        }

//6th comparison statement         
        if(number1 >= number2)
        {
            System.out.printf("%d >= %d%n", number1, number2);
        }        
    }
    
}
