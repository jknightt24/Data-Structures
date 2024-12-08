import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Random;
public class ArraySortDataCollector 
{
    /**
     * Method in charge of running all the sorting algorithms and formatting the results to a file
     * @param file
     * @param array
     * @throws Exception
     */
    public void runSorts(File file, int[] array) throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        arraySort sort = new arraySort();
        String line = br.readLine();
        // populate the array with random numbers
        for(int i = 0; i < array.length; i++)
        {
            Random rand = new Random();
            array[i] = rand.nextInt(1000000);
        }
        
        bw.write(array.length + ", ");
        bw.write(sort.insertionSort(array) + ", ");
        bw.write(sort.mergeSort(array) + ", ");
        bw.write(sort.shellSort(array) + ", ");
        bw.write(sort.bubbleSort(array) + ", ");
        bw.write(sort.selectionSort(array) + ", ");
        bw.write(sort.quickSort(array) + ", ");
        bw.write(sort.heapSort(array) + "\n");
        line = br.readLine();
        
        br.close();
        bw.close();
    }
    
    public void format(File file) throws Exception
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        bw.write("Array Size, Insertion Sort, Merge Sort, Shell Sort, Bubble Sort, Selection Sort, Quick Sort, HeapSort\n");
        bw.close();
    }
}
