public class TaxSquare extends Square {

    private int rent;

    TaxSquare(String name, int squareType, int rent)
    {
        super(name, squareType);
        this.rent = rent;
    }





    public int getRent()
    {
        return rent;
    }
    public void setRent(int rent)
    {
        this.rent = rent;
    }

    public String toString()
    {
        return super.toString() + "[rent: " + rent + "]";
    }

}
