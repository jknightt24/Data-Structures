/**
 * FakeTreasure is a subclass of Trap. It is a trap that is disguised as a treasure chest. 
 * When the player interacts with it, the player is asked if they want to open the chest. 
 * If the player chooses to open the chest, they will recieve damage.
 */
public class FakeTreasure extends Trap
{
    public FakeTreasure()
    {
        super("Fake Treasure Chest");
    }

    @Override
    public void Interact(Player player)
    {
        System.out.println("You have found a treasure chest. Do you want to open it? (yes/no)");
    }
}
