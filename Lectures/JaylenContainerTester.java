public class JaylenContainerTester 
{
    public static void main(String[] args)
    {
        int[] data = new int[10];   

        for(int i = 0; i < 11; i++)
        {
            data.addValue(i, i);
        }

        data.toString();
    }
}
