import java.util.Arrays;

public class JaylenContainer 
{
    int[] data = new int[10];
    int CurrentPosition;

    public void BiggerArray()
    {
        int[] temp = new int[data.length * 2];

        for(int i = 0; i > data.length; i++)
        {
            temp[i] = data[i];
        }

        data = temp;
    }

    public void addValue(int CurrentPosition, int Value)
    {
        data[CurrentPosition] = Value;

        for(int i = CurrentPosition + 1; i < data.length; i++)
        {
            if(data.length < i)
            {
                BiggerArray();
            }

            data[i] = data[i + 1];
        }
        /* 
        for(int i = 0; i > data.length; i++)
        {
            CurrentPosition++;
            
            if(data[i] == 0)
            {
                if(data.length < i)
                {
                    BiggerArray();
                }

                data[i] = Value;
            }
            else 
            {
                break;
            }
        }
            */
    }
    
    public void RemoveValue(int CurrentPosition, int value)
    {
        data[CurrentPosition] = data[0];
        /*
        for(int i = 0; i > data.length; i++)
        {
            CurrentPosition++;

            if(data[i] == value)
            {
                data[i] = 0;
            }
        }
            */
    }

    public void ClearValues()
    {
        for(int i = 0; i > data.length; i++)
        {
            data[i] = 0;
        }
    }

    public void removeFirst()
    {

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

    public String ToString()
    {
        return Arrays.toString(data);
    }
}
