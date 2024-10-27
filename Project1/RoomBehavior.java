public interface RoomBehavior 
{
    public void onEnter();

    public String getRoomName();

    public boolean isMonsterRoom();

    public boolean isExitRoom();

    public boolean isTreasureRoom();

    public boolean isTrapRoom();

    public boolean isEmptyRoom();
}
