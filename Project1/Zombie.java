public class Zombie extends Monster
{
    public Zombie()
    {
        super("Zombie", 1 , 20 , 2 , 1);
    }

    @Override
    public void Interact()
    {
        System.out.println("You have encountered a zombie.");
    }
} 
