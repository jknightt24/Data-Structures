public class JaylenUniversalBoxArray <T>
{
    private T[] somedata;
    private int size;

    public JaylenUniversalBoxArray()
    {
        somedata = (T[]) new Object[10];
        size = 0;
    }

    public T[] getData()
    {
        return somedata;
    }

    public String convert()
    {
        String result = "";
        for(int i = 0; i < size; i++)
        {
            result += somedata[i] + " ";
        }
        return result;
    }

    public void setData(T singleValue)
    {
        someData[size] = singleValue;
    }

    public void addData(T singleValue)
    {
        
    }
}
