package lld.parkingLot;

public class BikeVehicle implements Vehicle{

    public String vehicleNumber;

    public BikeVehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    @Override
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.BIKE;
    }
}
