//Michael Lankford
//1816337
//Homework 5 Question 1 

public class SummationThreeNumbers 
{

// Summation Method    
    
    public static int sumv(int...numbers)
    {
        int total = 0;
        
        for (int n : numbers)
        {
            total= total +n;
        }
        
        return total;
    }
    
//Driver Class    
    
    public static void main(String[] args)
    {
        
    //Declare Variables    
        
        int n1 = 12;
        int n2 = 23;
        int n3 = 34;   
        
    // Print numbers and their values    
        
        System.out.printf("n1 = %d%nn2 = %d%nn3 = %d%n", n1, n2, n3);
       
    //Print summation of numbers    
        
        System.out.printf("The summation of n1, n2, and n3 are %d%n", sumv(n1, n2, n3));
        System.out.printf("The summation of n1 and n3 are %d", sumv(n1, n3));
    }
}
