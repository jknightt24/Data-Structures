import java.util.Random;

public class JaylenContainerTester 
{
    public static void main(String[] args)
    {
        JaylenContainer<Integer> data = new JaylenContainer<Integer>();
        
        System.out.println(data);
        System.out.println(data.size());
        
        data.add(12, 5);
        
        System.out.println(data);
    }
}
