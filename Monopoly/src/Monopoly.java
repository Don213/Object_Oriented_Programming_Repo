import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.Random;
import javafx.scene.control.CheckBox;
import java.util.Random;

public class Monopoly{

    private Rules rules;//set of rules chosen in the beginning
    private String [] chance;//chance array
    private String [] community;//community chest array
    private Stage window;//window
    private Scene scene1, scene2, scene3, scene4;//all of the main scenes
    private Player player1, player2, player3, player4, player5;//the maximum supported number of players
    private boolean diceRolled;//checks to see if dice have been rolled in various methods(mostly end turn method)
    private int playerCounter;//A global counter that helped somewhere
    private int turnTeller;//Represents a number 1-5 corresponding to the players
    private int turnCounter;//Counts the amount of turns to end the game at 10 when rules are set that way
    private Square monopolyBoard;//holds the monopoly board. It is a linked list of square objects






    //dice
    private ImageView dice1,dice2;
    private Label diceLabel;
    private VBox diceVBox;
    private int dice1Value, dice2Value;
    //money box
    private Label moneyAmount;
    //



    //Global variables for the top icons were created to help with their manipulation
    private BorderPane iconOne, iconTwo, iconThree, iconFour, iconFive;
    private HBox topRowBox;

    private GridPane backgroundPane;
    //



    // These variables were created globally
    // to help with manipulation of the property box
    private VBox sidePanelVBox;
    private GridPane propertyGrid;

    private ImageView square1 = new ImageView();
    private ImageView square2 = new ImageView();
    private ImageView square3 = new ImageView();
    private ImageView square4 = new ImageView();
    private ImageView square5 = new ImageView();
    private ImageView square6 = new ImageView();

    private ImageView square7 = new ImageView();
    private ImageView square8 = new ImageView();
    private ImageView square9 = new ImageView();
    private ImageView square10 = new ImageView();
    private ImageView square11 = new ImageView();
    private ImageView square12 = new ImageView();

    private ImageView square13 = new ImageView();
    private ImageView square14 = new ImageView();
    private ImageView square15 = new ImageView();
    private ImageView square16 = new ImageView();
    private ImageView square17 = new ImageView();
    private ImageView square18 = new ImageView();

    private ImageView square19 = new ImageView();
    private ImageView square20 = new ImageView();
    private ImageView square21 = new ImageView();
    private ImageView square22 = new ImageView();
    private ImageView square23 = new ImageView();
    private ImageView square24 = new ImageView();

    private ImageView square25 = new ImageView();
    private ImageView square26 = new ImageView();
    private ImageView square27 = new ImageView();
    private ImageView square28 = new ImageView();


    ImageView[] squareList = new ImageView[] {

            square1,
            square2,
            square3,
            square4,
            square5,
            square6,
            square7,
            square8,
            square9,
            square10,
            square11,
            square12,
            square13,
            square14,
            square15,
            square16,
            square17,
            square18,
            square19,
            square20,
            square21,
            square22,
            square23,
            square24,
            square25,
            square26,
            square27,
            square28,
    };
//









    private HBox gameSquareHBox1 = new HBox();
    private HBox gameSquareHBox2 = new HBox();
    private HBox gameSquareHBox3 = new HBox();
    private HBox gameSquareHBox4 = new HBox();
    private HBox gameSquareHBox5 = new HBox();
    private HBox gameSquareHBox6 = new HBox();



    private ImageView gameSquare1 = new ImageView();
    private ImageView gameSquare2 = new ImageView();
    private ImageView gameSquare3 = new ImageView();
    private ImageView gameSquare4 = new ImageView();
    private ImageView gameSquare5 = new ImageView();
    private ImageView gameSquare6 = new ImageView();

    private ImageView [] gameSquareList = new ImageView[]{
            gameSquare1,
            gameSquare2,
            gameSquare3,
            gameSquare4,
            gameSquare5,
            gameSquare6,
    };





    private HBox [] gameSquareHBoxList = new HBox[]{
            gameSquareHBox1,
            gameSquareHBox2,
            gameSquareHBox3,
            gameSquareHBox4,
            gameSquareHBox5,
            gameSquareHBox6,
    };




























    public class Rules{

        private boolean turnLimitTen;
        private boolean tradingSelling;
        private boolean landingOnGoBonus;
        private boolean FreeParkingTaxFund;
        private boolean randomGamePieces;

        private int numberOfPlayers;
        private int startingCash;
        private int jailTime;

        public Rules()
        {
        }

        public Rules(boolean turnLimitTen, boolean tradingSelling, boolean landingOnGoBonus,
                          boolean FreeParkingTaxFund, boolean randomGamePieces, int numberOfPlayers,
                          int startingCash, int jailTime)
        {
            this.turnLimitTen = turnLimitTen;
            this.tradingSelling = tradingSelling;
            this.landingOnGoBonus = landingOnGoBonus;
            this.FreeParkingTaxFund = FreeParkingTaxFund;
            this.randomGamePieces = randomGamePieces;
            this.numberOfPlayers = numberOfPlayers;
            this.startingCash = startingCash;
            this.jailTime = jailTime;
        }


        public boolean getTurnLimitTen()
        {
            return this.turnLimitTen;
        }
        public boolean getTradingSelling()
        {
            return this.tradingSelling;
        }
        public boolean getLandingOnGoBonus()
        {
            return this.landingOnGoBonus;
        }
        public boolean getFreeParkingTaxFund()
        {
            return this.FreeParkingTaxFund;
        }
        public boolean getRandomGamePieces()
        {
            return this.randomGamePieces;
        }
        public int getNumberOfPlayers()
        {
            return this.numberOfPlayers;
        }
        public int getStartingCash()
        {
            return this.startingCash;
        }
        public int getJailTime()
        {
            return this.jailTime;
        }



    }

    /////////////////////////////////
    // Outside of rules class. Allows
    // Monopoly access to set variables
    // in the rule class easier
    //
    /////////////////////////////////
    private void setRules(boolean turnLimitTen, boolean tradingSelling, boolean landingOnGoBonus,
                         boolean FreeParkingTaxFund, boolean randomGamePieces, int numberOfPlayers,
                         int startingCash, int jailTime)
    {
        rules = new Rules(turnLimitTen,tradingSelling,landingOnGoBonus,FreeParkingTaxFund,randomGamePieces,
                numberOfPlayers,startingCash,jailTime);
    }


    /////////////////////////////////
    // Helps read in files when
    // needed
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
    // Main constructor for the
    // Monopoly class. Starts the
    // GUI creation through the
    // rulesGUI method
    //
    /////////////////////////////////
    Monopoly(Stage window, Scene scene1, Scene scene2, Scene scene3, Scene scene4)
    {
        this.window = window;
        this.scene1 = scene1;
        this.scene2 = scene2;
        this.scene3 = scene3;
        this.scene4 = scene4;

        monopolyBoard = new Square();
        monopolyBoard.constructLinkedList(monopolyBoard,"Text_Files\\squares.txt");

        Card cards = new Card();
        chance = cards.getChance();
        community = cards.getCommunity();

        rules = new Rules();

        turnTeller = 1;
        turnCounter = 0;

        player1 = new Player();
        player1.setCurrentSpace(monopolyBoard);

        diceRolled = false;

        rulesGUI();

    }




