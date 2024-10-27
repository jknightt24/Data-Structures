import java.util.Random;

public abstract class Monster implements InteractableObject
{
    private String monsterName;
    private int attack;
    private int hp;
    private int defense;
    private int speed;
    private int resultLife;

    public Monster(String name, int enemyAttack, int enemyHp, int enemyDefense, int enemySpeed)
    {
        monsterName = name;
        attack = enemyAttack;
        hp = enemyHp;
        defense = enemyDefense;
        speed = enemySpeed;
    }  

    public String getMonsterName()
    {
        return monsterName;
    }

    public void setMonsterName(String inputName)
    {
        monsterName = inputName;
    }

    public int getAttack()
    {
        Random rng = new Random();
        int damage = rng.nextInt(attack / 2, attack);

        if(damage < 1)
        {
            return 1;
        }
        else
        {
            return damage;
        }

        
    }

    public void setAttack(int inputAttack)
    {
        attack = inputAttack;
    }

    public int getHp()
    {
        return hp;
    }

    public void setHp(int inputHp)
    {
        hp = inputHp;
    }

    public int getDef()
    {
        return defense;
    }

    public void setDef(int inputDef)
    {
        defense = inputDef;
    }

    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int inputSpeed)
    {
        speed = inputSpeed;
    }

    public void setFloorModifier(int floor)
    {
        attack = attack + (floor * 2);
        hp = hp + (floor * 2);
        defense = defense + (floor * 2);
        speed = speed + (floor * 2);
    }

    public void monsterBattleCalculation(Player player)
    {
        resultLife = player.getHp() - this.getAttack();

        if(resultLife < 0)
        {
            resultLife = 0;
        }

        player.setHp(resultLife);
    }

    public void Battle(Player player)
    {
        this.monsterBattleCalculation(player);

        System.out.println("The monster attacked you for " + this.getAttack() + " damage!");

        if(player.getHp() == 0)
        {
            System.out.println("You have been defeated by the monster.");
        }
        else
        {
            System.out.println("You have " + player.getHp() + " hp left.");
        }
    }

    public void monsterFirstBattle(Player player)
    {
        this.monsterBattleCalculation(player);
    }

    @Override
    public void Interact(Player player)
    {
        System.out.println("You have encountered a monster!");
    }

    
}
