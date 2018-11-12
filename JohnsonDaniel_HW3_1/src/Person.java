import java.io.*;
import java.util.Scanner;

public class Person implements Serializable{

    private String name;

    Person(String name)
    {
    this.name = name;
    }
    /*
    public String getName()
    {
       return this.name;
    }
    */
    public String toString(){

        return (getClass().getSimpleName()  + "[Name: " + name + "]");
    }



    public static void acceptAndWriteFile()
    {
        Scanner sc = new Scanner(System.in);
        String fileName;
        String name = "";
        Person tempObject;




        System.out.println("Hello. Please enter the name of the text file with the names.");

        while((name != null)) {
            fileName = sc.nextLine();
            try {
                BufferedReader inputStream = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("peeps.dat"));
                    name = inputStream.readLine();
                    while(name != null)
                    {
                        tempObject  = new Person(name);
                        oos.writeObject(tempObject);
                        name = inputStream.readLine();
                    }
                    oos.close();
                }
                catch(FileNotFoundException e){System.out.println("The output file was not found.");}
                catch(EOFException e){}
                catch(IOException e){}
                inputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println("The file specified was not found. Please enter the name of the file again.");
            } catch(IOException e){}
        }
        //System.out.println("Hello there; the file opening was a success " + name);

    }


    public static void readFile()
    {
        String tempPerson;
        String fileName = "peeps.dat";
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("peeps.dat"));
            try {
                tempPerson = ois.readObject().toString();
                while(tempPerson != null) {
                    System.out.println(tempPerson);
                    tempPerson = ois.readObject().toString();
                }
                ois.close();
            }catch(ClassNotFoundException e){}

        }catch(FileNotFoundException e){System.out.println("The output file was not found.");}
        catch(EOFException e){}
        catch(IOException e){System.out.println("Something went wrong");}


    }




    public static void main(String[] args)
    {
     acceptAndWriteFile();
     readFile();
    }




}
