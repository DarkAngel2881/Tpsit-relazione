package Meth_1;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Lock;

public class Scrittore implements Runnable{
   final ArrayList<Integer> list;
   final Lock lock;

   public Scrittore (ArrayList<Integer> list, Lock lock){
       this.list = list;
       this.lock = lock;
   }

   @Override
   public void run() {
       Random random = new Random();

       for(var i = 0; i<1000; i++) {
           synchronized (list)
           {
               list.add(random.nextInt());
           }
       }
   }
}

