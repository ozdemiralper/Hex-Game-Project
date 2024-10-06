package gamepractice.HexGameProject;

public class DataSave {
    private static String name1Value;
    private static String name2Value;
    private static int mapValue;

    public static String getName1Value(){
        return name1Value;
    }
    public static String getName2Value(){
        return name2Value;
    }
    public static int getMapValue() {
        return mapValue;
    }
    public void setName1Value(String name1Value) {this.name1Value = name1Value;}
    public void setName2Value(String name2Value) {this.name2Value = name2Value;}
    public void setMapValue(int mapValue) {
        this.mapValue=mapValue;
    }

}
