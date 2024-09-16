// 
public class Pokemon implements MoreSpeed
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

    @Override
    public int CompareSpeed(Pokemon someRandomPokemon) 
    {
       if(someRandomPokemon.getSpeed() > this.getSpeed())
       {
            return -1;
       }
       else if(someRandomPokemon.getSpeed() > this.getSpeed())
       {
            return 0;
       }
       else
       {
            return 1;
       }
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
