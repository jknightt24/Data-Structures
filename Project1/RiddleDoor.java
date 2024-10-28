
public class RiddleDoor extends Trap
{
    
    public RiddleDoor()
    {
        super("RiddleDoor");
    }

    @Override
    public void Interact(Player player)
    {
        System.out.println("You have found a Riddle Door! You have to solve a riddle to pass through the door.");
        System.out.println("What has keys but can't open locks?");
        System.out.println("Type your answer: ");
    }
}
