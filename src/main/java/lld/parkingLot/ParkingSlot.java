package lld.parkingLot;

public class ParkingSlot {
    Integer slotNumber;
    VehicleType slotType;
    Vehicle vehicle;

    public ParkingSlot(Integer slotNumber, VehicleType slotType) {
        this.slotNumber = slotNumber;
        this.slotType = slotType;
    }

    public boolean isOccupied() {
        return vehicle!= null;
    }



    public VehicleType getSlotType() {
        return slotType;
    }

    public void setSlotType(VehicleType slotType) {
        this.slotType = slotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "slotNumber=" + slotNumber +
                ", slotType=" + slotType +
                ", vehicle=" + vehicle +
                ", isOccupied=" + isOccupied() +
                '}';
    }

    public void parkVehicle(Vehicle vehicle) {
          this.setVehicle(vehicle);
    }

    public void unPark() {
        this.vehicle = null;
    }
}
