package gamepractice.HexGameProject;

public class Algorithm extends Model {
    public static boolean[][] isControlled;
    public static void check(){
        isControlled=new boolean[rowLength][rowLength];
    if (color==1 ){
        for (int x=0, y = 0; x < rowLength; x++) {
            if (whatColor[x][y]==1&& !isEnded) {
                checkwin(x,y);
            }}}
    else {
        {for (int x=0, y = 0; y < rowLength; y++) {
                if (whatColor[x][y]==2&& !isEnded){
                    checkwin(x,y);
                }}}}
    }
    public  static void checkwin(int x, int y){
        isControlled[x][y]=true;
        if (color==1){
            if(y==rowLength-1) {isEnded=true;}
            else if (y == 0) {
                if (x==0){
                    if (!isControlled[x][y+1] && whatColor[x][y+1]==1 && !isEnded) {checkwin(x,y+1); }
                    if (!isControlled[x+1][y] &&whatColor[x+1][y]==1 && !isEnded) {checkwin(x+1,y);}}
                else if (x==rowLength-1) {
                    if (!isControlled[x-1][y] &&whatColor[x-1][y]==1 && !isEnded) {checkwin(x-1,y);}
                    if (!isControlled[x-1][y+1] &&whatColor[x-1][y+1]==1 && !isEnded) {checkwin(x-1,y+1);}
                    if (!isControlled[x][y+1] &&whatColor[x][y+1]==1 && !isEnded) {checkwin(x,y+1);}}
                else{
                    if (!isControlled[x-1][y] &&whatColor[x-1][y]==1 && !isEnded) {checkwin(x-1,y);}
                    if (!isControlled[x-1][y+1] &&whatColor[x-1][y+1]==1 && !isEnded) {checkwin(x-1,y+1);}
                    if (!isControlled[x][y+1] &&whatColor[x][y+1]==1 && !isEnded) {checkwin(x,y+1);}
                    if (!isControlled[x+1][y] &&whatColor[x+1][y]==1 && !isEnded) {checkwin(x+1,y);}}}
            else {
                if (x==0){
                    if (!isControlled[x][y+1] &&whatColor[x][y+1]==1 && !isEnded) {checkwin(x,y+1);}
                    if (!isControlled[x][y-1] &&whatColor[x][y-1]==1 && !isEnded) {checkwin(x,y-1);}
                    if (!isControlled[x+1][y] &&whatColor[x+1][y]==1 && !isEnded) {checkwin(x+1,y);}
                    if (!isControlled[x+1][y-1] &&whatColor[x+1][y-1]==1 && !isEnded) {checkwin(x+1,y-1);}}
                else if (x==rowLength-1) {
                    if (!isControlled[x-1][y] &&whatColor[x-1][y]==1 && !isEnded) {checkwin(x-1,y);}
                    if (!isControlled[x-1][y+1] &&whatColor[x-1][y+1]==1 && !isEnded) {checkwin(x-1,y+1);}
                    if (!isControlled[x][y+1] &&whatColor[x][y+1]==1 && !isEnded) {checkwin(x,y+1);}
                    if (!isControlled[x][y-1] &&whatColor[x][y-1]==1 && !isEnded) {checkwin(x,y-1);}}
                else{
                    if (!isControlled[x-1][y] &&whatColor[x-1][y]==1 && !isEnded) {checkwin(x-1,y);}
                    if (!isControlled[x-1][y+1] &&whatColor[x-1][y+1]==1 && !isEnded) {checkwin(x-1,y+1);}
                    if (!isControlled[x][y+1] &&whatColor[x][y+1]==1 && !isEnded) {checkwin(x,y+1);}
                    if (!isControlled[x][y-1] &&whatColor[x][y-1]==1 && !isEnded) {checkwin(x,y-1);}
                    if (!isControlled[x+1][y] &&whatColor[x+1][y]==1 && !isEnded) {checkwin(x+1,y);}
                    if (!isControlled[x+1][y-1] &&whatColor[x+1][y-1]==1 && !isEnded) {checkwin(x+1,y-1);}
                }}
        }
        else if (color==2) {
            if(x==rowLength-1) {isEnded=true;}
            else if (x == 0) {
                if (y==0){
                    if (!isControlled[x][y+1] &&whatColor[x][y+1]==2 && !isEnded) {checkwin(x,y+1);}
                    if (!isControlled[x+1][y] &&whatColor[x+1][y]==2 && !isEnded) {checkwin(x+1,y);}}
                else if (y==rowLength-1) {
                    if (!isControlled[x][y-1] &&whatColor[x][y-1]==2 && !isEnded) {checkwin(x,y-1);}
                    if (!isControlled[x+1][y] &&whatColor[x+1][y]==2 && !isEnded) {checkwin(x+1,y);}
                    if (!isControlled[x+1][y-1] &&whatColor[x+1][y-1]==2 && !isEnded) {checkwin(x+1,y-1);}}
                else{
                    if (!isControlled[x][y+1] &&whatColor[x][y+1]==2 && !isEnded) {checkwin(x,y+1);}
                    if (!isControlled[x][y-1] &&whatColor[x][y-1]==2 && !isEnded) {checkwin(x,y-1);}
                    if (!isControlled[x+1][y] &&whatColor[x+1][y]==2 && !isEnded) {checkwin(x+1,y);}
                    if (!isControlled[x+1][y-1] &&whatColor[x+1][y-1]==2 && !isEnded) {checkwin(x+1,y-1);}}}
            else  {
                if (y==0){
                    if (!isControlled[x-1][y] &&whatColor[x-1][y]==2 && !isEnded) {checkwin(x-1,y);}
                    if (!isControlled[x-1][y+1] &&whatColor[x-1][y+1]==2 && !isEnded){checkwin(x-1,y+1);}
                    if (!isControlled[x][y+1] &&whatColor[x][y+1]==2 && !isEnded) {checkwin(x,y+1);}
                    if (!isControlled[x+1][y] &&whatColor[x+1][y]==2 && !isEnded) {checkwin(x+1,y);}}
                else if (y==rowLength-1) {
                    if (!isControlled[x-1][y] &&whatColor[x-1][y]==2 && !isEnded) {checkwin(x-1,y);}
                    if (!isControlled[x][y-1] &&whatColor[x][y-1]==2 && !isEnded) {checkwin(x,y-1);}
                    if (!isControlled[x+1][y] &&whatColor[x+1][y]==2 && !isEnded) {checkwin(x+1,y);}
                    if (!isControlled[x+1][y-1] &&whatColor[x+1][y-1]==2 && !isEnded) {checkwin(x+1,y-1);}}
                else{
                    if (!isControlled[x-1][y] &&whatColor[x-1][y]==2 && !isEnded) {checkwin(x-1,y);}
                    if (!isControlled[x-1][y+1] &&whatColor[x-1][y+1]==2 && !isEnded) {checkwin(x-1,y+1);}
                    if (!isControlled[x][y+1] &&whatColor[x][y+1]==2 && !isEnded) {checkwin(x,y+1);}
                    if (!isControlled[x][y-1] &&whatColor[x][y-1]==2 && !isEnded) {checkwin(x,y-1);}
                    if (!isControlled[x+1][y] &&whatColor[x+1][y]==2 && !isEnded) {checkwin(x+1,y);}
                    if (!isControlled[x+1][y-1] &&whatColor[x+1][y-1]==2 && !isEnded) {checkwin(x+1,y-1);}
           }}}
        if(isEnded) {winRoad(x,y);}
    }

    public static void main(String[] args) {
        launch(args);
    }
}
