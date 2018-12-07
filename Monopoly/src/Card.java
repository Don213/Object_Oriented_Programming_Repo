import java.io.*;



public class Card {

    private String [] chance;
    private String [] community;




    /////////////////////////////////
    // Helps read in files for the constructor
    /////////////////////////////////
    private BufferedReader readFileIn(String fileName) {
        try {
            return (new BufferedReader(new InputStreamReader(new FileInputStream(fileName))));
        } catch (FileNotFoundException e) {
            System.out.println("Error, File Not Found");
        }
        return null;
    }


    /////////////////////////////////
    // The main constructor for the
    // card class that creates two arrays.
    // One for chance and one for community
    // chest
    /////////////////////////////////
    public Card()
    {
        BufferedReader temp1 = readFileIn("Text_Files\\chance.txt");
        String storage1 = "";
        BufferedReader temp2 = readFileIn("Text_Files\\community.txt");
        String storage2 = "";

        int counter = 0;
        chance = new String[5];
        community = new String[5];

        try {
            while ((storage1 = temp1.readLine()) != null) {
                chance[counter] = storage1;
                counter++;
            }
        }catch(Exception e){System.out.println("There was a problem reading the chance and community chest files.");}

        counter = 0;

        try {
            while ((storage2 = temp2.readLine()) != null) {
                community[counter] = storage2;
                counter++;
            }
        }catch(Exception e){System.out.println("There was a problem reading the chance and community chest files.");}


    }





    //get/set methods
    public String[] getChance()
    {
        return chance;
    }
    public String[] getCommunity()
    {
        return community;
    }

    public void setChance(String [] chance)
    {
        this.chance = chance;
    }
    public void setCommunity(String [] community)
    {
        this.community = community;
    }










}
