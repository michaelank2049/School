//Michael Lankford
//1816337
//Homework 5 Question 5

public class MultiplyBy3
{
    static int[] array1 = {1, 2, 3, 4, 5};
    
    public static void mult3()
    {
        int product = 3;
        for(int i = 0; i < array1.length; i++)
        {
            System.out.println(array1[i] * product);
        }
    }
    
    public static void main(String[] args)
    {
       mult3();  
    } 
}
