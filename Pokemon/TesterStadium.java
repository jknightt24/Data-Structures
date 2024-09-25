
public class TesterStadium
{
    public static void main(String[] args)
    {

        Pikachu bob  = new Pikachu();
        Charizard jimmy = new Charizard();
        Lucario Steve = new Lucario();
        UltraNecrozma GodIncarnate = new UltraNecrozma();

        System.out.println("Battle music initilized");
        System.out.println("Pikachu vs Charizard vs Lucario vs Ultra Necrozma");

        System.out.println("Pikachu's HP: " + bob.getHp());
        System.out.println("Charizard's HP: " + jimmy.getHp());
        System.out.println("Lucario's HP: " + Steve.getHp());
        System.out.println("Ultra Necrozma's HP: " + GodIncarnate.getHp()); 

        bob.CompareTo(GodIncarnate);
        
       
        while(bob.getHp() > 0 || jimmy.getHp() > 0 || Steve.getHp() > 0 || GodIncarnate.getHp() > 0)
        {
            if(bob.getHp() <= 0)
            {
                System.out.println("Pikachu has fainted");
                break;
            }

            if(jimmy.getHp() <= 0)
            {
                System.out.println("Charizard has fainted");
                break;
            }

            if(Steve.getHp() <= 0)
            {
                System.out.println("Lucario has fainted");
                break;
            }

            if(GodIncarnate.getHp() <= 0)
            {
                System.out.println("Ultra Necrozma has fainted");
                break;
            }

            int random = (int)(Math.random() * 4);
            if(random == 0)
            {
                bob.Thunderbolt(jimmy);
                System.out.println("Pikachu used Thunderbolt on Charizard");
                System.out.println("Charizard's HP: " + jimmy.getHp());
            }
            else if(random == 1)
            {
                jimmy.FlameThrower(Steve);
                System.out.println("Charizard used Flamethrower on Lucario");
                System.out.println("Lucario's HP: " + Steve.getHp());
            }
            else if(random == 2)
            {
                Steve.CloseCombat(GodIncarnate);
                System.out.println("Lucario used Close Combat on Ultra Necrozma");
                System.out.println("Ultra Necrozma's HP: " + GodIncarnate.getHp());
            }
            else
            {
                GodIncarnate.PsychoCut(bob);
                System.out.println("Ultra Necrozma used Psycho Cut on Pikachu");
                System.out.println("Pikachu's HP: " + bob.getHp());
            }
        }      
    }
}
