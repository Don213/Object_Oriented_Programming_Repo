public class TaxSquare extends Square {

    private int rent;

    //default constructor
    TaxSquare(){

    }
    //constructor
    TaxSquare(String name, int squareType, int rent)
    {
        super(name, squareType);
        this.rent = rent;
    }




    //rent get and set
    public int getRent()
    {
        return rent;
    }
    public void setRent(int rent)
    {
        this.rent = rent;
    }

    /*used for testing purposes
    public String toString()
    {
        return super.toString() + "[rent: " + rent + "]";
    }
*/
}
