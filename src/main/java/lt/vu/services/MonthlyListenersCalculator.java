package lt.vu.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.Future;

import static java.lang.Math.abs;

@ApplicationScoped
public class MonthlyListenersCalculator implements Serializable, IMonthlyListenersCalculator {
    @Futureable
    public Future<Integer> calculateMonthlyListeners() {
        System.out.println("Using default implementation of MonthlyListenersCalculator");

        /* Simulate calculation */
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        final int calculatedMonthlyListeners = abs(new Random().nextInt(1000));
        return new AsyncResult<>(calculatedMonthlyListeners);
    }
}