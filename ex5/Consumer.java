package by.itacademy.lesson15.ex5;

import by.itacademy.lesson15.ex4.RandomUtil;
import lombok.AllArgsConstructor;

import java.util.concurrent.BlockingQueue;

@AllArgsConstructor
public class Consumer implements Runnable {

    private final BlockingQueue<Integer> deque;

    @Override
    public void run() {
    while (true) {
        try {
            System.out.println(Thread.currentThread().getName() + " пытается получить...");
            Integer value = deque.take();
            System.out.println(Thread.currentThread().getName() + "  получил " + value);
            System.out.println("Количество элементов: " + deque.size());
            Thread.sleep(RandomUtil.geverate(10)+1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }
}
