/**
 * EmptyRoom is a class that implements the RoomBehavior interface and the InteractableObject interface.
 * It is a room that has no monsters, no treasure, no traps, and is not an exit.
 * Allows safe passage through the dungeon.
 */
public class EmptyRoom implements RoomBehavior, InteractableObject
{
    public void onEnter()
    {
        System.out.println("You have entered an empty room. its empty.");
    }

    public void Interact(Player player)
    {
        System.out.println("You have found nothing.");
    }

    @Override
    public String getRoomName()
    {
        return "Empty Room";
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
        return false;
    }

    @Override
    public boolean isEmptyRoom()
    {
        return true;
    }
}
