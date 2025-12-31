package lld.parkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilityClass {

    public ParkingLot initialize() {
        ParkingSlot slot1 = new ParkingSlot(1, VehicleType.BIKE);
        ParkingSlot slot2 = new ParkingSlot(2, VehicleType.BIKE);
        ParkingSlot slot3 = new ParkingSlot(3, VehicleType.BIKE);
        ParkingSlot slot4 = new ParkingSlot(4, VehicleType.CAR);
        ParkingSlot slot5 = new ParkingSlot(5, VehicleType.CAR);

        List<ParkingSlot> floor1ParkingSlot = new ArrayList<>();
        floor1ParkingSlot.add(slot1);
        floor1ParkingSlot.add(slot2);
        floor1ParkingSlot.add(slot3);
        floor1ParkingSlot.add(slot4);
        floor1ParkingSlot.add(slot5);

        ParkingFloor floor1 = new ParkingFloor(1,floor1ParkingSlot);


        ParkingSlot slot6 = new ParkingSlot(6, VehicleType.BIKE);
        ParkingSlot slot7 = new ParkingSlot(7, VehicleType.BIKE);
        ParkingSlot slot8 = new ParkingSlot(8, VehicleType.BIKE);
        ParkingSlot slot9 = new ParkingSlot(9, VehicleType.CAR);
        ParkingSlot slot10 = new ParkingSlot(10, VehicleType.CAR);

        List<ParkingSlot> floor2ParkingSlot = new ArrayList<>();
        floor2ParkingSlot.add(slot6);
        floor2ParkingSlot.add(slot7);
        floor2ParkingSlot.add(slot8);
        floor2ParkingSlot.add(slot9);
        floor2ParkingSlot.add(slot10);
        ParkingFloor floor2 = new ParkingFloor(2,floor2ParkingSlot);

        List<ParkingFloor>parkingFloorList = new ArrayList<>();
        parkingFloorList.add(floor1);
        parkingFloorList.add(floor2);

        ParkingLot parkingLot = new ParkingLot(parkingFloorList);
        return parkingLot;
    }


    public Map<VehicleType, Double> initializeHourlyPlan() {
        Map<VehicleType, Double> hourlyPlans = new HashMap<>();
        hourlyPlans.put(VehicleType.BIKE, 25.0);
        hourlyPlans.put(VehicleType.CAR, 40.0);
        return hourlyPlans;
    }

    public Map<VehicleType, Double> initializeDailyPlan() {
        Map<VehicleType, Double> dailyPlan = new HashMap<>();
        dailyPlan.put(VehicleType.BIKE, 400.0);
        dailyPlan.put(VehicleType.CAR, 900.0);
        return dailyPlan;
    }


}
