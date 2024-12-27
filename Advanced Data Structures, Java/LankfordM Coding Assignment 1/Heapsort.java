public class Heapsort 
{
    public void Heapify(int[] numArray, int arrayLength, int root)      //Heapify method
    {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        
        if (left < arrayLength && numArray[left] > numArray[largest])     //If left child is larger than the root, swap them, else, leave them
        {
            largest = left;
        }
        
        if (right < arrayLength && numArray[right] > numArray[largest])     //If right child is larger than the root, swap them, else, leave them
        {
            largest = right;
        }
        
        if (largest != root)        //If the largest != root then swap them and call Heapify again
        {
            int temp = numArray[root];
            numArray[root] = numArray[largest];
            numArray[largest] = temp;
            
            Heapify(numArray, arrayLength, largest);
        }
    }
    
    public void buildMaxHeap(int[] numArray, int arrayLength)       //buildMaxHeap method
    { 
        for (int i = arrayLength / 2 - 1; i >= 0; i--)      //For tree nodes run Heapify on each 1 element heap
        {
            Heapify(numArray, arrayLength, i);
        }
    }
   
    public void Heapsort(int[] numArray)        //Heapsort method
    {
        int arrayLength = numArray.length;
        
        buildMaxHeap(numArray, arrayLength);        //Call buildMaxHeap to build the heap
        
        for (int i = arrayLength - 1; i >= 0; i--)      //For the array, swap element 0 with the current element and call Heapify
        {
            int temp = numArray[0];
            numArray[0] = numArray[i];
            numArray[i] = temp;

            Heapify(numArray, i, 0);
        }
    }
}