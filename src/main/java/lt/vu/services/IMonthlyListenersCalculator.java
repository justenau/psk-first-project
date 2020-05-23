package lt.vu.services;
import java.util.concurrent.Future;

public interface IMonthlyListenersGenerator {
    Future<Integer> generateMonthlyListeners();
}