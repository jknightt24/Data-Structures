
public class TreasureRoom implements RoomBehavior, InteractableObject
{

    @Override
    public void onEnter()
    {
        System.out.println("You have entered the treasure room.");
    }

    public void Interact(Player player)
    {
        System.out.println("You have found the treasure.");
    }

    @Override
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

    @Override
    public boolean isEmptyRoom()
    {
        return false;
    }
}
