public class ExitRoom implements RoomBehavior
{
    public void onEnter()
    {
        System.out.println("You have entered the exit room.");
    }

    public String getRoomName()
    {
        return "Exit Room";
    }

    public void Interact()
    {
        System.out.println("You have exited this floor of the dungeon ");
    }

    @Override
    public boolean isMonsterRoom()
    {
        return false;
    }

    @Override
    public boolean isExitRoom()
    {
        return true;
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
    
}
