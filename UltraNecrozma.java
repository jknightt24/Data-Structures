public class UltraNecrozma extends Pokemon
{
    public UltraNecrozma()
    {
        super(97, 167, 97, 167, 97, 129, "");
    }

    public void PrismaticLaser(Pokemon someRandomPokemon)
    {
        DamageCalcSpAtk(someRandomPokemon);
    }

    public void PsychoCut(Pokemon someRandomPokemon)
    {
        DamageCalcAtk(someRandomPokemon);
    }

    public void MetalClaw(Pokemon someRandomPokemon)
    {
        DamageCalcAtk(someRandomPokemon);
    }

    public void NightSlash(Pokemon someRandomPokemon)
    {
        DamageCalcAtk(someRandomPokemon);
    }    
    
}
