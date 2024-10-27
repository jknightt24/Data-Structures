import java.util.ArrayList;

public class JaylenDaisyChainConnector <E>
{
    private box<E> head = null;
    private box<E> tail = null;
    private box<E>[] daisyChain = new box[10];
    private int size = 0;

    public void daisyChain()
    {
        this.head = null;
    }

    public void JaylenDaisyChain()
    {
        head = null;
        tail = null;
    }

    public void add(E box)
    {
        box<E> temp = new box<>(box);

        if(this.head == null)
        {
            head = temp;
        }
        else
        {
            box<E> X = head;

            while(X.getNextBox() != null)
            {
                X = X.getNextBox();
            }

            X.setNextBox(temp);
        }

        size++;
    }

    public void addFront(E box)
    {
        head = new box<E>(box, head);

        if(tail == null)
        {
            tail = head;
        }

        size++; 
    }

    public void addEnd(E box)
    {
        size++;

        box<E> temp = new box<>(box);

        if(head == null)
        {
            head = temp;
        }
        else
        {
            tail.setNextBox(temp);
        }
    }

    private void addAfter(E box, box<E> boxafter)
    {
        box<E> temp = new box<>(box, boxafter.getNextBox());

        boxafter.setNextBox(temp);

        size++; 
    }

    public void addatIndex(E box, int index)
    {
        if(index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("out of bounds of this list");
        }

        if(index == 0)
        {
            addFront(box);
        }
        else if(index == size)
        {
            addEnd(box);
        }
        else
        {
            box<E> temp = head;

            for(int i = 1; i < index; i++)
            {
                temp = temp.getNextBox();
            }

            addAfter(box, temp.getNextBox());
        }
    }

    public E removeFirst()
    {
        box<E> temp;
        
        temp = head;

        if(head != null)
        {
            head = head.getNextBox();
        }
        
        return (E) temp.getChain();
    }

    public E removeEnd()
    {
        box<E> temp = head;
        box<E> temp2 = null;

        //iterates to last box and makes temp2 second to last box
        while(temp.getNextBox() != null)
        {
            temp2 = temp;
            temp = temp.getNextBox();
        }
        
        //makes the second to last box the last box
        if(temp2 != null)
        {
            temp2.setNextBox(null);
        }
        else
        {
            head = null;
        }

        return (E) temp.getChain();
    }

    public E removeAtIndex(int index)
    {
        if(index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("out of bounds of this list");
        }

        box<E> temp = head;
        box<E> temp2 = null;
    
        //iterates to the box before the index
        for(int i = 0; i < index; i++)
        {
            temp2 = temp;
            temp = temp.getNextBox();
        }
        //removes the box at the index
        if(temp2 != null)
        {
            temp2.setNextBox(temp.getNextBox());
        }
        else
        {
            head = temp.getNextBox();
        }

        return (E) temp.getChain();
    }

    public E replace(E box, int index)
    {
        if(index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("out of bounds of this list");
        }

        box<E> temp = head;

        //iterates to the box at the index
        for(int i = 0; i < index; i++)
        {
            temp = temp.getNextBox();
        }

        temp.box = box;

        return (E) temp.getChain();
    }

    public E clear()
    {
        box<E> temp = head;
        head = null;
        size = 0;

        return (E) temp.getChain();
    }

    public boolean contains(E box)
    {
        box<E> temp = head;

        while(temp != null)
        {
            if(temp.getChain().equals(box))
            {
                return true;
            }

            temp = temp.getNextBox();
        }

        return false;
    }

    public void makeCircular()
    {
        tail.setNextBox(head);
    }

    public int size()
    {
        return size;
    }

    @Override
    public String toString()
    {
        box temp;

        temp = head;
        while(temp != null)
        {
            System.out.println(temp.getChain());
            temp = temp.getNextBox();
        }

        return "";
    }

}
