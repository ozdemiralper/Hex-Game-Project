package gamepractice.HexGameProject;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static double buttonX=150, buttonY=75;
    private DataSave dataSave=new DataSave();

    public void start(Stage primaryStage) throws IOException {
        Pane mainMenu = new Pane();
        Scene scene = new Scene(mainMenu, 1525, 775);
        double centreX =(mainMenu.getWidth())/2, centreY=(mainMenu.getHeight())/2;

        Image backgroundImage = new Image("file:src/main/resources/images/background.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(mainMenu.getWidth()); backgroundImageView.setFitHeight(mainMenu.getHeight());

        Button playButton =new Button("PLAY");
        Button exitButton =new Button("EXIT");

        playButton.setPrefSize(buttonX, buttonY);playButton.setFont(new Font(20));
        exitButton.setPrefSize(buttonX, buttonY);exitButton.setFont(new Font(20));

        playButton.setLayoutX(centreX-225); playButton.setLayoutY(centreY+100);
        exitButton.setLayoutX(centreX+75); exitButton.setLayoutY(centreY+100);

        mainMenu.getChildren().addAll(backgroundImageView,playButton,exitButton);

        playButton.setOnAction(e ->  {primaryStage.setScene(options(primaryStage));});
        exitButton.setOnAction(e -> {Platform.exit();});

        primaryStage.setScene(scene);
        primaryStage.setTitle("HexGame");
        primaryStage.show();
    }
    public Scene options (Stage stage) {

        Pane opMenu = new Pane();
        Scene opScene = new Scene(opMenu, 1525, 775);
        double centreX =(opMenu.getWidth())/2, centreY=(opMenu.getHeight())/2;

        Image backgroundImage = new Image("file:src/main/resources/images/background.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);// describe the image
        backgroundImageView.setFitWidth(opMenu.getWidth()); backgroundImageView.setFitHeight(opMenu.getHeight());

        Button startButton = new Button("START");
        Button backButton =new Button("BACK");
        Button exitButton =new Button("EXIT");
        Text player1 = new Text("PLAYER 1:");
        Text player2 = new Text("PLAYER 2:");
        Text map = new Text("MAP SIZE:");
        TextField name1 = new TextField(); name1.setPromptText("Enter Name");
        TextField name2 = new TextField(); name2.setPromptText("Enter Name");
        ComboBox<Integer> mapSize = new ComboBox<>(); mapSize.getItems().addAll(5,11,17);
        mapSize.getSelectionModel().selectFirst();

        startButton.setPrefSize(buttonX, buttonY);startButton.setFont(new Font(20));
        backButton.setPrefSize(buttonX,buttonY);backButton.setFont(new Font(20));
        exitButton.setPrefSize(buttonX, buttonY);exitButton.setFont(new Font(20));
        player1.setFont(Font.font("Arial", FontWeight.BOLD, 24)); player1.setFill(Color.DARKBLUE);
        player2.setFont(Font.font("Arial", FontWeight.BOLD, 24)); player2.setFill(Color.DARKRED);
        map.setFont(Font.font("Arial", FontWeight.BOLD, 24)); map.setFill(Color.WHITE);
        name1.setPrefWidth(200); name1.setPrefHeight(50);
        name2.setPrefWidth(200); name2.setPrefHeight(50);
        mapSize.setPrefSize(200, 50);

        startButton.setLayoutX(centreX-375); startButton.setLayoutY(centreY+200);
        backButton.setLayoutX(centreX-75); backButton.setLayoutY(centreY+200);
        exitButton.setLayoutX(centreX+225); exitButton.setLayoutY(centreY+200);
        player1.setLayoutX(100); player1.setLayoutY(335);
        player2.setLayoutX(100); player2.setLayoutY(410);
        map.setLayoutX(100); map.setLayoutY(485);
        name1.setLayoutX(250); name1.setLayoutY(300);
        name2.setLayoutX(250); name2.setLayoutY(375);
        mapSize.setLayoutX(250); mapSize.setLayoutY(450);

        name1.setText(dataSave.getName1Value());
        name2.setText(dataSave.getName2Value());
        mapSize.setValue(dataSave.getMapValue());

        opMenu.getChildren().addAll(backgroundImageView,startButton,backButton,exitButton,player1,player2,map,name1,name2,mapSize);

        startButton.setOnAction(actionEvent -> {
            dataSave.setName1Value(name1.getText());
            dataSave.setName2Value(name2.getText());
            dataSave.setMapValue(mapSize.getValue());
            Scene gameScene = Game.gameScene(stage);
            stage.setScene(gameScene);
        });
        backButton.setOnAction(actionEvent -> {
            try {start(stage);}
            catch (IOException ioException) {ioException.printStackTrace();}
        });
        exitButton.setOnAction(actionEvent -> {Platform.exit();});

        stage.setScene(opScene);
        stage.setTitle("HexGame");
        stage.show();
        return opScene;
    }
    public static void main(String[] args) {
        launch();
    }
}