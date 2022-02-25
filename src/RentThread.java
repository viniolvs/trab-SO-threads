package src;

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
        boolean aux;
        aux = manager.rentCar(car, client);
        sem.release();

        /*
        if(aux == true){
            System.out.println(car.getModel()+" rented to "+client.getName());
        }
        else
            System.out.println("Car already rented!"); 
        */
    }
}