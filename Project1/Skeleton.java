public class Skeleton extends Monster
{
    public Skeleton()
    {
        super("Skeleton ", 3, 10, 0, 3);
    }

    @Override
    public void Interact(Player player)
    {
        System.out.println("You have encountered a skeleton!");
    }
}
