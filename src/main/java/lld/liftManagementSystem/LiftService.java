package lld.liftManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class LiftService {

    private LiftManagementApp app;

    public LiftService(LiftManagementApp app) {
        this.app = app;
    }

    public String createLifts(int noOfLifts, int noOfFloors) {

        for (int i = 1; i <= noOfLifts; i++) {
            List<InternalButton> buttons = new ArrayList<>();
            for (int f = 1; f <= noOfFloors; f++) {
                buttons.add(new InternalButton(f));
            }
            LiftPanel panel = new LiftPanel(buttons);
            Lift lift = new Lift(i, panel);
            app.getLiftList().add(lift);
        }
        return noOfLifts + " lifts created successfully";
    }


    public void assignStopsToOptimalLift(Direction requestDirection, int requestFloor) {

        Lift bestLift = null;
        int bestScore = Integer.MAX_VALUE;

        for (Lift lift : app.getLiftList()) {

            Direction liftDirection = lift.getDirection();
            int liftFloor = lift.getCurrentFloor();

            // 1️⃣ Lift must be compatible with request direction or idle
            if (liftDirection != Direction.IDLE &&
                    liftDirection != requestDirection) {
                continue;
            }

            // 2️⃣ Lift must not have already passed the request floor
            if (liftDirection == Direction.UP && requestFloor < liftFloor) {
                continue;
            }
            if (liftDirection == Direction.DOWN && requestFloor > liftFloor) {
                continue;
            }

            // 3️⃣ Choose the closest eligible lift
            int distance = Math.abs(liftFloor - requestFloor);
            if (distance < bestScore) {
                bestScore = distance;
                bestLift = lift;
            }
        }

        // 4️⃣ Assign stop if a suitable lift is found
        if (bestLift != null) {
            bestLift.addStop(requestFloor);
        }
        // else: request can be queued or retried later
    }





}
