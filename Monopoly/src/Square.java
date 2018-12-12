import java.io.*;

public class Square {


    private static Square head;
    private Square next;
    private Square last;
    private String name;
    private int squareNumber;
    private int gridNumber;
    private int squareType;


    //method to help read in files
    public BufferedReader readFileIn(String fileName) {
        try {
            return (new BufferedReader(new InputStreamReader(new FileInputStream(fileName))));
        } catch (FileNotFoundException e) {
            System.out.println("Error, File Not Found");
        }
        return null;
    }


    //default constructor
    public Square()
    {

    }

    //constructor
    public Square(String name, int squareType)
    {
        this.name = name;
        this.squareType = squareType;
    }

    //constructs the linked list of square objects stored in the monopoly class
    public void constructLinkedList(Square head, String fileName)
    {
        BufferedReader in = readFileIn(fileName);
        Square tempSquare;
        String tempString;
        String tempList[];




        try {
            tempString = in.readLine();
            tempList = tempString.split(",");
            head.setName(tempList[1]);
            head.setSquareType(Integer.parseInt(tempList[0]));
            setHead(head);
            head.setGridNumber(0);
            int counter = 0;
            int counter2 = 0;


            while (((tempString = in.readLine()) != null)) {

                tempList = tempString.split(",");
                if(Integer.parseInt(tempList[0]) == 1)
                {
                    tempSquare = head;
                    head.setNext(new Square(tempList[1], Integer.parseInt(tempList[0])));
                }
                else if(Integer.parseInt(tempList[0]) == 2)
                {
                    tempSquare = head;
                    head.setNext(new PropertySquare(tempList[1], (int)Float.parseFloat(tempList[0]), tempList[2], (int)Float.parseFloat(tempList[3]),
                            (int)Float.parseFloat(tempList[4]), (int)Float.parseFloat(tempList[5]), (int)Float.parseFloat(tempList[6]), (int)Float.parseFloat(tempList[7]), (int)Float.parseFloat(tempList[8])));
                }
                else if(Integer.parseInt(tempList[0]) == 3)
                {
                    tempSquare = head;
                    head.setNext(new TaxSquare(tempList[1], (int)Float.parseFloat(tempList[0]), (int)Float.parseFloat(tempList[2])));
                }
                else if(Integer.parseInt(tempList[0]) == 4)
                {
                    tempSquare = head;
                    head.setNext(new RailroadSquare(tempList[1], (int)Float.parseFloat(tempList[0]), (int)Float.parseFloat(tempList[3]), (int)Float.parseFloat(tempList[2])));
                }
                else
                {
                    tempSquare = head;
                    head.setNext(new UtilitySquare(tempList[1], (int)Float.parseFloat(tempList[0]), (int)Float.parseFloat(tempList[2]), (int)Float.parseFloat(tempList[3])));
                }
                head = head.getNext();
                counter = setSquareNumberAndGridNumber(head, counter, counter2);
                counter2++;
                head.setLast(tempSquare);
            }

            head.setNext(getHead());
            tempSquare = head;
            head = head.getNext();
            head.setLast(tempSquare);
            in.close();
        }catch(IOException e){System.out.println("There was an error");}

        //return head;
    }






    //get and set for next
    public Square getNext()
    {
        return next;
    }
    public void setNext(Square data)
    {
        next = data;
    }

    //get and set for last
    public Square getLast()
    {
        return last;
    }
    public void setLast(Square data)
    {
        last = data;
    }

    //get and set for name
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    //get and set for square type
    public int getSquareType()
    {
        return squareType;
    }
    public void setSquareType(int squareType)
    {
        this.squareType = squareType;
    }


    //get and set for head
    public Square getHead()
    {
        return head;
    }
    public void setHead(Square data)
    {
        head = data;
    }


    //get and set for square number
    private void setSquareNumber(int squareNumber)
    {
        this.squareNumber = squareNumber;
    }
    public int getSquareNumber()
    {
        return squareNumber;
    }

    //get and set for grid number. Used when referencing where to place players on the grid/board
    private void setGridNumber(int gridNumber)
    {
        this.gridNumber = gridNumber;
    }
    public int getGridNumber()
    {
        return gridNumber;
    }


    //sets up the square number and the grid number.
    private int setSquareNumberAndGridNumber(Square current, int counter, int counter2)
    {

        current.setGridNumber(counter2 + 1);


        if(current.getClass().getSimpleName().equals("PropertySquare") || current.getClass().getSimpleName().equals("RailroadSquare") ||current.getClass().getSimpleName().equals("UtilitySquare"))
        {
            current.setSquareNumber(counter);
            counter = counter+1;
        } else{current.setSquareNumber(-1);}


        return counter;
    }







/*
    //used for testing purposes
    public String toString()
    {
        return (getClass().getSimpleName() + "[name: " + name + ", squareType: " + squareType + ", nextName: " + next.getName() + ", lastName: " + last.getName() + "]");
    }
*/


}
