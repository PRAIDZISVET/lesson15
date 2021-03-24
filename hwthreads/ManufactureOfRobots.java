package by.itacademy.lesson15.hwthreads;

import java.util.Deque;
import java.util.LinkedList;

public class ManufactureOfRobots {
    public static void main(String[] args) {
        Deque<Integer> elements = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            int firstNightProducedElement = RandomUtil.produceDefault();
            elements.add(firstNightProducedElement);
        }
        System.out.println("Количество деталей на свалке в первую ночь: " + elements.size());
//        for (Integer element : elements) {
//            System.out.println(element);
 //       }
        Thread factoryThread = new Thread(new FactoryThread(elements));
        Thread firstAssistant = new Thread(new AssistantThread(elements));
        Thread secondAssistant = new Thread(new AssistantThread(elements));

        factoryThread.start();
        firstAssistant.start();
        secondAssistant.start();

        try {
            factoryThread.join();
            firstAssistant.join();
            secondAssistant.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