    /////////////////////////////////
    // This is the constructor for the
    // scenes before the actual game.
    // it allows you extra flexibility
    // in setting rules, but there
    // are some rules that do not work
    // still
    //
    /////////////////////////////////
    private void rulesGUI()
    {
        //////////////////////////////////////////////////////////////////////////////////////////////////////Scene1
        /////////////////////////////////////////////////////////////Top Section

        //////////////////////Sets up the intro pics to the game
        HBox introScene1 = new HBox();
        try {
            Image monopolyLogo = new Image(new FileInputStream("src\\Monopoly_Pics\\MonopolyLogo.jpg"));
            ImageView monopolyLogoView = new ImageView(monopolyLogo);

            Image topHatMan = new Image(new FileInputStream("src\\Monopoly_Pics\\TopHatMan2.png"));
            ImageView topHatManView = new ImageView(topHatMan);

            introScene1.getChildren().addAll(monopolyLogoView, topHatManView);
        }catch(Exception eee){System.out.println("Files were not found");}
        //////////////////////Sets up the intro pics to the game



        //////////////////////Sets up intro dialogue to the game
        Label setRulesText = new Label("Hello! Welcome to the game of Monopoly! \n The next page will give you a set of rules that can be changed to your liking. \n (Defaults requirements already set unless changed)");
        setRulesText.setFont(Font.font(("Verdana"), FontWeight.BOLD, 26));
        //////////////////////Sets up intro dialogue to the game



        VBox introVBox = new VBox();//Add as top
        introVBox.getChildren().addAll(introScene1,setRulesText);
        introScene1.setAlignment(Pos.CENTER);
        setRulesText.setTextAlignment((TextAlignment.CENTER));
        /////////////////////////////////////////////////////////////Top Section




        /////////////////////////////////////////////////////////////Middle Section
        ///////////////Continue Button
        //
        Label continueText = new Label("Continue");
        continueText.setFont(Font.font(("Verdana"), FontWeight.BOLD, 60));
        Button continueButton = new Button("",continueText);
        continueButton.setOnAction(e -> window.setScene(scene2));
        //
        VBox ruleVBox = new VBox();
        ruleVBox.getChildren().addAll(continueButton);

        //
        ///////////////Continue Button
        /////////////////////////////////////////////////////////////Middle Section
        //////////////////////////////////////////////////////////////////////////////////////////////////////Scene1

        BorderPane mainPane1 = new BorderPane();
        mainPane1.setTop(introVBox);
        introVBox.setAlignment(Pos.CENTER);
        mainPane1.setCenter(ruleVBox);
        ruleVBox.setAlignment((Pos.CENTER));
        //mainPane1.setBottom(continueButton);
        //mainPane1.setAlignment(continueButton, Pos.TOP_CENTER);


        scene1 = new Scene(mainPane1, 1280, 720);
        mainPane1.setStyle("-fx-background-color: #9FFF9F;");
        mainPane1.setPadding(new Insets(10,10,10,10));

        //////////////////////////////////////////////////////////////////////////////////////////////////////Scene1
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////Scene2
        /////////////////////////////////////////////////////////////Top Section
        Text topTextScene2 = new Text("Rule Selection");
        topTextScene2.setFont(Font.font(("Verdana"), FontWeight.BOLD, 40));


        HBox topScene2 = new HBox();//Add as top
        topScene2.getChildren().addAll(topTextScene2);
        topScene2.setPadding(new Insets(10,15,10,15));
        topScene2.setAlignment(Pos.TOP_CENTER);
        /////////////////////////////////////////////////////////////Top Section



        /////////////////////////////////////////////////////////////Middle Section
        ///////////////First Rule
        //
        Text rule1Text = new Text("Would you like to limit the game to 10 turns?");
        rule1Text.setFont(Font.font(("Verdana"), 20));
        //

        //
        CheckBox r1Yes = new CheckBox("Yes");
        r1Yes.setSelected(true);
        CheckBox r1No = new CheckBox("No");

        r1Yes.selectedProperty().addListener(e ->{
            if(r1Yes.isSelected()){
                r1No.setSelected(false);
            }else{r1No.setSelected(true);}
        });
        r1No.selectedProperty().addListener(e ->{
            if(r1No.isSelected()){
                r1Yes.setSelected(false);
            }else{r1Yes.setSelected(true);}
        });


        VBox rule1Checks = new VBox();
        rule1Checks.getChildren().addAll(r1Yes,r1No);
        rule1Checks.setPadding(new Insets(10,15,10,15));
        //


        HBox rule1 = new HBox();
        rule1.getChildren().addAll(rule1Text,rule1Checks);
        rule1.setPadding(new Insets(10,10,10,10));
        ///////////////First Rule



        ///////////////Second Rule
        //
        Text rule2Text = new Text("Would you like to enable trading and selling?");
        rule2Text.setFont(Font.font(("Verdana"), 20));
        //

        //
        CheckBox r2Yes = new CheckBox("Yes");

        CheckBox r2No = new CheckBox("No");
        r2No.setSelected(true);

        r2Yes.selectedProperty().addListener(e ->{
            if(r2Yes.isSelected()){
                r2No.setSelected(false);
            }else{r2No.setSelected(true);}
        });
        r2No.selectedProperty().addListener(e ->{
            if(r2No.isSelected()){
                r2Yes.setSelected(false);
            }else{r2Yes.setSelected(true);}
        });


        VBox rule2Checks = new VBox();
        rule2Checks.getChildren().addAll(r2Yes,r2No);
        rule2Checks.setPadding(new Insets(10,15,10,15));
        //


        HBox rule2 = new HBox();
        rule2.getChildren().addAll(rule2Text,rule2Checks);
        rule2.setPadding(new Insets(10,10,10,10));
        ///////////////Second Rule



        ///////////////Third Rule
        //
        Text rule3Text = new Text("Would you like to enable a bonus for landing on GO? (+200)");
        rule3Text.setFont(Font.font(("Verdana"), 20));
        //

        //
        CheckBox r3Yes = new CheckBox("Yes");

        CheckBox r3No = new CheckBox("No");
        r3No.setSelected(true);

        r3Yes.selectedProperty().addListener(e ->{
            if(r3Yes.isSelected()){
                r3No.setSelected(false);
            }else{r3No.setSelected(true);}
        });
        r3No.selectedProperty().addListener(e ->{
            if(r3No.isSelected()){
                r3Yes.setSelected(false);
            }else{r3Yes.setSelected(true);}
        });


        VBox rule3Checks = new VBox();
        rule3Checks.getChildren().addAll(r3Yes,r3No);
        rule3Checks.setPadding(new Insets(10,15,10,15));
        //


        HBox rule3 = new HBox();
        rule3.getChildren().addAll(rule3Text,rule3Checks);
        rule3.setPadding(new Insets(10,10,10,10));
        ///////////////Third Rule



        ///////////////Fourth Rule
        //
        Text rule4Text = new Text("Would you like to fund free parking with tax collection?");
        rule4Text.setFont(Font.font(("Verdana"), 20));
        //

        //
        CheckBox r4Yes = new CheckBox("Yes");

        CheckBox r4No = new CheckBox("No");
        r4No.setSelected(true);

        r4Yes.selectedProperty().addListener(e ->{
            if(r4Yes.isSelected()){
                r4No.setSelected(false);
            }else{r4No.setSelected(true);}
        });
        r4No.selectedProperty().addListener(e ->{
            if(r4No.isSelected()){
                r4Yes.setSelected(false);
            }else{r4Yes.setSelected(true);}
        });


        VBox rule4Checks = new VBox();
        rule4Checks.getChildren().addAll(r4Yes,r4No);
        rule4Checks.setPadding(new Insets(10,15,10,15));
        //


        HBox rule4 = new HBox();
        rule4.getChildren().addAll(rule4Text,rule4Checks);
        rule4.setPadding(new Insets(10,10,10,10));
        ///////////////Fourth Rule



        ///////////////Fifth Rule
        //
        Text rule5Text = new Text("Would you like to randomize game piece assignment?");
        rule5Text.setFont(Font.font(("Verdana"), 20));
        //

        //
        CheckBox r5Yes = new CheckBox("Yes");
        r5Yes.setSelected(true);
        CheckBox r5No = new CheckBox("No");


        r5Yes.selectedProperty().addListener(e ->{
            if(r5Yes.isSelected()){
                r5No.setSelected(false);
            }else{r5No.setSelected(true);}
        });
        r5No.selectedProperty().addListener(e ->{
            if(r5No.isSelected()){
                r5Yes.setSelected(false);
            }else{r5Yes.setSelected(true);}
        });


        VBox rule5Checks = new VBox();
        rule5Checks.getChildren().addAll(r5Yes,r5No);
        rule5Checks.setPadding(new Insets(10,15,10,15));
        //


        HBox rule5 = new HBox();
        rule5.getChildren().addAll(rule5Text,rule5Checks);
        rule5.setPadding(new Insets(10,10,10,10));
        ///////////////Fifth Rule



        ///////////////Sixth Rule
        //
        Text rule6Text = new Text("How many players do you want to have in the game?");
        rule6Text.setFont(Font.font(("Verdana"), 20));
        //

        //
        Slider slider = new Slider();
        slider.setMin(2);
        slider.setMax(5);
        slider.setValue(5);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setBlockIncrement(1);
        slider.setSnapToTicks(true);
        slider.setPadding(new Insets(10,15,10,15));
        //


        HBox rule6 = new HBox();
        rule6.getChildren().addAll(rule6Text,slider);
        rule6.setPadding(new Insets(10,10,10,10));
        ///////////////Sixth Rule



        ///////////////Seventh Rule
        //
        Text rule7Text = new Text("How much starting cash would you like each player to have?");
        rule7Text.setFont(Font.font(("Verdana"), 20));
        //

        //
        Slider slider2 = new Slider();
        slider2.setMin(1500);
        slider2.setMax(3000);
        slider2.setValue(1500);
        slider2.setShowTickLabels(true);
        slider2.setShowTickMarks(true);
        slider2.setMajorTickUnit(500);
        slider2.setMinorTickCount(0);
        slider2.setBlockIncrement(500);
        slider2.setSnapToTicks(true);
        slider2.setPadding(new Insets(10,15,10,15));
        //


        HBox rule7 = new HBox();
        rule7.getChildren().addAll(rule7Text,slider2);
        rule7.setPadding(new Insets(10,10,10,10));
        ///////////////Seventh Rule




        ///////////////Eighth Rule
        //
        Text rule8Text = new Text("How many turns of jail time would you like?");
        rule8Text.setFont(Font.font(("Verdana"), 20));
        //

        //
        Slider slider3 = new Slider();
        slider3.setMin(1);
        slider3.setMax(5);
        slider3.setValue(1);
        slider3.setShowTickLabels(true);
        slider3.setShowTickMarks(true);
        slider3.setMajorTickUnit(1);
        slider3.setMinorTickCount(0);
        slider3.setBlockIncrement(1);
        slider3.setSnapToTicks(true);
        slider3.setPadding(new Insets(10,15,10,15));
        //


        HBox rule8 = new HBox();
        rule8.getChildren().addAll(rule8Text,slider3);
        rule8.setPadding(new Insets(10,10,10,10));
        ///////////////Seventh Rule




        ////////////////Continue to Name Selection
        Label continueToGameLabel = new Label("Continue");
        continueText.setFont(Font.font(("Verdana"), FontWeight.BOLD, 20));
        Button continueToGame = new Button("",continueToGameLabel);
        ///////Leaps to next Method when button is pressed
        continueToGame.setOnAction(e -> setupNameAndGamePieceGUI(r1Yes.isSelected(),r2Yes.isSelected(),r3Yes.isSelected(),
                r4Yes.isSelected(),r5Yes.isSelected(),((int)slider.getValue()),((int)slider2.getValue()),((int)slider3.getValue())));
        ///////Leaps to next Method when button is pressed
        ////////////////Continue to Name Selection




        //Adding Rules Here
        VBox center1 = new VBox();//Add as Center
        center1.getChildren().addAll(rule1, rule2, rule3, rule4, rule5, rule6, rule7, rule8, continueToGame);
        rule1.setAlignment(Pos.CENTER);
        rule2.setAlignment(Pos.CENTER);
        rule3.setAlignment(Pos.CENTER);
        rule4.setAlignment(Pos.CENTER);
        rule5.setAlignment(Pos.CENTER);
        rule6.setAlignment(Pos.CENTER);
        rule7.setAlignment(Pos.CENTER);
        rule8.setAlignment(Pos.CENTER);
        continueToGame.setAlignment(Pos.CENTER);
        /////////////////////////////////////////////////////////////Middle Section
        //////////////////////////////////////////////////////////////////////////////////////////////////////Scene2

        BorderPane mainPane2 = new BorderPane();
        mainPane2.setTop(topScene2);
        topScene2.setAlignment(Pos.CENTER);
        mainPane2.setCenter(center1);
        center1.setAlignment((Pos.CENTER));

        scene2 = new Scene(mainPane2, 1280, 720);
        mainPane2.setStyle("-fx-background-color: #9FFF9F;");
        mainPane2.setPadding(new Insets(10,10,10,10));
        //////////////////////////////////////////////////////////////////////////////////////////////////////Scene2
        window.setScene(scene1);
        window.show();
    }



