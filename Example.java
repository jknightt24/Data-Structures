public class Example
// extends keyword allows for inheritance
{
    public void dummyMethod()
    {
        boolean dog = false;
    }

    public double getMoney()
    {
        return 10 +5;
        // after the first return it ends the method and never reaches the second
       // return 10 +5;
    }

    double oldMoney;
    double[] monkies;
    public void setMoney(double newMoney)
    {
        oldMoney = newMoney;

        oldMoney++;

        // since singleMonkey was created for the for loop its a local variable and not declared as a global variable
        //singleMonkey's are deleted after the for loop
        for(double singleMonkey : monkies)
        {
            System.out.println(singleMonkey);
        }

        for(int i = 0; i < monkies.length; i++)
        {
            monkies[i] = 0;
        }

        return;
        // void methods do not require a return but you can set an empty return for the code to stop
    }   
}
