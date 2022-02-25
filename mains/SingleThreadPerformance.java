package mains;

import src.*;

public class SingleThreadPerformance {
    public static void main(String[] args) {

        RentManager manager = new RentManager();
        int n = 10000;
        int clients = n;
        int cars = n;

        for (int i = 0 ; i < cars; i++) {
            manager.addCar(new Car(i));
        }
        for (int i = 0; i < clients; i++) {
            manager.addClient(new Client(i));
        }

        long begin = System.currentTimeMillis();
        for (int i = 0; i < clients; i++) {
            manager.rentCar(manager.getCars().get(i%cars), manager.getClients().get(i));
        }
        long end = System.currentTimeMillis();       
        
        System.out.println("Executed in "+(end-begin)+" milliseconds");
    }
}
