import java.util.Random;

public class JaylenContainerTester 
{
    public static void main(String[] args)
    {
        JaylenContainer data = new JaylenContainer();   

        System.out.println(data.toString());
        System.out.println(data.Size());

        for(int i = 0; i <= data.Size() - 1; i++)
        {
            data.addValue(i, new Random().nextInt(100));
        }

        System.out.println(data.toString());
    }
}
