
import java.util.Random;
import java.util.Scanner;
public class JaylenDungeon <E> extends JaylenDaisyChainConnector<E>
{
    public Player player = new Player();
    private Room<E> head = null;
    private Room<E> tail = null;
    private int floor = 1;
    private int location;
    private int roomType;
    private int randomContents;
    private Room<E>[] dungeonFloor = new Room[11];

    Random rng = new Random();
    int numRooms = rng.nextInt(5, 10);
    Room<E> dungeon;

    public JaylenDungeon() 
    {
        head = null;
        tail = null;   
        this.location = 0; 
    }

    public void setupFloor()
    {
        E room = null;
        RoomBehavior behavior;

        for(int i = 0; i < numRooms; i++)
        {            
            roomType = rng.nextInt(1, 100);
        
            if(roomType <= 35)
            {
                behavior = new TreasureRoom();
                dungeonFloor[i] = new Room<E>(room, behavior);
                
            }
            else if(roomType >= 36 && roomType <= 75)
            {
                behavior = new MonsterRoom();
                dungeonFloor[i] = new Room<E>(room, behavior);
            }
            else
            {
                behavior = new TrapRoom();
                dungeonFloor[i] = new Room<E>(room, behavior);
            }
        }

        behavior = new ExitRoom();
        dungeonFloor[numRooms] = new Room<E>(room, behavior);

        for(int i = 0; i < numRooms; i++)
        {
            if(i == 0)
            {
                head = dungeonFloor[i];
                tail = dungeonFloor[i];
            }
            else
            {
                tail.setNextRoom(dungeonFloor[i]);
                tail = dungeonFloor[i];
            }
        }
    }

    public void nextFloor()
    {
        if(location == numRooms)
        {
            floor++;
            location = 0;
        }
    }

    public void moveForward()
    {
        if(location < numRooms)
        {
            location++;
        }
        else
        {
            location = 0;
        }
    }

    public void moveBackward()
    {
        if(location > 0)
        {
            location--;
        }
        else
        {
            location = numRooms;
        }
    }

    public void enterDungeon()
    {
        Room<E> temp = head;

        while(temp != null)
        {
            temp.enterRoom();
            temp = temp.getNextRoom();
        }

        System.out.println("You have entered the dungeon.");
    }

    public void startExploring()
    {
        Scanner input = new Scanner(System.in);
        String choice;

        System.out.println("You are now exploring the dungeon.");
        System.out.println("You are currently on floor " + floor + " and in room " + location + " aka the starting room.");
        System.out.println("You can move forward or move backward.");
        System.out.println("Once you find the exit room, you can go to the next floor by typing exit.");
        System.out.println("type forward to move forward, type back to move backward ");
        System.out.println("You can also check your stats at anytime you are not dealing with a room by typing stats.");

        choice = input.nextLine();

        while(!choice.equals("exit"))
        {
            if(choice.equals("forward"))
            {
                moveForward();
                Interact();
            }
            else if(choice.equals("backward"))
            {
                moveBackward();
                Interact();
            }
            else if(choice.equals("stats"))
            {
                player.printStats();
            }
            else
            {
                System.out.println("Invalid choice. Please try again.");
            }

            System.out.println("You are now in room " + location + ".");
            
            if(location == numRooms)
            {
                System.out.println("You have found the exit room.");
                System.out.println("You can now go to the next floor.");
                System.out.println("Type exit to go to the next floor. or keep exploring this floor by typing forward or back.");
            }

            choice = input.nextLine();
        }

        System.out.println("You have exited this floor of the dungeon.");
        nextFloor();
        setupFloor();
        startExploring();
    }

    public void Interact()
    {
        RoomBehavior currentRoom = dungeonFloor[location].getBehavior();
        RoomBehavior emptyRoom = new EmptyRoom();

        if(currentRoom != null)
        {
            currentRoom = dungeonFloor[location].getBehavior();
        }
        else
        {
            location++;
            currentRoom = dungeonFloor[location].getBehavior();
        }
        
        Scanner input = new Scanner(System.in);


        if(currentRoom.isTreasureRoom())
        {
            System.out.println("You have found a treasure. ");
            Treasure treasure = generateRandomTreasure(); 

            System.out.println("Would you like to take the treasure? Type yes to take the treasure or no to leave it.");

            if(input.nextLine().equals("yes"))
            {
                treasure.Interact(player);
                dungeonFloor[location].setBehavior(emptyRoom);
            }
            else if(input.nextLine().equals("no"))
            {
                System.out.println("You have chosen to leave the treasure.");
            }   
        }
        else if(currentRoom.isMonsterRoom())
        {
            Monster monster = generateRandomMonster(floor);
            monster.Interact(player);

            System.out.println("Would you like to fight the " + monster.getMonsterName() + "?" + " Type fight to fight or run to run back to the previous room.");
            System.out.println("Be aware that running away will cause you to recieve 1 hit worth of damage from the " + monster.getMonsterName() + ".");

            if(input.nextLine().equals("fight"))
            {
                player.Battle(monster);
                dungeonFloor[location].setBehavior(emptyRoom);
            }
            else if(input.nextLine().equals("run"))
            {
                System.out.println("You have chosen to run away.");

                monster.monsterBattleCalculation(player);
                moveBackward();
            }
        }
        else if(currentRoom.isTrapRoom())
        {
            TrapRoom trap = new TrapRoom();
            trap.Interact(player);
        }
        else
        {
            System.out.println("You have entered an empty room.");
        }

        input.close();
    }

    
    /** 
     * @return Treasure
     */
    public Treasure generateRandomTreasure()
    {
        randomContents = rng.nextInt(1, 3);
        if(randomContents == 1)
        {
            return new Potion();
        }
        else if(randomContents == 2)
        {
            return new ShinySword();
        }
        else
        {
            return new MaxHpPotion();
        }

        
    }

    public Monster generateRandomMonster(int floor)
    {
        randomContents = rng.nextInt(1, 2);
        if(randomContents == 0)
        {
            return new Skeleton();
        }
        else
        {
            return new Zombie();
        }
    }

    @Override
    public String toString()
    {
        Room<E> temp;

        temp = head;
        while(temp != null)
        {
            System.out.println(temp.getRoomName());
            temp = temp.getNextRoom();
        }

        return "";
    }

}
