package gamepractice.HexGameProject;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class Game extends HelloApplication {
    static boolean isBlueTurn = true , isEnded=false;
    static boolean[][] isClicked;
    public static double centreX,centreY;
    static int rowLenght;
    public static Scene gameScene(Stage gameStage) {
        Pane gamePane = new Pane();
        Scene gameScene = new Scene(gamePane, 1525, 775);
        centreX = (gameScene.getWidth()) / 2; centreY = (gameScene.getHeight()) / 2;
        Image backgroundImage = new Image("file:src/main/resources/images/gamebackground.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);// describe the image
        backgroundImageView.setFitWidth(gamePane.getWidth());backgroundImageView.setFitHeight(gamePane.getHeight());
        if (DataSave.getMapValue()==0){rowLenght=5;}
        else {rowLenght=DataSave.getMapValue();}
        String name1= DataSave.getName1Value(); String name2=DataSave.getName2Value();

        Text player1 = new Text("PLAYER 1:"+name1);
        Text player2 = new Text("PLAYER 2:"+name2);
        Text turnText = new Text("TURN:");
        Button exitButton =new Button("EXIT");
        Button menuButton =new Button("MENU");
        Button backButton =new Button("BACK");

        player1.setFont(Font.font("Arial", FontWeight.BOLD, 24)); player1.setFill(Color.DARKBLUE);
        player2.setFont(Font.font("Arial", FontWeight.BOLD, 24)); player2.setFill(Color.DARKRED);
        turnText.setFont(Font.font("Arial", FontWeight.BOLD, 24)); turnText.setFill(Color.WHITE);

        player1.setLayoutX(50); player1.setLayoutY(50);
        player2.setLayoutX(1100); player2.setLayoutY(50);
        turnText.setLayoutX(550); turnText.setLayoutY(50);

        exitButton.setPrefSize(buttonX, buttonY);exitButton.setFont(new Font(20));
        exitButton.setLayoutX(centreX+225); exitButton.setLayoutY(centreY+300);

        backButton.setPrefSize(buttonX, buttonY);backButton.setFont(new Font(20));
        backButton.setLayoutX(centreX-75); backButton.setLayoutY(centreY+300);

        menuButton.setPrefSize(buttonX, buttonY);menuButton.setFont(new Font(20));
        menuButton.setLayoutX(centreX-375); menuButton.setLayoutY(centreY+300);

        HelloApplication mainMenu = new HelloApplication();
        exitButton.setOnAction(actionEvent -> {
            Platform.exit();});

        menuButton.setOnAction(actionEvent -> {
            isEnded=false; isBlueTurn=true;
            try {
                mainMenu.start(gameStage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        backButton.setOnAction(actionEvent -> {
            isEnded=false; isBlueTurn=true;
            mainMenu.options(gameStage);});

        gamePane.getChildren().addAll(backgroundImageView,player1,player2,turnText,exitButton,menuButton,backButton);
        Model.playGround(gamePane,rowLenght);

        return gameScene;
    }


    public static void main(String[] args) {
        launch(args);
    }
}

