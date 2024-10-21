
public class TreasureRoom implements RoomBehavior, InteractableObject
{
    public void onEnter()
    {
        System.out.println("You have entered the treasure room.");
    }

    public void Interact()
    {
        System.out.println("You have found the treasure.");
    }

    public String getRoomName()
    {
        return "Treasure Room";
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
        return true;
    }

    @Override
    public boolean isTrapRoom()
    {
        return false;
    }
}
