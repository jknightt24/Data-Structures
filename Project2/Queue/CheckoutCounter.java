
public class CheckoutCounter 
{
    /**Queue with superexpress customers */
    private CustomerQueue superexpress;
    /**Queue with express customers */
    private CustomerQueue express1;
    /**Second queue with express customers */
    private CustomerQueue express2;
    /**Array of standard lines */
    private CustomerQueue[] stand = new CustomerQueue[10];
    /**Number of items allowed in the superexpress line*/ 
    private int numSuper;
    /**Number of items allowed in the express line */
    private int numExp;
    /**Number of standard lines */
    private int numStandLines;
    /**Average wait time for the line */
    private double avgWait;
    /**Average wait time for all lines */
    private double totalWait;
    /**Number of Customers per hour */
    private int arrivalRate;
    

    /**Constructor for CheckoutCounter which handles all lines
     * @param numSuper
     * @param numExp
     * @param numStandLines
     * @param arrivalRate
     */
    public CheckoutCounter(int numSuper, int numExp, int numStandLines, int arrivalRate)
    {
        superexpress = new CustomerQueue("Superexpress", numSuper);
        express1 = new CustomerQueue("Express 1", numExp);
        express2 = new CustomerQueue("Express 2", numExp);
        for(int i = 0; i < numStandLines; i++)
        {
            stand[i] = new CustomerQueue("Standard " + i, Integer.MAX_VALUE);
        }

        this.numSuper = numSuper;
        this.numExp = numExp;
        this.numStandLines = numStandLines;
        this.arrivalRate = arrivalRate;

        avgWait = 0;
        totalWait = 0;
    }

    

    /**Checks if a new customer arrives in line
     * @param time 
     */
    public void checkNewCustomer(double time, int items)
    {
        if(Math.random() < arrivalRate)
        {
            Customer c = new Customer(items, time);
            //Adds to the superexpress line if the customer has less than or equal to the number of items allowed
            if(c.getItems() <= numSuper)
            {
                superexpress.addCustomer(c);
                superexpress.updateQueue(time);
            }
            //Adds to the express line if the customer has less than or equal to the number of items allowed
            //Whichever express line has the least amount of customers is chosen
            else if(c.getItems() <= numExp)
            {
                if(express1.getNumCustomers() <= express2.getNumCustomers())
                {
                    express1.addCustomer(c);
                    express1.updateQueue(time);
                }
                else
                {
                    express2.addCustomer(c);
                    express2.updateQueue(time);
                }
            }
            else
            // Adds to the shortest standard line
            {
                int min = Integer.MAX_VALUE;
                int index = 0;
                for(int i = 0; i < numStandLines; i++)
                {
                    if(stand[i].getNumCustomers() < min)
                    {
                        min = stand[i].getNumCustomers();
                        index = i;
                    }
                }
                stand[index].addCustomer(c);
                stand[index].updateQueue(time);
            }
        }
    }

    /**Updates the line
     * @param time
     * @param queue
     */
    public void update(double time, CustomerQueue queue)
    {
        if(!queue.isEmpty())
        {
            Customer c = queue.removeCustomer();
            totalWait += time - c.getArrivalTime();
            avgWait = totalWait / queue.getNumServed();
        }
        
        for(int i = 0; i < numStandLines; i++)
        {
            if(!stand[i].isEmpty())
            {
                Customer c = stand[i].removeCustomer();
                totalWait += time - c.getArrivalTime();
                avgWait = totalWait / stand[i].getNumServed();
            }
        }
    }

    /**Gets the average wait time
     * @return avgWait
     */
    public double getAvgWait()
    {
        return avgWait;
    }

    /**Gets the superexpress line
     * @return superexpress
     */
    public CustomerQueue getSuperexpress()
    {
        return superexpress;
    }

    /**Gets the first express line
     * @return express1
     */
    public CustomerQueue getExpress1()
    {
        return express1;
    }

    /**Gets the second express line
     * @return express2
     */
    public CustomerQueue getExpress2()
    {
        return express2;
    }

    /**Gets the standard line at index i
     * @param i
     * @return stand[i]
     */
    public CustomerQueue getStand(int i)
    {
        return stand[i];
    }

    /**Gets the number of standard lines
     * @return numStandLines
     */
    public int getNumStandLines()
    {
        return numStandLines;
    }

    /**Gets the total wait time for all standard lines
     * @return totalWait
     */
    public double getStandTotalWait()
    {
        double total = 0;
        for(int i = 0; i < numStandLines; i++)
        {
            total += stand[i].getTotalWait();
        }
        return total;
    }

    /**Gets the total number of customers in the standard lines
     * @return total
     */
    public int getStandTotalCustomers()
    {
        int total = 0;
        for(int i = 0; i < numStandLines; i++)
        {
            total += stand[i].getNumServed();
        }
        return total;
    }

    /**Gets the total number of customers in all lines
     * @return total
     */
    public int getTotalCustomers()
    {
        return superexpress.getNumServed() + express1.getNumServed() + express2.getNumServed() + getStandTotalCustomers();
    }

    /**Gets the maximum number of customers any line had
     * @return total
     */
    public int getMaxCustomers()
    {
        int max = superexpress.getMaxCustomers();
        if(express1.getMaxCustomers() > max)
        {
            max = express1.getMaxCustomers();
        }
        if(express2.getMaxCustomers() > max)
        {
            max = express2.getMaxCustomers();
        }
        for(int i = 0; i < numStandLines; i++)
        {
            if(stand[i].getMaxCustomers() > max)
            {
                max = stand[i].getMaxCustomers();
            }
        }
        return max;
    }

    /**Gets the total number of items processed in the standard lines
     * @return total
     */
    public int getStandTotalItems()
    {
        int total = 0;
        for(int i = 0; i < numStandLines; i++)
        {
            total += stand[i].getItemsProcessed();
        }
        return total;
    }

}
