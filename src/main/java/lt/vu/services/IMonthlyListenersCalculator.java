package lt.vu.services;
import java.util.concurrent.Future;

public interface IMonthlyListenersCalculator {
    Future<Integer> calculateMonthlyListeners();
}