package SlotMachine;

import java.util.Random;

public class SlotMachine implements Iterator
{
    private int coins = 20;
    private int plays;
    private int size = 20;

    @Override
    public boolean hasNext() 
    {
        while(coins > 0)
        {
            return true;
        }

        return false;
    }

    @Override
    public int next() 
    {
        if(hasNext())
        {
            remove();
            size--;
        }

        return size;
    }

    @Override
    public void remove() 
    {
        coins = coins - 1;
        size--;
    }

    public void win()
    {
        coins = coins + 2;
        size += 2;
    }

    public void playSlots()
    {
        Random rng = new Random();

        while(hasNext())
        {
            if(rng.nextInt(100) > 80)
            {
                win();
            }
            else
            {
                remove();
            }
            //System.out.println(coins);
            plays++;
        }
        System.out.println(plays);
    }
    
}
