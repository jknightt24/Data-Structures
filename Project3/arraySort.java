
public class arraySort
{   
    int mergeSortTime = 0;
    /**
     * Bubble sort algorithm
     * for each element in the array compare it to the next element
     * if the current element is greater than the next element swap the two
     * continue until no swaps are needed
     * @param array
     */
    public int bubbleSort(int[] array)
    {
        long currentTime = System.currentTimeMillis();
        int[] copy = array.clone();
        boolean swapped = true;
        int temp = 0;

        while(swapped)
        {
            swapped = false;
            for(int i = 0; i < copy.length - 1; i++)
            {
                if(copy[i] > copy[i + 1])
                {
                    temp = copy[i];
                    copy[i] = copy[i + 1];
                    copy[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        return (int)(System.currentTimeMillis() - currentTime);
    }

    /**
     * Selection sort algorithm
     * First finds the smallest element in the list and puts it at the beginning of the array
     * then finds the second smallest and puts it at the second spot in the array
     * repeat until the array is ordered
     */
    public int selectionSort(int[] array)
    {
        long currentTime = System.currentTimeMillis();
        int[] copy = array.clone();
        
        for(int i = 0; i < copy.length - 1; i++)
        {
            int smallest = i;
            for(int j = i + 1; j < copy.length; j++)
            {
                if(copy[j] < copy[smallest])
                {
                    smallest = j;
                }
            }
        }
        return (int)(System.currentTimeMillis() - currentTime);
    }

    /**
     * insertion sort algorithm
     * First find the smallest element in the list and put it at the beginning of the sorted version of th array
     * then find the second smallest and put it at the second spot in the new array
     * repeat until the new array is ordered
     */
    public int insertionSort(int[] array)
    {
        long currentTime = System.currentTimeMillis();
        int[] copy = array.clone();
        int temp = 0;

        for(int i = 1; i < copy.length; i++)
        {
            for(int j = i; j > 0; j--)
            {
                if(copy[j] < copy[j - 1])
                {
                    temp = copy[j];
                    copy[j] = copy[j - 1];
                    copy[j - 1] = temp;
                }
            }
        }
        return (int)(System.currentTimeMillis() - currentTime);
    }
    /**
     * Merge sort algorithm
     * Constantly splits the array in half until the array is of size 1
     * then merges the arrays back together in order
     * @param array
     * @return
     */
    public int mergeSort(int[] array) 
    {
        long currentTime = System.currentTimeMillis();
        int[] copy = array.clone();

        if (copy.length <= 1) 
        {
            return 0;
        }

        int[] sortedArray = mergeSortHelper(copy);
        return (int) (System.currentTimeMillis() - currentTime);
    }

    private int[] mergeSortHelper(int[] array) 
    {
        if (array.length <= 1) 
        {
            return array;
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        left = mergeSortHelper(left);
        right = mergeSortHelper(right);

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) 
    {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) 
        {
            if (left[i] <= right[j]) 
            {
                result[k++] = left[i++];
            } 
            else 
            {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) 
        {
            result[k++] = left[i++];
        }

        while (j < right.length) 
        {
            result[k++] = right[j++];
        }

        return result;
    }

    /**
     * From https://www.geeksforgeeks.org/shell-sort/#
     * Optimized version of insertion sort which also makes use of gap values 
     * these gap values are used to compare elements that are far apart from each other
     * @param copy
     * @return
     */
    public int shellSort(int[] array)
    {
        long currentTime = System.currentTimeMillis();
        int[] copy = array.clone();
        int size = copy.length;

        // Makes the initial gap the size of the array 
        for(int gap = size / 2; gap > 0; gap = gap / 2)
        {
            // counts from the gap up to the size of the array
            for(int i = gap; i < size; i++)
            {
                // makes the gap value(middle value) of the array a temp value
                int temp = copy[i];
                int j;
                for(j = i; j >= gap && copy[j - gap] > temp; j = j - gap)
                {
                    copy[j] = copy[j - gap];
                    
                }
                copy[j] = temp;
            }
        }
        return (int)(System.currentTimeMillis() - currentTime);
    }

    /**
     * Quick sort algorithm
     * First picks a pivot point in the array
     * then compares all elements to the pivot point
     * if the element is less than the pivot point it is moved to the left of the pivot
     * if the element is greater than the pivot point it is moved to the right of the pivot
     * repeat until the array is sorted
     * @param array
     * @return
     */
    public int quickSort(int[] array)
    {
        long currentTime = System.currentTimeMillis();
        int[] copy = array.clone();
        quickSortHelper(copy, 0, copy.length - 1);
        return (int)(System.currentTimeMillis() - currentTime);
    }

    private void quickSortHelper(int[] array, int low, int high)
    {
        if(low < high)
        {
            int pi = partition(array, low, high);

            quickSortHelper(array, low, pi - 1);
            quickSortHelper(array, pi + 1, high);
        }
    }

    private int partition(int[] array, int low, int high)
    {
        int pivot = array[high];
        int i = (low - 1);

        for(int j = low; j < high; j++)
        {
            if(array[j] < pivot)
            {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    /**
     * Heap sort algorithm
     * First creates a heap from the array using the binary heap data structure
     * then sorts the array by swapping the first element with the last element
     * then heapifying the array
     * repeat until the array is sorted
     * @param array
     * @return
     */
    public int heapSort(int[] array)
    {
        long currentTime = System.currentTimeMillis();
        int[] copy = array.clone();
        int size = copy.length;

        for(int i = size / 2 - 1; i >= 0; i--)
        {
            heapify(copy, size, i);
        }

        for(int i = size - 1; i > 0; i--)
        {
            int temp = copy[0];
            copy[0] = copy[i];
            copy[i] = temp;

            heapify(copy, i, 0);
        }
        return (int)(System.currentTimeMillis() - currentTime);
    }

    private void heapify(int[] array, int size, int i)
    {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < size && array[left] > array[largest])
        {
            largest = left;
        }

        if(right < size && array[right] > array[largest])
        {
            largest = right;
        }

        if(largest != i)
        {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, size, largest);
        }
    }
}
