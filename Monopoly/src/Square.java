import java.io.*;

public class Square {


    private static Square head;
    private Square next;
    private Square last;
    private String name;

    private int squareType;


    public Square()
    {
    //this.next = null;
    //his.last = null;
    }

    public Square(String name, int squareType)
    {
        this.name = name;
        this.squareType = squareType;
        //this.next = null;
        //this.last = null;
        //setHead(this);
    }

    public Square addSquare(String name, int squareType, Square last)
    {
        Square temp = new Square();

        last.setNext(temp);

        temp.setName(name);
        temp.last = last;
        temp.squareType = squareType;
        return temp;
    }

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
                    head.setNext(new RailroadSquare(tempList[1], (int)Float.parseFloat(tempList[0]), (int)Float.parseFloat(tempList[2]), (int)Float.parseFloat(tempList[3])));
                }
                else
                {
                    tempSquare = head;
                    head.setNext(new UtilitySquare(tempList[1], (int)Float.parseFloat(tempList[0]), (int)Float.parseFloat(tempList[2]), (int)Float.parseFloat(tempList[3])));
                }
                head = head.getNext();
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


    public BufferedReader readFileIn(String fileName) {
        try {
            return (new BufferedReader(new InputStreamReader(new FileInputStream(fileName))));
        } catch (FileNotFoundException e) {
            System.out.println("Error, File Not Found");
        }
        return null;
    }




    //
    public Square getNext()
    {
        return next;
    }
    public void setNext(Square data)
    {
        next = data;
    }

    //
    public Square getLast()
    {
        return last;
    }
    public void setLast(Square data)
    {
        last = data;
    }

    //
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    //
    public int getSquareType()
    {
        return squareType;
    }
    public void setSquareType(int squareType)
    {
        this.squareType = squareType;
    }


    //
    public Square getHead()
    {
        return head;
    }
    public void setHead(Square data)
    {
        head = data;
    }

    //
    public String toString()
    {
        return (getClass().getSimpleName() + "[name: " + name + ", squareType: " + squareType + ", nextName: " + next.getName() + ", lastName: " + last.getName() + "]");
    }



    //
    public Square findLink(String name)
    {
        Square original = this;
        Square temp;
        temp = this;
        int count = 0;
        while(!temp.getName().equals(name))
        {
            temp = this.getNext();
            if(count > 39) {
                return null;
            }
            count++;
        }
        return temp;
    }












}
