
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
        this.location = 1; 
    }

    /**
     * Sets up the floor of the dungeon with random rooms connected to each other.
     */
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
                head = dungeonFloor[1];
                dungeonFloor[i].setNextRoom(dungeonFloor[i + 1]);
                tail = dungeonFloor[numRooms];
            }
            else if(i == numRooms - 1)
            {
                dungeonFloor[i].setNextRoom(dungeonFloor[1]);
                dungeonFloor[i].setPreviousRoom(dungeonFloor[i - 1]);
            }
            else
            {
                tail.setNextRoom(dungeonFloor[i]);
                dungeonFloor[i].setPreviousRoom(tail);
                tail = dungeonFloor[i];
            }
        }
    }

    /**
     * Moves the player to the next floor of the dungeon.
     */
    public void nextFloor()
    {
        if(location == numRooms)
        {
            floor++;
            location = 0;
        }
    }

    /**
     * Moves the player forward in the dungeon.
     */
    public void moveForward()
    {
        if(location < numRooms)
        {
            location++;
        }
        else
        {
            location = 1;
        }
    }

    /**
     * Moves the player backward in the dungeon.
     */
    public void moveBackward()
    {
        if(location > 1)
        {
            location--;
        }
        else
        {
            location = numRooms;
        }
    }

    /**
     * Starts of the constructed dungeon and allows the player to explore said dungeon.
     */
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
        

        while(!choice.equals("exit") && player.getHp() > 0)
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
                choice = input.nextLine();
            }

            System.out.println("You are now in room " + location + ".");
            showSurroundingRooms();
            
            if(location == numRooms)
            {
                System.out.println("You have found the exit room.");
                System.out.println("You can now go to the next floor.");
                System.out.println("Type exit to go to the next floor. or keep exploring this floor by typing forward or back.");
            }

            choice = input.nextLine();
        }

        if(player.getHp() == 0)
        {
            System.out.println("You have been defeated by the monsters in the dungeon.");
            System.out.println("You have failed to complete the dungeon.");
        }

        System.out.println("You have exited this floor of the dungeon.");
        nextFloor();
        setupFloor();
        startExploring();
        input.close();
    }

    /**
     * Causes the player to interact with the room they are currently in.
     * upon entering a room, the method will check if the room is a treasure room, monster room, trap room, or empty room.
     * if the room is anything but an empty room, this will generate a random interaction for the player to deal with
     * based on the type of room the player is currently in.
     */
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
            monster.setFloorModifier(floor);
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
            while(player.getHp() > 0)
            {
                Trap trap = generateRandomTrap();
                trap.Interact(player);

                if(trap instanceof FakeTreasure)
                {
                    if(input.nextLine().equals("yes"))
                    {
                        Random rand = new Random();
                        int damage = rand.nextInt(5) + 1;
                        System.out.println("You have triggered a trap. You have taken " + damage + " damage.");
                        player.setHp(player.getHp() - damage);
                        System.out.println("Your health is now " + player.getHp() + ".");

                        dungeonFloor[location].setBehavior(emptyRoom);
                    }
                    else if(input.nextLine().equals("no"))
                    {
                        System.out.println("You have chosen not to open the chest. and moved on.");

                        dungeonFloor[location].setBehavior(emptyRoom);
                    }
                }
                else if(trap instanceof RiddleDoor)
                {
                    int tries = 0;

                    while(!input.nextLine().equals("keyboard") || input.nextLine().equals("piano") || tries < 3)
                    {
                        if(input.nextLine().equals("keyboard") || input.nextLine().equals("piano"))
                        {
                            System.out.println("You have solved the riddle! You may pass through the door.");
                            dungeonFloor[location].setBehavior(emptyRoom);
                        }
                        else if(tries == 3)
                        {
                            System.out.println("I feel kinda bad for you, so I'll let you pass through the door.");
                            dungeonFloor[location].setBehavior(emptyRoom);
                        }
                        else
                        {
                            System.out.println("You have answered incorrectly! You have taken 5 damage.");
                            player.setHp(player.getHp() - 5);
                            System.out.println("Your health is now " + player.getHp() + ".");
                            tries++;

                            System.out.println("What has keys but can't open locks?");
                            System.out.println("Type your answer: ");
                            input.nextLine();
                        }
                    }
                }
            
            }
            input.close();
        }
        else
        {
            System.out.println("You have entered an empty room.");
        }
    }

    
    /** 
     * Generates a random treasure for the player to interact with.
     * @return a random treasure object for the player to interact with.
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

    /**
     * Generates a random monster for the player to interact with.
     * @param floor
     * @return a random monster object for the player to interact with.
     */
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

    /**
     * Generates a random trap for the player to interact with.
     * @return a random trap object for the player to interact with.
     */
    public Trap generateRandomTrap()
    {
        return new FakeTreasure();
    }

    /**
     * Shows the player the rooms surrounding the room they are currently in.
     */
    public void showSurroundingRooms()
    {
        if(dungeonFloor[location].getNextRoom() == null)
        {
            dungeonFloor[location].setNextRoom(dungeonFloor[location + 1]);
            System.out.println(dungeonFloor[location].getNextRoom().getRoomName() + " is the next room.");
        }
        else
        {
            System.out.println(dungeonFloor[location].getNextRoom().getRoomName() + " is the next room.");
        }
        if(dungeonFloor[location].getPreviousRoom() == null)
        {
            dungeonFloor[location].setPreviousRoom(dungeonFloor[location - 1]);
            System.out.println(dungeonFloor[location].getPreviousRoom().getRoomName() + " is the previous room.");
        }
        else
        {
            System.out.println(dungeonFloor[location].getPreviousRoom().getRoomName() + " is the previous room.");
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
