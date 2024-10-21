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

        return rng.nextInt(attack / 2, attack);
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

    public void monsterBattleCalculation(Player player)
    {
        resultLife = player.getHp() - this.getAttack();

        if(resultLife < 0)
        {
            resultLife = 0;
        }

        player.setHp(resultLife);
    }

    public void monsterFirstBattle(Player player)
    {
        this.monsterBattleCalculation(player);
    }

    public void Interact()
    {
        System.out.println("You have encountered a monster!");
    }

    
}
