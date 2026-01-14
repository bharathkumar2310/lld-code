package lld.liftManagementSystem;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SchedulerService {

    private LiftManagementApp liftManagementApp;

    public SchedulerService(LiftManagementApp liftManagementApp) {
        this.liftManagementApp = liftManagementApp;
    }

    public void start() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        List<Lift> liftLists = liftManagementApp.getLiftList();

        executorService.scheduleAtFixedRate(
                () -> liftLists.forEach(Lift::moveLift),
                0, 1, TimeUnit.SECONDS
        );

    }


    public void moveLift() throws InterruptedException {




    }


}
