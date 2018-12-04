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
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;
import java.io.FileInputStream;
import javafx.scene.control.CheckBox;


public class Monopoly{


    private Rules rules;
    private Stage window;
    private Scene scene1, scene2, scene3, scene4;
    private Player player1, player2, player3, player4, player5;
    private int turnCounter;

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


        public boolean[] getBooleanVars()
        {
            boolean temp[] = {turnLimitTen,tradingSelling,landingOnGoBonus,FreeParkingTaxFund,randomGamePieces};
            return temp;
        }

        public int[] getIntVars()
        {
            int temp[] = {numberOfPlayers,startingCash,jailTime};
            return temp;
        }
    }

    //Outside of rules class. Allows Monopoly access to set variables in the rule class
    private void setRules(boolean turnLimitTen, boolean tradingSelling, boolean landingOnGoBonus,
                         boolean FreeParkingTaxFund, boolean randomGamePieces, int numberOfPlayers,
                         int startingCash, int jailTime)
    {
        rules = new Rules(turnLimitTen,tradingSelling,landingOnGoBonus,FreeParkingTaxFund,randomGamePieces,
                numberOfPlayers,startingCash,jailTime);
    }




    private void rulesGUI()
    {
        //////////////////////////////////////////////////////////////////////////////////////////////////////Scene1
        /////////////////////////////////////////////////////////////Top Section
        //
        HBox introScene1 = new HBox();
        try {
            Image monopolyLogo = new Image(new FileInputStream("Monopoly_Pics\\MonopolyLogo.jpg"));
            ImageView monopolyLogoView = new ImageView(monopolyLogo);

            Image topHatMan = new Image(new FileInputStream("Monopoly_Pics\\TopHatMan2.png"));
            ImageView topHatManView = new ImageView(topHatMan);
            //}catch(e FileNotFoundException){System.out.println();}
            //HBox introScene1 = new HBox();
            introScene1.getChildren().addAll(monopolyLogoView, topHatManView);
        }catch(Exception eee){System.out.println("Files were not found");}

        //

        //
        Label setRulesText = new Label("Hello! Welcome to the game of Monopoly! \n The next page will give you a set of rules that can be changed to your liking. \n (Defaults requirements already set unless changed)");
        setRulesText.setFont(Font.font(("Verdana"), FontWeight.BOLD, 26));
        //

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






        //////////////////////////////////////////////////////////////////////////////////////////////////////Scene2
        ///////////////Top Section
        Text topTextScene2 = new Text("Rule Selection");
        topTextScene2.setFont(Font.font(("Verdana"), FontWeight.BOLD, 40));


        HBox topScene2 = new HBox();//Add as top
        topScene2.getChildren().addAll(topTextScene2);
        topScene2.setPadding(new Insets(10,15,10,15));
        topScene2.setAlignment(Pos.TOP_CENTER);
        ///////////////Top Section



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
        r2Yes.setSelected(true);
        CheckBox r2No = new CheckBox("No");

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
        r3Yes.setSelected(true);
        CheckBox r3No = new CheckBox("No");

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
        r4Yes.setSelected(true);
        CheckBox r4No = new CheckBox("No");

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
        r5Yes.setSelected(false);
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
        slider.setMin(0);
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

        ////////////////Continue to Game Button

        //
        Label continueToGameLabel = new Label("Continue");
        continueText.setFont(Font.font(("Verdana"), FontWeight.BOLD, 20));
        Button continueToGame = new Button("",continueToGameLabel);


        ///////Leaps to next Method when button is pressed

        continueToGame.setOnAction(e -> setupNameAndGamePieceGUI(r1Yes.isSelected(),r2Yes.isSelected(),r3Yes.isSelected(),
                r4Yes.isSelected(),r5Yes.isSelected(),((int)slider.getValue()),((int)slider2.getValue()),((int)slider3.getValue())));

        ///////Leaps to next Method when button is pressed



        ////////////////Continue to Game Button



        /////////////////////////////////////////Adding Rules Here
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







    Monopoly(Stage window, Scene scene1, Scene scene2, Scene scene3, Scene scene4)
    {
        rules = new Rules();
        this.window = window;
        this.scene1 = scene1;
        this.scene2 = scene2;
        this.scene3 = scene3;
        this.scene4 = scene4;
        rulesGUI();
        turnCounter = 0;
    }






    private void setupNameAndGamePieceGUI(boolean turnLimitTen, boolean tradingSelling, boolean landingOnGoBonus,
                                          boolean FreeParkingTaxFund, boolean randomGamePieces, int numberOfPlayers,
                                          int startingCash, int jailTime)
    {
        setRules(turnLimitTen,tradingSelling,landingOnGoBonus,FreeParkingTaxFund,randomGamePieces,
                numberOfPlayers,startingCash,jailTime);

        Label label, label2 = new Label(), label3 = new Label(), label4;
        ComboBox comboBox = new ComboBox();

        //Will allow setting of game piece depending on past choice
        if(randomGamePieces)
        {
            label = new Label("Please enter your name below:");
        }else {
            label = new Label("Please enter your name below and then choose your game piece.");

            //list for dropdown menu
            ObservableList<String> options =
                    FXCollections.observableArrayList(
                            "Hat",
                            "Thimble",
                            "Battleship",
                            "Top Hat",
                            "Race Car"
                    );
            comboBox = new ComboBox(options);
            comboBox.getSelectionModel().selectFirst();


            //Label for name entry
            label3.setText("Name:");
            label3.setTextAlignment(TextAlignment.CENTER);
            label3.setFont(Font.font(("Verdana"), FontWeight.BOLD, 15));

            //Label for game piece selection menu
            label2.setText("Game Piece:");
            label2.setTextAlignment(TextAlignment.CENTER);
            label2.setFont(Font.font(("Verdana"), FontWeight.BOLD, 15));

        }
        //setup for main text on page that allows choosing of name and game piece
        label.setTextAlignment(TextAlignment.CENTER);
        label.setFont(Font.font(("Verdana"), FontWeight.BOLD, 30));

        //label for button and button creation
        label4 = new Label("Continue to Game");
        label4.setFont(Font.font(("Verdana"), FontWeight.BOLD, 20));
        Button continueToGame = new Button("",label4);//button that continues to the game
        continueToGame.setOnAction(e -> playGameGUI());
        continueToGame.setPadding(new Insets(20,20,20,20));

        //Text Field to enter a name. Default is "Name"
        TextField nameArea = new TextField("Name");
        nameArea.setAlignment(Pos.CENTER);
        nameArea.setMaxSize(120,30);





        ImageView topHatMan= new ImageView();
        //Adding Picture to make things more exciting
        try {
            Image monopolyLogo = new Image(new FileInputStream("Monopoly_Pics\\TopHatMan.png"));
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



    public void turn()
    {

    }



    private void playGameGUI()
    {
        setInitialGameScene();














    }


    private void setInitialGameScene()
    {




        //////////////////////////////////////Dice
        ImageView gameBoard = new ImageView();
        ImageView dice1= new ImageView();
        ImageView dice2= new ImageView();
        try {
            Image dice12 = new Image(new FileInputStream("Monopoly_Pics\\Dice_1.gif"));
            dice1 = new ImageView(dice12);
            Image dice22 = new Image(new FileInputStream("Monopoly_Pics\\Dice_1.gif"));
            dice2 = new ImageView(dice22);
        }catch(Exception e){System.out.println("A file did not load");}

        Label diceLabel = new Label("Player 1's Turn:");
        diceLabel.setTextAlignment(TextAlignment.RIGHT);
        diceLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 20));
        diceLabel.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #FF0000; -fx-border-width: 5px");
        diceLabel.setMaxSize(270,125);
        diceLabel.setPadding(new Insets(5,5,5,5));
        //////////////////////////////////////Dice




        //////////////////////////////////////Game Board
        try {
            Image board = new Image(new FileInputStream("Monopoly_Pics\\Monopoly_Game_Board2.jpg"));
            gameBoard = new ImageView(board);
        }catch(Exception e){System.out.println("A file did not load");}
        //////////////////////////////////////Game Board


        //////////////////////////////////////Player Icons
        Label iconLabel = new Label("Players:");
        iconLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 20));
        iconLabel.setPadding(new Insets(20,20,20,20));
        iconLabel.setTextAlignment(TextAlignment.CENTER);


        String cssBordering1 = "-fx-border-color:black ; \n" //#090a0c
                + "-fx-border-insets:3;\n"
                + "-fx-border-radius:7;\n"
                + "-fx-border-width:1.0";

        String cssBordering2 = "-fx-border-color:red ; \n" //#090a0c
                + "-fx-border-insets:3;\n"
                + "-fx-border-radius:7;\n"
                + "-fx-border-width:1.0";


        ImageView icon1= new ImageView(),icon2= new ImageView(),icon3= new ImageView(),icon4= new ImageView(),icon5 = new ImageView();
        Image icon12;
        Image icon22;
        Image icon32;
        Image icon42;
        Image icon52;

        BorderPane iconOne = new BorderPane();
        BorderPane iconTwo = new BorderPane();
        BorderPane iconThree = new BorderPane();
        BorderPane iconFour = new BorderPane();
        BorderPane iconFive = new BorderPane();

        try {
            icon12 = new Image(new FileInputStream("Monopoly_Pics\\Top_Hat.jpg"));
            icon1 = new ImageView(icon12);
            icon22 = new Image(new FileInputStream("Monopoly_Pics\\Thimble.jpg"));
            icon2 = new ImageView(icon22);
            icon32 = new Image(new FileInputStream("Monopoly_Pics\\Racecar.jpg"));
            icon3 = new ImageView(icon32);
            icon42 = new Image(new FileInputStream("Monopoly_Pics\\Boot.jpg"));
            icon4 = new ImageView(icon42);
            icon52 = new Image(new FileInputStream("Monopoly_Pics\\BattleShip.jpg"));
            icon5 = new ImageView(icon52);


            iconOne.setCenter(icon1);
            iconOne.setMaxHeight(icon12.getHeight()+5);
            iconOne.setMaxWidth(icon12.getWidth()+5);
            iconOne.setStyle(cssBordering1);


            iconTwo.setCenter(icon2);
            iconTwo.setMaxHeight(icon22.getHeight()+5);
            iconTwo.setMaxWidth(icon22.getWidth()+5);
            iconTwo.setStyle(cssBordering2);


            iconThree.setCenter(icon3);
            iconThree.setMaxHeight(icon32.getHeight()+5);
            iconThree.setMaxWidth(icon32.getWidth()+5);
            iconThree.setStyle(cssBordering1);


            iconFour.setCenter(icon4);
            iconFour.setMaxHeight(icon42.getHeight()+5);
            iconFour.setMaxWidth(icon42.getWidth()+5);
            iconFour.setStyle(cssBordering2);


            iconFive.setCenter(icon5);
            iconFive.setMaxHeight(icon52.getHeight()+5);
            iconFive.setMaxWidth(icon52.getWidth()+5);
            iconFive.setStyle(cssBordering1);


        }catch(Exception e){System.out.println("A file did not load");}
        //////////////////////////////////////Player Icons



        //////////////////////////////////////Settings Button
        Label topRowLabel = new Label("Settings");
        topRowLabel.setTextAlignment(TextAlignment.RIGHT);
        topRowLabel.setFont(Font.font(("Verdana"), FontWeight.BOLD, 25));


        String cssBordering3 = "-fx-border-color:black ; \n" //#090a0c
                + "-fx-border-insets:3;\n"
                + "-fx-border-radius:7;\n"
                + "-fx-border-width:1.0";


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
        //playerIconBox.setAlignment(Pos.BASELINE_RIGHT);
        playerIconBox.setPadding(new Insets(5,5,5,5));
        //////////////////////////////////////Settings Button


        //Contains the player icon section and the settings button
        HBox topRowBox = new HBox();
        topRowBox.getChildren().addAll(playerIconBox,settingsButtonHBox);
        //



        //Box contains the Dice
        HBox diceBox = new HBox();
        diceBox.setAlignment(Pos.TOP_LEFT);
        diceBox.getChildren().addAll(dice1,dice2);
        diceBox.setPadding(new Insets(5,5,5,5));
        diceBox.setStyle("-fx-background-color: #00DEFF; -fx-border-color: #FF0000; -fx-border-width: 5px");
        diceBox.setMaxSize(270,145);
        diceBox.setMinSize(270,145);
        //



        //Box Contains signal for player's turn and the dice Box
        VBox diceVBox = new VBox();
        diceVBox.getChildren().addAll(diceLabel, diceBox);
        //

        //Grid section for whole layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.getColumnConstraints().add(new ColumnConstraints(280));


        grid.getRowConstraints().add(new RowConstraints(90));
        grid.getRowConstraints().add(new RowConstraints(90));
        grid.getRowConstraints().add(new RowConstraints(520));
        //Monopoly_Pics\Monopoly_Game_Board2.jpg
        String cssBackground1 = "-fx-background-image: url(./Monopoly_Pics/SceneBackground.jpg);" +
            "background-size: cover; /* for IE9+, Safari 4.1+, Chrome 3.0+, Firefox 3.6+ */\n" +
            "        -webkit-background-size: cover; /* for Safari 3.0 - 4.0 , Chrome 1.0 - 3.0 */\n" +
            "        -moz-background-size: cover; /* optional for Firefox 3.6 */ \n" +
            "        -o-background-size: cover; /* for Opera 9.5 */\n" +
            "        margin: 0; /* to remove the default white margin of body */\n" +
            "        padding: 0; /* to remove the default white margin of body */\n" +
            "        overflow: hidden;";

        String cssBackground2 = "-fx-background-image: url(Monopoly_Game_Board2.jpg);" +
                "background-size: cover; /* for IE9+, Safari 4.1+, Chrome 3.0+, Firefox 3.6+ */\n" +
                "        -webkit-background-size: cover; /* for Safari 3.0 - 4.0 , Chrome 1.0 - 3.0 */\n" +
                "        -moz-background-size: cover; /* optional for Firefox 3.6 */ \n" +
                "        -o-background-size: cover; /* for Opera 9.5 */\n" +
                "        margin: 0; /* to remove the default white margin of body */\n" +
                "        padding: 0; /* to remove the default white margin of body */\n" +
                "        overflow: hidden;";

        GridPane backgroundPane = new GridPane();
        backgroundPane.setStyle(cssBackground2);


        GridPane.setConstraints(topRowBox,1,0,1,1);
        GridPane.setConstraints(diceVBox,0,0,1,2);
        GridPane.setConstraints(backgroundPane,1,1,1,3);



        grid.getChildren().addAll(diceVBox,backgroundPane,topRowBox);
        grid.setStyle("-fx-background-color: #65CCFF; -fx-border-color: #000000; -fx-border-width: 5px");
        //grid.setStyle(cssBackground1);
        //

        scene4 = new Scene(grid, 1020, 830);


        window.setScene(scene4);
        window.centerOnScreen();
        window.setResizable(false);
    }

















}
