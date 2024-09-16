public class Lucario extends Pokemon 
{
    public Lucario()
    {
        super(70, 110, 70, 115, 70, 90, "");
    }

    public void CloseCombat(Pokemon someRandomPokemon)
    {
        DamageCalcAtk(someRandomPokemon);
    }

    public void ForcePalm(Pokemon someRandomPokemon)
    {
        DamageCalcAtk(someRandomPokemon);
    }

    public void MetalClaw(Pokemon someRandomPokemon)
    {
        DamageCalcAtk(someRandomPokemon);
    }

    public void AuraSphere(Pokemon someRandomPokemon)
    {
        DamageCalcSpAtk(someRandomPokemon);
    }
}
