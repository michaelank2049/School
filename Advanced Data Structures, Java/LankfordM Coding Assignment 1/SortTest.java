import java.util.Arrays;

public class SortTest 
{
    public static void main(String[] args)
    {
        Quicksort quick = new Quicksort();        //Create Quicksort and Heapsort class objects
        Heapsort heap = new Heapsort();
                                         
                                                   //Creat arrays to be sorted
        int[] arrayUnsorted1 = {8, 100, 52, 23, 84, 3, 11, 25, 92, 78, 21, 50, 9, 4, 36, 84, 73, 16, 36, 94, 5, 82, 57, 69, 6, 48, 19, 94, 72, 1};
        int[] arrayUnsorted2 = arrayUnsorted1.clone();
        int[] arraySemisorted1 = {1, 12, 12, 7, 17, 20, 32, 27, 36, 53, 8, 45, 49, 51, 33, 15, 54, 60, 64, 72, 76, 83, 89, 89, 91, 94, 95, 96, 98, 99};
        int[] arraySemisorted2 = arraySemisorted1.clone();
        
                                                    //System prints and calls for the unsorted arrays
        System.out.println("The array is: " + Arrays.toString(arrayUnsorted1));  
        
        quick.Quicksort(arrayUnsorted1, 0, arrayUnsorted1.length - 1);
        System.out.println("The quicksort sorted array is: " + Arrays.toString(arrayUnsorted1));

        heap.Heapsort(arrayUnsorted2);
        System.out.println("The heapsort sorted array is: " + Arrays.toString(arrayUnsorted2));
        System.out.println();

                                                    //Sytem prints and calls for the semisorted arrays
        System.out.println("The array is: " + Arrays.toString(arraySemisorted1));  
        
        quick.Quicksort(arraySemisorted1, 0, arrayUnsorted1.length - 1);
        System.out.println("The quicksort sorted array is: " + Arrays.toString(arraySemisorted1));

        heap.Heapsort(arraySemisorted2);
        System.out.println("The heapsort sorted arrayis: " + Arrays.toString(arraySemisorted2));       
    }
}
