package lld.liftManagementSystem;

public class liftManagementMain {

    public static void main(String[] args) {
        LiftManagementApp liftManagementApp = new LiftManagementApp();

        FloorService floorService = new FloorService(liftManagementApp);
        floorService.createFloors(6);

        LiftService liftService = new LiftService(liftManagementApp);
        liftService.createLifts(3,6);


    }











}
