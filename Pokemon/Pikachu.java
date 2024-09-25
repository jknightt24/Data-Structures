public class Pikachu extends Pokemon
{
    
    public Pikachu()
    {
        super(75, 55, 30, 50, 40, 90, "");
    }

    public void Thunderbolt(Pokemon someRandomPokemon)
    {
       DamageCalcSpAtk(someRandomPokemon);
       
    }

    public void Spark(Pokemon someRandomPokemon)
    {
        DamageCalcAtk(someRandomPokemon);
    }

    public void ElectroBall(Pokemon someRandomPokemon)
    {
        DamageCalcSpAtk(someRandomPokemon);
    }

    public void IronTail(Pokemon someRandomPokemon)
    {
        DamageCalcAtk(someRandomPokemon);
    }

   /*  @Override
    public String toString()
    {
        return ("Pikachu " + getHp() + " " + getAtk());
    }
        */
}
