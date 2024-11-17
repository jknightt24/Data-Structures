import java.util.LinkedList;
import java.util.Queue;

public class Department 
{   
    private Queue<Executives> queue;

    private String departmentName;
    /**
     * Constructor for Department
     * @param departmentName
     */
    public Department(String departmentName)
    {
        this.departmentName = departmentName;
        this.queue = new LinkedList<Executives>();
    }
    /**
     * Method to add an executive to the default queue
     * @param e
     */
    public void addExecutive(Executives e)
    {
        queue.add(e);
        System.out.println("Executive " + e.getName() + " has entered the " + departmentName + " department");
    }

    /**
     * Method to remove an executive from the default queue
     * @param e
     * @param queue
     */
    public void removeExecutive(Executives e, Queue<Executives> queue)
    {
        queue.remove(e);
        System.out.println("Executive " + e.getName() + " has left the " + departmentName + " department");
    }

    public String getDepartmentName()
    {
        return departmentName;
    }

    /**
     * Method to get the executive from the queue
     * @param name
     * @param queue
     * @return
     */
    public Executives getExecutive(String name, Queue<Executives> queue)
    {
        for(Executives e : queue)
        {
            if(e.getName().equals(name))
            {
                return e;
            }
        }
        return null;
    }

    public Queue<Executives> getQueue()
    {
        return queue;
    }

    /**
     * Method to show the payroll of the executives
     * adds additional amount to base salary depending on the position of the executive in the queue
     */
    public void showPayroll()
    {
        int baseSalary = 40000;
        int additionalAmount = 5000;

        for (int i = 0; i < queue.size(); i++)
        {
            Executives e = ((LinkedList<Executives>) queue).get(i);
            int additionalPay = additionalAmount * (queue.size() - i - 1);
            e.updatePayroll(baseSalary + additionalPay);
        }
    }
}
