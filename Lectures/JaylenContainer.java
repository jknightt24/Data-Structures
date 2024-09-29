import java.util.Arrays;

public class JaylenContainer 
{
    int[] data = new int[10];
    int CurrentPosition;
    boolean containes;
    int numbers;

    public void BiggerArray()
    {
        data = Arrays.copyOf(data, data.length + 1);
    }

    

    public void addValue(int CurrentPosition, int Value)
    {
        if(data.length <= CurrentPosition)
        {
            BiggerArray();
            data[CurrentPosition] = Value;
        }
        else
        {
            data[CurrentPosition] = Value;
        }

        for(int i = CurrentPosition; i < data.length - 1; i++)
        {
            data[i] = data[i + 1];
        }
    }

    public void addFirst(int value)
    {
        data[0] = value;
        
        for(int i = 0; i < data.length; i++)
        {
            data[i] = data[i + 1];
        }
    }
   
    public void RemoveValue(int CurrentPosition)
    {
        data[CurrentPosition] = data[0];

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

    public int ContainerSize()
    {
        int count = 0;
        for(int i = 0; i > data.length; i++)
        {
            if(data[i] != 0)
            {
                count++;
            }
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
