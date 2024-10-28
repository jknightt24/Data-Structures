/**
 * MaxHpPotion is a class that extends the Treasure class. 
 * It is a type of treasure that increases the player's max health by 5 and heals the player by 5 health points when interacted with.
 */
public class MaxHpPotion extends Treasure
{
    public MaxHpPotion()
    {
        super("MaxHpPotion");
    }  
    
    @Override
    public void Interact(Player player)
    {
        System.out.println("You have found a MaxHpPotion! You have gained 5 max health points. and heal 5 health points.");

        if(player.getHp() + 5 > player.getMaxHp())
        {
            player.setHp(player.getMaxHp());
        }
        else
        {
            player.setHp(player.getHp() + 5);
        }

        player.setMaxHp(player.getMaxHp() + 5);

        System.out.println("player current hp is: " + player.getHp());
        
    }
}
