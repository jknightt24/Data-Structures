/**
 * Player class that contains the player's stats and battle calculations
 */
import java.util.Random;

public class Player
{
    private int attack;
    private int hp;
    private int maxHp;
    private int defense;
    private int speed;
    private int resultLife;

    public Player()
    {
        attack = 5;
        hp = 30;
        maxHp = 30;
        defense = 0;
        speed = 5;
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

    public void setDef(int inputDefense)
    {
        defense = inputDefense;
    }

    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int inputSpeed)
    {
        speed = inputSpeed;
    }

    public void setMaxHp(int inputMaxHp)
    {
        maxHp = inputMaxHp;
    }

    public int getMaxHp()
    {
        return maxHp;
    }

    public void printStats()
    {
        System.out.println("Player Stats: ");
        System.out.println("Attack: " + attack);
        System.out.println("HP: " + hp);
        System.out.println("Defense: " + defense);
        System.out.println("Speed: " + speed);
    }

    public void PlayerBattleCalculation(Monster monster)
    {
        resultLife = monster.getHp() - this.getAttack();
        
        if(resultLife < 0)
        {
            resultLife = 0;
        }

        monster.setHp(resultLife);
    }


    public void Battle(Monster monster)
    {
        if(this.getHp() > 0 && monster.getHp() > 0)
        {
            // Determines who's speed is faster and they start the loop of battle until the fight is over
            if(this.getSpeed() >= monster.getSpeed())
            {
                PlayerBattleCalculation(monster);

                System.out.println("Monster HP: " + monster.getHp());

                while(this.getHp() > 0 && monster.getHp() > 0)
                {
                    monster.monsterBattleCalculation(this);
                    System.out.println("Player hp: " + this.getHp());
                    PlayerBattleCalculation(monster);

                    System.out.println("Monster HP: " + monster.getHp());
                }
            }
            else
            {
                monster.monsterBattleCalculation(this);

                while(this.getHp() > 0 && monster.getHp() > 0)
                {
                    PlayerBattleCalculation(monster);
                    monster.monsterBattleCalculation(this);

                    System.out.println("Monster HP: " + monster.getHp());
                }
            }
        }
    }
}
