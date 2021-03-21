package by.itacademy.lesson15.ex1;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class AccountThread extends Thread {
    private final Account from;
    private final Account to;

    @Override
    public void run() {
        int sum = 100;
        LinkedList<Account> accounts = new LinkedList<>();
        accounts.add(from);
        accounts.add(to);
        //accounts.sort(Comparator.naturalOrder());
        Collections.sort(accounts);
        for (int i = 0; i < 20; i++) {
            synchronized (accounts.getFirst()) {
                synchronized (accounts.getLast()) {
                    if (from.takeOff(sum)) {
                        to.add(sum);
                    }
                }
            }
        }
    }
}
