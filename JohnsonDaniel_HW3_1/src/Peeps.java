import java.io.*;
import java.util.Scanner;

public class Peeps {





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
        System.out.println("Hello. Please enter the name of the text file with the names.");

        String fileName;


        String name = null;

        while((name.equals(null))) {




            try {
                BufferedReader inputStream = new BufferedReader(new InputStreamReader(new FileInputStream("Names.txt")));
                try {
                    name = inputStream.readLine();
                } catch (Exception e) {
                    System.out.println("There was an error when processing the file.");
                }
            } catch (FileNotFoundException e) {
                System.out.println("The file specified was not found. Please enter the name of the file again.");
            }
        }
        System.out.println("Hello there");


    }




}
