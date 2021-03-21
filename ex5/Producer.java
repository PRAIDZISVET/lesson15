package by.itacademy.lesson15.ex5;

import by.itacademy.lesson15.ex4.RandomUtil;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private final BlockingQueue<Integer> deque;

    public Producer(BlockingQueue<Integer> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int generatedValue = RandomUtil.geverateDefault();
                System.out.println(Thread.currentThread().getName() + " сгенерировал число " + generatedValue);
                deque.put(generatedValue);
                System.out.println(Thread.currentThread().getName() + " поместил " + generatedValue);
                System.out.println("Количество элементов: " + deque.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