    /////////////////////////////////
    // This is the last scene before
    // the game board appears and
    // allows the users to set their
    // names and their icons if
    // chosen to using the rulesGUI()
    // earlier.
    /////////////////////////////////
    private void setupNameAndGamePieceGUI(boolean turnLimitTen, boolean tradingSelling, boolean landingOnGoBonus,
                                          boolean FreeParkingTaxFund, boolean randomGamePieces, int numberOfPlayers,
                                          int startingCash, int jailTime)
    {
        setRules(turnLimitTen,tradingSelling,landingOnGoBonus,FreeParkingTaxFund,randomGamePieces,
                numberOfPlayers,startingCash,jailTime);

        Label label, label2 = new Label(), label3 = new Label(), label4;
        ComboBox comboBox = new ComboBox();
        ComboBox comboBox1;


        //Will allow setting of game piece depending on past choice
        if(randomGamePieces)
        {
            label = new Label("Please enter Player 1's name:");
        }else {
            label = new Label("Please enter your name below and then choose your game piece.");

            //list for dropdown menu
            ObservableList<String> options =
                    FXCollections.observableArrayList(
                            "Boot",
                            "Thimble",
                            "Battleship",
                            "Top Hat",
                            "Racecar"
                    );
            comboBox = new ComboBox(options);
            comboBox.getSelectionModel().selectFirst();



            //Label for name entry
            label3.setText("Player 1's Name:");
            label3.setTextAlignment(TextAlignment.CENTER);
            label3.setFont(Font.font(("Verdana"), FontWeight.BOLD, 15));

            //Label for game piece selection menu
            label2.setText("Game Piece:");
            label2.setTextAlignment(TextAlignment.CENTER);
            label2.setFont(Font.font(("Verdana"), FontWeight.BOLD, 15));

        }
        //setup for main text on page that allows choosing of name and game piece
        label.setTextAlignment(TextAlignment.CENTER);
        label.setFont(Font.font(("Verdana"), FontWeight.BOLD, 25));


        //Text Field to enter a name. Default is "Name"
        TextField nameArea = new TextField("Name");
        nameArea.setAlignment(Pos.CENTER);
        nameArea.setMaxSize(120,30);



        comboBox1 = comboBox;
        playerCounter = 0;

        //label for button and button creation and button actions
        label4 = new Label("Continue");
        label4.setFont(Font.font(("Verdana"), FontWeight.BOLD, 20));
        Button continueToGame = new Button("",label4);//button that continues to the game

        continueToGame.setOnAction(e -> {
            if(((playerCounter) <= numberOfPlayers)) {
                if (randomGamePieces) {
                    setupPlayersAndGamePieces(playerCounter, nameArea.getText(),startingCash);
                    nameArea.setText("Name");
                    playerCounter++;
                    if(playerCounter== numberOfPlayers){
                        player1.setCurrentSpace(monopolyBoard);
                        player2.setCurrentSpace(monopolyBoard);
                        if(player3 != null)
                        {
                            player3.setCurrentSpace(monopolyBoard);
                        }
                        if(player4 != null)
                        {
                            player4.setCurrentSpace(monopolyBoard);
                        }
                        if(player5 != null)
                        {
                            player5.setCurrentSpace(monopolyBoard);
                        }
                        playGameGUI();
                    }
                    else {
                        label.setText(("Please enter Player " + (playerCounter+1) + "'s name:"));
                        if (numberOfPlayers == (playerCounter+1)) {
                            label4.setText("Continue to game!");
                        }
                    }

                    //e.consume();
                } else {
                    String tempName = comboBox1.getValue().toString();
                    setupPlayersAndGamePieces(playerCounter, nameArea.getText(),tempName,startingCash);
                    ObservableList<String> options =
                            FXCollections.observableArrayList(
                                    "Boot",
                                    "Thimble",
                                    "Battleship",
                                    "Top Hat",
                                    "Racecar"
                            );
                    if(playerCounter == 0) {
                        options.remove(options.indexOf(player1.getGamePiece()));
                        comboBox1.setItems(options);
                        comboBox1.getSelectionModel().selectFirst();
                        label3.setText("Player 2's Name:");
                        nameArea.setText("Name");
                    } else if(playerCounter == 1){
                        options.remove(options.indexOf(player1.getGamePiece()));
                        options.remove(options.indexOf(player2.getGamePiece()));
                        comboBox1.setItems(options);
                        comboBox1.getSelectionModel().selectFirst();
                        label3.setText("Player 3's Name:");
                        nameArea.setText("Name");
                    }else if(playerCounter == 2){
                        options.remove(options.indexOf(player1.getGamePiece()));
                        options.remove(options.indexOf(player2.getGamePiece()));
                        options.remove(options.indexOf(player3.getGamePiece()));
                        comboBox1.setItems(options);
                        comboBox1.getSelectionModel().selectFirst();
                        label3.setText("Player 4's Name:");
                        nameArea.setText("Name");
                    } else if(playerCounter == 3){
                        options.remove(options.indexOf(player1.getGamePiece()));
                        options.remove(options.indexOf(player2.getGamePiece()));
                        options.remove(options.indexOf(player3.getGamePiece()));
                        options.remove(options.indexOf(player4.getGamePiece()));
                        comboBox1.setItems(options);
                        comboBox1.getSelectionModel().selectFirst();
                        label3.setText("Player 5's Name:");
                        nameArea.setText("Name");
                    }



                    if(playerCounter == numberOfPlayers-1){
                        player1.setCurrentSpace(monopolyBoard);
                        player2.setCurrentSpace(monopolyBoard);
                        if(player3 != null)
                        {
                            player3.setCurrentSpace(monopolyBoard);
                        }
                        if(player4 != null)
                        {
                            player4.setCurrentSpace(monopolyBoard);
                        }
                        if(player5 != null)
                        {
                            player5.setCurrentSpace(monopolyBoard);
                        }
                        playGameGUI();
                    }

                    else {
                        if (numberOfPlayers == (playerCounter+1)) {
                            label4.setText("Continue to game!");
                        }
                        playerCounter++;
                    }
                    //e.consume();
                }
            }

        });

        continueToGame.setPadding(new Insets(20,20,20,20));







        ImageView topHatMan= new ImageView();
        //Adding Picture to make things more exciting
        try {
            Image monopolyLogo = new Image(new FileInputStream("src\\Monopoly_Pics\\TopHatMan.png"));
            topHatMan = new ImageView(monopolyLogo);
        }catch(Exception e){System.out.println("A file did not load");}
        //






        HBox name = new HBox();
        name.setPadding(new Insets(20,20,20,20));
        HBox game = new HBox();
        game.setPadding(new Insets(20,20,20,20));


        VBox nameGame = new VBox();
        nameGame.setPadding(new Insets(20,20,20,20));

        if (randomGamePieces)
        {

            nameGame.getChildren().addAll(topHatMan,label,nameArea,continueToGame);
            label.setTextAlignment(TextAlignment.CENTER);
            nameArea.setAlignment(Pos.CENTER);
        }else{
            name.getChildren().addAll(label3, nameArea);
            game.getChildren().addAll(label2,comboBox);

            nameGame.getChildren().addAll(topHatMan,name,game,continueToGame);
            name.setAlignment(Pos.CENTER);
            game.setAlignment(Pos.CENTER);
        }




        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(nameGame);
        nameGame.setAlignment(Pos.CENTER);

        mainPane.setStyle("-fx-background-color: #65CCFF;");
        mainPane.setPadding(new Insets(10,10,10,10));


        scene3 = new Scene(mainPane, 500, 720);
        window.setScene(scene3);
        window.centerOnScreen();
        //playGameGUI();
    }



    /////////////////////////////////
    // These are methods that setup the
    // players and their game pieces.
    // there are a few other things that
    // happen within but these are helpers
    // for setting up
    /////////////////////////////////
    private int setupPlayersAndGamePieces(int counter, String name, int startingCash)
    {
        BufferedReader br = readFileIn("Text_Files\\pieces.txt");
        String tempString;
        String tempArray[] = new String[5];
        int temp = 0;
        int count = 0;
        Random rand = new Random();

        try {
            while (((tempString = br.readLine()) != null)) {
                tempArray[count] = tempString;
                count++;
                }
            }catch(Exception e){System.out.println("There was and error reading the game piece text file");}


            if(counter == 0) {
                temp = rand.nextInt(5);
                player1 = new Player(name, tempArray[temp],startingCash);
            }else if(counter == 1){
                temp = rand.nextInt(5);
                while(tempArray[temp].equals(player1.getGamePiece()))
                    temp = rand.nextInt(5);
                player2 = new Player(name, tempArray[temp],startingCash);
            }else if(counter == 2){
                temp = rand.nextInt(5);
                while(tempArray[temp].equals(player1.getGamePiece()) || tempArray[temp].equals(player2.getGamePiece()))
                    temp = rand.nextInt(5);
                player3 = new Player(name, tempArray[temp],startingCash);
            } else if(counter == 3){
                temp = rand.nextInt(5);
                while(tempArray[temp].equals(player1.getGamePiece()) || tempArray[temp].equals(player2.getGamePiece()) || tempArray[temp].equals(player3.getGamePiece()))
                    temp = rand.nextInt(5);
                player4 = new Player(name, tempArray[temp],startingCash);
            }else if(counter == 4){
                temp = rand.nextInt(5);
                while(tempArray[temp].equals(player1.getGamePiece()) || tempArray[temp].equals(player2.getGamePiece()) || tempArray[temp].equals(player3.getGamePiece()) || tempArray[temp].equals(player4.getGamePiece()))
                    temp = rand.nextInt(5);
                player5 = new Player(name, tempArray[temp],startingCash);
            }else{return counter++;}


        try {
            br.close();
        }catch(Exception e){System.out.println("Text file failed to close.");}

        return (counter++);
    }

    /////////////////////////////////
    private int setupPlayersAndGamePieces(int counter, String name, String gamePiece, int startingCash)
    {
        if(counter == 0) {
            player1 = new Player(name,gamePiece,startingCash);
        } else if(counter == 1) {
            player2 = new Player(name,gamePiece,startingCash);
        }else if(counter == 2) {
            player3 = new Player(name,gamePiece,startingCash);
        }else if(counter == 3) {
            player4 = new Player(name,gamePiece,startingCash);
        }else if(counter == 4) {
            player5 = new Player(name,gamePiece,startingCash);
        }


        return (counter++);
    }





    /////////////////////////////////
    // This sets up the actual game
    // area. With a lot of helpers
    // and their helpers below.
    /////////////////////////////////
    private void playGameGUI()
    {
        setInitialGameScene();
    }
    private void setInitialGameScene()
    {


        sidePanelSetup();
        diceSetup();
        topPanelSetup();


        setupPlayerPieces();

        ////////////////////////////////////////Organizes grid section for whole layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.getColumnConstraints().add(new ColumnConstraints(280));


        grid.getRowConstraints().add(new RowConstraints(90));
        grid.getRowConstraints().add(new RowConstraints(90));
        grid.getRowConstraints().add(new RowConstraints(600));
        ////////////////////////////////////////Organizes grid section for whole layout




        /////////////////////////////////////////////////////////////////////////////////////////////////////Game Board
        String cssBackground2 =
                "-fx-background-image: url(Monopoly_Pics/Monopoly_Game_Board2.jpg);\n" +
                        "    -fx-background-repeat: stretch;\n" +
                        "    -fx-background-size:700 700;\n" +
                        "    -fx-background-position: center center;\n" +
                        "    -fx-effect: dropshadow(three-pass-box, black, 30, 0.5, 0, 0);\n";


        backgroundPane = new GridPane();
        backgroundPane.setStyle(cssBackground2);
        backgroundPane.setGridLinesVisible(true);



        ////////////////////////////////////////////////////////////////////////////////Adds all rows and columns
        int bigSideColumn = 69;
        int littleSideColumn = 20;
        int regularColumn = 57;
        int bigSideRow = 76;
        int littleSideRow = 20;
        int regularRow = 57;
        int balance = 0;

        backgroundPane.getColumnConstraints().add(new ColumnConstraints(bigSideColumn));
        backgroundPane.getColumnConstraints().add(new ColumnConstraints(littleSideColumn));
        for(int i = 0; i < 9; i++)
        {
            if(i > 4){
                balance = 1;
                if(i == 5){balance = 2;}
            }
            backgroundPane.getColumnConstraints().add(new ColumnConstraints(regularColumn+balance));
        }
        backgroundPane.getColumnConstraints().add(new ColumnConstraints(littleSideColumn));
        backgroundPane.getColumnConstraints().add(new ColumnConstraints(bigSideColumn));

        balance = 0;

        backgroundPane.getRowConstraints().add(new RowConstraints(bigSideRow));
        backgroundPane.getRowConstraints().add(new RowConstraints(littleSideRow));
        for(int i = 0; i < 9; i++)
        {
            if(i > 4){
                balance = 1;
            }
            if(i == 5){balance = 2;}
            backgroundPane.getRowConstraints().add(new RowConstraints(regularRow+balance));
        }
        backgroundPane.getRowConstraints().add(new RowConstraints(littleSideRow));
        backgroundPane.getRowConstraints().add(new RowConstraints(bigSideRow));
        ////////////////////////////////////////////////////////////////////////////////Adds all rows and columns
        /////////////////////////////////////////////////////////////////////////////////////////////////////Game Board









        //////////////////////////////////////////////////////////////////////////////////Setting Outer Pane
        GridPane.setConstraints(topRowBox,1,0,1,1);
        GridPane.setConstraints(diceVBox,0,0,1,2);
        GridPane.setConstraints(backgroundPane,1,1,1,3);
        GridPane.setConstraints(sidePanelVBox, 0,2, 1,2);


        grid.getChildren().addAll(diceVBox,backgroundPane,topRowBox,sidePanelVBox);
        String cssBackground1 =
                "-fx-background-image: url(Monopoly_Pics/SceneBackground.jpg);\n" +
                        "    -fx-background-repeat: stretch;\n" +
                        "    -fx-background-size:cover;\n" +
                        "    -fx-background-position: center center;\n" +
                        "    -fx-effect: dropshadow(three-pass-box, black, 30, 0.5, 0, 0);\n";
        grid.setStyle(cssBackground1);
        //////////////////////////////////////////////////////////////////////////////////Setting Outer Pane




        scene4 = new Scene(grid, 1020, 830);
        window.setScene(scene4);
        window.centerOnScreen();
        window.setResizable(false);
    }





