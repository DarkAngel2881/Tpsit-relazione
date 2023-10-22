package Meth_4;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;

public class Scrittore implements Runnable{
   final ArrayBlockingQueue<Integer> list;
   final Lock lock;
   public Scrittore (ArrayBlockingQueue<Integer> list, Lock lock){
       this.list = list;
       this.lock = lock;
   }

   @Override
   public void run() {
       Random random = new Random();

       for(var i = 0; i<1000; i++) {
           {
               list.add(random.nextInt());
           }
       }
   }
}

