
import javax.swing.JOptionPane;

public class QueueLab 
{
    private CheckoutCounter counter;
    private int maxTime;
    private int maxItems;

    public void enterData()
    {
        int numSuper = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of items for the Superexpress line"));
        int numExp = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of items for the Express lines"));
        int numStandLines = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of standard lines"));
        int arrivalRate = Integer.parseInt(JOptionPane.showInputDialog("Enter the arrival rate"));
        counter = new CheckoutCounter(numSuper, numExp, numStandLines, arrivalRate);

        maxItems = Integer.parseInt(JOptionPane.showInputDialog("Enter the maximum number of items a customer can have"));
        maxTime = Integer.parseInt(JOptionPane.showInputDialog("Enter the maximum simulation time"));
    }   

    public void runSimulation()
    {
        double time = 0;
        while(time < maxTime)
        {
            counter.checkNewCustomer(time, (int)(Math.random() * maxItems) + 1);
            time++;
        }
    }

    public void printResults()
    {
        System.out.println("The average wait time for the Superexpress line is " + counter.getSuperexpress().getTotalWait() / counter.getSuperexpress().getNumServed());
        System.out.println("The average wait time for the Express 1 line is " + counter.getExpress1().getTotalWait() / counter.getExpress1().getNumServed());
        System.out.println("The average wait time for the Express 2 line is " + counter.getExpress2().getTotalWait() / counter.getExpress2().getNumServed());
        for(int i = 0; i < counter.getNumStandLines(); i++)
        {
            if(counter.getStand(i).getNumCustomers() > 0)
            {
                System.out.println("The average wait time for all customers in the Standard " + i + " line is " + counter.getStand(i).getTotalWait() / counter.getStand(i).getNumCustomers());
            }
            else
            {
                System.out.println("There were no customers in the Standard " + i + " line");
            }
        }
        System.out.println("The Overall average wait time is " + (counter.getSuperexpress().getTotalWait() + counter.getExpress1().getTotalWait() + counter.getExpress2().getTotalWait() + counter.getStandTotalWait()) / counter.getTotalCustomers());

        System.out.println("The maximum length of the Superexpress line was " + counter.getSuperexpress().getMaxCustomers());
        System.out.println("The maximum length of the Express 1 line was " + counter.getExpress1().getMaxCustomers());
        System.out.println("The maximum length of the Express 2 line was " + counter.getExpress2().getMaxCustomers());
        for(int i = 0; i < counter.getNumStandLines(); i++)
        {
            System.out.println("The maximum length of the Standard " + i + " line was " + counter.getStand(i).getMaxCustomers());
        }

        System.out.println("The number of customers per hour in the Superexpress line was " + counter.getSuperexpress().getNumServed() / (maxTime / 60));
        System.out.println("The number of customers per hour in the Express 1 line was " + counter.getExpress1().getNumServed() / (maxTime / 60));
        System.out.println("The number of customers per hour in the Express 2 line was " + counter.getExpress2().getNumServed() / (maxTime / 60));
        for(int i = 0; i < counter.getNumStandLines(); i++)
        {
            System.out.println("The number of customers per hour in the Standard " + i + " line was " + counter.getStand(i).getNumServed() / (maxTime / 60));
        }

        System.out.println("The number of items per hour in the Superexpress line was " + counter.getSuperexpress().getItemsProcessed() / (maxTime / 60));
        System.out.println("The number of items per hour in the Express 1 line was " + counter.getExpress1().getItemsProcessed() / (maxTime / 60));
        System.out.println("The number of items per hour in the Express 2 line was " + counter.getExpress2().getItemsProcessed() / (maxTime / 60));
        for(int i = 0; i < counter.getNumStandLines(); i++)
        {
            System.out.println("The number of items per hour in the Standard " + i + " line was " + counter.getStand(i).getItemsProcessed() / (maxTime / 60));
        }
        System.out.println("The total number of items processed was " + (counter.getSuperexpress().getItemsProcessed() + counter.getExpress1().getItemsProcessed() + counter.getExpress2().getItemsProcessed() + counter.getStandTotalItems()));

        System.out.println("The average free time for the Superexpress line was " + (maxTime - counter.getSuperexpress().overallWait()));
        System.out.println("The average free time for the Express 1 line was " + (maxTime - counter.getExpress1().overallWait()));
        System.out.println("The average free time for the Express 2 line was " + (maxTime - counter.getExpress2().overallWait()));
        for(int i = 0; i < counter.getNumStandLines(); i++)
        {
            if((maxTime - counter.getStand(i).overallWait()) < 0)
            {
                System.out.println("The average free time for the Standard " + i + " line was 0");
            }
            else
            {
                System.out.println("The average free time for the Standard " + i + " line was " + (maxTime - counter.getStand(i).overallWait()));
            }
        }
        System.out.println("The total free time was " + (maxTime * counter.getTotalCustomers() - counter.getSuperexpress().overallWait() - counter.getExpress1().overallWait() - counter.getExpress2().overallWait() - counter.getStandTotalWait()));
    }
    
}