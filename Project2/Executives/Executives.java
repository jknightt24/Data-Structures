

public class Executives
{
    private String name;
    private int salary;
    /**
     * Constructor for Executives
     * @param name
     */
    public Executives(String name)
    {
        this.name = name;
        salary = 40000;
    }
    /**
     * Method to get the name of the executive
     * @return name
     */
    public String getName()
    {
        return name;
    }
    /**
     * Method to update the payroll of the executive
     * @param i
     */
    public void updatePayroll(int i)
    {
        salary = i;
        System.out.println(name + " has been paid " + salary + " for the month");
    }
    /**
     * Method to get the salary of the executive
     * @return salary
     */
    public int getSalary()
    {
        updatePayroll(salary);
        return salary;
    }
}