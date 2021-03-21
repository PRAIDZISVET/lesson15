package by.itacademy.lesson15.ex5;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) {

        BlockingQueue<Integer> integers = new LinkedBlockingDeque<>(10);

        Thread producer = new Thread(new Producer(integers));
        Thread consumer = new Thread(new Consumer(integers));

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
