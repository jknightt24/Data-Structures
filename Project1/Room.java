
public class Room<E> extends JaylenDaisyChainConnector<E> implements InteractableObject
{
    E Room;
    Room<E> previousRoom;
    Room<E> nextRoom;
    RoomBehavior behavior;

    public Room(E room, RoomBehavior typeRoom)
    {
        this.Room = room;
        this.nextRoom = null;
        this.previousRoom = null;
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

    public Room<E> getPreviousRoom()
    {
        return previousRoom;
    }  

    public void setPreviousRoom(Room<E> previousRoom)
    {
        this.previousRoom = previousRoom;
    }

    public void enterRoom()
    {
        if(behavior != null)
        {
            behavior.onEnter();
        }
    }

    public void Interact(Player player)
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

    public boolean isEmptyRoom()
    {
        return behavior.isEmptyRoom();
    }


}
