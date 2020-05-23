package lt.vu.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.Future;

    @ApplicationScoped
    @Alternative
    public class AlternativeMonthlyListenersGenerator implements Serializable, IMonthlyListenersGenerator {
        @Futureable
        public Future<Integer> generateMonthlyListeners() {
            System.out.println("Using alternative implementation of MonthlyListenersGenerator");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            final int monthlyListeners = UUID.randomUUID().hashCode();
            return new AsyncResult<>(monthlyListeners);
        }
    }