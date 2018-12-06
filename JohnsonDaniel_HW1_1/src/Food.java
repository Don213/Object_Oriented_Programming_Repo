public class Food implements Cloneable
{
    private String brand;
    private String productName;
    private String units;


    public Food(String brandIn, String productNameIn, String unitsIn)
    {
        brand = brandIn;
        productName = productNameIn;
        units = unitsIn;
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





    //1-2-a
    public String toString()
    {
        return (this.getClass().getSimpleName() + "[Brand: " + getBrand() + ", " + "Product Name: " + getProductName()
                + ", " + "Units: " + getUnits() + "]");
    }






    //This method returns true if the two Food objects are equal
    public boolean equals(Food pf)
    {
        //1-3-a (superclass checks for the same object)
        if(pf == null || getClass() != pf.getClass())
        {
            return false;
        }
        //1-3-b
        Food food = (Food)pf;

        if (getBrand().equals(food.getBrand())
                && getProductName().equals(food.getProductName())
                && getUnits().equals(food.getUnits()))
        {
            return true;
        }
        else {return false;}
    }





    //This method returns a clone of the current object
    public Food clone() throws CloneNotSupportedException
    {
        //1-4-b
        return (Food)super.clone();
    }



}
