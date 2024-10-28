/**
 * exit room class that implements the room behavior interface
 * this is the final room of any floor
 * it is the room that the player must reach to exit the floor and proceed to the next
 */
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

    @Override
    public boolean isEmptyRoom()
    {
        return false;
    }
    
}
