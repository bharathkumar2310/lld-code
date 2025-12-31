package lld.parkingLot;

public class CarVehicle implements Vehicle {

    public String vehicleNumber;

    public CarVehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }


    @Override
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.CAR;
    }
}
