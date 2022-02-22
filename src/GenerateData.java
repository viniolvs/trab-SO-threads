package src;

import java.util.Random;

//gera dados aleatórios para teste
public class GenerateData {
    private static final Random random = new Random();

    //Book data
    public static int getYear() {
        int year = random.nextInt((2022-2000)+1)+2000;
        return year;
    }
    
    public static String getModel(int ID) {
        return "model "+ Integer.toString(ID);
    }
    public static String getColor(int ID) {
        if (ID%2 == 0) 
            return "White";
        else
            return "Black";
    }
    

    //clientdata
    public static String getName(int ID) {
        return "client "+ Integer.toString(ID);
    }
}
