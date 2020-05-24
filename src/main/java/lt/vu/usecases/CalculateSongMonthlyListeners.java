package lt.vu.usecases;

import lt.vu.interceptors.LoggedInvocation;
import lt.vu.services.IMonthlyListenersCalculator;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Model
@SessionScoped
public class CalculateSongMonthlyListeners implements Serializable {
    @Inject
    IMonthlyListenersCalculator monthlyListenersCalculator;

    private Future<Integer> monthlyListenersCalculationTask = null;

    @LoggedInvocation
    public String calculateMonthlyListeners() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        monthlyListenersCalculationTask = monthlyListenersCalculator.calculateMonthlyListeners();

        return  "/songDetails.xhtml?faces-redirect=true&songId=" + requestParameters.get("songId");
    }

    public boolean isMonthlyListenersCalculationRunning() {
        return monthlyListenersCalculationTask != null && !monthlyListenersCalculationTask.isDone();
    }

    public String getMonthlyListenersCalculationStatus() throws ExecutionException, InterruptedException {
        if (monthlyListenersCalculationTask == null) {
            return null;
        } else if (isMonthlyListenersCalculationRunning()) {
            return "Monthly listeners calculation in progress";
        }
        return "Calculated monthly listeners " + monthlyListenersCalculationTask.get();
    }
}