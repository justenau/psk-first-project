package lt.vu.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Future;

@ApplicationScoped
public class MonthlyListenersGenerator implements Serializable, IMonthlyListenersGenerator {
    @Futureable
    public Future<Integer> generateMonthlyListeners() {
        System.out.println("Using default implementation of MonthlyListenersGenerator");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        final int generatedMonthlyListeners = new Random().nextInt(1000);
        return new AsyncResult<>(generatedMonthlyListeners);
    }
}