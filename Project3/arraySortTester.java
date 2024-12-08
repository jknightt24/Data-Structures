import java.io.File;

public class arraySortTester
{
    public static void main(String args[]) throws Exception
    {
        int[] array1 = new int[10000];
        int[] array2 = new int[20000];
        int[] array3 = new int[30000];
        int[] array4 = new int[40000];
        int[] array5 = new int[50000];
        int[] array6 = new int[60000];
        int[] array7 = new int[70000];
        int[] array8 = new int[80000];
        int[] array9 = new int[90000];
        int[] array10 = new int[100000];
        int[] array11 = new int[110000];
        int[] array12 = new int[120000];
        int[] array13 = new int[130000];
        int[] array14 = new int[140000];
        int[] array15 = new int[150000];
        int[] array16 = new int[160000];
        int[] array17 = new int[170000];
        int[] array18 = new int[180000];
        int[] array19 = new int[190000];
        int[] array20 = new int[200000];

        ArraySortDataCollector collector = new ArraySortDataCollector();
        collector.format(new File("arraySortData.csv"));
        collector.runSorts(new File("arraySortData.csv"), array1);
        collector.runSorts(new File("arraySortData.csv"), array2);
        collector.runSorts(new File("arraySortData.csv"), array3);
        collector.runSorts(new File("arraySortData.csv"), array4);
        collector.runSorts(new File("arraySortData.csv"), array5);
        collector.runSorts(new File("arraySortData.csv"), array6);
        collector.runSorts(new File("arraySortData.csv"), array7);
        collector.runSorts(new File("arraySortData.csv"), array8);
        collector.runSorts(new File("arraySortData.csv"), array9);
        collector.runSorts(new File("arraySortData.csv"), array10);
        collector.runSorts(new File("arraySortData.csv"), array11);
        collector.runSorts(new File("arraySortData.csv"), array12);
        collector.runSorts(new File("arraySortData.csv"), array13);
        collector.runSorts(new File("arraySortData.csv"), array14);
        collector.runSorts(new File("arraySortData.csv"), array15);
        collector.runSorts(new File("arraySortData.csv"), array16);
        collector.runSorts(new File("arraySortData.csv"), array17);
        collector.runSorts(new File("arraySortData.csv"), array18);
        collector.runSorts(new File("arraySortData.csv"), array19);
        collector.runSorts(new File("arraySortData.csv"), array20);
        
    }
}