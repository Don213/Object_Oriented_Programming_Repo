////////////////////////////////
//
// Daniel Johnson
// Assignment 2.1
// 10/29/18
//
////////////////////////////////


////////////////////////////////
//
// DESCRIPTION: This program greets the user and asks for their name. After the initial greeting the program
// proceeds to read their name from a text file and then greets them (with their name) while also
// capitalizing their whole name.
//
////////////////////////////////


import java.io.*;
class Greetings{

//This reads a single line from a given text file
static String readNameFromFile()
{
    String name = "";
    try {
        BufferedReader inputStream = new BufferedReader (new InputStreamReader(new FileInputStream("Name.txt")));
        try {
            name = inputStream.readLine();
        }catch(Exception e){System.out.println("There was an error when processing the file.");}
    }catch (FileNotFoundException e) {
        System.out.println("There was an error reading the file.");
    }
    return name;
}


public static void main(String[] args)
{
    String name = readNameFromFile().toUpperCase(); //calls function and capitalized the name returned

    System.out.println("Hello, what is your name?");//initial greeting
    System.out.println("Hello, " + name + ", it is nice to meet you.");//greeting with name


}
}

