package SlotMachineObject;
import java.util.Random;
import java.util.ArrayList;

public class SlotMachine implements IteratorObject
{
    ArrayList<Coin> coins = new ArrayList<Coin>(20);
    private int plays;
    private int size = 0;


    @Override
    public boolean hasNext() 
    {
        while(size > 0)
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
        }

        return size;
    }

    @Override
    public void remove() 
    {
        coins.remove(size - 1);
        size--;
    }

    public void populateBag()
    {
        for(int i = 0; i < 20; i++)
        {
            coins.add(new Coin());
            size++;
        }
    }

    public void win()
    {
        coins.add(new Coin());
        coins.add(new Coin());
        size =+ 2;
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
                next();
            }
            plays++;
            System.out.println(size);
        }
        System.out.println(plays);
    }
    
}
