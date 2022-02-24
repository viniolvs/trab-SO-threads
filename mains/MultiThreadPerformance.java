package mains;
import src.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadPerformance {
    public static void main(String[] args) throws InterruptedException{


        RentManager manager = new RentManager();

        int clients = 50000;
        int cars = 50000;

        for (int i = 0 ; i < cars; i++) {
            manager.addCar(new Car(i));
        }
        for (int i = 0; i < clients; i++) {
            manager.addClient(new Client(i));
        }

        Semaphore sem = new Semaphore(1);
        ExecutorService executor = Executors.newFixedThreadPool(8);

        long begin = System.currentTimeMillis();
        for (int i = 0; i < clients; i++) {
            executor.execute(new RentThread(manager, manager.getCars().get(i%cars), manager.getClients().get(i), sem));    
        }
        executor.shutdown();
        while (!executor.awaitTermination(24L, TimeUnit.MILLISECONDS)); //espera threads terminarem para continuar a execução
        long end = System.currentTimeMillis();
        
        System.out.println("Executed in "+(end-begin)+" milisegundos");
    }
}
