//Fig 4.8
//Counter controlled repetition

import java.util.Scanner;

public class ClassAverage 
{
    public static void main(String[] args)
    {
        
        Scanner input = new Scanner(System.in);
        
        int total = 0;
        int gradeCounter = 1;
   
//Processing phase        
        while(gradeCounter <= 10)
        {
            System.out.print("Enter grade:");
            int grade = input.nextInt();
            total = total + grade;
            gradeCounter = gradeCounter + 1;
        }
       
//termination phase        
        int average = total / 10;
        
//Display total and average of grades        
        System.out.printf("%nTotl of all 10 grades is %d%n", total);
        System.out.printf("Class average is %d%n", average);
    }
    
    
}
