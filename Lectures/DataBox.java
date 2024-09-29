// trying to do something that might break
import java.util.Arrays;
public class DataBox
{
    public void test()
    {
        int[] test = new int[10];
        
        try
        {
            test[10] = 10;
        }
        catch(Exception e)
        {
            throw e;
        }
    }

   
}