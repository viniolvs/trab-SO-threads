package src;

public class Rent {
    protected final Car car;
    protected final Client client;

    protected Rent(Car car, Client client){
        this.car = car;
        this.client = client;
    }
    protected Car getCar() {
        return car;
    }
    protected Client getClient() {
        return client;
    }
}