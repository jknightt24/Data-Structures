/**
 * Potion class that extends Treasure class. This class is used to create a potion object that can be interacted with by the player.
 * The potion object will increase the player's health by 10 points.
 */
public class Potion extends Treasure
{
    public Potion()
    {
        super("Potion");
    }

    @Override
    public void Interact(Player player)
    {
        System.out.println("You have found a potion! You have gained 10 health points.");
        
        player.setHp(player.getHp() + 10);
        if(player.getHp() > player.getMaxHp())
        {
            player.setHp(player.getMaxHp());
        }

        System.out.println("player hp: " + player.getHp());
    }
}
