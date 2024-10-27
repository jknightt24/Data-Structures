public abstract class Trap implements InteractableObject
{
    private String trapName;

    public Trap(String inputTrapName)
    {
        trapName = inputTrapName;
    }

    public void Interact(Player player)
    {
        if(this instanceof FakeTreasure)
        {
            this.Interact(player);
        }
        else if(this instanceof RiddleDoor)
        {
            this.Interact(player);
        }
    }
}
