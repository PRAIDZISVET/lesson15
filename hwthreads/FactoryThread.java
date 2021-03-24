package by.itacademy.lesson15.hwthreads;

import lombok.AllArgsConstructor;

import java.util.Deque;

@AllArgsConstructor
public class FactoryThread implements Runnable {

    private Deque<Integer> deque;
    public static int countOfNights = 1;

    @Override
    public void run() {

        while (countOfNights < 101) {
            synchronized (deque) {
                System.out.println("Наступила " + countOfNights + " ночь");
                int countElements = RandomUtil.elementsPerNight(4) + 1;
                for (int i = 1; i < countElements + 1; i++) {
                    int idProducedElement = RandomUtil.produceDefault();
                    deque.add(idProducedElement);
                }
                System.out.println("На свалку выбросили " + countElements + " деталь(и)(ей)");
                System.out.println("Количество деталей на свалке: " + deque.size());
                countOfNights++;
            }
        }

    }
}
