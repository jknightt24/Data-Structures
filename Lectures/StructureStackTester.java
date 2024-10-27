public class StructureStackTester extends JaylenDeck
{
    public static void main(String[] args) 
    {
        JaylenDeck data = new JaylenDeck();

        for(int i = 0; i < data.size; i++)
        {
            data.push("1");
        }

        data.pull();

        System.out.println(data);
    }
}
