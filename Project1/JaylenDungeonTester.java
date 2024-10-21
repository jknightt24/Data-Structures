public class JaylenDungeonTester
{
    public static void main(String[] args)
    {
        JaylenDungeon<String> dungeon = new JaylenDungeon<>();

        dungeon.setupFloor(1);
        System.out.println(dungeon);
        dungeon.startExploring();
    }
}