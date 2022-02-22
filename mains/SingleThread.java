package mains;

import src.*;

public class SingleThread {
    public static void main(String[] args) {

        long begin = System.currentTimeMillis();

        RentManager manager = new RentManager();

        //for (int i = 0; i < 100; i++) {
            manager.addCar(new Car(0));
            manager.addClient(new Client(0));
        //}
        manager.rentCar(manager.getCars().get(0), manager.getClients().get(0));
        if(manager.verifieRent(manager.getCars().get(0)))
            System.out.println("Rent executed");
       
    
        long end = System.currentTimeMillis();
        System.out.println("Levou "+(end-begin)+" milisegundos");
    }
}
