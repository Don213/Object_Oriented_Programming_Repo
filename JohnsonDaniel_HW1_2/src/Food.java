public class Food implements Cloneable
{
    private String brand;
    private String productName;
    private String units;

    private static Food singletonObj;



    //2-a
    //Private Constructor
    private Food()
    {

    }



    //2-b
    //The method that gets the only instance of the singleton class, Food
    public static Food getInstance()
    {
        if(singletonObj == null) {
            singletonObj = new Food();
        }
            return singletonObj;
    }










    public void setBrand(String brandIn)
    {
        brand = brandIn;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setProductName(String productNameIn)
    {
        productName = productNameIn;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setUnits(String unitsIn)
    {
        units = unitsIn;
    }

    public String getUnits()
    {
        return units;
    }





    ////////////////////////////////////////
    //My methods
    public String getName()
    {
        return "Food";
    }

    public String toString()
    {
        return (getName() + "[Brand: " + getBrand() + ", " + "Product Name: " + getProductName()
                + ", " + "Units: " + getUnits() + "]");
    }

    ////////////////////////////////////////////////////////
    //This method returns true if the two Food objects are equal
    public boolean equals(Food pf)
    {
        if(pf == null || getClass() != pf.getClass())
        {
            return false;
        }
        Food food = (Food)pf;

        if (getBrand().equals(food.getBrand())
                && getProductName().equals(food.getProductName())
                && getUnits().equals(food.getUnits()))
        {
            return true;
        }
        else {return false;}
    }




}
