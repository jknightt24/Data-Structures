
public abstract class Treasure implements InteractableObject
{
    private String treasureName;

    public Treasure(String inputTreasureName)
    {
        treasureName = inputTreasureName;
    }

    public void Interact(Player player)
    {
        System.out.println("You have found a " + treasureName + "!");

        if(this instanceof Potion)
        {
            this.Interact();
            player.setHp(player.getHp() + 10);
            if(player.getHp() > player.getMaxHp())
            {
                player.setHp(player.getMaxHp());
            }
        }
        else if(this instanceof MaxHpPotion)
        {
            this.Interact();
            player.setMaxHp(player.getMaxHp() + 5);
            player.setHp(player.getHp() + 5);
        }
    }

    public String getTreasureName()
    {
        return treasureName;
    }

    public void setTreasureName(String inputTreasureName)
    {
        treasureName = inputTreasureName;
    }
    
    
}
