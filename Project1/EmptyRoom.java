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
