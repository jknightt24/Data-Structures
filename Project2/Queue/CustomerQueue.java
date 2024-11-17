
import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueue
{
    /**The queue containg all the passengers */
    private Queue<Customer> queue;
    /**The name of the queue */
    private String queueName;
    /**The total wait time of all passengers */
    private int totalWait;
    /**The arrival rate of customers per hour */
    private int arrivalRate;
    /**The number of passengers served */
    private int numServed;
    /**Number of total items allowed in line */
    private int allowedItems;
    /**Number of customers currently in line */
    private int numCustomers;
    /** The maximum number of customers that were in the line */
    private int maxCustomers;
    /**Number of items processed from the customer */
    private int itemsProcessed;

    /**Constructor for CustomerQueue
     * @param queueName
     * @param allowedItems
     */
    public CustomerQueue(String queueName, int allowedItems)
    {
        queue = new LinkedList<Customer>();
        this.queueName = queueName;
        this.allowedItems = allowedItems;
        this.maxCustomers = 0;
        totalWait = 0;
        arrivalRate = 0;
    }

    /**Adds a customer to the queue designated
     * @param c
     */
    public void addCustomer(Customer c)
    {
        queue.add(c);
        System.out.println("Customer with " + c.getItems() + " items has entered the " + queueName + " line at time " + c.getArrivalTime());
        numCustomers++;
        if(numCustomers > maxCustomers)
        {
            maxCustomers = numCustomers;
        }
    }

    public Customer removeCustomer()
    {
        Customer c = queue.remove();
        System.out.println("Customer with " + c.getItems() + " items has left the " + queueName + " line at time " + c.getArrivalTime());
        itemsProcessed += c.getItems();
        numCustomers--;
        return c;
    }

    /**
     * Updates the queue by checking if the customer is done and the line is not empty
     * @param currentTime
     */
    public void updateQueue(double currentTime)
    {
        if(!queue.isEmpty())
        {
            Customer c = queue.peek();
            if(c.isDone(currentTime))
            {
                totalWait += currentTime - c.getArrivalTime();
                numServed++;
                removeCustomer();
            }
        }
    }

    public boolean isEmpty()
    {
        return queue.isEmpty();
    }

    public int getNumServed()
    {
        return numServed;
    }

    public void setNumServed(int numServed)
    {
        this.numServed = numServed;
    }

    public double getTotalWait()
    {
        return totalWait;
    }

    public void averageWait()
    {
        System.out.println("The average wait time for the " + queueName + " line is " + totalWait / numServed);
    }

    public int overallWait()
    {
        return totalWait;
    }

    public int getNumCustomers()
    {
        return numCustomers;
    }

    public int getMaxCustomers()
    {
        return maxCustomers;
    }
    
    public int customersPerHour()
    {
        return numServed;
    }

    public int getItemsProcessed()
    {
        return itemsProcessed;
    }
}
