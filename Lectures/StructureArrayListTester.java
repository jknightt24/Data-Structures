public class StructureArrayListTester extends JaylenContainer
{
    public static void main(String[] args) 
    {
        JaylenContainer data = new JaylenContainer();

        for(int i = 0; i < data.size(); i++)
        {
            data.addFirst(i);
        }

        data.removeFirst();

        System.out.println(data);
    }
}
