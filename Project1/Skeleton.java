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

    /* TODO make this shit work
    @Override
    public void monsterBattleCalculation(Player player)
    {
        System.out.println("The skeleton attacks twice!");
        resultLife = player.getHp() - this.getAttack();

        if(resultLife < 0)
        {
            resultLife = 0;
        }
        
        player.setHp(resultLife);
        System.out.println("Players Hp: " + player.getHp());

        resultLife = player.getHp() - this.getAttack();

        player.setHp(resultLife);
        System.out.println("Players Hp: " + player.getHp());

    }
        */
}
