public class JaylenUniversalBox <T>
{
    // global variable therefore should be private
    public T thing1;

    public JaylenUniversalBox(T userInputThing)
    {
       // thing1 // should assign it to something
       thing1 = userInputThing;
    }

    public T getT()
    {
        return thing1;
    }
}