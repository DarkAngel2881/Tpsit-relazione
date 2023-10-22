package Meth_3;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.random.RandomGenerator;

public class Scrittore implements Runnable{
   final List<Integer> list;
   final Lock lock;
   public Scrittore (List<Integer> list, Lock lock){
       this.list = list;
       this.lock = lock;
   }

   @Override
   public void run() {
       RandomGenerator random = new Random();

       for(var i = 0; i<1000; i++) {
           {
               list.add(random.nextInt());
           }
       }
   }
}

