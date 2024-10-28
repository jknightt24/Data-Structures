
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
