public class Charizard extends Pokemon 
{
    public Charizard()
    {
        super(78, 84, 78, 109, 85, 100, "");
    }

    public void FireFang(Pokemon someRandomPokemon)
    {
        DamageCalcAtk(someRandomPokemon);
    }

    public void FlameThrower(Pokemon someRandomPokemon)
    {
        DamageCalcSpAtk(someRandomPokemon);
    }

    public void Slash(Pokemon someRandomPokemon)
    {
        DamageCalcAtk(someRandomPokemon);
    }

    public void InfernoSpin(Pokemon someRandomPokemon)
    {
        DamageCalcSpAtk(someRandomPokemon);
    }


}
