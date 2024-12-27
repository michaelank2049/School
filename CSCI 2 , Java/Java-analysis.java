//Fig 4.12
//Nested control statements

import java.util.Scanner;

public class Analysis 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        int passes = 0;
        int failures = 0;
        int studentCounter = 1;
      
//Process 10 students using counter-controlled repetition        
        while(studentCounter <= 10)
        {
            System.out.print("Enter result(1 = pass, 2 = fail):");
            int result = input.nextInt();
            
            if(result == 1)
            {
                passes = passes +1;
            }
            else
            {
                failures = failures + 1;
            }
            studentCounter = studentCounter +1;
        }
        
//Termination phase; prepare and display results        
        System.out.printf("Passed: %d%nFailed: %d%n", passes, failures);
        
//Determine whether more than 8 students passed        
        if(passes > 8)
        {
            System.out.println("bonus to instructor!");
        }
    }
    
}
