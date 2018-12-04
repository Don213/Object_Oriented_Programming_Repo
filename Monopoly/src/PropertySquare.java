public class PropertySquare extends RailroadSquare {

    private String color;
    private int rent1,rent2,rent3,rent4;
    private int houses;



    PropertySquare(String name, int squareType, String color, int price, int rent, int rent1, int rent2, int rent3, int rent4)
    {
        super(name, squareType, rent, price);
        this.color = color;
        this.rent1 = rent1;
        this.rent2 = rent2;
        this.rent3 = rent3;
        this.rent4 = rent4;
    }

    //color get/set
    void setColor(String color)
    {
        this.color = color;
    }
    String getColor()
    {
        return color;
    }

    //rent1 get/set
    void setRent1(int rent1)
    {
        this.rent1 = rent1;
    }
    int getRent1()
    {
        return rent1;
    }

    //rent2 get/set
    void setRent2(int rent2)
    {
        this.rent2 = rent2;
    }
    int getRent2()
    {
        return rent2;
    }

    //rent3 get/set
    void setRent3(int rent3)
    {
        this.rent3 = rent3;
    }
    int getRent3()
    {
        return rent3;
    }

    //rent4 get/set
    void setRent4(int rent4)
    {
        this.rent4 = rent4;
    }
    int getRent4()
    {
        return rent4;
    }


    public String toString()
    {
        return super.toString() + "[color: " + color + ", rent1: " + rent1 + ", rent2: " + rent2 + ", rent3: " + rent3 + ", rent4: " + rent4 + "]";
    }

    void setHouses(int houses)
    {
        this.houses = houses;
    }
    int houses()
    {
        return houses;
    }




}
