
public class Customer 
{
    /**Amount of items the customer has at checkout */
    private int items;
    /**Maximum amount of items the customer can have at checkout */
    private int maxItems;
    /**Amount of time it takes to process the customer */
    private int processingTime;
    /**The time the customer arrives at the checkout */
    private double arrivalTime;

    public Customer(int items, double arrivalTime)
    {

        this.arrivalTime = arrivalTime;
        this.items = items;

        this.processingTime += this.items * 0.08;
    }

    public double getArrivalTime()
    {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    public int getItems()
    {
        return items;
    }

    public void setItems(int items)
    {
        this.items = items;
    }

    public int getMaxItems()
    {
        return maxItems;
    }

    public void setMaxItems(int maxItems)
    {
        this.maxItems = maxItems;
    }   

    public int getProcessingTime()
    {
        return processingTime;
    }

    public boolean isDone(double currentTime)
    {
        return (currentTime - arrivalTime) >= processingTime;
    }
}
