public class Player {

    private String playerName;
    private String gamePiece;
    private Square currentSpace;
    private int money;
    private int propertyCounter;
    private Square[] ownedProperty;
    private boolean stillPlaying;



    Player(String playerName, String gamePiece, Square currentSpace)
    {
        this.playerName = playerName;
        this.gamePiece = gamePiece;
        this.currentSpace = currentSpace;
        this.money = 1500;
        this.ownedProperty = new Square[40];
        this.stillPlaying = true;

    }


    public void checkLoss()
    {
        if(money <= 0)
        {
            stillPlaying = false;
        }
    }

    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }
    public String playerName()
    {
        return playerName;
    }

    public void setGamePiece(String gamePiece)
    {
        this.gamePiece = gamePiece;
    }
    public String getGamePiece()
    {
        return gamePiece;
    }

    public void setCurrentSpace()
    {
        this.currentSpace = currentSpace;
    }
    public Square getCurrentSpace()
    {
        return currentSpace;
    }

    public void setMoney(int money)
    {
        this.money = money;
    }
    public int getMoney()
    {
        return money;
    }

    public void setStillPlaying(boolean tf)
    {
        stillPlaying = tf;
    }
    public boolean getStillPlaying()
    {
        return stillPlaying;
    }

    public void addToProperty(Square current)
    {
        ownedProperty[propertyCounter] = current;
        propertyCounter++;
    }
}
