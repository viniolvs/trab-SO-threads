package src;

import java.util.ArrayList;

public class RentManager {
    private final ArrayList<Client> clients;
    private final ArrayList<Car> cars;
    private final ArrayList<Rent> rents;

    public RentManager(){
        clients = new ArrayList<Client>();
        cars = new ArrayList<Car>();
        rents = new ArrayList<Rent>();
    }

    public ArrayList<Client> getClients() {
        return clients;
    }
    public ArrayList<Car> getCars() {
        return cars;
    }
    public ArrayList<Rent> getRents() {
        return rents;
    }
    public void addClient (Client client) {
        clients.add(client);
    }
    public void addCar(Car car) {
        cars.add(car);
    }
    
    public boolean rentCar (Car car, Client client){
        if(verifieRent(car) == true){
            return false;
        }
        else{
            rents.add(new Rent(car, client));
            return true;
        }
    }

    public boolean verifieRent(Car car) {
        for (Rent rent : rents) {
            if (car.getID() == rent.getCar().getID())
                return true;
        }
        return false;
    }
}
