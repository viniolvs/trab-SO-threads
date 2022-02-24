package mains;
import src.*;

public class MultiThreadPerformance {
    public static void main(String[] args) throws InterruptedException{

        long begin = System.currentTimeMillis();

        RentManager manager = new RentManager();

        int clients = 200;
        int cars = 50;

        for (int i = 0 ; i < cars; i++) {
            manager.addCar(new Car(i));
        }
        for (int i = 0; i < clients; i++) {
            manager.addClient(new Client(i));
        }
        for (int i = 0; i < clients; i++) {
            boolean aux;
            aux = manager.rentCar(manager.getCars().get(i%cars), manager.getClients().get(i));
            if(aux)
                System.out.println(i+" Rent executed!");   
            else
                System.out.println(i+" Car already rented!");
        }
        
       
    
        long end = System.currentTimeMillis();
        System.out.println("Levou "+(end-begin)+" milisegundos");
    }
}
