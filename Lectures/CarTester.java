public class CarTester 
{
    public static void main(String[] args)
    {
        Car ford = new Car();
        Car BMW = new Car();

        System.out.println("We have 2 cars " + ford.getWheels() + " " + BMW.getWheels());

        System.out.println("Ford flat tire ");
        ford.flatTire();
    }
}
