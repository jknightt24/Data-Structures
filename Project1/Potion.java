public class Potion extends Treasure
{
    public Potion()
    {
        super("Potion");
    }

    @Override
    public void Interact()
    {
        System.out.println("You have found a potion! You have gained 10 health points.");
    }    
}
