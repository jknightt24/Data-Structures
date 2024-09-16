public class TestingObjectClass 
{
    public static void main(String[] args)
    {
        Pikachu pk = new Pikachu();
        // prints out the memory location of the object pk
        System.out.println(pk);
        System.out.println(pk.toString());

        double sum = 0;
        for(int i = 0; i < 10; i++)
        {
            sum = sum + .1;
            System.out.println(sum);
        }

        int result = 10000;
        System.out.println(result * result);
        // the code below reaches the number value limit
        int result2 = 100000;
        System.out.println(result * result);
    }
}
