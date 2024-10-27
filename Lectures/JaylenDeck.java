
public class JaylenDeck
{
    JaylenDaisyChainConnector<String> deck = new JaylenDaisyChainConnector<String>();
    int size = 0;
    

    public String peek()
    {
        if(deck.removeEnd() == null)
        {
            return "The deck is empty";
        }
        else
        {
            return deck.removeEnd();
        }
    }

    public void pop()
    {
        System.out.println(deck.removeEnd());
    }

    public void push(String card)
    {
        if(deck.isEmpty())
        {
            deck.addFront(card);
        }
    }

    public void isEmpty()
    {
        if(deck.removeEnd() == null)
        {
            System.out.println("The deck is empty");
        }
        else
        {
            System.out.println("The deck is not empty");
        }
    }

    public String pull()
    {
        return deck.removeEnd();
    }

    public void contains(String card)
    {
        deck.contains(card);
    }

    @Override
    public String toString()
    {
        String[] temp = new String[deck.size()];

        for(int i = 0; i < deck.size(); i++)
        {
            temp[i] = deck.removeEnd();

            System.out.println(temp[i]);
        }

        return "";
    }
}
