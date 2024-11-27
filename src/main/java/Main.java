
import java.sql.Date;
import java.sql.SQLException;
import model.ITRequest;
import repository.RequestRepo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class Main implements Runnable{
    
    
    public static void main(String[] args) throws SQLException, InterruptedException{
       
//        ITRequest re = new ITRequest(0, "dai", Date.valueOf("2024-02-02"), "alo@gmail.com", "abcd", "dseefe");
//        RequestRepo repo = new RequestRepo();
//        repo.addRequest(re);

        Main t1 = new Main();
        Thread thread = new Thread(t1); 
        thread.setName("mot");
        thread.setPriority(10);
        thread.start();
        thread.join();
        
        Main t2 = new Main();
        Thread thread2 = new Thread(t2); 
        thread2.setName("hai");
        thread2.setPriority(1);
        thread2.start();
        
    
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10; i++){
            System.err.println("thread " + Thread.currentThread().getName() + " dang chay: " + i);
        }
    }
}
