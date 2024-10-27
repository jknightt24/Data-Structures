public class box<E> extends JaylenDaisyChainConnector<E>
{
    // stores value
    E box;
    // stores next box
    box<E> next;

    public box(E item)
    {
        this.box = item;
        this.next = null;
    }
    
    public box(E item, box<E> nextBox)
    {
        box = item;
        next = nextBox;
    }

    public box<E> getNextBox() 
    {
        return next;
    }

    public void setNextBox(box<E> box) 
    {
        next = box;
    }

    public E getChain() 
    {
        return box;
    }
}
