package gamepractice.HexGameProject;

import javafx.animation.FadeTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Model extends Game {
    static double r ,n;

    static  int[][] whatColor;
     static int rowLength,color =0;
    static Pane tMap;
    public static void playGround(Pane gamePane, int h){
        rowLength=h;
        tMap=gamePane;
        r = 250/rowLength+5;
        n = Math.sqrt(r * r * 0.75);
        double a=630,b=25;
        isClicked = new boolean[rowLength][rowLength];

        Polygon turnhex = new Polygon();
        turnhex.getPoints().addAll(
                a, b, a, b + 30, a + 26, b + 30 * 1.5, a + 2 * 26, b + 30, a + 2 * 26, b, a + 26, b - 30 * 0.5);
        turnhex.setFill(Color.DARKBLUE);turnhex.setStrokeWidth(3);turnhex.setStroke(Color.GREY);

        for (int x = 0; x < rowLength; x++) {
            for (int y = 0; y < rowLength; y++) {
                double startingX = (centreX-((rowLength+((rowLength-1)/2))*n))+(y*n)+(x*2*n);
                double startingY = (centreY-((rowLength*r)-(((rowLength-1)*(r/2))/2))+(y*2*r*0.75));
                drawHexagon(startingX, startingY,x,y,turnhex);
                drawLine(startingX, startingY,x,y);
            }}
        tMap.getChildren().addAll(turnhex);}
    private static void drawHexagon(double startingX, double startingY, int x, int y,Polygon turnHex) {
        whatColor = new int[rowLength][rowLength];
        whatColor[x][y]=0;

        String name1= DataSave.getName1Value(); String name2=DataSave.getName2Value();

        Text player1 = new Text(name1+" WON");
        Text player2 = new Text(name2+" WON");
        player1.setFont(Font.font("Arial", FontWeight.BOLD, 40)); player1.setFill(Color.WHITE);
        player2.setFont(Font.font("Arial", FontWeight.BOLD, 40)); player2.setFill(Color.WHITE);
        player1.setLayoutX(50); player1.setLayoutY(100);
        player2.setLayoutX(1100); player2.setLayoutY(100);

        Polygon hexagon = new Polygon();
        hexagon.getPoints().addAll(
                startingX, startingY,
                startingX, startingY + r,
                startingX + n, startingY + r * 1.5,
                startingX + 2 * n, startingY + r,
                startingX + 2 * n, startingY,
                startingX + n, startingY - r * 0.5
        );
        hexagon.setFill(Color.WHITE);
        hexagon.setStrokeWidth(3);
        hexagon.setStroke(Color.GREY);
        hexagon.setOnMouseClicked(event -> {
            if (!isClicked[x][y] && !isEnded) {
                Color color = isBlueTurn ? Color.DARKBLUE : Color.DARKRED;
                hexagon.setFill(color);
                isBlueTurn = !isBlueTurn;
                isClicked[x][y] = true;
                if (isBlueTurn) {
                    turnHex.setFill(Color.DARKBLUE);whatColor[x][y] = 2;Model.color = 2;
                } else {
                    turnHex.setFill(Color.DARKRED);whatColor[x][y] = 1;Model.color = 1;
                }
                Algorithm.check();
                if (isEnded) {
                    if (!isBlueTurn) tMap.getChildren().add(player1);
                    else tMap.getChildren().add(player2);
                }}});
        tMap.getChildren().addAll(hexagon);
    }
    private static void drawLine(double x, double y, int row, int col){

        Polyline line1 = new Polyline();line1.setStroke(Color.DARKRED);
        Polyline line2 = new Polyline();line2.setStroke(Color.DARKRED);
        Polyline line3 = new Polyline();line3.setStroke(Color.DARKBLUE);
        Polyline line4 = new Polyline();line4.setStroke(Color.DARKBLUE);

        if(row==0){
            x=x-15; y=y+5;
            line1.getPoints().addAll(x, y, x, y + r, x + n, y + r * 1.5);
            x=x+15; y=y-5;}
        else if (row==rowLength-1) {
            x=x+15; y=y-5;
            line2.getPoints().addAll(x + 2*n, y + r, x + 2*n, y, x + n, y - r * 0.5);
            x=x-15; y=y+5;}
        if(col==0){
            y=y-15;
            line3.getPoints().addAll(x + 2*n, y, x + n, y - r * 0.5, x, y);}
        else if (col==rowLength-1) {
            y=y+15;
            line4.getPoints().addAll(x, y + r, x + n, y + r * 1.5, x + 2*n, y + r);}

        line1.setStrokeWidth(10);line2.setStrokeWidth(10);line3.setStrokeWidth(10);line4.setStrokeWidth(10);
        tMap.getChildren().addAll(line1,line2,line3,line4);
    }
    public static void winRoad(int x,int y) {
        Polygon winHexagon = new Polygon();{
            double winX = (centreX - ((rowLength + ((rowLength - 1) / 2)) * n)) + (y * n) + (x * 2 * n);
            double winY = (centreY - ((rowLength * r) - (((rowLength - 1) * (r / 2)) / 2)) + (y * 2 * r * 0.75));
            winHexagon.getPoints().addAll(
                    winX, winY,
                    winX, winY + r,
                    winX + n, winY + r * 1.5,
                    winX + 2 * n, winY + r,
                    winX + 2 * n, winY,
                    winX + n, winY - r * 0.5);

            winHexagon.setFill(Color.SPRINGGREEN);
            winHexagon.setStrokeWidth(3);
            winHexagon.setStroke(Color.DARKGREEN);

            FadeTransition ft = new FadeTransition(Duration.millis(300), winHexagon);
            ft.setFromValue(1.0);
            ft.setToValue(0.3);
            ft.setCycleCount(10);
            ft.setAutoReverse(true);
            ft.play();

            tMap.getChildren().addAll(winHexagon);
            }
    }
    public static void main(String[] args) {
        launch(args);
    }
}


