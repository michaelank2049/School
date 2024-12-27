import java.util.Scanner;

public class Factorial 
{
    public static long factrl(long n)
    {
        if(n <= 1)
        {
            return 1;
        }
        else
        {
            return n * factrl(n-1);
        }
        
    }
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number:");
        long n = input.nextInt();
        
        System.out.printf("The factorial of %d is %d", n, factrl(n));
    }
}


