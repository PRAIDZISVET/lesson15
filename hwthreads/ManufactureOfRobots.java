package by.itacademy.lesson15.hwthreads;

import java.util.Deque;
import java.util.LinkedList;

public class ManufactureOfRobots {
    public static void main(String[] args) {
        Deque<Integer> elements = new LinkedList<>();
        Thread factoryThread = new Thread(new FactoryThread(elements));
        Thread firstAssistant = new Thread(new AssistantThread(elements));
        Thread secondAssistant = new Thread(new AssistantThread(elements));

    }
}
