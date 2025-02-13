public class JaylenContainer <T>
{
    private T type;
    private int[] data = new int[10];
    private int size;

    public T getType()
    {
        return type;
    }

    public void setType(T type)
    {
        this.type = type;
    }
    
    public void biggerArray()
    {
        int[] temp = new int[data.length * 2];

        for(int i = 0; i < data.length; i++)
        {
            temp[i] = data[i];
        }

        data = temp;
    }

    
    public void add(Integer currentPosition, T value)
    {
        size = data.length;

        while(currentPosition > data[data.length - 1] && size < currentPosition)
        {
            biggerArray();
            size = data.length;
        }
        
        for(int i = currentPosition; i < size - 1; i++)
        {
            data[i] = data[i + 1];
        }
        
        data[currentPosition] = value;
    }

    public void addFirst(T value)
    {
        biggerArray();

        for(int i = 0; i < data.length - 1; i++)
        {
            data[i] = data[i + 1];
        }

        data[0] = value;
    }
   
    public void removeValue(int CurrentPosition)
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

    public void clear()
    {
        for(int i = 0; i < data.length; i++)
        {
            data[i] = 0;
        }
    }

    public void replaceValue(int currentPosition, T value)
    {
        data[currentPosition] = value;
    }

    public void clearValues()
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

    public int size()
    {
        int count = 0;
        
        for(int i = 0; i <= data.length; i++)
        {
            count++;
        }
        
        return count;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("");

        for(int i = 0; i < data.length - 1; i++)
        {
            sb.append(data[i] + " ");
        }

        return sb.toString();
    }

    public boolean containes(T value, boolean containes)
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
