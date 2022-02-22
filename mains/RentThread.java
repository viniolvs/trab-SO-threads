package mains;

import src.*;
import java.util.concurrent.Semaphore;
import java.lang.InterruptedException;

public class RentThread implements Runnable{
    Semaphore sem;
    private final RentManager manager;
    private Car car;
    private Client client;

    public RentThread(RentManager manager, Car car, Client client,Semaphore sem){
        this.manager = manager;
        this.car = car;
        this.client = client;
        this.sem = sem;
    }

    public void run(){
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            System.err.println("Interrupted Exception Rent Thread");
        }
        boolean aux = manager.verifieRent(car);
        
        if(aux == false){
            manager.rentCar(car, client);
            System.out.println("Rented "+car.getTitle()+" to Client "+client.getName());
        }
        else
            System.out.println("Car already rented!");
        sem.release();
    }
}