////////////////////////////////
//
// Daniel Johnson
// Assignment 2.4
// 10/29/18
//
////////////////////////////////


////////////////////////////////
//
// DESCRIPTION: This program prints itself as output by using a text file with a copy of the program and reading from it.
//
////////////////////////////////


import java.io.*;

public class OutputSelf{

    //Reads a file and outputs it line by line
    //takes the file name as a string argument
    static void readFromFile(String inputFile)
    {
        String line = "";
        try {
            BufferedReader in = new BufferedReader (new InputStreamReader(new FileInputStream(inputFile)));
                try {
                    line = in.readLine();
                    while (line != null) {
                        System.out.println(line);
                        line = in.readLine();
                    }
                }catch(EOFException e){System.out.println("There was an error reading the file.");}
                catch(IOException e){System.out.println("There was an error reading the file.");}
                finally{
                    try {
                        in.close();
                    }catch(IOException e ){System.out.println("There was a problem closing the files.");}
                }
        }catch(FileNotFoundException e){System.out.println("There was an error reading the file.");}
        //System.out.println("File transfer complete.");
    }

    public static void main(String[] args)
    {
        String txtFileName = "ProgramText.txt";
        readFromFile(txtFileName);
    }
}