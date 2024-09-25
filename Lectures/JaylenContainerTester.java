public class JaylenContainerTester 
{
    public static void main(String[] args)
    {
        JaylenContainer data = new JaylenContainer();   

        for(int i = 0; i < 11; i++)
        {
            data.addValue(i, 5);
        }

        data.toString();
    }
}
