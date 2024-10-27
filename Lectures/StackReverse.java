import java.util.Stack;
public class StackReverse
{
    public static void main(String[] args) 
    {
        Stack<String> stack = new Stack<String>();
        Stack<String> temp = new Stack<String>();
        
        
        stack.push("1");
        stack.push("2");
        stack.push("3");

        System.out.println(stack);

        while(stack.size() != 0)
        {
            temp.push(stack.pop());
        }

        stack = temp;

        System.out.println(stack);
    }
}
