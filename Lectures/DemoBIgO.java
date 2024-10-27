public class DemoBIgO 
{
    public static void main(String[] args)
    {
        // exactly 1 action here so O(1)
        int six = 6;
        // considered the fastest thing you can do

        // 3 actions here so O(3)
        int seven = 6;
        int eight = 6;
        int nine = 6;

        //anytime you have an O less than n it is considered O(1)

        // inside the loop we have 3 actions
        // the loop runs n times so O(3n) which equals O(n) 
        for(int i = 0; i < size; i++)
        {
            int ten = 6;
            int eleven = 6;
            int twelve = 6;
        }

        // The loop runs n times
        // Inside the loop we have a loop that runs n times
        // Inside the nested loop we have 1 action
        // So the total number of actions is n * n * 1 = n^2
        // So the Big O is O(n^2)
        for(int j = 0; j < size; j++)
        {
            for(int k = 0; k < size; k++)
            {
                System.out.println("Hello");
            }
        }

        // big O always takes the worst case scenario in the program
        // the program is O(n^2) because it is the worst case scenario
    }
}
