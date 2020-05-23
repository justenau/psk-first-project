package lt.vu.usecases;

import debr.interceptors.LoggedInvocation;
import debr.services.INickNameGenerator;
import lt.vu.services.IMonthlyListenersGenerator;

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
public class GenerateSongMonthlyListeners implements Serializable {
    @Inject
    IMonthlyListenersGenerator monthlyListenersGenerator;

    private Future<Integer> monthlyListenersGeneratorTask = null;

    @LoggedInvocation
    public String generateNickName() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        monthlyListenersGeneratorTask = monthlyListenersGenerator.generateNickName();

        return  "/playerDetails.xhtml?faces-redirect=true&playerId=" + requestParameters.get("playerId");
    }

    public boolean isNickNameGenerationRunning() {
        return monthlyListenersGeneratorTask != null && !monthlyListenersGeneratorTask.isDone();
    }

    public String getNickNameGenerationStatus() throws ExecutionException, InterruptedException {
        if (monthlyListenersGeneratorTask == null) {
            return null;
        } else if (isNickNameGenerationRunning()) {
            return "Nick name generation in progress";
        }
        return "Suggested nick name: " + monthlyListenersGeneratorTask.get();
    }
}