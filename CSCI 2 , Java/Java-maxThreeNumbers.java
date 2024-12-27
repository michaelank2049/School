import java.util.Scanner;
public class maxThreeNumbers 
{
    public static void findMax1()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number 1 number 2 and number 3:");
        int number1 = input.nextInt();
        int number2 = input.nextInt();
        int number3 = input.nextInt();
        
        if (number1 > number2)
            if (number1 > number3)
                System.out.printf("The largest number is: %d", number1);
        
        if (number2 > number1)
            if (number2 > number3)
                System.out.printf("The largest number is: %d", number2);
        
        if (number3 > number1)
            if (number3 > number2)
                System.out.printf("The largest number is: %d", number3);
    }
    
    public static void findMax2()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number 1 number 2 and number 3:");
        int number1 = input.nextInt();
        int number2 = input.nextInt();
        int number3 = input.nextInt();
        
        if (number2 < number3)
            if (number1 < number3)
                System.out.printf("The largest number is: %d", number3);
        
        if (number2 < number1)
            if (number3 < number1)
                System.out.printf("The largest number is: %d", number1);
        
        if (number3 < number2)
            if (number1 < number2)
                System.out.printf("The largest number is: %d", number2);
    }
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        findMax1();
        input.nextLine();
        findMax2();
    }
    
}
