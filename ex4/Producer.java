package by.itacademy.lesson15.ex4;

import lombok.AllArgsConstructor;

import java.util.Deque;

import static by.itacademy.lesson15.ex4.RandomUtil.geverateDefault;

@AllArgsConstructor
public class Producer implements Runnable {

    private static final int MAX_COUNT = 10;
    private Deque<Integer> deque;

    @Override
    public void run() {
        synchronized (deque) {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " пытается поместить в очередь... ");
                if (deque.size() < MAX_COUNT) {
                    int generatedValue = geverateDefault();
                    deque.add(generatedValue);
                    System.out.println(Thread.currentThread().getName() + " добавил число " + generatedValue);
                    System.out.println("Количество элементов в очереди " + deque.size());
                }
                try {
                    System.out.println(Thread.currentThread().getName() + " заснул ");
                    deque.wait(10L);
                    System.out.println(Thread.currentThread().getName() + " проснулся ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
