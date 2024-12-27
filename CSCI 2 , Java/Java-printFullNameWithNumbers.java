import java.util.Scanner;

public class printFullNameWithNumbers
{   
    public static void sum()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number1 and number2:");
        int number1 = input.nextInt();
        int number2 = input.nextInt();
        
        int sum= number1 + number2;
        System.out.println("Michael A. Lankford");
        System.out.printf("The sum is %d", sum);
    }
    
    public static void main(String[] args)
    {   
        sum();
    }
    
}
