package src;

public class Car {
    private final int carID;
    private final int year;
    private final String model;
    private final String color;

    public Car(int ID) {
        carID = ID;
        model = GenerateData.getModel(ID);
        year = GenerateData.getYear();
        color = GenerateData.getColor(ID);
    }

    public int getID() {
        return carID;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public String getColor() {
        return color;
    }
}
