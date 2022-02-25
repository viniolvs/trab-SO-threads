package mains;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import src.*;

public class ExclusionTest {
    public static void main(String[] args) throws InterruptedException{
        RentManager manager = new RentManager();

        manager.addClient(new Client(0));
        manager.addClient(new Client(1));

        manager.addCar(new Car(0));

        Semaphore sem = new Semaphore(1);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new RentThread(manager, manager.getCars().get(0), manager.getClients().get(0), sem));
        executor.execute(new RentThread(manager, manager.getCars().get(0), manager.getClients().get(1), sem));
        executor.shutdown();   
    }
}
