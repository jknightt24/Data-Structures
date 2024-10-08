/**
 * Author: Jaylen Knight
 * 
 * Version: 1.0
 */
public abstract class Pokemon implements CompareTo
{
    private int hp;
    private int atk;
    private int def;
    private int Spatk;
    private int Spdef;
    private int Speed;
    private String Name;
    private int resultLife;

    public Pokemon(int userHp, int useratk, int userdef, int userSpatk, int userSpdef, int userSpeed, String userName)
    {
        hp = userHp;
        atk = useratk;
        def = userdef;
        Spatk = userSpatk;
        Spdef = userSpdef;
        Speed = userSpeed;
        Name = userName;
    }
   
    public int getHp()
    {
        return hp;
    }

    public int getAtk()
    {
        return atk;
    }

    public int getDef()
    {
        return def;
    }

    public int getSpatk()
    {
        return Spatk;
    }

    public int getSpdef()
    {
        return Spdef;
    }

    public int getSpeed()
    {
        return Speed;
    }

    public int setHp(int hp)
    {
        return this.hp;
    }

    public String getName()
    {
        return Name;
    } 

    public int setSpeed()
    {
        return this.Speed;
    }

    public String setName(String Name)
    {
        return this.Name;
    }


    //
    public void DamageCalcAtk(Pokemon someRandomPokemon)
    {
        resultLife = someRandomPokemon.getHp() - (this.getAtk() - someRandomPokemon.getDef());
        if(resultLife < 0)
        {
            resultLife = 0;
        }
        someRandomPokemon.hp = resultLife;

       if(someRandomPokemon.getHp() < 0)
       {
            someRandomPokemon.setHp(0);
       }
    }

    public void DamageCalcSpAtk(Pokemon someRandomPokemon)
    {
        resultLife = someRandomPokemon.getHp() - (this.getSpatk() - someRandomPokemon.getSpdef());
        if(resultLife < 0)
        {
            resultLife = 0;
        }
       someRandomPokemon.hp = resultLife;

       if(someRandomPokemon.getHp() < 0)
       {
            someRandomPokemon.setHp(0);
       }
    }
    /* 
    @Override
    public int CompareSpeed(Pokemon someRandomPokemon) 
    {
       if(someRandomPokemon.getSpeed() > this.getSpeed())
       {
            System.out.println("this pokemon is faster than you");
            return -1;
       }
       else if(someRandomPokemon.getSpeed() > this.getSpeed())
       {
            System.out.println("you are faster than this pokemon");
            return 0;
       }
       else
       {
            System.out.println("You are both tied in speed");
            return 1;
        }   
    }
        */

    @Override
    public boolean equals(Object obj)
    {
        Pokemon temp = (Pokemon) obj;
        if(this.getAtk() == temp.getAtk() && this.getHp() == temp.getHp()) //should put in all variables
        {
            return true;
        }
        return false;
    }
    // Ideally how CompareTO is written
    @Override
    public int CompareTo(Object obj)
    {
        Pokemon temp;

        if(obj instanceof Pokemon)
        {
            temp = (Pokemon) obj;
        }
        else
        {
            return -10000;
        }
        if(this.getSpeed() > temp.getSpeed())
        {
            return 1;
        }
        else if(this.getSpeed() == temp.getSpeed())
        {
            return 0;
        }
        return 0;
    }


    /*
    public Pokemon randomPokemon(Pokemon someRandomPokemon) 
    {
        int random = (int)(Math.random() * 4);
        if(random == 0)
        {
            return new Pikachu();
        }
        else if(random == 1)
        {
            return new Charizard();
        }
        else if(random == 2)
        {
            return new Lucario();
        }
        else
        {
            return new UltraNecrozma();
        }      
    }
        */
}
