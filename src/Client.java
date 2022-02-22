package src;

public class Client{
    private String name;
    private int clientID;
    private int rentedCars;

    public Client(int ID){
        name = GenerateData.getName(ID);
        clientID = ID;
        rentedCars = 0;
    }
    public String getName() {
        return name;
    }
    public int getID() {
        return clientID;
    }
    public int getRentedCar(){
        return rentedCars;
    }
    public void addCar() {
        rentedCars++;
    }
    
}
