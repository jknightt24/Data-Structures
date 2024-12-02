import java.util.Random;
public class JaylenSimpleHashTester 
{
    public static void main(String[] args)
    {
        JaylenSimpleHash hash = new JaylenSimpleHash();
        hash.hashSize();

        hash.add("Hello", hash.simpleHash);
        hash.add("World", hash.simpleHash);
        hash.add("Java", hash.simpleHash);
        hash.remove("World", hash.simpleHash);
        

        for(int i = 0; i < 100; i++)
        {
            Random rand = new Random();
            int n = rand.nextInt(100);
            hash.add(hash.dumbHashInt(n), hash.simpleHash);
        }

        hash.print(hash.simpleHash);
    }
}
