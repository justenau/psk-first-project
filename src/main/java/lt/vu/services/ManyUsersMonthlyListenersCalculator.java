package lt.vu.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.Future;

import static java.lang.Math.abs;

@ApplicationScoped
@Specializes
public class ManyUsersMonthlyListenersCalculator extends  MonthlyListenersCalculator implements Serializable {

    @Override
    @Futureable
    public Future<Integer> calculateMonthlyListeners() {
        /* Simulate calculation */
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        final int calculatedMonthlyListeners = abs(new Random().nextInt(1000000));
        return new AsyncResult<>(calculatedMonthlyListeners);
    }
}