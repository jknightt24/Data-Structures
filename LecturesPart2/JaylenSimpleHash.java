import java.util.LinkedList;
import java.util.Scanner;

public class JaylenSimpleHash
{
    LinkedList[] simpleHash;
    Scanner scan = new Scanner(System.in);
    
    public void hashSize()
    {
        System.out.println("Enter the size of the hash table: ");
        int size = scan.nextInt();
        simpleHash = new LinkedList[size];
    }

    public int dumbHash(String value)
    {
        if(value.length() == 0)
        {
            return 0;
        }
        else
        {
            return value.length();
        }
    }

    public String dumbHashInt(Integer value)
    {
        if(value.toString().length() == 0)
        {
            return "0";
        }
        else
        {
            return value.toString();
        }
    }

    public void add(String value, LinkedList[] simplehash)
    {
        int index = dumbHash(value);

        while(index > simplehash.length)
        {
            index = index % simplehash.length;
        }

        if(simplehash[index - 1] == null)
        {
            simplehash[index - 1] = new LinkedList();
            simplehash[index - 1].add(value);
        }
        else
        {
            simplehash[index - 1].add(value);
        }
    }

    public void remove(String value, LinkedList[] simplehash)
    {
        int index = dumbHash(value);

        while(index > simplehash.length)
        {
            index = index % simplehash.length;
        }

        if(simplehash[index - 1] == null)
        {
            System.out.println("The value does not exist in the hash table.");
        }
        else
        {
            simplehash[index - 1].remove(value);
        }
    }

    public void print(LinkedList[] simplehash)
    {
        for(int i = 0; i < simplehash.length; i++)
        {
            System.out.println(simplehash[i]);
        }
    }
}


