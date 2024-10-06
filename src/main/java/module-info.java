module gamepractice.hexgame004 {
    requires javafx.controls;
    requires javafx.fxml;


    opens gamepractice.HexGameProject to javafx.fxml;
    exports gamepractice.HexGameProject;
}