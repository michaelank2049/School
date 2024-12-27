//Michael Lankford
//1816337
//Homework 5 Question 2

import java.util.Scanner;
import java.util.Arrays;

public class TestAverages 
{   
    public static void main(String[] args)
    {
        
    //Declare array   
        int[][] test = new int[10][2];
        
    //Make scanner    
        Scanner input = new Scanner(System.in);

    //For loop to add grades to array   
        for(int i = 0; i < 10; i++)
        {
            System.out.println("Enter students grades:");
            for(int j = 0; j < 2; j++)
            {
                test[i][j] = input.nextInt();
            }
        }
     
    //For loop to print array elements    
        for(int[] element : test)
        {
            System.out.println(Arrays.toString(element));
        }
            
    //Declarations and for loop for average    
        int sumTest1 = 0;
        double averageTest1 = 0;
        int counterTest1 = 0;
        int sumTest2 = 0;
        double averageTest2 = 0;
        int counterTest2 = 0;
        for(int i = 0; i < test.length; i++)
        {
            for(int j = 0; j < test[i].length; j++)
            {
                sumTest1 = sumTest1 + test[i][0];
                counterTest1++;
                sumTest2 = sumTest2 + test[i][1];
                counterTest2++;
            }
        } 
        averageTest1 = sumTest1 /counterTest1;
        System.out.printf("The average of test 1 grades are: %.2f%n", averageTest1);
        averageTest2 = sumTest2 /counterTest2;
        System.out.printf("The average of test 2 grades are: %.2f%n", averageTest2);
    }
}