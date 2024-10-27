

public class JaylenDeckTester
{
    public static void main(String[] args) 
    {
        JaylenDeck deck = new JaylenDeck();

        deck.push("1");
        deck.push("2");
        deck.push("3");

        deck.contains("1");

        System.out.println(deck);
    }
}