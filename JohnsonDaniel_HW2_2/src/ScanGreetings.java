import java.util.Scanner;



public class ScanGreetings {

    private static String name;

    static void setName(String name_2)
    {
        name = name_2;
    }

    static String getName()
    {
        return name;
    }
    static void askForName()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, what is your name?");

        setName(sc.nextLine());
    }

    static void printGreeting()
    {
        System.out.println("Hello, " + getName().toUpperCase() + ", nice to meet you!");
    }















    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        askForName();
        printGreeting();
    }
}
