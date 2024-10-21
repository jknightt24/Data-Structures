
public class Room<E> extends JaylenDaisyChainConnector<E> implements InteractableObject
{
    E Room;
    Room<E> nextRoom;
    RoomBehavior behavior;

    public Room(E room, RoomBehavior typeRoom)
    {
        this.Room = room;
        this.nextRoom = null;
        this.behavior = typeRoom;
    }
    
    public E getRoom()
    {
        return Room;
    }

    public E getRoomName(Room<E> room)
    {
        return room.getRoom();
    }

    public Room<E> getNextRoom()
    {
        return nextRoom;
    }

    public void setNextRoom(Room<E> nextRoom)
    {
        this.nextRoom = nextRoom;
    }

    public void enterRoom()
    {
        if(behavior != null)
        {
            behavior.onEnter();
        }
    }

    public void Interact()
    {
        System.out.println("You have entered the dungeon.");
    }

    public String getRoomName()
    {
        return behavior.getRoomName();
    }

    public void setBehavior(RoomBehavior behavior)
    {
        this.behavior = behavior;
    }

    public RoomBehavior getBehavior()
    {
        return behavior;
    }

    public boolean isMonsterRoom()
    {
        return behavior.isMonsterRoom();
    }

    public boolean isExitRoom()
    {
        return behavior.isExitRoom();
    }

    public boolean isTreasureRoom()
    {
        return behavior.isTreasureRoom();
    }

    public boolean isTrapRoom()
    {
        return behavior.isTrapRoom();
    }

}
