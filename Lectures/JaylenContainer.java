import java.util.Arrays;

public class JaylenContainer <T>
{
    int[] data = new int[10];
    int CurrentPosition;
    boolean containes;
    int numbers;

    public void BiggerArray()
    {
        data = Arrays.copyOf(data, data.length + 1);
    }

    public void addValue(int CurrentPosition, int value)
    {
        for(int i = CurrentPosition; i < data.length; i++)
        {
            if(data[i] == data[data.length - 1])
            {
                BiggerArray();
                data[i] = data[i + 1];
                break;
            }
            else
            {
            data[i] = data[i + 1];
            }
        }

        data[CurrentPosition] = value;
      
    }

    public void addFirst(int value)
    {
        BiggerArray();

        for(int i = 0; i < data.length - 1; i++)
        {
            data[i] = data[i + 1];
        }

        data[0] = value;
    }
   
    public void RemoveValue(int CurrentPosition)
    {
        data[CurrentPosition] = 0;

        for(int i = CurrentPosition; i < data.length; i++)
        {
            data[i] = data[i - 1];
        }
    }

    public void removeFirst()
    {
        data[0] = 0;
    }

    public void removeLast()
    {
        data[data.length - 1] = 0;
    }

    public void Clear()
    {
        for(int i = 0; i < data.length; i++)
        {
            data[i] = 0;
        }
    }

    public void replaceValue(int CurrentPosition, int value)
    {
        data[CurrentPosition] = value;
    }

    public void ClearValues()
    {
        for(int i = 0; i > data.length; i++)
        {
            data[i] = 0;
        }
    }

    public int getValue(int index)
    {
        return data[index];
    }

    public int Size()
    {
        int count = 0
        ;
        for(int i = 0; i <= data.length; i++)
        {
            count++;
        }
        return count;
    }

    @Override
    public String toString()
    {
        String result = "";
        for(int i = 0; i < data.length; i++)
        {
            result += data[i] + " ";
        }
        return result;
    }

    public boolean Containes(int value, boolean containes)
    {
        for(int i = 0; i < data.length; i++)
        {
            if(i == value)
            {
                containes = true;
                break;
            }
            else
            {
                containes = false;
            }
        }
        return containes;
    }
}
