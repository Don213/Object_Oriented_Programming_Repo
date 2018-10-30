////////////////////////////////
//
// Daniel Johnson
// Assignment 2.3
// 10/29/18
//
////////////////////////////////


////////////////////////////////
//
// DESCRIPTION: This program transfers the contents of one text file to another.
//
////////////////////////////////

import java.io.*;

public class CharacterReadAndWriting {

    //Uses I/O to read a file char by char and copy it's contents into another file char by char.
    //Takes the name of the input file and the name of the output file as arguments
    static void readAndWrite(String input, String output)
    {
        char chr = ' ';
        int test;
        try {
            BufferedReader in = new BufferedReader (new InputStreamReader(new FileInputStream(input)));
                try{
                    PrintStream out = new PrintStream(new FileOutputStream(output));
                    try {
                        test = in.read();
                        chr = (char)test;
                        while (test != -1) {
                            out.print(chr);
                            test = in.read();
                            chr = (char) test;

                        }
                    }catch(EOFException e){}
                    out.close();
                }catch(EOFException e){/*System.out.println("There was an error reading the file.");*/}
                catch(FileNotFoundException e){System.out.println("There was an error reading the file.");}
                catch(IOException e){System.out.println("There was an error reading the file.");}
                finally{
                    try {
                        in.close();
                    }catch(IOException e ){System.out.println("There was a problem closing the files.");}
                }
            }catch(FileNotFoundException e) {
                System.out.println("There was an error reading the file");
            }

        System.out.println("File transfer complete.");
    }



    public static void main(String[] args)
    {
        String input = "Input.txt", output = "Output.txt";
        readAndWrite(input, output);
    }
}
