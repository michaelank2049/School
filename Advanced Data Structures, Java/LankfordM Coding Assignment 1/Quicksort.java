public class Quicksort 
{
   public void Quicksort(int[] numArray, int partition, int pivot)      //Quicksort method
   {
       if (partition < pivot)       //If partition < pivot call Partition to rearrange the subarray 
       {                                 
           int q = Partition(numArray, partition, pivot);
           Quicksort(numArray, partition, q - 1);           //Pass lower subarray to Quicksort
           Quicksort(numArray, q + 1, pivot);           //Pass upper subarray to Quicksort
       }
   }
   
   public int Partition(int[] numArray, int partition, int pivot)       //Partition method
   {
       int x = numArray[pivot];     //Select pivot element
       int i = partition - 1;
       
       for (int j = partition; j < pivot; j++)      //For subarray elements check to see if pivot > current element
       {
           if (numArray[j] <= x)        //If current element is <= pivot element then swap them and increment i for next element
           {
               i++;
               int tempElement = numArray[j];
               numArray[j] = numArray[i];
               numArray[i] = tempElement;
           }
       }
       
       int tempElement = numArray[i + 1];       //Swap pivot element with leftmost element greater than x
       numArray[i + 1] = numArray[pivot];
       numArray[pivot] = tempElement;
       
       return (i + 1);
   }
}
