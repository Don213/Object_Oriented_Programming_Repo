////////////////////////////////
//
// Daniel Johnson
// Assignment 2.2
// 10/29/18
//
////////////////////////////////


////////////////////////////////
//
// DESCRIPTION: This program greets a person and asks for their name. After their initial greeting, the program greets
// them once more with their name (capitalized).
//
////////////////////////////////


import java.util.Scanner;

public class ScanGreetings {

    //gives and initial greeting and asks for the person's name.
    static String askForName()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, what is your name?");

        return sc.nextLine();
    }
    //prints the second greeting that is personalized with the user's name (name given as input to the function)).
    static void printGreeting(String name)
    {
        System.out.println("Hello, " + name.toUpperCase() + ", nice to meet you!");
    }

    //uses functions above.
    public static void main(String[] args)
    {
        printGreeting(askForName());
    }
}
