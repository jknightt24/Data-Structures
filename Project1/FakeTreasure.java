import java.util.Scanner;
import java.util.Random;
public class FakeTreasure extends Trap
{
    public FakeTreasure()
    {
        super("Fake Treasure Chest");
    }

    @Override
    public void Interact(Player player)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("You have found a treasure chest. Do you want to open it? (yes/no)");
        String choice = input.nextLine();

        if(choice.equals("yes"))
        {
            Random rand = new Random();
            int damage = rand.nextInt(5) + 1;
            System.out.println("You have triggered a trap. You have taken " + damage + " damage.");
            player.setHp(player.getHp() - damage);
            System.out.println("Your health is now " + player.getHp() + ".");
        }
        else if(choice.equals("no"))
        {
            System.out.println("You have chosen not to open the chest. and moved on.");
        }
        
        input.close();
    }
}