    /////////////////////////////////
    // This sets up the top panel of
    // the game area and has a couple
    // helpers below.
    /////////////////////////////////
    private void topPanelSetup()
    {

        //////////////////////////////////////Player Icons
        Label iconLabel = new Label("Players:");
        iconLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 20));
        iconLabel.setPadding(new Insets(20,20,20,20));
        iconLabel.setTextAlignment(TextAlignment.CENTER);



        Image icon12;
        Image icon22;
        Image icon32;
        Image icon42;
        Image icon52;



        iconOne = new BorderPane();
        iconTwo = new BorderPane();
        iconThree = new BorderPane();
        iconFour = new BorderPane();
        iconFive = new BorderPane();

        setupPlayerIcons();
        //////////////////////////////////////Player Icons



        //////////////////////////////////////Settings Button
        Label topRowLabel = new Label("Settings");
        topRowLabel.setTextAlignment(TextAlignment.RIGHT);
        topRowLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 25));

        //Decorating button
        String cssBordering3 = "-fx-border-color:black ; \n" //#090a0c
                + "-fx-border-insets:3;\n"
                + "-fx-border-radius:7;\n"
                + "-fx-border-width:1.0";
        //

        Button settingsButton = new Button("",topRowLabel);
        settingsButton.setPadding(new Insets(25,25,25,25));
        settingsButton.setStyle(cssBordering3);


        HBox settingsButtonHBox = new HBox();
        settingsButtonHBox.getChildren().add(settingsButton);
        settingsButtonHBox.setPadding(new Insets(0,0,0,20));


        HBox playerIconBox = new HBox();
        playerIconBox.getChildren().addAll(iconLabel,iconOne,iconTwo,iconThree,iconFour,iconFive);
        playerIconBox.setStyle("-fx-background-color: #00DEFF; -fx-border-color: #FF0000; -fx-border-width: 5px");
        playerIconBox.setMaxSize(500,90);
        playerIconBox.setMinSize(500,90);
        playerIconBox.setPadding(new Insets(5,5,5,5));
        //////////////////////////////////////Settings Button






        ////Contains the player icon section and the settings button
        topRowBox = new HBox();
        topRowBox.getChildren().addAll(playerIconBox,settingsButtonHBox);
        ////



    }



    /////////////////////////////////
    // This sets up the player icons
    // inside of the top panel. They
    // are set up in player order
    // every time the game starts
    /////////////////////////////////
    private void setupPlayerIcons()
    {
        //CSS decorating for icons
        String cssBordering1 = "-fx-border-color:black ; \n" //#090a0c
                + "-fx-border-insets:3;\n"
                + "-fx-border-radius:7;\n"
                + "-fx-border-width:1.0";
        String cssBordering2 = "-fx-border-color:red ; \n" //#090a0c
                + "-fx-border-insets:3;\n"
                + "-fx-border-radius:7;\n"
                + "-fx-border-width:1.0";
        //
        try {
            ImageView icon1 = new ImageView(new Image(new FileInputStream("src\\Monopoly_Pics\\" + player1.getGamePiece() + ".jpg")));
            iconOne.setCenter(icon1);
            iconOne.setMaxHeight(icon1.getFitHeight()+5);
            iconOne.setMaxWidth(icon1.getFitWidth()+5);
            iconOne.setStyle(cssBordering1);
            ImageView icon2 = new ImageView(new Image(new FileInputStream("src\\Monopoly_Pics\\" + player2.getGamePiece() + ".jpg")));
            iconTwo.setCenter(icon2);
            iconTwo.setMaxHeight(icon2.getFitHeight()+5);
            iconTwo.setMaxWidth(icon2.getFitWidth()+5);
            iconTwo.setStyle(cssBordering2);
            if(!(player3 == null)) {
                ImageView icon3 = new ImageView(new Image(new FileInputStream("src\\Monopoly_Pics\\" + player3.getGamePiece() + ".jpg")));
                iconThree.setCenter(icon3);
                iconThree.setMaxHeight(icon3.getFitHeight()+5);
                iconThree.setMaxWidth(icon3.getFitWidth()+5);
                iconThree.setStyle(cssBordering1);
            }
            if(!(player4 == null)) {
                ImageView icon4 = new ImageView(new Image(new FileInputStream("src\\Monopoly_Pics\\" + player4.getGamePiece() + ".jpg")));
                iconFour.setCenter(icon4);
                iconFour.setMaxHeight(icon4.getFitHeight()+5);
                iconFour.setMaxWidth(icon4.getFitWidth()+5);
                iconFour.setStyle(cssBordering2);
            }
            if(!(player5 == null)) {
                ImageView icon5 = new ImageView(new Image(new FileInputStream("src\\Monopoly_Pics\\" + player5.getGamePiece() + ".jpg")));
                iconFive.setCenter(icon5);
                iconFive.setMaxHeight(icon5.getFitHeight()+5);
                iconFive.setMaxWidth(icon5.getFitWidth()+5);
                iconFive.setStyle(cssBordering1);
            }
        }catch(Exception e){System.out.println("There was an error retrieving an icon image");}
    }









    /////////////////////////////////
    // This sets up the side panel of
    // the game area and has some
    // helpers below
    /////////////////////////////////
    private void sidePanelSetup()
    {



        //Roll Dice Button
        Label rollDiceLabel = new Label("Roll Dice");
        rollDiceLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 25));

        Button rollDice = new Button("",rollDiceLabel);
        rollDice.setPadding(new Insets(15,45,15,45));
        rollDice.setOnAction(e -> {
            if(!diceRolled) {
                rollDice();
                updatePlayerLocation((dice1Value + dice2Value));
                movePiece();
                checkSquare();
            }
        });
        HBox rollDiceButtonBox = new HBox();//add to side panel
        rollDiceButtonBox.getChildren().addAll(rollDice);
        rollDiceButtonBox.setPadding(new Insets(10,10,10,10));
        //Roll Dice Button


        //End Turn Button
        Label endTurnLabel = new Label("End Turn");
        endTurnLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 25));

        Button endTurn = new Button("",endTurnLabel);
        endTurn.setPadding(new Insets(15,45,15,45));

        HBox endTurnButtonBox = new HBox();//add to side panel
        endTurnButtonBox.getChildren().addAll(endTurn);
        endTurnButtonBox.setPadding(new Insets(10,10,10,10));
        endTurn.setOnAction(e -> {
            endPlayerTurn();
            //System.out.println("hello this is bad");
        });
        //End Turn Button



        //Action log that records what happens
        TextArea actionLog = new TextArea();
        actionLog.setEditable(false);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        actionLog.setText(timestamp.toString());
        actionLog.setPadding(new Insets(5,5,5,5));

        VBox actionLogVBox = new VBox();
        actionLogVBox.getChildren().addAll(actionLog);
        actionLogVBox.setAlignment(Pos.CENTER);
        actionLogVBox.setPadding(new Insets(10,10,20,10));
        actionLogVBox.setMaxSize(240,50);
        actionLogVBox.setMinSize(240,50);
        //Action log that records what happens





        //Money Amount
        Label money = new Label("Money: ");
        money.setFont(Font.font(("Verdana"), FontWeight.BOLD, 20));
        money.setTextAlignment(TextAlignment.CENTER);

        moneyAmount = new Label("$" + Integer.toString(player1.getMoney()));
        moneyAmount.setFont(Font.font(("Verdana"), 15));
        moneyAmount.setTextAlignment(TextAlignment.CENTER);

        HBox moneyHBox = new HBox();
        moneyHBox.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #FF0000; -fx-border-width: 5px");
        moneyHBox.getChildren().addAll(money, moneyAmount);
        moneyHBox.setMaxSize(195,50);
        moneyHBox.setMinSize(195,50);
        moneyHBox.setAlignment(Pos.CENTER);

        VBox moneyVBox = new VBox();//add to side panel
        moneyVBox.getChildren().addAll(moneyHBox);
        moneyVBox.setPadding(new Insets(10,20,10,20));
        //Money Amount






        Label propertyLabel = new Label("Owned Properties:");
        propertyLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 15));

        HBox propertyLabelHBox = new HBox();
        propertyLabelHBox.getChildren().add(propertyLabel);
        propertyLabelHBox.setStyle("-fx-background-color: #FFF; -fx-border-color: #FF0000; -fx-border-width: 5px");
        propertyLabelHBox.setPadding(new Insets(5,5,5,5));













        propertyGrid = new GridPane();
        propertyGrid.setPadding(new Insets(30, 5,40,5));
        propertyGrid.setMaxSize(210, 220);
        propertyGrid.setMinSize(210, 220);
        propertyGrid.setAlignment(Pos.CENTER);
        propertyGrid.setStyle("-fx-background-color: #DEDEDE; -fx-border-color: #FFF; -fx-border-width: 5px");
        propertyGrid.setHgap(5);
        propertyGrid.setVgap(10);





        propertyGrid.add(square1, 0,1);
        propertyGrid.add(square2, 1,1);
        propertyGrid.add(square3, 2,1);
        propertyGrid.add(square4, 3,1);
        propertyGrid.add(square5, 4,1);
        propertyGrid.add(square6, 5,1);

        propertyGrid.add(square7, 0,2);
        propertyGrid.add(square8, 1,2);
        propertyGrid.add(square9, 2,2);
        propertyGrid.add(square10, 3,2);
        propertyGrid.add(square11, 4,2);
        propertyGrid.add(square12, 5,2);

        propertyGrid.add(square13, 0,3);
        propertyGrid.add(square14, 1,3);
        propertyGrid.add(square15, 2,3);
        propertyGrid.add(square16, 3,3);
        propertyGrid.add(square17, 4,3);
        propertyGrid.add(square18, 5,3);

        propertyGrid.add(square19, 0,4);
        propertyGrid.add(square20, 1,4);
        propertyGrid.add(square21, 2,4);
        propertyGrid.add(square22, 3,4);
        propertyGrid.add(square23, 4,4);
        propertyGrid.add(square24, 5,4);

        propertyGrid.add(square25, 1,5);
        propertyGrid.add(square26, 2,5);
        propertyGrid.add(square27, 3,5);
        propertyGrid.add(square28, 4,5);

        fillPropertyBox(player1);


        //VBox for the property display
        VBox propertyVBox = new VBox();//Add to side panel
        propertyVBox.getChildren().addAll(propertyLabelHBox, propertyGrid);
        propertyVBox.setAlignment(Pos.CENTER);
        propertyVBox.setStyle("-fx-background-color: #FFF; -fx-border-color: #FF0000; -fx-border-width: 5px");
        propertyVBox.setPadding(new Insets(10,10,10,10));
        //







        //Side Panel
        sidePanelVBox = new VBox();//add to grid
        sidePanelVBox.setStyle("-fx-background-color: #00DEFF; -fx-border-color: #FF0000; -fx-border-width: 5px");
        sidePanelVBox.setMaxSize(270,600);
        sidePanelVBox.setMinSize(270,600);
        sidePanelVBox.getChildren().addAll(rollDiceButtonBox,endTurnButtonBox,moneyVBox,actionLogVBox,propertyVBox);
        sidePanelVBox.setPadding(new Insets(10,10,10,10));
        rollDiceButtonBox.setAlignment(Pos.CENTER);
        endTurnButtonBox.setAlignment(Pos.CENTER);
        moneyVBox.setAlignment(Pos.CENTER);
        //Side Panel



    }


    /////////////////////////////////
    // This helps set up the dice
    // inside of the side panel
    /////////////////////////////////
    private void diceSetup()
    {
        dice1= new ImageView();
        dice2= new ImageView();
        try {
            Image dice12 = new Image(new FileInputStream("src\\Monopoly_Pics\\Dice_1.gif"));
            dice1 = new ImageView(dice12);
            Image dice22 = new Image(new FileInputStream("src\\Monopoly_Pics\\Dice_1.gif"));
            dice2 = new ImageView(dice22);
        }catch(Exception e){System.out.println("A file did not load");}

        diceLabel = new Label((player1.getPlayerName() +"'s Turn:"));
        diceLabel.setTextAlignment(TextAlignment.RIGHT);
        diceLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 20));
        diceLabel.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #FF0000; -fx-border-width: 5px");
        diceLabel.setMaxSize(270,125);
        diceLabel.setPadding(new Insets(5,5,5,5));



        HBox diceBox = new HBox();
        diceBox.setAlignment(Pos.TOP_LEFT);
        diceBox.getChildren().addAll(dice1,dice2);
        diceBox.setPadding(new Insets(5,5,5,5));
        diceBox.setStyle("-fx-background-color: #00DEFF; -fx-border-color: #FF0000; -fx-border-width: 5px");
        diceBox.setMaxSize(270,145);
        diceBox.setMinSize(270,145);

        ////Box Contains signal for player's turn and the dice Box
        diceVBox = new VBox();
        diceVBox.getChildren().addAll(diceLabel, diceBox);
        ////
    }




    /////////////////////////////////
    // This fills up and updates the
    // property box with all of the
    // players properties when called
    //
    // This is sort of a setup and
    // updating method
    /////////////////////////////////
    private void fillPropertyBox(Player player)
    {
        Square [] temp = player.getOwnedProperties();


        try {
            for(int i = 0; i < 28; i++)
            {
                if(temp[i] != null) {
                    squareList[i].setImage(new Image(new FileInputStream("src\\Monopoly_Pics\\Squares\\" + (i + 1) + ".png")));
                }else{squareList[i].setImage(new Image(new FileInputStream("src\\Monopoly_Pics\\Squares\\" + 0 + ".jpg")));}
            }

        }catch(Exception e){System.out.println("There was an error reading square file");}

    }



    /////////////////////////////////
    // This fills goes through the
    // steps of ending a players turn.
    // It makes sure they have rolled
    // and when proceeding to the next
    // person, and it will skip the
    // next person's turn if they have
    // jail time
    /////////////////////////////////
    private void endPlayerTurn()
    {
        if(diceRolled)
        {
            boolean signal = false;
            turnTeller = turnTeller + 1;
            if(turnTeller == 6)
            {
                turnTeller = 1;
            }




            if(player1 != null && turnTeller == 1 && player1.getCurrentJailTime() > 0)
            {
                turnTeller++;
                player1.setCurrentJailTime(player1.getCurrentJailTime() - 1);
                System.out.println("player1 turn skipped");
            }
            if(player2 != null && turnTeller == 2 && (player2.getCurrentJailTime() > 0))
            {
                turnTeller++;
                player2.setCurrentJailTime(player2.getCurrentJailTime() - 1);
                System.out.println("player2 turn skipped");
            }
            if(player3 != null && turnTeller == 3 && (player3.getCurrentJailTime() > 0))
            {
                turnTeller++;
                player3.setCurrentJailTime(player3.getCurrentJailTime() - 1);
                System.out.println("player3 turn skipped");
            }
            if(player4 != null && turnTeller == 4 && (player4.getCurrentJailTime() > 0))
            {
                turnTeller++;
                player4.setCurrentJailTime(player4.getCurrentJailTime() - 1);
                System.out.println("player4 turn skipped");
            }
            if(player5 != null && turnTeller == 5 && (player5.getCurrentJailTime() > 0))
            {
                turnTeller++;
                player5.setCurrentJailTime((player5.getCurrentJailTime() - 1));
                System.out.println("player5 turn skipped");
            }












            do{
                if(turnTeller == 1){
                    fillPropertyBox(player1);
                    diceLabel.setText(player1.getPlayerName() + "'s Turn:");
                    updateMoneyLabel();
                    //printSquareType();
                    signal = false;
                }else if(turnTeller == 2) {
                    fillPropertyBox(player2);
                    diceLabel.setText(player2.getPlayerName() + "'s Turn:");
                    updateMoneyLabel();
                    //printSquareType();
                    signal = false;
                }else if(turnTeller == 3 && player3 != null){
                    fillPropertyBox(player3);
                    diceLabel.setText(player3.getPlayerName() + "'s Turn:");
                    updateMoneyLabel();
                    signal = false;
                }else if(turnTeller == 4 && player4 != null) {
                    fillPropertyBox(player4);
                    diceLabel.setText(player4.getPlayerName() + "'s Turn:");
                    updateMoneyLabel();
                    signal = false;
                }else if(turnTeller == 5 && player5 != null) {
                    fillPropertyBox(player5);
                    diceLabel.setText(player5.getPlayerName() + "'s Turn:");
                    updateMoneyLabel();
                    signal = false;
                }else{
                    turnTeller = 1;
                    signal = true;
                }
            }while(signal);









            diceRolled = false;

        }
        turnCounter++;
        if(rules.getTurnLimitTen() && (turnCounter == 11)) {
            Stage popupWindow = new Stage();
            Label endLabel = new Label("");
            Player playerArray [] = {player1,player2,player3,player4,player5};
            Player winner = player1;
            for(int i = 1; i < 5; i++){
                if(!(playerArray[i] == null)){
                    if(playerArray[i].getMoney() == Math.max(winner.getMoney(),playerArray[i].getMoney())){
                        winner = playerArray[i];
                    }
                }
            }

            endLabel = new Label(winner.getPlayerName() + " has won the game with $" + winner.getMoney() + "! \n Thank you for playing and have a nice day!!");



/*
            if (player1.getMoney() >= player2.getMoney() && player1.getMoney() > player3.getMoney() && player1.getMoney() > player4.getMoney() && player1.getMoney() > player5.getMoney()){
                endLabel = new Label(player1.getPlayerName() + " has won the game with $" + player1.getMoney() + "! \n Thank you for playing and have a nice day!!");
            }else if (player2.getMoney() >= player1.getMoney() && player2.getMoney() >= player3.getMoney() && player2.getMoney() >= player4.getMoney() && player2.getMoney() >= player5.getMoney()){
                endLabel = new Label(player2.getPlayerName() + " has won the game with $" + player2.getMoney() + "! \n Thank you for playing and have a nice day!!");
            }else if (player3.getMoney() >= player1.getMoney() && player3.getMoney() >= player2.getMoney() && player3.getMoney() >= player4.getMoney() && player3.getMoney() >= player5.getMoney()){
                endLabel = new Label(player2.getPlayerName() + " has won the game with $" + player2.getMoney() + "! \n Thank you for playing and have a nice day!!");
            }else if (player4.getMoney() >= player1.getMoney() && player4.getMoney() >= player2.getMoney() && player4.getMoney() >= player3.getMoney() && player4.getMoney() >= player5.getMoney()){
                endLabel = new Label(player2.getPlayerName() + " has won the game with $" + player2.getMoney() + "! \n Thank you for playing and have a nice day!!");
            }else if (player5.getMoney() >= player1.getMoney() && player5.getMoney() >= player2.getMoney() && player5.getMoney() >= player5.getMoney() && player5.getMoney() >= player4.getMoney()){
                endLabel = new Label(player2.getPlayerName() + " has won the game with $" + player2.getMoney() + "! \n Thank you for playing and have a nice day!!");
            }
*/


            endLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 24));
            endLabel.setTextAlignment(TextAlignment.CENTER);
            HBox buyLabelHBox = new HBox();
            buyLabelHBox.getChildren().addAll(endLabel);
            buyLabelHBox.setAlignment(Pos.CENTER);


            Label closeLabel = new Label("Close");
            closeLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 20));
            closeLabel.setTextAlignment(TextAlignment.CENTER);

            Button close = new Button("", closeLabel);
            close.setPadding(new Insets(10,50,10,50));
            close.setOnAction(e->{
                popupWindow.close();
                window.close();
            });


            HBox buttonsHBox = new HBox();
            buttonsHBox.getChildren().addAll(close);
            buttonsHBox.setAlignment(Pos.CENTER);


            VBox popupVBox = new VBox();
            popupVBox.getChildren().addAll(buyLabelHBox,buttonsHBox);

            BorderPane layout = new BorderPane();
            layout.setCenter(popupVBox);
            layout.setStyle("-fx-background-color: #09A99A;");

            Scene scene5 = new Scene(layout,800,200);
            popupWindow.initModality(Modality.APPLICATION_MODAL);
            popupWindow.setScene(scene5);
            popupWindow.show();
        }

    }






    /////////////////////////////////
    // This simulates a roll of 2 dice
    // that is shown in the top left
    // corner of the game scene
    /////////////////////////////////
    private void rollDice()
    {
        if(!diceRolled) {
            Random rand = new Random();
            int rand1 = rand.nextInt(6) + 1;
            int rand2 = rand.nextInt(6) + 1;

            try {
                Image diceImage;
                for (int i = 0; i < 2; i++) {
                    int tempInt;
                    if (i == 0) {
                        tempInt = rand1;
                    } else {
                        tempInt = rand2;
                    }
                    switch (tempInt) {
                        case 1:
                            diceImage = new Image(new FileInputStream("src\\Monopoly_Pics\\Dice_1.gif"));
                            if (i == 1) {
                                dice1.setImage(diceImage);
                                dice1Value = 1;
                            } else {
                                dice2.setImage(diceImage);
                                dice2Value = 1;
                            }
                            break;
                        case 2:
                            diceImage = new Image(new FileInputStream("src\\Monopoly_Pics\\Dice_2.gif"));
                            if (i == 1) {
                                dice1.setImage(diceImage);
                                dice1Value = 2;
                            } else {
                                dice2.setImage(diceImage);
                                dice2Value = 2;
                            }
                            break;
                        case 3:
                            diceImage = new Image(new FileInputStream("src\\Monopoly_Pics\\Dice_3.gif"));
                            if (i == 1) {
                                dice1.setImage(diceImage);
                                dice1Value = 3;
                            } else {
                                dice2.setImage(diceImage);
                                dice2Value = 3;
                            }
                            break;
                        case 4:
                            diceImage = new Image(new FileInputStream("src\\Monopoly_Pics\\Dice_4.gif"));
                            if (i == 1) {
                                dice1.setImage(diceImage);
                                dice1Value = 4;
                            } else {
                                dice2.setImage(diceImage);
                                dice2Value = 4;
                            }
                            break;
                        case 5:
                            diceImage = new Image(new FileInputStream("src\\Monopoly_Pics\\Dice_5.gif"));
                            if (i == 1) {
                                dice1.setImage(diceImage);
                                dice1Value = 5;
                            } else {
                                dice2.setImage(diceImage);
                                dice2Value = 5;
                            }
                            break;
                        case 6:
                            diceImage = new Image(new FileInputStream("src\\Monopoly_Pics\\Dice_6.gif"));
                            if (i == 1) {
                                dice1.setImage(diceImage);
                                dice1Value = 6;
                            } else {
                                dice2.setImage(diceImage);
                                dice2Value = 6;
                            }

                            break;
                    }
                }

            } catch (Exception e) {
                System.out.println("A file did not load");
            }
            System.out.println(dice1Value + "\n" + dice2Value);
            if(!(dice1Value == dice2Value)) {
                diceRolled = true;
            }
        }

    }




    /////////////////////////////////
    // This outputs a message after
    // the rent is taken from a player
    // to let everyone know what happened
    /////////////////////////////////
    private void rentMessage(Player play1, Player play2, int amount)
    {
        Stage popupWindow = new Stage();
        Label buyLabel = new Label();
        if(play1.getCurrentSpace().getClass().getSimpleName().equals("PropertySquare")) {
            PropertySquare temp1 = (PropertySquare)(play1.getCurrentSpace());
            if(temp1.getHouses() > 0)
            {
                buyLabel = new Label(play1.getPlayerName() + " landed on " + play1.getCurrentSpace().getName() +
                        " and had to pay " + play2.getPlayerName() + "\n$" + amount + " \nbecause it had " + temp1.getHouses() + " houses!");
            }else {
                buyLabel = new Label(play1.getPlayerName() + " landed on " + play1.getCurrentSpace().getName() +
                        " and had to pay " + play2.getPlayerName() + "\n$" + amount + " \nfor landing on their property!");
            }
        } else if(play1.getCurrentSpace().getClass().getSimpleName().equals("RailroadSquare")){
            buyLabel = new Label(play1.getPlayerName() + " landed on " + play1.getCurrentSpace().getName() +
                    " and had to pay " + play2.getPlayerName() + "\n$" + amount + " \nbecause they have" + play2.countRailRoads() + " Railroad");
        } else if(play1.getCurrentSpace().getClass().getSimpleName().equals("UtilitySquare")){
            UtilitySquare temp1 =  (UtilitySquare)play1.getCurrentSpace();
            buyLabel = new Label(play1.getPlayerName() + " landed on " + play1.getCurrentSpace().getName() +
                    " and had to pay " + play2.getPlayerName() + "\n$" + amount + " \n which is " + temp1.getMultiplierValue() + " times the amount shown on the dice!");
        }


        buyLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 24));
        buyLabel.setTextAlignment(TextAlignment.CENTER);
        HBox buyLabelHBox = new HBox();
        buyLabelHBox.getChildren().addAll(buyLabel);
        buyLabelHBox.setAlignment(Pos.CENTER);

        Label closeLabel = new Label("Close");
        buyLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 15));
        buyLabel.setTextAlignment(TextAlignment.CENTER);

        Button close = new Button("", closeLabel);
        close.setPadding(new Insets(10,50,10,50));
        close.setOnAction(e->{
            popupWindow.close();
        });


        HBox buttonsHBox = new HBox();
        buttonsHBox.getChildren().addAll(close);
        buttonsHBox.setAlignment(Pos.CENTER);


        VBox popupVBox = new VBox();
        popupVBox.getChildren().addAll(buyLabelHBox,buttonsHBox);

        BorderPane layout = new BorderPane();
        layout.setCenter(popupVBox);
        layout.setStyle("-fx-background-color: #09A99A;");

        Scene scene5 = new Scene(layout,800,100);
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setScene(scene5);
        popupWindow.show();
    }

    /////////////////////////////////
    // These three methods are
    // overloaded and will go through
    // the steps to make a player pay
    // the rent for the type of property
    // that they landed on.
    /////////////////////////////////
    private void payPlayerForProperty(Player player, RailroadSquare square)
    {
        Player tempPlayer = new Player();

        if(player1.hasProperty(square)){
            tempPlayer = player1;
        }else if(player2.hasProperty(square)){
            tempPlayer = player2;
        }else if(player3.hasProperty(square)){
            tempPlayer = player3;
        }else if(player4.hasProperty(square)){
            tempPlayer = player4;
        }else if(player5.hasProperty(square)){
            tempPlayer = player5;
        }


        if(player != tempPlayer){
            player.setMoney(player.getMoney()-square.getRent()*tempPlayer.countRailRoads());
            tempPlayer.setMoney(tempPlayer.getMoney() + square.getRent());
            rentMessage(player,tempPlayer,square.getRent()*tempPlayer.countRailRoads());
            updateMoneyLabel();
        }
    }
    /////////////////////////////////
    private void payPlayerForProperty(Player player, PropertySquare square)
    {
        Player tempPlayer = new Player();

        if(player1.hasProperty(square)){
            tempPlayer = player1;
        }else if(player2.hasProperty(square)){
            tempPlayer = player2;
        }else if(player3.hasProperty(square)){
            tempPlayer = player3;
        }else if(player4.hasProperty(square)){
            tempPlayer = player4;
        }else if(player5.hasProperty(square)){
            tempPlayer = player5;
        }


        if(player != tempPlayer){
            player.setMoney(player.getMoney()-square.getRent());
            tempPlayer.setMoney(tempPlayer.getMoney() + square.getRent());
            rentMessage(player,tempPlayer,square.getRent());
            updateMoneyLabel();
        }
    }
    /////////////////////////////////
    private void payPlayerForProperty(Player player, UtilitySquare square)
    {
        Player tempPlayer = new Player();

        if(player1.hasProperty(square)){
            tempPlayer = player1;
        }else if(player2.hasProperty(square)){
            tempPlayer = player2;
        }else if(player3.hasProperty(square)){
            tempPlayer = player3;
        }else if(player4.hasProperty(square)){
            tempPlayer = player4;
        }else if(player5.hasProperty(square)){
            tempPlayer = player5;
        }


        if(player != tempPlayer){
            player.setMoney(player.getMoney()-(square.getMultiplierValue()*(dice1Value+dice2Value)));
            tempPlayer.setMoney(tempPlayer.getMoney()+(square.getMultiplierValue()*(dice1Value+dice2Value)));
            rentMessage(player,tempPlayer,square.getMultiplierValue()*(dice1Value+dice2Value));
            updateMoneyLabel();
        }
    }



    /////////////////////////////////
    // This method will make the player
    // pay their taxes when landing on
    // specific squares. It also contains
    // the code for the popup box to
    // appear as well
    /////////////////////////////////
    private void payTaxes(Player player, TaxSquare square)
    {
        player.setMoney(player.getMoney() - square.getRent());
        updateMoneyLabel();





        Stage popupWindow = new Stage();
        Label taxLabel = new Label();
        taxLabel = new Label(player.getPlayerName() + " landed on " + square.getName() +
        " and had to pay " + square.getRent() + " in taxes!");



        taxLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 24));
        taxLabel.setTextAlignment(TextAlignment.CENTER);
        HBox taxLabelHBox = new HBox();
        taxLabelHBox.getChildren().addAll(taxLabel);
        taxLabelHBox.setAlignment(Pos.CENTER);

        Label closeLabel = new Label("Close");
        taxLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 15));
        taxLabel.setTextAlignment(TextAlignment.CENTER);

        Button close = new Button("", closeLabel);
        close.setPadding(new Insets(10,50,10,50));
        close.setOnAction(e->{
            popupWindow.close();
        });


        HBox buttonsHBox = new HBox();
        buttonsHBox.getChildren().addAll(close);
        buttonsHBox.setAlignment(Pos.CENTER);


        VBox popupVBox = new VBox();
        popupVBox.getChildren().addAll(taxLabelHBox,buttonsHBox);

        BorderPane layout = new BorderPane();
        layout.setCenter(popupVBox);
        layout.setStyle("-fx-background-color: #A9AA99;");

        Scene scene5 = new Scene(layout,800,125);
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setScene(scene5);
        popupWindow.show();









    }



    /////////////////////////////////
    // This determines the action to
    // be taken when stepping on a Square
    // of the "Square" class
    // there are various other
    // methods/functions that it
    // redirects to when it determines
    // which type of square it has
    /////////////////////////////////
    private void squareAction(Player player, Square square)
    {
        Stage popupWindow = new Stage();
        Label alertLabel = new Label();


        Random rand = new Random();
        if(square.getName().equals("Chance")){
            String temp = chance[rand.nextInt(5)];
            if(temp.equals("Take A Walk On The Boardwalk")){
                alertLabel = new Label(player.getPlayerName() + "picked out the \n \"" + temp + "\" \ncard from the chance pile!");
                updatePlayerLocation(player.findPropertyDifference("Boardwalk"));
                movePiece();
            }else if(temp.equals("Advance to Illinois Ave.")){
                alertLabel = new Label(player.getPlayerName() + "picked out the \n \"" + temp + "\" \ncard from the chance pile!");
                updatePlayerLocation(player.findPropertyDifference("Illinois Avenue"));
                movePiece();
            }else if(temp.equals("Advance to Nearest Utility")){
                alertLabel = new Label(player.getPlayerName() + "picked out the \n \"" + temp + "\" \ncard from the chance pile!");
                updatePlayerLocation(player.findNearestUtility());
                movePiece();
            }else if(temp.equals("Advance to Nearest Railroad")){
                alertLabel = new Label(player.getPlayerName() + "picked out the \n \"" + temp + "\" \ncard from the chance pile!");
                updatePlayerLocation(player.findNearestRailroad());
                movePiece();
            }else if(temp.equals("You Won The Lottery")){
                alertLabel = new Label(player.getPlayerName() + "picked out the \n \"" + temp + "\" \ncard from the chance pile!\n" +
                player.getPlayerName() + "won $1000!!!");
                player.setMoney(player.getMoney() + 1000);
                updateMoneyLabel();
            }

        }else if(square.getName().equals("Community Chest")){
            String temp = community[rand.nextInt(5)];
            if(temp.equals("Advance to Go")){
                alertLabel = new Label(player.getPlayerName() + " picked out the \n \"" + temp + "\" \ncard from the community chest pile!");
                updatePlayerLocation(player.findPropertyDifference("GO"));
                movePiece();
            }else if(temp.equals("Doctors Fees")){
                alertLabel = new Label(player.getPlayerName() + " picked out the \n \"" + temp + "\" \ncard from the community chest pile!\n" +
                        player.getPlayerName() + " lost $100!!!");
                player.setMoney(player.getMoney() - 100);
                updateMoneyLabel();
            }else if(temp.equals("Go to Jail")){
                alertLabel = new Label(player.getPlayerName() + " picked out the \n \"" + temp + "\" \ncard from the community chest pile!");
                player.setCurrentJailTime(rules.getJailTime());
                updatePlayerLocation(player.findPropertyDifference("Jail/Just Visiting"));
                movePiece();
            }else if(temp.equals("School Fees")){
                alertLabel = new Label(player.getPlayerName() + " picked out the \n \"" + temp + "\" \ncard from the community chest pile!\n" +
                        player.getPlayerName() + " lost $200!!!");
                player.setMoney(player.getMoney() - 200);
                updateMoneyLabel();
            }else if(temp.equals("PFD")){
                alertLabel = new Label(player.getPlayerName() + " picked out the \n \"" + temp + "\" \ncard from the community chest pile!\n" +
                        player.getPlayerName() + " won $350!!!");
                player.setMoney(player.getMoney() + 350);
                updateMoneyLabel();
            }
        }else if(square.getName().equals("Go to Jail")){
            alertLabel = new Label(player.getPlayerName() + " landed on the Go to Jail Square!! Looks like they're going to jail");
            player.setCurrentJailTime(rules.getJailTime());
            updatePlayerLocation(player.findPropertyDifference("Jail/Just Visiting"));
            movePiece();
        }else if(square.getName().equals("GO")){
            if(rules.getLandingOnGoBonus()){
                alertLabel = new Label(player.getPlayerName() + " landed on the Go Square and will collect a $200 bonus!!!");
                player.setMoney(player.getMoney() + 200);
                updateMoneyLabel();
            }else{alertLabel = new Label(player.getPlayerName() + " landed on the Go Square!");}
        }else if(square.getName().equals("Free Parking")) {
            alertLabel = new Label(player.getPlayerName() + " Landed on Free Parking!\n" + player.getPlayerName() + " won $20");
            player.setMoney(player.getMoney() + 20);
            updateMoneyLabel();
        }else if(square.getName().equals("Jail/Just Visiting")) {
            alertLabel = new Label(player.getPlayerName() + " is visiting their hacker friends in jail");
        }


        alertLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 24));
        alertLabel.setTextAlignment(TextAlignment.CENTER);
        HBox buyLabelHBox = new HBox();
        buyLabelHBox.getChildren().addAll(alertLabel);
        buyLabelHBox.setAlignment(Pos.CENTER);

        Label closeLabel = new Label("Close");
        alertLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 15));
        alertLabel.setTextAlignment(TextAlignment.CENTER);

        Button close = new Button("", closeLabel);
        close.setPadding(new Insets(10,50,10,50));
        close.setOnAction(e->{
            popupWindow.close();
            if(player.getCurrentSpace().getClass().getSimpleName().equals("PropertySquare") ||
                    player.getCurrentSpace().getClass().getSimpleName().equals("UtilitySquare") ||
                    player.getCurrentSpace().getClass().getSimpleName().equals("RailroadSquare")) {
                checkSquare();
            }
        });


        HBox buttonsHBox = new HBox();
        buttonsHBox.getChildren().addAll(close);
        buttonsHBox.setAlignment(Pos.CENTER);


        VBox popupVBox = new VBox();
        popupVBox.getChildren().addAll(buyLabelHBox,buttonsHBox);

        BorderPane layout = new BorderPane();
        layout.setCenter(popupVBox);
        layout.setStyle("-fx-background-color: #09A99A;");

        Scene scene5 = new Scene(layout,800,125);
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setScene(scene5);
        popupWindow.show();
    }





    /////////////////////////////////
    // This determines which type of
    // square in the hierarchy that has
    // been chosen and will determine
    // actions from there by rerouting
    // to different methods
    /////////////////////////////////
    public void checkSquare()
    {
        Player player = new Player();
        PropertySquare temp1 = new PropertySquare();
        RailroadSquare temp2 = new RailroadSquare();
        UtilitySquare temp3 = new UtilitySquare();
        TaxSquare temp4 = new TaxSquare();


        if(turnTeller == 1){
            player = player1;
        }else if(turnTeller == 2){
            player = player2;
        }else if(turnTeller == 3){
            player = player3;
        }else if(turnTeller == 4){
            player = player4;
        }else if(turnTeller == 5){
            player = player5;
        }


        if(player.getCurrentSpace().getClass().getSimpleName().equals("RailroadSquare")){
            temp2 = (RailroadSquare)player.getCurrentSpace();
            if(temp2.isBuyable()) {
                buySquare(player, temp2);
            }else{
                payPlayerForProperty(player, temp2);
            }
        }
        else if (player.getCurrentSpace().getClass().getSimpleName().equals("UtilitySquare")){
            temp3 = (UtilitySquare)player.getCurrentSpace();
            if(temp3.isBuyable()) {
                buySquare(player, temp3);
            }else{
                payPlayerForProperty(player, temp3);
            }
        }
        else if (player.getCurrentSpace().getClass().getSimpleName().equals("PropertySquare")){
            temp1 = (PropertySquare)player.getCurrentSpace();
            if(temp1.isBuyable()) {
                buySquare(player, temp1);
            }else{
                payPlayerForProperty(player, temp1);
            }
        }
        else if(player.getCurrentSpace().getClass().getSimpleName().equals("TaxSquare")){
            temp4 = (TaxSquare)player.getCurrentSpace();
            payTaxes(player, temp4);
        }
        else if(player.getCurrentSpace().getClass().getSimpleName().equals("Square")){
            squareAction(player, player.getCurrentSpace());
        }


    }




    /////////////////////////////////
    // These methods allow the user to
    // buy different types of "Square"
    // objects when stepping on their
    // spaces
    /////////////////////////////////
    public void buySquare(Player player, UtilitySquare utilitySquare)
    {
        Stage popupWindow = new Stage();


        Label buyLabel = new Label("You just landed on " + utilitySquare.getName() + "!!!" + "\nIt is available for purchase. " +
                "\nWould you like to buy " + utilitySquare.getName() + " for $" + utilitySquare.getPrice() + "?");
        buyLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 24));
        buyLabel.setTextAlignment(TextAlignment.CENTER);
        HBox buyLabelHBox = new HBox();
        buyLabelHBox.getChildren().addAll(buyLabel);
        buyLabelHBox.setAlignment(Pos.CENTER);

        Button yes = new Button("Yes");
        Button no = new Button("No");
        yes.setOnAction(e->{
            player.addToProperty(utilitySquare);
            player.setMoney(player.getMoney() - utilitySquare.getPrice());
            utilitySquare.setBuyable(false);
            updateMoneyLabel();
            fillPropertyBox(player);
            popupWindow.close();
        });
        no.setOnAction(e->{
            popupWindow.close();
        });


        HBox buttonsHBox = new HBox();
        buttonsHBox.getChildren().addAll(yes,no);
        buttonsHBox.setAlignment(Pos.CENTER);


        VBox popupVBox = new VBox();
        popupVBox.getChildren().addAll(buyLabelHBox,buttonsHBox);

        BorderPane layout = new BorderPane();
        layout.setCenter(popupVBox);
        layout.setStyle("-fx-background-color: #9FFF9F;");

        Scene scene5 = new Scene(layout,800,150);
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setScene(scene5);
        popupWindow.show();
    }
    /////////////////////////////////
    public void buySquare(Player player, RailroadSquare railroadSquare)
    {
        Stage popupWindow = new Stage();


        Label buyLabel = new Label("You just landed on " + railroadSquare.getName() + "!!!" + "\n It is available for purchase. " +
                "\nWould you like to buy " + railroadSquare.getName() + " for $" + railroadSquare.getPrice() + "?");
        buyLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 24));
        buyLabel.setTextAlignment(TextAlignment.CENTER);
        HBox buyLabelHBox = new HBox();
        buyLabelHBox.getChildren().addAll(buyLabel);
        buyLabelHBox.setAlignment(Pos.CENTER);

        Button yes = new Button("Yes");
        Button no = new Button("No");
        yes.setOnAction(e->{
            player.addToProperty(railroadSquare);
            player.setMoney(player.getMoney() - railroadSquare.getPrice());
            railroadSquare.setBuyable(false);
            updateMoneyLabel();
            fillPropertyBox(player);
            popupWindow.close();
        });
        no.setOnAction(e->{
            popupWindow.close();
        });


        HBox buttonsHBox = new HBox();
        buttonsHBox.getChildren().addAll(yes,no);
        buttonsHBox.setAlignment(Pos.CENTER);


        VBox popupVBox = new VBox();
        popupVBox.getChildren().addAll(buyLabelHBox,buttonsHBox);

        BorderPane layout = new BorderPane();
        layout.setCenter(popupVBox);
        layout.setStyle("-fx-background-color: #009999;");

        Scene scene5 = new Scene(layout,800,150);
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setScene(scene5);
        popupWindow.show();
    }
    /////////////////////////////////
    public void buySquare(Player player, PropertySquare propertySquare)
    {
        Stage popupWindow = new Stage();


        Label buyLabel = new Label("You just landed on " + propertySquare.getName() + "!!!" + "\n It is available for purchase. " +
                "\nWould you like to buy " + propertySquare.getName() + " for $" + propertySquare.getPrice() + "?");
        buyLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 24));
        buyLabel.setTextAlignment(TextAlignment.CENTER);
        HBox buyLabelHBox = new HBox();
        buyLabelHBox.getChildren().addAll(buyLabel);
        buyLabelHBox.setAlignment(Pos.CENTER);

        Button yes = new Button("Yes");
        Button no = new Button("No");
        yes.setOnAction(e->{
            player.addToProperty(propertySquare);
            player.setMoney(player.getMoney() - propertySquare.getPrice());
            propertySquare.setBuyable(false);
            updateMoneyLabel();
            fillPropertyBox(player);
            popupWindow.close();
        });
        no.setOnAction(e->{
            popupWindow.close();
        });


        HBox buttonsHBox = new HBox();
        buttonsHBox.getChildren().addAll(yes,no);
        buttonsHBox.setAlignment(Pos.CENTER);


        VBox popupVBox = new VBox();
        popupVBox.getChildren().addAll(buyLabelHBox,buttonsHBox);

        BorderPane layout = new BorderPane();
        layout.setCenter(popupVBox);
        layout.setStyle("-fx-background-color: #999000;");

        Scene scene5 = new Scene(layout,800,150);
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setScene(scene5);
        popupWindow.show();
    }






    /////////////////////////////////
    // This method updates the money
    // box located below the dice and
    // buttons on the left side of the
    // board. It will figure out whose
    // turn it is and update the money
    // according to that player
    /////////////////////////////////
    private void updateMoneyLabel()
    {
        Player player = new Player();
        if(turnTeller == 1){
            player = player1;
        }
        else if(turnTeller == 2){
            player = player2;
        }
        else if(turnTeller == 3){
            player = player3;
        }
        else if(turnTeller == 4){
            player = player4;
        }
        else if(turnTeller == 5){
            player = player5;
        }
        moneyAmount.setText(Integer.toString(player.getMoney()));
    }




    /////////////////////////////////
    // This moves the images/icons that
    // represent the players. It
    // requires that the icon/player's
    // location be updated by the
    // updatePlayerLocation function
    // first
    /////////////////////////////////
    private void movePiece()
    {
        Player player = new Player();
        HBox gameSquareHBox = new HBox();

        int countPlayers = 2;
        if(player3 != null){
            countPlayers++;
        }
        if(player4 != null){
            countPlayers++;
        }
        if(player5 != null){
            countPlayers++;
        }






        if(turnTeller == 1){
            player = player2;
            gameSquareHBox = gameSquareHBox2;
        }else if(turnTeller == 2){
            if(countPlayers > 2) {
                player = player3;
                gameSquareHBox = gameSquareHBox3;
            }else{
                player = player1;
                gameSquareHBox = gameSquareHBox1;
            }
        }else if(turnTeller == 3){
            if(countPlayers > 3) {
                player = player4;
                gameSquareHBox = gameSquareHBox4;
            }else{
                player = player1;
                gameSquareHBox = gameSquareHBox1;
            }
        }else if(turnTeller == 4){
            if(countPlayers > 4) {
                player = player5;
                gameSquareHBox = gameSquareHBox5;
            }else{
                player = player1;
                gameSquareHBox = gameSquareHBox1;
            }
        }else if(turnTeller == 5){
            player = player1;
            gameSquareHBox = gameSquareHBox1;
        }



        //player = player1;
        //gameSquareHBox = gameSquareHBox1;
        //int currentSpace = player.getCurrentSpace().getGridNumber();




        int [] squareNumberStorage = new int[5];
        boolean numberCheck = true;
        int playerIndicator = turnTeller + 1;

        backgroundPane.getChildren().clear();

        for(int i = 0; i < countPlayers; i++) {

            for(int j = 0; j < i; j++){
                numberCheck = true;
                if(player.getCurrentSpace().getGridNumber() == squareNumberStorage[j]){
                    numberCheck = false;
                }
            }
            if(numberCheck) {

                switch (player.getCurrentSpace().getGridNumber()) {
                    case 0:
                        backgroundPane.add(gameSquareHBox, 12, 12);
                        break;
                    case 1:
                        backgroundPane.add(gameSquareHBox, 10, 12);
                        break;
                    case 2:
                        backgroundPane.add(gameSquareHBox, 9, 12);
                        break;
                    case 3:
                        backgroundPane.add(gameSquareHBox, 8, 12);
                        break;
                    case 4:
                        backgroundPane.add(gameSquareHBox, 7, 12);
                        break;
                    case 5:
                        backgroundPane.add(gameSquareHBox, 6, 12);
                        break;
                    case 6:
                        backgroundPane.add(gameSquareHBox, 5, 12);
                        break;
                    case 7:
                        backgroundPane.add(gameSquareHBox, 4, 12);
                        break;
                    case 8:
                        backgroundPane.add(gameSquareHBox, 3, 12);
                        break;
                    case 9:
                        backgroundPane.add(gameSquareHBox, 2, 12);
                        break;
                    case 10:
                        backgroundPane.add(gameSquareHBox, 0, 12);
                        break;
                    case 11:
                        backgroundPane.add(gameSquareHBox, 0, 10);
                        break;
                    case 12:
                        backgroundPane.add(gameSquareHBox, 0, 9);
                        break;
                    case 13:
                        backgroundPane.add(gameSquareHBox, 0, 8);
                        break;
                    case 14:
                        backgroundPane.add(gameSquareHBox, 0, 7);
                        break;
                    case 15:
                        backgroundPane.add(gameSquareHBox, 0, 6);
                        break;
                    case 16:
                        backgroundPane.add(gameSquareHBox, 0, 5);
                        break;
                    case 17:
                        backgroundPane.add(gameSquareHBox, 0, 4);
                        break;
                    case 18:
                        backgroundPane.add(gameSquareHBox, 0, 3);
                        break;
                    case 19:
                        backgroundPane.add(gameSquareHBox, 0, 2);
                        break;
                    case 20:
                        backgroundPane.add(gameSquareHBox, 0, 0);
                        break;
                    case 21:
                        backgroundPane.add(gameSquareHBox, 2, 0);
                        break;
                    case 22:
                        backgroundPane.add(gameSquareHBox, 3, 0);
                        break;
                    case 23:
                        backgroundPane.add(gameSquareHBox, 4, 0);
                        break;
                    case 24:
                        backgroundPane.add(gameSquareHBox, 5, 0);
                        break;
                    case 25:
                        backgroundPane.add(gameSquareHBox, 6, 0);
                        break;
                    case 26:
                        backgroundPane.add(gameSquareHBox, 7, 0);
                        break;
                    case 27:
                        backgroundPane.add(gameSquareHBox, 8, 0);
                        break;
                    case 28:
                        backgroundPane.add(gameSquareHBox, 9, 0);
                        break;
                    case 29:
                        backgroundPane.add(gameSquareHBox, 10, 0);
                        break;
                    case 30:
                        backgroundPane.add(gameSquareHBox, 12, 0);
                        break;
                    case 31:
                        backgroundPane.add(gameSquareHBox, 12, 2);
                        break;
                    case 32:
                        backgroundPane.add(gameSquareHBox, 12, 3);
                        break;
                    case 33:
                        backgroundPane.add(gameSquareHBox, 12, 4);
                        break;
                    case 34:
                        backgroundPane.add(gameSquareHBox, 12, 5);
                        break;
                    case 35:
                        backgroundPane.add(gameSquareHBox, 12, 6);
                        break;
                    case 36:
                        backgroundPane.add(gameSquareHBox, 12, 7);
                        break;
                    case 37:
                        backgroundPane.add(gameSquareHBox, 12, 8);
                        break;
                    case 38:
                        backgroundPane.add(gameSquareHBox, 12, 9);
                        break;
                    case 39:
                        backgroundPane.add(gameSquareHBox, 12, 10);
                        break;
                }
            }

            squareNumberStorage[i] = player.getCurrentSpace().getGridNumber();


            playerIndicator++;
            if (playerIndicator > countPlayers)
            {
                playerIndicator = playerIndicator - countPlayers;
            }


            if(playerIndicator == 1) {
                player = player1;
                gameSquareHBox = gameSquareHBox1;
            }else if(playerIndicator == 2){
                player = player2;
                gameSquareHBox = gameSquareHBox2;
            }else if(playerIndicator== 3){
                player = player3;
                gameSquareHBox = gameSquareHBox3;
            }else if(playerIndicator == 4){
                player = player4;
                gameSquareHBox = gameSquareHBox4;
            }else if(playerIndicator == 5){
                player = player5;
                gameSquareHBox = gameSquareHBox5;
            }

        }

    }

    /////////////////////////////////
    // This assigns certain images to
    // HBoxes that get manipulated
    // on a grid layout to simulate a
    // game board
    /////////////////////////////////
    private void setupPlayerPieces()
    {
        try {
            Image player1Image = new Image(new FileInputStream("src\\Monopoly_Pics\\Little" + player1.getGamePiece() + ".jpg"));
            ImageView player1ImageView = new ImageView(player1Image);
            gameSquareHBox1.getChildren().add(player1ImageView);


            Image player2Image = new Image(new FileInputStream("src\\Monopoly_Pics\\Little" + player2.getGamePiece() + ".jpg"));
            ImageView player2ImageView = new ImageView(player2Image);
            gameSquareHBox2.getChildren().add(player2ImageView);

            if(player3 != null) {
                Image player3Image = new Image(new FileInputStream("src\\Monopoly_Pics\\Little" + player3.getGamePiece() + ".jpg"));
                ImageView player3ImageView = new ImageView(player3Image);
                gameSquareHBox3.getChildren().add(player3ImageView);
            }

            if(player4 != null){
                Image player4Image = new Image(new FileInputStream("src\\Monopoly_Pics\\Little" + player4.getGamePiece() + ".jpg"));
                ImageView player4ImageView = new ImageView(player4Image);
                gameSquareHBox4.getChildren().add(player4ImageView);
            }

            if(player5 != null){
                Image player5Image = new Image(new FileInputStream("src\\Monopoly_Pics\\Little" + player5.getGamePiece() + ".jpg"));
                ImageView player5ImageView = new ImageView(player5Image);
                gameSquareHBox5.getChildren().add(player5ImageView);
            }

        }catch(Exception e){System.out.println("There was a problem reading the game pieces.");}

        //Centers HBox containers
        for(int i = 0; i < 6; i++){
            gameSquareHBoxList[i].setAlignment(Pos.CENTER);
        }
        //
    }


    /////////////////////////////////
    // This method updates the
    // currentLocation of the current
    // player. It will update their
    // location with as many squares
    // as equal to the input
    /////////////////////////////////
    private void updatePlayerLocation(int update)
    {
        Player player = new Player();
        if(turnTeller == 1){
            player = player1;

        }else if(turnTeller == 2){
            player = player2;

        }else if(turnTeller == 3){
            player = player3;

        }else if(turnTeller == 4){
            player = player4;

        }else if(turnTeller == 5){
            player = player5;
        }
        for(int i = 0; i < (update); i++)
        {
            player.setCurrentSpace(player.getCurrentSpace().getNext());
            if(player.getCurrentSpace().getGridNumber() == 39 && (i+1 < update)){
                if(player.getCurrentJailTime() > 0){
                    dontPayForJail(player);
                }else {
                    payforPassingGo(player);
                }
            }
        }
    }




    /////////////////////////////////
    // This method creates a popup box
    // and also gives money to people
    // when they pass go
    /////////////////////////////////
    private void payforPassingGo(Player play){
        play.setMoney(play.getMoney() + 200);
        updateMoneyLabel();


        Stage popupWindow = new Stage();


        Label buyLabel = new Label(play.getPlayerName() + "Just received $200 for passing or landing on GO!");
        buyLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 22));
        buyLabel.setTextAlignment(TextAlignment.CENTER);
        HBox buyLabelHBox = new HBox();
        buyLabelHBox.getChildren().addAll(buyLabel);
        buyLabelHBox.setAlignment(Pos.CENTER);

        Label closeLabel = new Label("Close");
        buyLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 15));
        buyLabel.setTextAlignment(TextAlignment.CENTER);

        Button close = new Button("", closeLabel);
        close.setPadding(new Insets(10,50,10,50));
        close.setOnAction(e->{
            popupWindow.close();
        });


        HBox buttonsHBox = new HBox();
        buttonsHBox.getChildren().addAll(close);
        buttonsHBox.setAlignment(Pos.CENTER);


        VBox popupVBox = new VBox();
        popupVBox.getChildren().addAll(buyLabelHBox,buttonsHBox);

        BorderPane layout = new BorderPane();
        layout.setCenter(popupVBox);
        layout.setStyle("-fx-background-color: #09A99A;");

        Scene scene5 = new Scene(layout,800,100);
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setScene(scene5);
        popupWindow.show();

    }



    /////////////////////////////////
    // This method creates a popup box
    // and also denies money to those
    // who pass go when they have jail
    // time they need to serve
    /////////////////////////////////
    private void dontPayForJail(Player play){
        Stage popupWindow = new Stage();


        Label buyLabel = new Label(play.getPlayerName() + "Did not receive any money for passing go because he went to jail instead!");
        buyLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 22));
        buyLabel.setTextAlignment(TextAlignment.CENTER);
        HBox buyLabelHBox = new HBox();
        buyLabelHBox.getChildren().addAll(buyLabel);
        buyLabelHBox.setAlignment(Pos.CENTER);

        Label closeLabel = new Label("Close");
        buyLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 15));
        buyLabel.setTextAlignment(TextAlignment.CENTER);

        Button close = new Button("", closeLabel);
        close.setPadding(new Insets(10,50,10,50));
        close.setOnAction(e->{
            popupWindow.close();
        });


        HBox buttonsHBox = new HBox();
        buttonsHBox.getChildren().addAll(close);
        buttonsHBox.setAlignment(Pos.CENTER);


        VBox popupVBox = new VBox();
        popupVBox.getChildren().addAll(buyLabelHBox,buttonsHBox);

        BorderPane layout = new BorderPane();
        layout.setCenter(popupVBox);
        layout.setStyle("-fx-background-color: #09A99A;");

        Scene scene5 = new Scene(layout,800,100);
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setScene(scene5);
        popupWindow.show();

    }


}
