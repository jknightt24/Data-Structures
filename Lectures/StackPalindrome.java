import java.util.Stack;
public class StackPalindrome
{
    public static void main(String[] args)
    {
        Stack<String> stack = new Stack<String>();
        Stack<String> temp = new Stack<String>();
        Stack<String> temp2 = new Stack<String>();
 
        stack.push("R");
        stack.push("O");
        stack.push("T");
       u stack.push("A");
        stack.push("T");
        stack.push("O");
        stack.push("R");

        int size = stack.size();
        int mid = size / 2;

        System.out.println(mid);
        
        for(int i = 0; i < mid; i++)
        {
            temp.push(stack.pop());
        }

        if(mid % 2 != 0)
        {
            stack.pop();
        }

       
        while(!stack.isEmpty())
        {
            temp2.push(stack.pop());
        }

        boolean isPalindrome = true;
        while(!temp.isEmpty() && !temp2.isEmpty())
        {
            if(!temp.pop().equals(temp2.pop()))
            {
                isPalindrome = false;
                break;
            }
        }

       if(isPalindrome)
       {
           System.out.println("It is a palindrome");
       }
       else
       {
           System.out.println("It is not a palindrome");
       }

    }
}
