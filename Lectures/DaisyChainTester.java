public class DaisyChainTester 
{
    
    public static void main(String[] args)
    {
        JaylenDaisyChainConnector<String> chain = new JaylenDaisyChainConnector<String>();

        chain.addFront("first box");
        chain.addatIndex("second box", 0 );
        chain.addFront("third box but first");
        chain.addEnd("last box");
        chain.removeFirst();
        chain.removeEnd();
        chain.removeAtIndex(0);
        chain.replace("replacement box",0);
        chain.clear();


        System.out.print(chain);

        
    }
}
