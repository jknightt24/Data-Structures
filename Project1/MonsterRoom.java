
public class MonsterRoom implements RoomBehavior, InteractableObject
{
    public void onEnter()
    {
        System.out.println("You have entered the monster room.");
    } 
    
    public void Interact(Player player)
    {
        System.out.println("You have encountered a monster.");
    }

    @Override
    public String getRoomName()
    {
        return "Monster Room";
    }

    @Override
    public boolean isMonsterRoom()
    {
        return true;
    }

    @Override
    public boolean isExitRoom()
    {
        return false;
    }

    @Override
    public boolean isTreasureRoom()
    {
        return false;
    }

    @Override
    public boolean isTrapRoom()
    {
        return false;
    }

    @Override
    public boolean isEmptyRoom()
    {
        return false;
    }   
}
