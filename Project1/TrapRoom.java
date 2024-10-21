public class TrapRoom implements RoomBehavior, InteractableObject
{
    public void onEnter()
    {
        System.out.println("You have entered the trap room.");
    }
    
    public void Interact()
    {
        System.out.println("You have triggered a trap.");
    }

    public String getRoomName()
    {
        return "Trap Room";
    }

    @Override
    public boolean isMonsterRoom()
    {
        return false;
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
        return true;
    }
}
