public class MaxHpPotion extends Treasure
{
    public MaxHpPotion()
    {
        super("MaxHpPotion");
    }  
    
    @Override
    public void Interact()
    {
        System.out.println("You have found a MaxHpPotion! You have gained 5 max health points. and heal 5 health points.");
    }
}
