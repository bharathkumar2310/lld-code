package lld.liftManagementSystem;


import java.util.ArrayList;
import java.util.List;

public class FloorService {

    private LiftManagementApp app;

    public FloorService(LiftManagementApp app) {
        this.app = app;
    }

    public String createFloors(int noOfFloors) {

        for (int i = 1; i <= noOfFloors; i++) {

            List<ExternalButton> buttons = new ArrayList<>();

            if (i > 1) {
                buttons.add(new ExternalButton(Direction.DOWN));
            }
            if (i < noOfFloors) {
                buttons.add(new ExternalButton(Direction.UP));
            }

            FloorPanel panel = new FloorPanel(buttons);
            Floor floor = new Floor(i, panel);

            app.getFloorList().add(floor);
        }
        return "Floors created successfully";
    }
}
