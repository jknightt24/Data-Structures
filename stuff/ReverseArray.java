package stuff;
import java.util.ArrayList;
public class ReverseArray 
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        for(int i = 0; i < list.size() / 2; i++)
        {
            // set the first element to a temp variable
            int temp = list.get(i);
            // set the first element to the last element
            list.set(i, list.get(list.size() - 1 - i));
            // set the last element to the temp variable 
            list.set(list.size() - 1 - i, temp);
        }
        
       
        System.out.println(list);
    }
}
