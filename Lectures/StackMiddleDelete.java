import java.util.Stack;

public class StackMiddleDelete
{
    public static void main(String[] args) 
    {
        Stack<String> stack = new Stack<String>();
        Stack<String> temp = new Stack<String>();
        
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");

        int size = stack.size();
        int mid = size / 2;
        int count = 0;

        System.out.println("this is the stack " + stack);
        
        while(count < mid)
        {
            temp.push(stack.pop());
            count++;
        }

        stack.pop();

        while(!temp.isEmpty())
        {
            stack.push(temp.pop());
        }

        System.out.println("this is the stack after removing the middle " + stack);

    }
}
