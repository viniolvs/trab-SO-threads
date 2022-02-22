package mains;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import src.*;


public class MultiThread {
    public static void main(String[] args) {
        
        long begin = System.currentTimeMillis();
        int ID = 0;
        Semaphore sem = new Semaphore(1);
        //Semaphore sem = new Semaphore(1);
            
       
        RentManager manager = new RentManager();      
        for (int i = 0; i < 10; i++) {
            manager.addCar(new Car(i));
        }
        for (int i = 0; i < 20; i++) {
            manager.addClient(new Client(i));
        }
        

        ExecutorService executor = Executors.newFixedThreadPool(5);
        int i=0;
        //for (int i = 0; i < 10; i++) {
                executor.execute(new RentThread(manager, manager.getCars().get(i), manager.getClients().get(i),sem));
                executor.execute(new RentThread(manager, manager.getCars().get(i), manager.getClients().get(i+10),sem));
        //}
        executor.shutdown();



        long end = System.currentTimeMillis();
        System.out.println("Levou "+(end-begin)+" milisegundos");
    }
    
}
