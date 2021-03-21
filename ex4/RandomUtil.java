package by.itacademy.lesson15.ex4;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor (access = AccessLevel.PRIVATE)
public final class RandomUtil {

    private static final Random RANDOM = new Random();
    private static final int DEFAULT_VALUE = 10;

    public static int geverate (int max) {
        return RANDOM.nextInt(max);
    }
    public static int geverateDefault () {
        return RANDOM.nextInt(DEFAULT_VALUE);
    }

}
