public class Zombie extends Monster
{
    public Zombie()
    {
        super("Zombie", 1 , 20 , 2 , 1);
    }

    /**
     * Interact method for the Zombie class
     * @param player The player object
     */
    @Override
    public void Interact(Player player)
    {
        System.out.println("You have encountered a zombie.");
    }
} 
