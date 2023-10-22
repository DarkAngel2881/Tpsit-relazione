package Meth_2;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.random.RandomGenerator;

public class Scrittore implements Runnable{
   final ArrayList<Integer> list;
   final Lock lock;

   public Scrittore (ArrayList<Integer> list, Lock lock){
       this.list = list;
       this.lock = lock;
   }

   @Override
   public void run() {
       RandomGenerator random = new Random();

       for(var i = 0; i<1000; i++) {
    lock.lock();
         {
            list.add(random.nextInt());
         }
         lock.unlock();

       }
   }
}

