
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Company 
{
    private Queue<Department> queue;
    private Queue<Executives> unemployed;
    /**
     * 
     */
    public Company()
    {  
        this.queue = new LinkedList<Department>();
        this.unemployed = new LinkedList<Executives>();
    }

    public void run()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the company type anything to begin except for Exit");
        String input = scan.nextLine();
        
        while(input != "Exit")
        {
            System.out.println("What would you like to do within the company? ");
            System.out.println("1. Add a new department (Add)");
            System.out.println("2. Add a new executive (Hire)");
            System.out.println("3. Add a person to a department (Join)");
            System.out.println("4. Remove a person from a department (Quit)");
            System.out.println("5. Move a person from 1 department to another (Change)");
            System.out.println("6. Pay all persons that are working in a department (Payroll)");
            System.out.println("7. See the salary of a person (Salary)");
            System.out.println("8. Exit the program (Exit)");
            input = scan.nextLine();

            /**
             * Creates a new department in the queue
             */
            if(input.equalsIgnoreCase("Add"))
            {
                System.out.println("What is the name of the department? ");
                String departmentName = scan.nextLine();
                Department d = new Department(departmentName);
                queue.offer(d);
                System.out.println("Department " + departmentName + " has been added");
            }
            /**
             * Creates a new executive in the unemployed queue
             */
            else if(input.equalsIgnoreCase("Hire"))
            {
                System.out.println("What is the name of the executive? ");
                String name = scan.nextLine();
                Executives e = new Executives(name);
                unemployed.add(e);
                System.out.println("Executive " + name + " has been hired");
            }
            /**
             * Adds an executive to a designated department
             */
            else if(input.equalsIgnoreCase("Join"))
            {
                System.out.println("What is the name of the Executive? ");
                String name = scan.nextLine();
                //finds the executive in the unemployed queue
                if(getExecutive(name, unemployed) != null)
                {
                    System.out.println("What is the name of the department you would like the executive to join? ");
                    String departmentName = scan.nextLine();
                    Department d = null;
                    //finds the department in the queue
                    if(getDepartment(departmentName, queue) != null)
                    {
                        d = getDepartment(departmentName, queue);
                        Executives e = getExecutive(name, unemployed);
                        d.addExecutive(e);
                    }
                    else
                    {
                        System.out.println("Department does not exist");
                    }
                }
                else
                {
                    System.out.println("Executive does not exist");
                    
                }   
            }
            /**
             * Removes an executive from a designated department
             */
            else if(input.equalsIgnoreCase("Quit"))
            {
                System.out.println("What is the name of the employee? ");
                String name = scan.nextLine();
                Executives e = null;
                //first checks if the executive is in the unemployed queue
                if(getExecutive(name, unemployed) != null)
                {
                    e = getExecutive(name, unemployed);
                    unemployed.remove(e);
                    System.out.println("Executive " + e.getName() + " has been removed from the company");
                }
                //if the executive is not in the unemployed queue, then it checks the department mentioned by the user
                else 
                {
                    System.out.println("What is the name of the department the employee is in " );
                    String departmentName = scan.nextLine();
                    Department d = null;
                    if(getDepartment(departmentName, queue) != null)
                    {
                        d = getDepartment(departmentName, queue);
                        e = d.getExecutive(name, d.getQueue());
                        d.removeExecutive(e, d.getQueue());
                        System.out.println("Executive " + e.getName() + " has been removed from the company");
                    }
                    else
                    {
                        System.out.println("Department does not exist");
                        input = scan.nextLine();
                    }
                }
            }
            /**
             * Moves an executive from one department to another
             */
            else if(input.equalsIgnoreCase("Change"))
            {
                System.out.println("What is the name of the employee? ");
                String name = scan.nextLine();
                Executives e = null;
                //checks if the executive is in the unemployed queue
                if(getExecutive(name, unemployed) != null)
                {
                    System.out.println("What is the name of the department you would like the executive to join? ");
                    String departmentName = scan.nextLine();
                    Department d = null;
                    if(getDepartment(departmentName, queue) != null)
                    {
                        d = getDepartment(departmentName, queue);
                        e = getExecutive(name, unemployed);
                        d.addExecutive(e);
                    }
                    else
                    {
                        System.out.println("Department does not exist");
                        input = scan.nextLine();
                    }
                }
                //if the executive is not in the unemployed queue, then it checks the department mentioned by the user
                else
                {
                    System.out.println("What is the name of the department the employee is in " );
                    String departmentName = scan.nextLine();
                    Department d = null;
                    if(getDepartment(departmentName, queue) != null)
                    {
                        d = getDepartment(departmentName, queue);
                        e = d.getExecutive(name, d.getQueue());
                        d.removeExecutive(e, d.getQueue());

                        System.out.println("What is the name of the department you would like the executive to join? ");
                        String newDepartmentName = scan.nextLine();
                        Department newDepartment = null;
                        if(getDepartment(newDepartmentName, queue) != null)
                        {
                            newDepartment = getDepartment(newDepartmentName, queue);
                            newDepartment.addExecutive(e);
                        }
                        else
                        {
                            System.out.println("Department does not exist");
                            input = scan.nextLine();
                        }
                    }
                    else
                    {
                        System.out.println("Department does not exist");
                        input = scan.nextLine();
                    }
                }
                
            }
            /**
             * Pays all the executives in a department
             */
            else if(input.equalsIgnoreCase("Payroll"))
            {
                for(Department d : queue)
                {
                    d.showPayroll();
                }
            }
            /**
             * Shows the salary of an executive specified by the user
             * If the executive is unemployed, then the salary is 0
             * If the executive is in a department, then the salary is the base salary + additional amount depending on the position of the executive in the queue
             */
            else if(input.equalsIgnoreCase("Salary"))
            {
                System.out.println("What is the name of the executive? ");
                String name = scan.nextLine();
                Executives e = null;
                if(getExecutive(name, unemployed) != null)
                {
                    e = getExecutive(name, unemployed);
                    System.out.println(e.getName() + " has a salary of 0 because they are unemployed");
                }
                else
                //if the executive is not in the unemployed queue, then it checks the department mentioned by the user
                {
                    System.out.println("What is the name of the department the employee is in " );
                    String departmentName = scan.nextLine();
                    Department d = null;
                    if(getDepartment(departmentName, queue) != null)
                    {
                        d = getDepartment(departmentName, queue);
                        e = d.getExecutive(name, d.getQueue());
                        System.out.println(e.getName() + " has a salary of " + e.getSalary());
                    }
                    else
                    {
                        System.out.println("Department does not exist");
                        input = scan.nextLine();
                    }
                }
            }
            else if(input.equalsIgnoreCase("Exit"))
            {
                break;
            }
        }
        scan.close();
    }

    /**
     * Method to get the department from the queue of departments based on the department name
     * @param departmentName
     * @param queue
     * @return
     */
    public Department getDepartment(String departmentName, Queue<Department> queue)
    {
        for(Department d : queue)
        {
            if(d.getDepartmentName().equalsIgnoreCase(departmentName))
            {
                return d;
            }
        }
        return null;
    }
    /**
     * Method to get the executive from the queue of executives based on the executive name
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
}
