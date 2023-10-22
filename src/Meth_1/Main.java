package Meth_1;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> list;
        Lock lock;
        ExecutorService pool;
        long from, to;
        long times[] = new long[20];
        for (int j = 0; j < 20; j++) {
            list = new ArrayList<>();
            lock = new ReentrantLock();
            pool = Executors.newFixedThreadPool(4);

            from = System.currentTimeMillis();

            for (var i = 0; i < 1000; i++) {
                pool.execute(new Scrittore(list, lock));
            }
            pool.shutdown();

            to = System.currentTimeMillis();
            times[j] = to - from;
            System.out.println("size: " + list.size() + ", time: " + (to - from));
        }
        long s = 0;
        for (int j = 0; j < 20; j++) {
            s += times[j];
        }

        System.out.println("media tempi: " + (s / 20));
    }
}
