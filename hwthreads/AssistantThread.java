package by.itacademy.lesson15.hwthreads;

import lombok.AllArgsConstructor;

import java.util.Deque;

@AllArgsConstructor
public class AssistantThread implements Runnable {

    private final Deque<Integer> deque;

    @Override
    public void run() {
        while (FactoryThread.countOfNights < 101) {
            synchronized (deque) {
                System.out.println("Помощник ученого пытается забрать деталь...");
                if (!(deque.isEmpty())) {
                    int countElements = RandomUtil.elementsPerNight(4) + 1;
                    for (int i = 1; i < countElements + 1; i++) {
                        Integer item = deque.removeFirst();
                    }
                    System.out.println(Thread.currentThread() + " взял на свалке " + countElements + " деталей.");
                    System.out.println("На свалке осталось " + deque + "деталей");
                }
            }

        }
    }
}
