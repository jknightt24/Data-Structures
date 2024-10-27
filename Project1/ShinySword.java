public class ShinySword extends Treasure
{
    public ShinySword()
    {
        super("ShinySword");
    }

    @Override
    public void Interact(Player player)
    {
        System.out.println("You have found a Shiny new Sword! You have gained 5 attack points.");
        player.setAttack(player.getAttack() + 5);
    }
}
