package lt.vu.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.Future;

import static java.lang.Math.abs;

@ApplicationScoped
    @Alternative
    public class AlternativeMonthlyListenersCalculator implements Serializable, IMonthlyListenersCalculator {
        @Futureable
        public Future<Integer> calculateMonthlyListeners() {
            System.out.println("Using alternative implementation of MonthlyListenersCalculator");

            /*Simulate calculation*/
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            final int monthlyListeners = abs(UUID.randomUUID().hashCode());
            return new AsyncResult<>(monthlyListeners);
        }
    }