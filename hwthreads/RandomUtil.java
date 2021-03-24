package by.itacademy.lesson15.hwthreads;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor (access = AccessLevel.PRIVATE)
public class RandomUtil {
    private final static Random RANDOM = new Random();
    private static final int DEFAULT_ELEMENTS = 9;


    public static int elementsPerNight (int count) {
        return RANDOM.nextInt(count);
    }
    public static int produceDefault () {
        return RANDOM.nextInt(DEFAULT_ELEMENTS);
    }
}
