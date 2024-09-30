public class TestJaylenUniversalBox 
{
    public static void main(String[] args)
    {
        JaylenUniversalBox<Integer> test1 = new JaylenUniversalBox<Integer>(777); // Can modify to accepts parameters
        JaylenUniversalBox<String> test2 = new JaylenUniversalBox<>("Hello World "); 

        System.out.println(test1.getT());
        System.out.println(test2.getT());
    }
}
