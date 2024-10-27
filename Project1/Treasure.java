
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
            this.Interact(player);
            
        }
        else if(this instanceof MaxHpPotion)
        {
            this.Interact(player);
            
        }
        else if(this instanceof ShinySword)
        {
            this.Interact(player);
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
