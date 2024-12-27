
import java.util.Arrays;

//Michael Lankford
//1816337
//Homework 5 Question 3

public class Define2DArray
{
    public static void main(String[] args)
    {
    //1st way to define    
        int[][] array1 = {{2, 4, 6}, {1, 3}, {4, 5, 8, 9}};
        
        for(int[] element : array1)
        {
            System.out.println(Arrays.toString(element));
        }
    
    //2cd way to define    
        int[][] array2 = new int[3][4];
        array2[0][0] = 2;
        array2[0][1] = 4;
        array2[0][2] = 6;
        array2[1][0] = 1;
        array2[1][1] = 3;
        array2[2][0] = 4;
        array2[2][1] = 5;
        array2[2][2] = 8;
        array2[2][3] = 9;
        
        for(int[] element : array2)
        {
            System.out.println(Arrays.toString(element));
        }
            
    }   
}
