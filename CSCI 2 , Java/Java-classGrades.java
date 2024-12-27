import java.util.Scanner;

public class ClassGrades
{
    public static void main(String[] args)
    { 
        
//Assignments        
        
        Scanner input = new Scanner(System.in);        
        int count = 1;
        int count1 = 0;
        int number = 0;
        int course1 = 0;
        int course2 = 0;
        int course3 = 0;
        
// For loop

        for(int counter = 1; counter <=5; counter+=1)
        {  
            System.out.println("Enter a student's grade (course 1):");
            course1 = course1 + input.nextInt();
        }

// Do...while Loop        
        
        do
        {
            System.out.println("Enter a student's grade (course 2):");
            course2= course2 + input.nextInt();
            count = count + 1;
        }while(count <= 7);
        
// While Loop        
        
        while (number != -1)
        {
            System.out.println("Enter a student's grade (course 3)(enter -1 to stop):");
            number = input.nextInt();
            if (number != -1)
            {
                course3 = course3 + number;
                count1 = count1 + 1;
            }
        }

//Print statements        
        
        System.out.printf("The average of course 1 is:%d\n", (course1 / 5));
        System.out.printf("The average of course 2 is:%d\n", (course2 / 7));
        System.out.printf("The average of course 3 is:%d\n", (course3 / count1));

    }
}
