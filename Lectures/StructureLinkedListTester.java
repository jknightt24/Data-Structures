
import java.util.LinkedList;
public class StructureLinkedListTester
{
    public static void main(String[] args) 
    {

        LinkedList<Integer> data = new LinkedList<Integer>();

        for(int i = 0; i < data.size(); i++)
        {
            data.add(i);
        }

        
        System.out.println(data);
    }
    
}
