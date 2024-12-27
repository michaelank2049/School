//Michael Lankford
//1816337
//Homework 5 Question 6

import java.util.Scanner;

public class FrequencyArray 
{
    public static void main(String[] args)
    {
    
    //Array and variable declarations
        int[] arrx = new int[15];
        Scanner input = new Scanner(System.in);
        int x = 0;
        
    //For loop to add values to array arrx    
        while(x < 15)
        {
            System.out.println("Enter a value between 0 and 3:");
            int user = input.nextInt();
            if(user>=0 && user<=3)
            {
                arrx[x] = user;
            }
            x++;
        }

    //For loop to calculate frequency   
        int counter0 = 0;
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        for(int z : arrx)
        {
            if(z == 0)
            {
                counter0++;
            }
            else if(z == 1)
            {
                counter1++;
            }
            else if(z == 2)
            {
                counter2++;
            }
            else
            {
                counter3++;
            }
        }
        int[] frequency = {counter0, counter1, counter2, counter3};
       
    //For loop to print frequency     
        System.out.print("Frequency:");  
        for(int i: frequency)
        {
            System.out.printf("%d ", i);
        }
        System.out.println();
     
        
    //For loop for bar graph
      for(int row = 0; row < frequency.length; row++)
      {
        for(int column = 0; column < frequency[row]; column++ )
        {
            if(column == 0)
            {
              System.out.printf("%d:", row);
            }
            System.out.printf("%c", '*');
        }
        System.out.println();
      }
    }
    
}
