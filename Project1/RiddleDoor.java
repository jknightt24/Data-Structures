import java.util.Scanner;
public class RiddleDoor extends Trap
{
    int tries = 0;
    public RiddleDoor()
    {
        super("RiddleDoor");
    }

    @Override
    public void Interact(Player player)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("You have found a Riddle Door! You have to solve a riddle to pass through the door.");
        System.out.println("What has keys but can't open locks?");
        System.out.println("Type your answer: ");

        String answer = input.nextLine();

        while(!answer.equalsIgnoreCase("keyboard") || tries < 3)
        {
            if(answer.equalsIgnoreCase("keyboard") || answer.equalsIgnoreCase("piano"))
            {
                System.out.println("You have solved the riddle! You may pass through the door.");
                break;
            }
            else if(tries == 3)
            {
                System.out.println("I feel kinda bad for you, so I'll let you pass through the door.");
                break;
            }
            else
            {
                System.out.println("You have answered incorrectly! You have taken 5 damage.");
                player.setHp(player.getHp() - 5);
                System.out.println("Your health is now " + player.getHp() + ".");
                tries++;

                System.out.println("What has keys but can't open locks?");
                System.out.println("Type your answer: ");
                answer = input.nextLine();
            }
        }

        input.close();
    }
}
