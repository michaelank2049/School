//Fig 19.4 
//Sort an array with selection sort

import java.security.SecureRandom;
import java.util.Arrays;

public class SelectionSortTest 
{
    //sort array
    public static void selectionSort(int[] data)
    {
        for(int i = 0; i < data.length - 1; i++) //loop over data.length - 1 elements
        {
            int smallest = i; //1st index of remaining array
            
            for(int index = i + 1; index < data.length; index++) //loop to find index of smallest element
            {
                if(data[index] < data[smallest])
                {
                    smallest = index;
                }
                
                swap(data, i, smallest); //swap smallest element into position
//                printPass(i + 1, smallest); //output pass algorithm
            }
        }
        
    }
    
    private static void swap(int[] data, int first, int second) //helper method to swap values in two elements
    {
        int temporary = data[first]; //Store 1st in temporary
        data[first] = data[second]; //Replace first with second
        data[second] = temporary; //Put temporary in second
    }
    
    private static void printPass(int[] data, int pass, int index) //Print a pass of the algorithm
    {
        System.out.printf("after pass %2d: ", pass);
        
        for(int i = 0; i < index; i++) //Output elements till selected item
        {
            System.out.printf("%d", data[i]);
        }
        
        System.out.printf("%d*", data[index]); //Indicate swap
        
        for(int i = index + 1; i < data.length; i++) //finish outputting array
        {
            System.out.printf("%d", data[i]);
        }
        
        System.out.printf("%n            "); // For alignment
        
        for(int j = 0; j < pass; j++) //Indicate amount of array that's sorted
        {
            System.out.print("--  ");
        }
        
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        SecureRandom generator = new SecureRandom();
        
        int[] data = new int[10]; //Create array
        
        for(int i = 0; i < data.length; i++) //populate array
        {
            data[i] = 10 + generator.nextInt(90);
        }
        
        System.out.printf("Unsorted array:%n%s%n%n", Arrays.toString(data)); //Display array
        
        selectionSort(data); //Sort Array
        
        System.out.printf("Sorted array:%n%s%n%n", Arrays.toString(data)); //Display Array
        
    }
    
}
