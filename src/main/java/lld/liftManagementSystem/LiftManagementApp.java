package lld.liftManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class LiftManagementApp {

    List<Floor> floorList;
    List<Lift>liftList;


    public LiftManagementApp() {
        this.floorList = new ArrayList<>();
        this.liftList = new ArrayList<>();
    }

    public List<Floor> getFloorList() {
        return floorList;
    }

    public List<Lift> getLiftList() {
        return liftList;
    }
}
