import javafx.scene.image.ImageView;

public class Player {

    private String playerName;//stores name
    private String gamePiece;//stores game piece
    private Square currentSpace;//stores current square object
    private int money;//stores amount of money
    private int propertyCounter; //counts their property amounts
    private Square[] ownedProperty; //holds all of their properties
    private boolean stillPlaying; //finds out if they are still playing (not used because that feature was not finished
    private int currentJailTime; //holds the amount of time a player has left in jail

    //Default constructor for when it is needed to do initialization
    Player()
    {

    }

    //More constructors
    Player(String playerName, String gamePiece, Square currentSpace, int startingCash)
    {
        this.playerName = playerName;
        this.gamePiece = gamePiece;
        this.currentSpace = currentSpace;
        this.money = startingCash;
        this.ownedProperty = new Square[28];
        this.stillPlaying = true;

    }
    //
    Player(String playerName, String gamePiece)
    {
        this.playerName = playerName;
        this.gamePiece = gamePiece;
        this.ownedProperty = new Square[28];
        this.stillPlaying = true;

    }
    //
    Player(String playerName, String gamePiece, int startingCash)
    {
        this.playerName = playerName;
        this.gamePiece = gamePiece;
        this.money = startingCash;
        this.ownedProperty = new Square[28];
        this.stillPlaying = true;
    }


    //jail get/set
    public int getCurrentJailTime() {
        return currentJailTime;
    }
    public void setCurrentJailTime(int jailTime){
        this.currentJailTime = jailTime;
    }




    //name get/set
    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }
    public String getPlayerName()
    {
        return playerName;
    }

    //game piece get/set
    public void setGamePiece(String gamePiece)
    {
        this.gamePiece = gamePiece;
    }
    public String getGamePiece()
    {
        return gamePiece;
    }

    //current space get/set
    public void setCurrentSpace(Square currentSpace)
    {
        this.currentSpace = currentSpace;
    }
    public Square getCurrentSpace()
    {
        return currentSpace;
    }

    //money get/set
    public void setMoney(int money)
    {
        this.money = money;
    }
    public int getMoney()
    {
        return money;
    }

    //still Playing get/set
    public void setStillPlaying(boolean tf)
    {
        stillPlaying = tf;
    }
    public boolean getStillPlaying()
    {
        return stillPlaying;
    }


    //adds a property to property list
    public void addToProperty(Square current)
    {
        ownedProperty[current.getSquareNumber()] = current;
        propertyCounter++;
    }

    //checks to see if this person has a certain property
    public boolean hasProperty(Square square)
    {
        for(int i = 0; i < 28; i++){
            if(ownedProperty[i] != null && ownedProperty[i].equals(square)){
                return true;
            }
        }
        return false;
    }

    //counts railroads for checking what the price should be to charge a player rent
    public int countRailRoads(){
        int count = 0;
        for(int i = 0; i < 28; i++){
            if(ownedProperty[i] != null && ownedProperty[i].getClass().getSimpleName().equals("RailroadSquare")){
                count++;
            }
        }
        return count;
    }


    //get for owned properties
    public Square [] getOwnedProperties()
    {
        return ownedProperty;
    }


    //finds the amount of spaces in-between the current property and a string search for another
    public int findPropertyDifference(String name)
    {
        Square temp = getCurrentSpace();
        int counter = 0;
        for(int i = 0; i < 40; i++) {
            temp = temp.getNext();
            counter++;
            if(temp.getName().equals(name))
            {
                return counter;
            }
        }
        return counter;
    }

    //finds the nearest utility to the player
    public int findNearestUtility()
    {
        Square temp = getCurrentSpace();
        int counter = 0;
        for(int i = 0; i < 40; i++) {
            temp = temp.getNext();
            counter++;
            if(temp.getClass().getSimpleName().equals("UtilitySquare"))
            {
                return counter;
            }
        }
        return counter;
    }


    //find the nearest railroad to the player
    public int findNearestRailroad()
    {
        Square temp = getCurrentSpace();
        int counter = 0;
        for(int i = 0; i < 40; i++) {
            temp = temp.getNext();
            counter++;
            if(temp.getClass().getSimpleName().equals("RailroadSquare"))
            {
                return counter;
            }
        }
        return counter;
    }


}
